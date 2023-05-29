package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.lecture.vo.ProblemBankVo;
import com.semi.lecture.vo.SubmitAnswerVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/test/score")
public class TestScoreController extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if (loginMember == null || !loginMember.getIdentity().equals("T")) {
				req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
				resp.sendRedirect("/semi/member/login");
				return;
			}

			String memberNo = req.getParameter("memberNo");
			String examCategoryNo = req.getParameter("examCategoryNo");
			String examSubject = req.getParameter("examSubject");

			ProblemBankVo pbv = new ProblemBankVo();
			pbv.setExamCategoryNo(examCategoryNo);
			pbv.setExamSubject(examSubject);

			List<SubmitAnswerVo> submitAnswerList = ls.getSubmitAnswerList(pbv, memberNo);
			req.setAttribute("submitAnswerList", submitAnswerList);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/score.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		LectureVo lectureVo = (LectureVo) req.getSession().getAttribute("lectureVo");
		if (loginMember == null || !loginMember.getIdentity().equals("T")) {
			req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
			resp.sendRedirect("/semi/member/login");
			return;
		}

		Gson gson = new Gson();
		String params = req.getParameter("params");
		String proNoList = req.getParameter("proNoList");
		String scoreList = req.getParameter("scoreList");
		String[] paramsArr = gson.fromJson(params, String[].class);
		String[] proNoArr = gson.fromJson(proNoList, String[].class);
		String[] scoreArr = gson.fromJson(scoreList, String[].class);

		try {
			int result1 = ls.scoreOne(paramsArr[0], paramsArr[1], paramsArr[3]);
			int result2 = ls.scoreAnswers(paramsArr[0], paramsArr[1], proNoArr, scoreArr);

			if (result1 != 1 || result2 != 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
