package com.semi.notice.controller;

import java.io.IOException;
import java.util.List;

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
			// 페이징처리
			int listCount = ns.selectCnt();
			int currentPage = Integer.parseInt(req.getParameter("page"));
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			List<NoticeVo> list = ns.selectNoticeList(pv);
			
			//화면
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/board/boardNoticeList.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[Error] notice list error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "공지사항 목록조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
