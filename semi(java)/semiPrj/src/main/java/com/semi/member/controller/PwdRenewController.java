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

@WebServlet("/member/pwd/renew")
public class PwdRenewController extends HttpServlet{
	
	//새 비밀번호 입력 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo pwdFind = (MemberVo) req.getSession().getAttribute("pwdFind");
		
		if(pwdFind != null) {
			req.getRequestDispatcher("/WEB-INF/views/member/pwdRenew.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인을 먼저 해주세요");
			resp.sendRedirect(req.getContextPath() + "/main");
		}
	}
	
	//새 비밀번호 입력
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			MemberVo pwdFind = (MemberVo) session.getAttribute("pwdFind");
			
			//데꺼
			String memberNo = pwdFind.getMemberNo();
			String memberPwd = req.getParameter("memberPwd");
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setMemberNo(memberNo);
			vo.setMemberPwd(memberPwd);
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.renewPwd(vo);
			
			//화면
			if(result == 1) {
				String root = req.getContextPath();
				req.getSession().setAttribute("alertMsg", "비밀번호 수정 성공!");
				resp.sendRedirect(root + "/main");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] renew pwd fail ...");
			e.printStackTrace();
			
			req.setAttribute("alertMsg", "비밀번호 수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/member/pwdRenew.jsp").forward(req, resp);
		}
	
	}
	
}
