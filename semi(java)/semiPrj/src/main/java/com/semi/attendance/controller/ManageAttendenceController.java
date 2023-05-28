package com.semi.attendance.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.vo.AdminVo;
import com.semi.attendance.service.AttendanceService;
import com.semi.attendance.vo.AttendanceVo;
import com.semi.common.page.PageVo;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/attendance/manage")
public class ManageAttendenceController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo) session.getAttribute("loginAdmin");
		
		if (loginAdmin == null) {
			req.setAttribute("errorMsg", "관리자 로그인을 먼저 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			
		String searchType = req.getParameter("searchType");
		String searchValue = req.getParameter("searchValue");
		
		AttendanceService as = new AttendanceService();
		int cnt = as.getAdminAttendanceListCnt(searchType, searchValue);
		String page_ = req.getParameter("page");
		if (page_ == null) {
			page_ = "1";
		}
		int page = Integer.parseInt(page_);
		PageVo pv = new PageVo(cnt, page, 5, 10);
		
		//서비스
		List<AttendanceVo> voList = null;
		//List<BoardVo> voList = bs.getBoardList(pv);
		if (searchType ==null || searchType.equals("")) {
			voList = as.getAdminAttendanceList(pv);
		}
		else {
			voList = as.getAdminAttendanceList(pv, searchType, searchValue);
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		
		//화면
		req.setAttribute("searchVo", map);
		req.setAttribute("voList", voList);
		req.setAttribute("pageVo", pv);
		req.getRequestDispatcher("/WEB-INF/views/attendance/attendance-manage.jsp").forward(req, resp);
	} catch (Exception e) {
		System.out.println("[ERROR] 관리자용 출석 조회 오류");
		e.printStackTrace();
		
		req.setAttribute("errorMsg", "관리자용 출석 조회 오류");
		req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
	}

}

}
