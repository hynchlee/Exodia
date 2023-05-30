package com.semi.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.board.service.BoardService;
import com.semi.board.vo.ReplyVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/board/reply/write")
public class BoardReplyWriteController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			
			
			String writerNo = loginMember.getMemberNo();
			
			String bno = req.getParameter("bno");
			String replyContent = req.getParameter("replyContent");
			
			ReplyVo revo = new ReplyVo();
			revo.setBoardNo(bno);
			revo.setReplyContent(replyContent);
			revo.setWriterNo(writerNo);
			
			BoardService bs = new BoardService();
			int result = bs.replyWrite(revo);
			
//			if (result != 1) {
//				throw new Exception();
//			}
			
			System.out.println("댓글 작성 결과" + result);
			
			//문자열 내보내기
			PrintWriter out = resp.getWriter();
			if (result == 1) {
				out.write("success");
			}
		} catch (Exception e) {
			System.out.println("[ERROR] board reply error");
			e.printStackTrace();
			
			
		}
		
	}
	

}
