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
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/manage")
public class LectureManageController extends HttpServlet {
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

			String page = req.getParameter("page");
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");

			int cnt = ls.getLectureListCnt(searchType, searchValue);

			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}

			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<LectureVo> lectureList = ls.getLectureList(pageVo, searchType, searchValue);

			req.setAttribute("lectureList", lectureList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/manage.jsp").forward(req, resp);
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
				result = ls.modifyLectureOne(params);
			} else if (type.equals("del")) {
				int[] lectureNo = new int[params.length - 1];
				for (int i = 0; i < lectureNo.length - 1; i++) {
					lectureNo[i] = Integer.parseInt(params[i + 1]);
				}
				result = ls.deleteLecture(lectureNo);
			} else if (type.equals("plus")) {
				result = ls.insertLectureOne(params);
			}

			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/lecture/manage");
		}
	}
}
