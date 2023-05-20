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
import com.semi.lecture.vo.ExamCategoryVo;
import com.semi.lecture.vo.LectureVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/test/list2")
public class TestList2Controller extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");

			int cnt = ls.getExamCategoryListCnt2(loginMember);

			String page = req.getParameter("page");
			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}

			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<ExamCategoryVo> examCategoryList = ls.getExamCategoryList2(pageVo, loginMember);
			LectureVo lectureVo = ls.getLectureOne(examCategoryList.get(0).getLectureCategoryNo(), loginMember.getMemberNo());
			
			req.getSession().setAttribute("lectureVo", lectureVo);
			req.setAttribute("examCategoryList", examCategoryList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/list2.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error(시험 목록 (강사))");
		}
	}
}
