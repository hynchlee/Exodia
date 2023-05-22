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

@WebServlet("/qna/answer/edit")
public class QnaAnswerEditController extends HttpServlet{
	
	//관리자한테만 보이는 페이지
	
	//답변 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인유저 회원번호 가져오기
		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin");
		if(loginAdmin == null) {
			req.setAttribute("errorMsg", "접근 권한 없음");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			String qno = req.getParameter("qno");

			QnaService qs = new QnaService();
			QnaVo qvNo = qs.getQnaByNo(qno);
			
			req.setAttribute("qvNo", qvNo);
			req.getRequestDispatcher("/WEB-INF/views/qna/qnaAnswerEdit.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] qna answer edit view error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "문의 답변 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	//답변하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			String qno = req.getParameter("qno");
			String qnaAnswerContent = req.getParameter("qnaAnswerContent");
			
			QnaVo qvo = new QnaVo();
			qvo.setQnaNo(qno);
			qvo.setQnaAnswer(qnaAnswerContent);
			
			QnaService qs = new QnaService();
			int result = qs.answerEditQna(qvo);
			
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
