package com.semi.mypage.controller;

import java.io.IOException;
import java.nio.channels.IllegalSelectorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.common.page.PageVo;
import com.semi.lecture.vo.LectureVo;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;
import com.semi.mypage.service.MypageService;

@WebServlet(urlPatterns = "/tmypage")
public class tMypageController extends HttpServlet{
	
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
			List<LectureVo> volist = ms.viewStudent(memberNo);
			List<BoardVo> notList = ms.showNotice();			
			List<BoardVo> freeList = ms.freeboard();
			String letterCount = ms.countLetter01(memberNo);
			String countMyWrite = ms.countMyWrite(memberNo);
			
			req.setAttribute("volist", volist);
			req.setAttribute("notList", notList);
			req.setAttribute("freeList", freeList);
			req.setAttribute("letterCount", letterCount);
			req.setAttribute("countMyWrite", countMyWrite);
			req.getRequestDispatcher("/WEB-INF/views/personal/tmypage.jsp").forward(req, resp);
			
			} catch (Exception e) {
				System.out.println("tmypage 게시판 조회 중 발생");
				e.printStackTrace();
				
				req.setAttribute("errorMsg", "마이페이지 조회중 에러발생");
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}
	
		
	
	}
	
}