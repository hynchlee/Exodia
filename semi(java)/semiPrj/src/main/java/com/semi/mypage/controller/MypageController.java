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

import com.semi.board.vo.BoardVo;
import com.semi.lecture.vo.LectureVo;
import com.semi.member.vo.MemberVo;
import com.semi.mypage.service.MypageService;

@WebServlet(urlPatterns = "/mypage")
public class MypageController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			if (loginMember == null) {
				throw new IllegalSelectorException();
			}
			
			String memberNo = loginMember.getMemberNo();
			
			MypageService ms = new MypageService();
			List<BoardVo> snotList = ms.showNotice02();
			String letterCount = ms.countLetter01(memberNo);
			String countMyWrite = ms.countMyWrite(memberNo);
			
			req.setAttribute("snotList", snotList);
			req.setAttribute("letterCount", letterCount);
			req.setAttribute("countMyWrite", countMyWrite);
			req.getRequestDispatcher("/WEB-INF/views/personal/mypage.jsp").forward(req, resp);
			
			} catch (Exception e) {
				System.out.println("mypage 게시판 조회 중 발생");
				e.printStackTrace();
				
				req.setAttribute("errorMsg", "마이페이지 조회중 에러발생");
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}
			 
		
	}
	
}