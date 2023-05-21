package com.semi.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.member.vo.MemberVo;
import com.semi.review.service.ReviewService;
import com.semi.review.vo.ReviewVo;

@WebServlet("/review/edit")
public class ReviewEditController extends HttpServlet{
	
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인유저 회원번호 가져오기
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null) {
			req.setAttribute("errorMsg", "로그인 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			String rno = req.getParameter("rno");
			
			ReviewService rs = new ReviewService();
			ReviewVo rvNo = rs.getReviewNo(rno);
			
			req.setAttribute("rvNo", rvNo);
			req.getRequestDispatcher("/WEB-INF/views/review/reviewEdit.jsp").forward(req, resp);
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
			String rno = req.getParameter("rno");
			String boardTitle = req.getParameter("boardTitle");
	        String boardContent = req.getParameter("boardContent");
	        
	        ReviewVo rvo = new ReviewVo();
	        rvo.setReviewNo(rno);
	        rvo.setReviewTitle(boardTitle);
	        rvo.setReviewContent(boardContent);
	        
	        ReviewService rs = new ReviewService();
	        int result = rs.editReview(rvo);
	        
	        if (result != 1) {
				throw new Exception();
			}
	        
	        resp.sendRedirect(req.getContextPath() + "/review/detail?rno=" + rno);
	        
		} catch (Exception e) {
			System.out.println("[ERROR] board edit error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
