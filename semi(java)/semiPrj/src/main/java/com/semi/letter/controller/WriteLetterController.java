package com.semi.letter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.letter.service.LetterService;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/letter/write")
public class WriteLetterController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
				
		if(loginMember == null) {
			req.setAttribute("errorMsg", "로그인을 먼저 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/views/letter/write-letter.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		
		String sendMemberName = loginMember.getMemberNick();
		
		try {
			String receiver = req.getParameter("receiver");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			LetterVo vo = new LetterVo();
			vo.setReceiveMemberName(receiver);
			vo.setLetterTitle(title);
			vo.setLetterContent(content);
			
			LetterService ms = new LetterService();
			int result = ms.writeLetter(vo, sendMemberName);
			
			if(result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/letter/sent-letter.jsp").forward(req, resp);
			}
			
			else {
				req.setAttribute("errorMsg", "오류발생");
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			System.out.println("쪽지 작성 중 오류 발생");
			e.printStackTrace();
		}
		
	}
	
}
