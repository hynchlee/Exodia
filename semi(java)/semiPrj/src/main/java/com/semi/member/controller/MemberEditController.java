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

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet{
	
	//회원정보 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
	}
	
	//회원정보 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			//데꺼
			String memberNo = loginMember.getMemberNo();
			String memberPwd = req.getParameter("memberPwd");
			String phoneNo = req.getParameter("phoneNo");
			String profile = req.getParameter("profile");
			
			//데뭉
			MemberVo editVo = new MemberVo();
			editVo.setMemberNo(memberNo);
			editVo.setMemberPwd(memberPwd);
			editVo.setPhoneNo(phoneNo);
			editVo.setProfile(profile);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo updatedMember = ms.edit(editVo, loginMember);
			
			//화면
			if(updatedMember != null) {
				req.getSession().setAttribute("alertMsg", "수정완료!");
				req.getSession().setAttribute("loginMember", updatedMember);
				String root = req.getContextPath();
				resp.sendRedirect(root + "/main");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] edit fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원정보수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
	
	
}
