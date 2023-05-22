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

@WebServlet("/letter/trash")
public class TrashLetterController extends HttpServlet {

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

			String memberNo = loginMember.getMemberNo();

			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			String searchSR = req.getParameter("searchSR");

			LetterService ls = new LetterService();

			int cnt = ls.getLetterListCnt(searchSR, searchType, searchValue, memberNo);
			String page_ = req.getParameter("page");
			if (page_ == null) {
				page_ = "1";
			}
			int page = Integer.parseInt(page_);
			PageVo pv = new PageVo(cnt, page, 5, 10);

			// 서비스
			List<LetterVo> voList = null;
			// List<BoardVo> voList = bs.getBoardList(pv);
			if (searchSR == null || searchSR.equals("") || searchType == null || searchType.equals("")) {
				voList = ls.getLetterList(pv, memberNo);
			} else {
				voList = ls.getLetterTrashList(searchSR, pv, searchType, searchValue, memberNo);
			}

			Map<String, String> map = new HashMap<>();
			map.put("searchSR", searchSR);
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);

			// 화면
			req.setAttribute("searchVo", map);
			req.setAttribute("voList", voList);
			req.setAttribute("pageVo", pv);
			req.getRequestDispatcher("/WEB-INF/views/letter/receive-letter.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] 받은편지 오류 에러");
			e.printStackTrace();

			req.setAttribute("errorMsg", "받은 편지 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
}
