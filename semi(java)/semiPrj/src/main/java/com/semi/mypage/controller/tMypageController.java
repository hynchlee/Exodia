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
import com.semi.calender.vo.CalenderVo;
import com.semi.common.page.PageVo;
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;
import com.semi.mypage.service.MypageService;
import com.semi.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/tmypage")
public class tMypageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			LectureVo lectureVo = (LectureVo) session.getAttribute("lectureVo");

			if (loginMember == null) {
				throw new IllegalSelectorException();
			}

			String memberNo = loginMember.getMemberNo();

			MypageService ms = new MypageService();
			LectureService ls = new LectureService();
			List<LectureVo> tvolist = ms.teacherLecture(memberNo);

			if(lectureVo == null) {
				lectureVo = tvolist.get(0);
				session.setAttribute("lectureVo", lectureVo);
			}
			
			List<MemberVo> volist = ls.getMemberList(lectureVo.getLectureNo());
			
			List<NoticeVo> notList = ms.showNotice();
			String letterCount = ms.countLetter01(memberNo);
			String countMyWrite = ms.countMyWrite(memberNo);
			List<BoardVo> tcvoList = ms.getBoardTClassList(lectureVo.getLectureNo());
			List<CalenderVo> ttodoList = ms.ttodoList(memberNo);

			req.setAttribute("volist", volist);
			req.setAttribute("tvolist", tvolist);
			req.setAttribute("notList", notList);
			req.setAttribute("tcvoList", tcvoList);
			req.setAttribute("letterCount", letterCount);
			req.setAttribute("countMyWrite", countMyWrite);
			req.setAttribute("ttodoList", ttodoList);	
			req.getRequestDispatcher("/WEB-INF/views/personal/tmypage.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println("tmypage 게시판 조회 중 발생");
			e.printStackTrace();

			req.setAttribute("errorMsg", "마이페이지 조회중 에러발생");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String lectureNo = req.getParameter("lectureNo");
			LectureService ls = new LectureService();
			LectureVo lectureVo = ls.getLectureOne(lectureNo);
			
			req.getSession().setAttribute("lectureVo", lectureVo);
		} catch (Exception e) {
			System.out.println("tmypage 게시판 조회 중 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "마이페이지 조회중 에러발생");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}