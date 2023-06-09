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

import com.google.gson.Gson;
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
import com.semi.teamCalendar.service.TeamCalendarService;
import com.semi.teamCalendar.vo.TeamCalendarVo;
import com.semi.vacation.dao.VacationDao;
import com.semi.vacation.vo.VacationVo;

@WebServlet(urlPatterns = "/tmypage")
public class tMypageController extends HttpServlet {
	private static TeamCalendarService fcs = new TeamCalendarService();
	private static LectureService ls = new LectureService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			LectureVo lectureVo = (LectureVo) session.getAttribute("lectureVo");
			if(loginMember == null || !loginMember.getIdentity().equals("T")) {
				req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
				resp.sendRedirect("/semi/member/login");
				return;
			}

			String memberNo = loginMember.getMemberNo();

			MypageService ms = new MypageService();
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
			List<VacationVo> vaList = ms.watchingStudent(lectureVo.getLectureNo());
			List<CalenderVo> ttodoList = ms.ttodoList(memberNo);
			List<TeamCalendarVo> voList = fcs.tgetFullCalendar(lectureVo.getLectureNo());
			
			req.setAttribute("voList", voList);
			req.setAttribute("volist", volist);
			req.setAttribute("tvolist", tvolist);
			req.setAttribute("notList", notList);
			req.setAttribute("tcvoList", tcvoList);
			req.setAttribute("letterCount", letterCount);
			req.setAttribute("countMyWrite", countMyWrite);
			req.setAttribute("ttodoList", ttodoList);	
			req.setAttribute("vaList", vaList);				
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
			Gson gson = new Gson();
			String params = req.getParameter("params");
			
			if(params != null) {
				String[] paramsArr = gson.fromJson(params, String[].class);
				
				int result = ls.updateTeamRole(paramsArr);
				if(result == 0) {
					throw new Exception();
				}
				return;
			}
			
			String lectureNo = req.getParameter("lectureNo");
			LectureVo lectureVo = ls.getLectureOne(lectureNo);
			req.getSession().setAttribute("lectureVo", lectureVo);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}
	}

}