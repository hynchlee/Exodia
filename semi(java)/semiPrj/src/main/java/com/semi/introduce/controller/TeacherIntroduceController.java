package com.semi.introduce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.page.PageVo;
import com.semi.introduce.service.IntroduceService;
import com.semi.member.vo.MemberVo;

@WebServlet("/introduce/teacher")
public class TeacherIntroduceController extends HttpServlet {
	private final IntroduceService is = new IntroduceService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int cnt = is.getTeacherListCnt();

			String page = req.getParameter("page");
			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}
			
			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<MemberVo> teacherList = is.getTeacherList(pageVo);
			List<String> commentList = is.getCommentList();
			req.setAttribute("teacherList", teacherList);
			req.setAttribute("commentList", commentList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/introduce/teacher.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("error(강사 소개)");
		}

	}
}
