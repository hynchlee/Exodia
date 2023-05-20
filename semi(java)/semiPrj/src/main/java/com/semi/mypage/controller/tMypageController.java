package com.semi.mypage.controller;

import java.io.IOException;
import java.nio.channels.IllegalSelectorException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.lecture.vo.LectureVo;
import com.semi.member.vo.MemberVo;
import com.semi.mypage.service.MypageService;

@WebServlet(urlPatterns = "/tmypage")
public class tMypageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/personal/tmypage.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			if (loginMember == null) {
				throw new IllegalSelectorException();
			}
			
			String memberNo = loginMember.getMemberNo();
			
			MypageService ms = new MypageService();
			List<LectureVo> volist = ms.viewStudent(memberNo);
			
			if (volist == null) {
				throw new Exception("값이 존재하지 않음");
			}
			
			req.setAttribute("volist", volist);
			req.getRequestDispatcher("/WEB-INF/views/personal/tmypage.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("학생 리스트 조회 실패");
			e.printStackTrace();
		}
		
		
		
	}
	
}