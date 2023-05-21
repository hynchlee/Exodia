package com.semi.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.qna.service.QnaService;
import com.semi.qna.vo.QnaVo;
import com.semi.review.service.ReviewService;
import com.semi.review.vo.ReviewVo;

@WebServlet("/review/detail")
public class ReviewDetailController extends HttpServlet{
	
	//관리자한테만 보이는 페이지
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String rno = req.getParameter("rno");
			
			ReviewService rs = new ReviewService();
			ReviewVo rvNo = rs.getReviewNo(rno);
			
			if (rvNo == null) {
				throw new Exception();
			}
			
			req.setAttribute("rvNo", rvNo);
			req.getRequestDispatcher("/WEB-INF/views/review/reviewDetail.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "잘못된 접근");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage");
		}
		
	}

}
