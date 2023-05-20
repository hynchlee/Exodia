package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.service.MemberService;
import com.semi.member.vo.MemberVo;

@WebServlet("/member/pwd/find")
public class PwdFindController extends HttpServlet{
	
	//비밀번호 찾기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/pwdFind.jsp").forward(req, resp);
	}
	
	//비밀번호 찾기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String memberId = req.getParameter("memberId");
			String memberNick = req.getParameter("memberNick");
			String birthNum = req.getParameter("birthNum");
			String phoneNo = req.getParameter("phoneNo");
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setMemberId(memberId);
			vo.setMemberNick(memberNick);
			vo.setBirthNum(birthNum);
			vo.setPhoneNo(phoneNo);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo pwdFind = ms.findPwd(vo);
			
			//화면
			if(pwdFind != null) {
				req.setAttribute("pwdFind", pwdFind);
				req.getRequestDispatcher("/WEB-INF/views/member/pwdFind2.jsp").forward(req, resp);
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] pwd find fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "비밀번호 찾기 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
	
}
