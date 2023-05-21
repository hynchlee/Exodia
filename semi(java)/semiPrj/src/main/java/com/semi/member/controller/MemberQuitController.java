package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.service.MemberService;
import com.semi.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getMemberNo();
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.quit(memberNo);
			
			//화면
			if(result == 1) {
				session.invalidate();
				req.getSession().setAttribute("alertMsg", "회원 탈퇴 성공");
				resp.sendRedirect(req.getContextPath()+ "/main");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] quit fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원 탈퇴 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}

}
