package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.lecture.vo.ProblemBankVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/test/scoreList")
public class TestScoreListController extends HttpServlet{
	private final LectureService ls = new LectureService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LectureVo lectureVo = (LectureVo) req.getSession().getAttribute("lectureVo");
			
			String examCategoryNo = req.getParameter("no");
			String examSubject = req.getParameter("subject");

			if(examCategoryNo == null || examSubject == null) {
				examCategoryNo = "1";
				examSubject = "프로그래밍 언어 응용";				
			}
			
			ProblemBankVo pbv = new ProblemBankVo();
			pbv.setExamCategoryNo(examCategoryNo);
			pbv.setExamSubject(examSubject);

			List<MemberVo> memberList = ls.getMemberList(lectureVo);
			
			req.setAttribute("problemBankVo", pbv);
			req.setAttribute("memberList", memberList);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/scoreList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error(채점)");
		}
	}
}
