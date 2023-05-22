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
import com.semi.lecture.vo.LectureMemberVo;
import com.semi.lecture.vo.ProblemBankVo;
import com.semi.lecture.vo.SubmitAnswerVo;
import com.semi.member.vo.MemberVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/test/list")
public class TestListController extends HttpServlet {
	private final LectureService ls = new LectureService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			int cnt = ls.getExamCategoryListCnt(loginMember);

			String page = req.getParameter("page");
			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}

			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<ExamCategoryVo> examCategoryList = ls.getExamCategoryList(pageVo, loginMember);

			req.setAttribute("examCategoryList", examCategoryList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/list.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("error(시험 목록 (학생))");
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			String examCategoryNo = req.getParameter("examCategoryNo");
			String examSubject = req.getParameter("examSubject");
			
			ProblemBankVo pbv = new ProblemBankVo();
			pbv.setExamCategoryNo(examCategoryNo);
			pbv.setExamSubject(examSubject);

			List<SubmitAnswerVo> submitAnswerList = ls.getSubmitAnswerList(pbv, loginMember.getMemberNo());
			req.setAttribute("submitAnswerList", submitAnswerList);
			req.setAttribute("problemBankVo", pbv);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/start.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error(학생 평)");
		}

	}
}
