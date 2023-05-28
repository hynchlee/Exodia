package com.semi.vacation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.attendance.service.AttendanceService;
import com.semi.attendance.vo.AttendanceVo;
import com.semi.common.page.PageVo;
import com.semi.member.vo.MemberVo;
import com.semi.vacation.service.VacationService;
import com.semi.vacation.vo.VacationVo;

@WebServlet("/vacation/list")
public class ListVacationController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");

		if (loginMember == null) {
			req.setAttribute("errorMsg", "로그인을 먼저 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}

		try {

			String no = loginMember.getMemberNo();

			VacationService vs = new VacationService();

			int listCount = vs.getVacationCnt(no);
			String page = req.getParameter("page");
			if (page == null)
				page = "1";
			int currentPage = Integer.parseInt(page);
//			int currentPage = 1;
			int pageLimit = 5;
			int boardLimit = 5;
			PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);

			// 서비스
			List<VacationVo> voList = vs.getVacationList(pv, no);

			// 화면
			req.setAttribute("pv", pv);
			req.setAttribute("list", voList);
			req.getRequestDispatcher("/WEB-INF/views/vacation/list-vacation.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println("휴가 내역 조회 중 오류 발생");
			e.printStackTrace();

			req.setAttribute("errorMsg", "공지사항 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}

	}

}
