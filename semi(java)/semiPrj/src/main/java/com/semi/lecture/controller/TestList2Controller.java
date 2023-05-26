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
import com.semi.lecture.vo.ExamCategoryVo;
import com.semi.lecture.vo.LectureMemberVo;
import com.semi.lecture.vo.LectureVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/lecture/test/list2")
public class TestList2Controller extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			LectureVo lectureVo = (LectureVo) req.getSession().getAttribute("lectureVo");
			if(loginMember == null || !loginMember.getIdentity().equals("T")) {
				req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
				resp.sendRedirect("/semi/member/login");
				return;
			}

			
			int cnt = ls.getExamCategoryListCnt2(lectureVo.getLectureNo());

			String page = req.getParameter("page");
			int pageInt = 1;
			if (page != null) {
				pageInt = Integer.parseInt(page);
			}

			PageVo pageVo = new PageVo(cnt, pageInt, 5, 10);
			List<ExamCategoryVo> examCategoryList = ls.getExamCategoryList2(pageVo, lectureVo.getLectureNo());

			List<MemberVo> memberList = ls.getMemberList(lectureVo.getLectureNo());
			examCategoryList = ls.updateExamStatusList(examCategoryList, memberList.get(0).getMemberNo());
			
			req.setAttribute("examCategoryList", examCategoryList);
			req.setAttribute("pageVo", pageVo);
			req.getRequestDispatcher("/WEB-INF/views/lecture/test/list2.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String type = req.getParameter("type");
			String examCategoryNo = req.getParameter("examCategoryNo");
			String lectureNo = req.getParameter("lectureNo");
			int result = 0;
			
			if(type.equals("start")) {
				result = ls.testStart(examCategoryNo, lectureNo);
			} else if(type.equals("end")) {
				result = ls.testEnd(examCategoryNo, lectureNo);
			}
			
			if(result == 0) {
				throw new Exception();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/semi/lecture/test/list2");
	}
}
