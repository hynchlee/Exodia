package com.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.vo.AdminVo;
import com.semi.member.vo.MemberVo;
import com.semi.qna.service.QnaService;
import com.semi.qna.vo.QnaVo;

@WebServlet("/qna/answer/write")
public class QnaAnswerWriteController extends HttpServlet{
	
	//관리자한테만 보이는 페이지
	
	//답변 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인유저 회원번호 가져오기
		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin");
		if(loginAdmin == null) {
			req.setAttribute("errorMsg", "로그인해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			String qno = req.getParameter("qno");

			QnaService qs = new QnaService();
			QnaVo qvNo = qs.getQnaByNo(qno);
			
			req.setAttribute("qvNo", qvNo);
			req.getRequestDispatcher("/WEB-INF/views/qna/qnaAnswerWrite.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] qna answer write view error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "문의 답변 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	//답변하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin");
		
		if (loginAdmin == null) {
			req.setAttribute("errorMsg", "답변 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			String qno = req.getParameter("qno");
			String qnaAnswerContent = req.getParameter("qnaAnswerContent");
			String adminNo = loginAdmin.getAdminNo();
			
			QnaVo qvo = new QnaVo();
			qvo.setQnaNo(qno);
			qvo.setQnaAnswer(qnaAnswerContent);
			qvo.setAdminNo(adminNo);
			
			QnaService qs = new QnaService();
			int result = qs.answerWriteQna(qvo);
			
			if (result == 1) {
				resp.sendRedirect(req.getContextPath() + "/qna/detail?qno=" + qno);
			}else {
				throw new IllegalStateException("게시글 작성 결과 1이 아님");
			}
		} catch (Exception e) {
			System.out.println("[ERROR] qna answer write error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "문의 답변 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	

}
