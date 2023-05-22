package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.page.PageVo;
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/apply")
public class LectureApplyController extends HttpServlet{
	private final LectureService ls = new LectureService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int cnt = ls.getLectureListCnt();

			String page = req.getParameter("page");
			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}
			
			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<LectureVo> lectureList = ls.getLectureList(pageVo);

			req.setAttribute("lectureList", lectureList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/apply.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("error(수강신청 get)");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			String lectureNo = req.getParameter("lectureNo");
			
			if(loginMember == null) {
				req.getSession().setAttribute("alertMsg", "로그인을 먼저 해주세요");
				resp.sendRedirect("/semi/member/login");
				return;
			} else {
				int result = ls.lectureApplyOne(lectureNo, loginMember.getMemberNo());
				
				if(result == 1) {
					req.getSession().setAttribute("alertMsg", "수강신청이 완료되었습니다");
					resp.sendRedirect("/semi/lecture/apply");
				} else {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			System.out.println("error(수강신청 post)");
		}
	}
}
