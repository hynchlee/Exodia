package com.semi.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.semi.board.service.BoardService;
import com.semi.board.vo.ReplyVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/board/reply/edit")
public class BoardReplyEditController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String writerNo = loginMember.getMemberNo();
			
			try {
				String rno = req.getParameter("replyNo");
		        String updatedContent = req.getParameter("updatedContent");

		        // 데이터베이스 업데이트 로직을 수행합니다 (여기에 실제로 데이터베이스를 업데이트하는 코드를 추가해야 합니다)
		        ReplyVo revo = new ReplyVo();
		        revo.setReplyNo(rno);
		        revo.setReplyContent(updatedContent);
		        
		        BoardService bs = new BoardService();
		        int result = bs.editReply(revo);
		        

		        // 업데이트 결과를 클라이언트에게 응답합니다
//		        PrintWriter out = resp.getWriter();
		        if (result == 1) {
//		        	out.print("댓글이 업데이트되었습니다.");
//		        	out.close();
		        	
		        	resp.setContentType("text/plain");
		            resp.getWriter().write("댓글이 수정되었습니다.");
				}
			} catch (Exception e) {
				System.out.println("[ERROR] board reply edidt error");
				e.printStackTrace();
			}
	
	}

}
