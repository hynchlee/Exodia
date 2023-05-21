package com.semi.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.page.PageVo;
import com.semi.review.service.ReviewService;
import com.semi.review.vo.ReviewVo;

@WebServlet("/review/list")
public class BoardReviewListController extends HttpServlet{
	
	private final ReviewService res = new ReviewService();

	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//검색
//			String searchCategory = req.getParameter("searchCategory");
			
			int cnt = res.getReviewListCnt();
			int page = Integer.parseInt(req.getParameter("page"));
			PageVo pv = new PageVo(cnt, page, 5, 10);
			
			List<ReviewVo> rvoList = res.getReviewList(pv);
			
			
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("rvoList", rvoList);
			req.getRequestDispatcher("/WEB-INF/views/review/boardReviewList.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[ERROR] review list error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "수강후기 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
