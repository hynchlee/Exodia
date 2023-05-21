package com.semi.notice.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.page.PageVo;
import com.semi.notice.service.NoticeService;
import com.semi.notice.vo.NoticeVo;

@WebServlet("/notice/list")
public class BoardNoticeListController extends HttpServlet{

	private final NoticeService ns = new NoticeService();
	
	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");

			int cnt = ns.getNoticeListCnt(searchType, searchValue);
			int page = Integer.parseInt(req.getParameter("page")); //현재 페이지 받아오기
			PageVo pv = new PageVo(cnt, page, 5, 10);
			
			List<NoticeVo> nvoList = null;
			if (searchType == null || searchType.equals("")) {
				nvoList = ns.getNoticeList(pv);
			}else {
				nvoList = ns.getNoticeList(pv, searchType, searchValue);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("nvoList", nvoList);
			req.getRequestDispatcher("/WEB-INF/views/notice/boardNoticeList.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[Error] notice list error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "공지사항 목록조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
