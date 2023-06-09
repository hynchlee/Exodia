package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.vo.AdminVo;
import com.semi.common.page.PageVo;
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.ExamCategoryVo;

@WebServlet("/lecture/test/info")
public class TestInfoController extends HttpServlet{
	private final LectureService ls = new LectureService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AdminVo loginAdmin = (AdminVo) req.getSession().getAttribute("loginAdmin");
			if(loginAdmin == null) {
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
			List<ExamCategoryVo> examCategoryList = ls.getExamCategoryList(pageVo, searchType, searchValue);

			req.setAttribute("examCategoryList", examCategoryList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/info.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}
	}
}
