package com.semi.main.controller;

import java.io.IOException;
import java.nio.channels.IllegalSelectorException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.vo.MemberVo;
import com.semi.mypage.service.MypageService;

@WebServlet(urlPatterns = "/smain")
public class StudentMainController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			if (loginMember == null) {
				throw new IllegalSelectorException();
			}
			
			String memberNo = loginMember.getMemberNo();
			
			MypageService ms = new MypageService();
			String letterCount = ms.countLetter01(memberNo);
			String countMyWrite = ms.countMyWrite(memberNo);
			
			req.setAttribute("letterCount", letterCount);
			req.setAttribute("countMyWrite", countMyWrite);
			req.getRequestDispatcher("/WEB-INF/views/main/smain.jsp").forward(req, resp);
			
			} catch (Exception e) {
				System.out.println("smain 조회 중 에러 발생");
				e.printStackTrace();
				
				req.setAttribute("errorMsg", "smain 조회중 에러발생");
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}
	
	}
	
}
