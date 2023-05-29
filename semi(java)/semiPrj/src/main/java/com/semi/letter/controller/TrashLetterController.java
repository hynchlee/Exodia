package com.semi.letter.controller;

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

import com.semi.common.page.PageVo;
import com.semi.letter.service.LetterService;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;
import com.semi.vacation.service.VacationService;
import com.semi.vacation.vo.VacationVo;

@WebServlet("/letter/trash")
public class TrashLetterController extends HttpServlet {

	private final LetterService ls = new LetterService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");

		if (loginMember == null) {
			req.setAttribute("errorMsg", "로그인을 먼저 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		req.getRequestDispatcher("/WEB-INF/views/letter/trash-letter.jsp").forward(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");

		if (loginMember == null) {
			req.setAttribute("errorMsg", "로그인을 먼저 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		String memberNo = loginMember.getMemberNo();
		
		try {

			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			LetterService ls = new LetterService();
			
			int cnt = ls.getLetterTrashListCnt(searchType, searchValue, memberNo);
			String page_ = req.getParameter("page");
			if (page_ == null) {
				page_ = "1";
			}
			int page = Integer.parseInt(page_);
			PageVo pv = new PageVo(cnt, page, 5, 10);
			
			//서비스
			List<LetterVo> voList = null;
			//List<BoardVo> voList = bs.getBoardList(pv);
			if (searchType ==null || searchType.equals("")) {
				voList = ls.getLetterTrashList(pv, memberNo);
			}
			else {
				voList = ls.getLetterTrashList(pv, searchType, searchValue, memberNo);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
						
			//화면
			req.setAttribute("loginMember", loginMember);
			req.setAttribute("searchVo", map);
			req.setAttribute("voList", voList);
			req.setAttribute("pageVo", pv);
			req.getRequestDispatcher("/WEB-INF/views/letter/trash-letter.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] 휴지통 오류 에러");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "휴지통 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}

	}

}
