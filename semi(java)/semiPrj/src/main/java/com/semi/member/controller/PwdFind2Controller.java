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

@WebServlet("/member/pwd/find2")
public class PwdFind2Controller extends HttpServlet{
	
	//비밀번호 찾기2 화면
	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo pwdFind = (MemberVo) req.getSession().getAttribute("pwdFind");
		
		if(pwdFind != null) {
			req.getRequestDispatcher("/WEB-INF/views/member/pwdFind2.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인을 먼저 해주세요");
			resp.sendRedirect(req.getContextPath() + "/main");
		}
	}
	
}
