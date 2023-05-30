package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.service.MemberService;

@WebServlet("/member/join/idcheck")
public class IdCheckController extends HttpServlet{

	//중복체크
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String memberId = req.getParameter("memberId");
			MemberService ms = new MemberService();
			int result = ms.checkId(memberId);
			if (result == 0) {
				resp.getWriter().write("ok");
			}else {
				resp.getWriter().write("no");
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] id check fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "아이디 중복검사 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
}
