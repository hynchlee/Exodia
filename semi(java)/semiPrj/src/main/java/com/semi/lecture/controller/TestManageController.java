package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.vo.AdminVo;
import com.semi.common.page.PageVo;
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.lecture.vo.ProblemBankVo;

@WebServlet("/lecture/test/manage")
public class TestManageController extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AdminVo loginAdmin = (AdminVo) req.getSession().getAttribute("loginAdmin");
			if (loginAdmin == null) {
				req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
				resp.sendRedirect("/semi/member/login");
				return;
			}

			String examCategoryNo = req.getParameter("no");
			String examSubject = req.getParameter("subject");

			ProblemBankVo pbv = new ProblemBankVo();
			pbv.setExamCategoryNo(examCategoryNo);
			pbv.setExamSubject(examSubject);

			int cnt = ls.getProblemListCnt(pbv);

			List<List<ProblemBankVo>> problemList = ls.getProblemList(pbv);

			req.setAttribute("problemList", problemList);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/manage.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			String[] params = json.replaceAll("\\s", "").replace("[", "").replace("]", "").replace("\"", "").split(",");
			String type = params[0];
			int result = 0;
			
			if (type.equals("mod")) {
				result = ls.modifyTestOne(params);
			} else if (type.equals("del")) {
				int[] examProblemNoArr = new int[params.length - 1];
				for (int i = 0; i < examProblemNoArr.length; i++) {
					examProblemNoArr[i] = Integer.parseInt(params[i + 1]);
				}
				result = ls.deleteProblem(examProblemNoArr);
			} else if (type.equals("plus")) {
				result = ls.insertProblemOne(params);
			}

			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/lecture/test/manage");
		}
	}

}
