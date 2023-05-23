package com.semi.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.service.BoardService;
import com.semi.board.vo.ReplyVo;

@WebServlet("/board/reply/list")
public class BoardReplyListController extends HttpServlet{
	
	
	//댓글 목록 조회
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String bno = req.getParameter("bno");
			
			BoardService bs = new BoardService();
			List<ReplyVo> revolist = bs.getBoardReplyList(bno);
			
			PrintWriter out = resp.getWriter();
			out.write(revolist.toString());
			
		} catch (Exception e) {
			System.out.println("[ERROR] reply list error");
			e.printStackTrace();
		}
		
		
		
	}

}
