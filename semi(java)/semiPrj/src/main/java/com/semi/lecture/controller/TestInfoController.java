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
import com.semi.lecture.vo.TestInfoVo;

@WebServlet("/lecture/test/info")
public class TestInfoController extends HttpServlet{
	private final LectureService ls = new LectureService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int cnt = ls.getTestInfoListCnt();

			String page = req.getParameter("page");
			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}
			
			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<TestInfoVo> testInfoList = ls.getTestInfoList(pageVo);

			req.setAttribute("testInfoList", testInfoList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/info.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("error(시험 정보)");
		}
	}
}
