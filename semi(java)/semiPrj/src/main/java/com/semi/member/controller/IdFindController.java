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
			String memberNick = req.getParameter("memberNick");
			String phoneNo = req.getParameter("phoneNo");
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setMemberNick(memberNick);
			vo.setPhoneNo(phoneNo);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo idFind = ms.findId(vo);
			
			//화면
			if(idFind != null) {
				req.setAttribute("idFind", idFind);
				req.getRequestDispatcher("/WEB-INF/views/member/idFind2.jsp").forward(req, resp);
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] id find fail ...");
			e.printStackTrace();
			
			req.setAttribute("alertMsg", "아이디 찾기 실패...");
			req.getRequestDispatcher("/WEB-INF/views/member/idFind.jsp").forward(req, resp);
		}
	
	}
	
	
}
