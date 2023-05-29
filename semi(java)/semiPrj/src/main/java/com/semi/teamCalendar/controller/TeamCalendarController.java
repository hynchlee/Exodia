package com.semi.teamCalendar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.member.vo.MemberVo;
import com.semi.teamCalendar.service.TeamCalendarService;
import com.semi.teamCalendar.vo.TeamCalendarVo;

@WebServlet("/teamCalendar")
public class TeamCalendarController extends HttpServlet {
	private static TeamCalendarService fcs = new TeamCalendarService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if (loginMember == null || !loginMember.getIdentity().equals("S")) {
				req.getSession().setAttribute("alertMsg", "로그인이 필요한 기능입니다");
				resp.sendRedirect("/semi/member/login");
				return;
			}

			List<TeamCalendarVo> voList = fcs.getFullCalendar(loginMember.getMemberNo());
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/teamCalendar/teamCalendar.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");

			Gson gson = new Gson();
			String params = req.getParameter("params");
			String[] paramsArr = gson.fromJson(params, String[].class);

			int result = 0;
			
			if(paramsArr[0].equals("write")) {
				result = fcs.writeCalendar(loginMember.getMemberNo(), paramsArr);				
			} else if(paramsArr[0].equals("modify")) {
				result = fcs.modifyCalendar(loginMember.getMemberNo(), paramsArr);
			} else if(paramsArr[0].equals("delete")) {
				result = fcs.deleteCalendar(loginMember.getMemberNo(), paramsArr);
			}

			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/semi/main");
		}

	}
}
