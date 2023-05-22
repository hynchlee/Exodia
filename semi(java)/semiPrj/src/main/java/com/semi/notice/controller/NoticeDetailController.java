package com.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.notice.service.NoticeService;
import com.semi.notice.vo.NoticeVo;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
	
	//상세조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String nno = req.getParameter("nno");
			
			NoticeService ns = new NoticeService();
			NoticeVo nvNo = ns.getNoticeByNo(nno);
			
			if (nvNo == null) {
				
				throw new Exception();
			}
			
			req.setAttribute("nvNo", nvNo);
			req.getRequestDispatcher("/WEB-INF/views/notice/noticeDetail.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "잘못된 접근");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}

	}
}
