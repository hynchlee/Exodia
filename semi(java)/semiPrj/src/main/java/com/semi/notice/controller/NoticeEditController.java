package com.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.vo.AdminVo;
import com.semi.notice.service.NoticeService;
import com.semi.notice.vo.NoticeVo;

@WebServlet("/notice/edit")
public class NoticeEditController extends HttpServlet{
	
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin");
		if (loginAdmin == null) {
			req.setAttribute("errorMsg", "접근 권한 없음");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			String nno = req.getParameter("nno");
			
			NoticeService ns = new NoticeService();
			NoticeVo nvo = ns.getNoticeByNo(nno);
			
			req.setAttribute("nvo", nvo);
			req.getRequestDispatcher("/WEB-INF/views/notice/noticeEdit.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] notice edit error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	
	//수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
}
