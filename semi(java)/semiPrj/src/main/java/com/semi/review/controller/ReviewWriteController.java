package com.semi.review.controller;

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
import com.semi.qna.service.QnaService;
import com.semi.qna.vo.QnaVo;
import com.semi.review.service.ReviewService;
import com.semi.review.vo.ReviewVo;

@WebServlet("/review/write")
public class ReviewWriteController extends HttpServlet{
	
	//작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/review/reviewWrite.jsp").forward(req, resp);
	}
	
	//작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//로그인유저 회원번호 가져오기
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			if(loginMember == null) {
				req.setAttribute("errorMsg", "로그인 해주세요");
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
				return;
			}
			
			//데꺼
			String boardTitle = req.getParameter("boardTitle");
            String boardContent = req.getParameter("boardContent");
            String boardWriterNo = loginMember.getMemberNo();
			
			//데뭉
            ReviewVo rvo = new ReviewVo();
            rvo.setReviewTitle(boardTitle);
            rvo.setReviewContent(boardContent);
            rvo.setMemberNo(boardWriterNo);
            
            ReviewService rs = new ReviewService();
            int result = rs.reviewWrite(rvo);
    
			//화면
			if (result == 1) {
				resp.sendRedirect(req.getContextPath() + "/review/list?page=1");
			}else {
				throw new IllegalStateException("게시글 작성 결과 1이 아님");
			}
		} catch (Exception e) {
			System.out.println("[ERROR] review write error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
		
	}

}
