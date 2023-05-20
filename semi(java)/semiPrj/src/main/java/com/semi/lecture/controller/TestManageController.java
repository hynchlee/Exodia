package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.page.PageVo;
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.lecture.vo.ProblemBankVo;

@WebServlet("/lecture/test/manage")
public class TestManageController extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String examCategoryNo = req.getParameter("no");
			String examSubject = req.getParameter("subject");

			if(examCategoryNo == null || examSubject == null) {
				examCategoryNo = "1";
				examSubject = "프로그래밍 언어 응용";				
			}
			
			ProblemBankVo pbv = new ProblemBankVo();
			pbv.setExamCategoryNo(examCategoryNo);
			pbv.setExamSubject(examSubject);
			
			int cnt = ls.getProblemListCnt(pbv);

			List<List<ProblemBankVo>> problemList = ls.getProblemList(pbv);

			req.setAttribute("problemList", problemList);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/manage.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error(시험 관리)");
		}
	}

}
