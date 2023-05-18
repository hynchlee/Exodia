package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.service.MemberService;
import com.semi.member.vo.MemberVo;

@WebServlet("/member/id/find")
public class IdFindController extends HttpServlet{
	
	//아이디 찾기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/idFind.jsp").forward(req, resp);
	}
	
	//아이디 찾기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String memberName = req.getParameter("memberName");
			String phoneNo = req.getParameter("phoneNo");
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setMemberName(memberName);
			vo.setPhoneNo(phoneNo);
			
			
			//////////////////여기까지 손 댐///////////////////////
			
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			//화면
			if(loginMember != null) {
				
				req.getSession().setAttribute("loginMember", loginMember);
				String root = req.getContextPath();
				
				if ( "S".equals(loginMember.getIdentity()) ) {
					resp.sendRedirect(root + "/smain");
				}else if( "T".equals(loginMember.getIdentity()) ) {
					resp.sendRedirect(root + "/tmain");
				}//ifif
				
			}//if
			
		}catch(Exception e) {
			System.out.println("[ERROR] login fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "로그인 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
	
	
}
