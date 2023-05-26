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
import com.semi.vacation.vo.VacationVo;

@WebServlet("/member/vacation/form")
public class MemberVactionFormController extends HttpServlet{
	
	//휴가신청 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		
		if(loginMember != null) {
			req.getRequestDispatcher("/WEB-INF/views/member/vacationForm.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인을 먼저 해주세요");
			resp.sendRedirect(req.getContextPath() + "/main");
		}
	}
	
	//휴가신청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");

			//데꺼
			String memberNo = loginMember.getMemberNo();
			String originVacationStart = req.getParameter("vacationStart");
			String originVacationEnd = req.getParameter("vacationEnd");
			String reason = req.getParameter("reason");
			
			String vacationStart = originVacationStart.replace("-", "");
			String vacationEnd = originVacationEnd.replace("-", "");

			//데뭉
			VacationVo vo = new VacationVo();
			vo.setMemberNo(memberNo);
			vo.setVacationStart(vacationStart);
			vo.setVacationEnd(vacationEnd);
			vo.setReason(reason);
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.requestVacation(vo);
			
			//화면
			if(result == 1) {
				String root = req.getContextPath();
				req.getSession().setAttribute("alertMsg", "휴가신청 성공!");
				resp.sendRedirect(root + "/main");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] request vacation fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "휴가신청 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
	
}
