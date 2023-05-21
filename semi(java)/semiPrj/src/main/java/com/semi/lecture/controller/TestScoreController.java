package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.ProblemBankVo;
import com.semi.lecture.vo.SubmitAnswerVo;

@WebServlet("/lecture/test/score")
public class TestScoreController extends HttpServlet{
	private final LectureService ls = new LectureService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
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
			System.out.println("error(채점 post)");
		}
	}
}
