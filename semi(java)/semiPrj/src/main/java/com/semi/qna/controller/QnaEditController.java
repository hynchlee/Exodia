package com.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.vo.AdminVo;
import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.member.vo.MemberVo;
import com.semi.notice.service.NoticeService;
import com.semi.notice.vo.NoticeVo;
import com.semi.qna.service.QnaService;
import com.semi.qna.vo.QnaVo;
import com.semi.review.service.ReviewService;
import com.semi.review.vo.ReviewVo;

@WebServlet("/qna/edit")
public class QnaEditController extends HttpServlet{
	
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인유저 회원번호 가져오기
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		if(loginMember == null) {
			req.setAttribute("errorMsg", "로그인해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			String qno = req.getParameter("qno");

			QnaService qs = new QnaService();
			QnaVo qvNo = qs.getQnaByNo(qno);
			
			req.setAttribute("qvNo", qvNo);
			req.getRequestDispatcher("/WEB-INF/views/qna/qnaEdit.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] board edit error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	//수정 작업
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String qno = req.getParameter("qno");
			String boardTitle = req.getParameter("boardTitle");
	        String boardContent = req.getParameter("boardContent");

	        QnaVo qvo = new QnaVo();
	        qvo.setQnaNo(qno);
	        qvo.setQnaTitle(boardTitle);
	        qvo.setQnaContent(boardContent);
	        
	        QnaService qs = new QnaService();
	        int result = qs.editQna(qvo);
	        
	        if (result != 1) {
				throw new Exception();
			}
	        
	        resp.sendRedirect(req.getContextPath() + "/qna/detail?qno=" + qno);
	        
		} catch (Exception e) {
			System.out.println("[ERROR] board edit error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
