package com.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.board.vo.ReplyVo;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			
			String bno = req.getParameter("bno");
			
			BoardService bs = new BoardService();
			BoardVo cvNo = bs.getBoardByNo(bno);
			
			if (cvNo == null) {
				
				throw new Exception();
				
			}
			
//			List<ReplyVo> revoList = bs.getBoardReplyList(bno);
			
//			req.setAttribute("bno", bno);
//			req.setAttribute("revoList", revoList);
			req.setAttribute("cvNo", cvNo);
			req.getRequestDispatcher("/WEB-INF/views/board/boardDetail.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "잘못된 접근");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}
	
	//댓글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}

}
