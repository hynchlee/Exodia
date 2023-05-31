package com.semi.mypage.controller;

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

@WebServlet(urlPatterns = "/mypage/checkout")
public class PressCheckOut extends HttpServlet{

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
		 	int inTimes = ms.inTimes(memberNo);
		 	
		 	int result = 0;
		 	
		 	if(inTimes < 30000) {
		 		result = ms.notCome(memberNo);
		 	}
		 	else if(inTimes < 60000) {
		 		result = ms.late(memberNo);
		 	}
		 	else {
		 		result = ms.checkout(memberNo);		 		
		 	}
		 	
		 	if(result == 1) {
				String root = req.getContextPath();
				resp.sendRedirect(root + "/mypage");
			}else {
				throw new Exception("입실 체크 실패..");
			}
			
		} catch (Exception e) {
			System.out.println("입실 체크 중 에러 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "입실 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
	
}
