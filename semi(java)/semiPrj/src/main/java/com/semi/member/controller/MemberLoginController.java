package com.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.lecture.vo.LectureCategoryVo;
import com.semi.member.service.MemberService;
import com.semi.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	
	//로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		
		if(loginMember == null) {
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "이미 로그인 상태입니다.");
			resp.sendRedirect(req.getContextPath() + "/main");
		}
	}
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//데꺼
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			
			//관리자 로그인 창 이동
			if("admin".equals(memberId) && "admin".equals(memberPwd)) {
				resp.sendRedirect(req.getContextPath() + "/admin/login");
				return;
			}
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			//강의 리스트 선언
			List<LectureCategoryVo> memberLecture = new ArrayList<>();

			//화면
			if(loginMember != null) {
				
				req.getSession().setAttribute("loginMember", loginMember);
				
				//세션에 강의 목록 추가
				memberLecture = ms.getLecture(loginMember.getMemberNo(), loginMember.getIdentity());
				req.getSession().setAttribute("memberLecture", memberLecture);
				
				String root = req.getContextPath();
				resp.sendRedirect(root + "/main");
				
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] login fail ...");
			e.printStackTrace();
			
			req.setAttribute("alertMsg", "로그인 실패...");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}
	
	}
	
}
