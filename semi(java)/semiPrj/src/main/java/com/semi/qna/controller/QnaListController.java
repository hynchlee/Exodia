package com.semi.qna.controller;

import java.io.IOException;
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
import com.semi.qna.service.QnaService;
import com.semi.qna.vo.QnaVo;

@WebServlet("/qna/list")
public class QnaListController extends HttpServlet{

	private final QnaService qs = new QnaService();
	
	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			try {
			//검색
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			int cnt = qs.getQnaListCnt(searchType, searchValue);
			int page = Integer.parseInt(req.getParameter("page"));
			PageVo pv = new PageVo(cnt, page, 5, 10);
			
			List<QnaVo> qvoList = null;
			if (searchType == null || searchValue.equals("")) {
				qvoList = qs.getBoardQnaList(pv);
			}else {
				qvoList = qs.getBoardQnaList(pv, searchType, searchValue);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("qvoList", qvoList);
			req.getRequestDispatcher("/WEB-INF/views/qna/boardQnaList.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[Error] qna list error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "문의게시판 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}

		
	}

}
