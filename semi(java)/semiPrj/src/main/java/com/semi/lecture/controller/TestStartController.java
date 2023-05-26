package com.semi.lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.lecture.service.LectureService;
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/test/start")
public class TestStartController extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if (loginMember == null || !loginMember.getIdentity().equals("S")) {
				req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
				resp.sendRedirect("/semi/member/login");
				return;
			}
			
			String examCategoryNo = req.getParameter("examCategoryNo");
			String[] examProblemNoArr = req.getParameterValues("examProblemNo");
			String[] answerArr = req.getParameterValues("answer");

			int result = ls.submitAnswers(loginMember.getMemberNo(), examCategoryNo, examProblemNoArr, answerArr);

			if (result == 1) {
				req.getSession().setAttribute("alertMsg", "평가 완료");
				resp.sendRedirect("/semi/lecture/test/list");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}

	}
}
