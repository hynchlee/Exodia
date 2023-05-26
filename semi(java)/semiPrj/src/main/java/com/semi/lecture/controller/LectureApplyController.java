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
public class LectureApplyController extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String page = req.getParameter("page");
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");

			int cnt = ls.getLectureListCnt(searchType, searchValue);

			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}

			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<LectureVo> lectureList = ls.getLectureList(pageVo, searchType, searchValue);

			req.setAttribute("lectureList", lectureList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/apply.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			String lectureNo = req.getParameter("lectureNo");

			if (loginMember == null) {
				req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
				resp.sendRedirect("/semi/member/login");
				return;
			} else {
				String no = ls.getLectureNo(loginMember.getMemberNo());
				if (no == null) {
					int result = ls.lectureApplyOne(lectureNo, loginMember.getMemberNo());
					if (result == 1) {
						req.getSession().setAttribute("alertMsg", "수강신청이 완료되었습니다");
					} else {
						throw new Exception();
					}
				} else {
					req.getSession().setAttribute("alertMsg", "이미 수강중인 강의가 있습니다");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/semi/main");
	}
}
