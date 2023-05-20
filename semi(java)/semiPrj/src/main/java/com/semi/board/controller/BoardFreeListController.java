package com.semi.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.common.page.PageVo;

@WebServlet("/free/list")
public class BoardFreeListController extends HttpServlet{
	
	private final BoardService bs = new BoardService();

	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//검색
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			int cnt = bs.getBoardFreeListCnt(searchType, searchValue);
			int page = Integer.parseInt(req.getParameter("page")); //현재 페이지 받아오기
			PageVo pv = new PageVo(cnt, page, 5, 10);
			
			List<BoardVo> fvoList = null;
			if (searchType == null || searchValue.equals("")) {
				fvoList = bs.getBoardFreeList(pv);
			}else {
				fvoList = bs.getBoardFreeList(pv, searchType, searchValue);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("fvoList", fvoList);
			req.getRequestDispatcher("/WEB-INF/views/board/boardFreeList.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[Error] free list error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "자유게시판 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
