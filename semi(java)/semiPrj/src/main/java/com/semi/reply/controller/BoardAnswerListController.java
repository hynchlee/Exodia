package com.semi.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.semi.board.service.BoardService;
import com.semi.board.vo.AnswerVo;
import com.semi.board.vo.ReplyVo;

@WebServlet("/board/answer/list")
public class BoardAnswerListController extends HttpServlet{
	
	
	//댓글 목록 조회
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String rno = req.getParameter("rno");
			
			BoardService bs = new BoardService();
			
			//답글 조회
			List<AnswerVo> answerList = bs.getReplyAnswerList(rno);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(answerList);
			
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
			
		} catch (Exception e) {
			System.out.println("[ERROR] answer list error");
			e.printStackTrace();
		}
		
		
		
	}

}
