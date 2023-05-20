package com.semi.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.service.BoardService;
import com.semi.common.page.PageVo;

@WebServlet("/my/list")
public class BoardMyListController extends HttpServlet{

	private final BoardService bs = new BoardService();
	
	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//페이징
		String searchType = req.getParameter("searchType");
		String searchValue = req.getParameter("searchValue");
		String searchCategory = req.getParameter("searchCategory");
		
//		int cnt = bs.getBoardMyListCnt();
//		int page = Integer.parseInt(req.getParameter("page"));
//		PageVo pv = new PageVo(cnt, page, 5, 10);
//		
//		HashMap<K, V>
//		
//		req.getRequestDispatcher("/WEB-INF/views/board/boardMyList.jsp").forward(req, resp);
	}

}
