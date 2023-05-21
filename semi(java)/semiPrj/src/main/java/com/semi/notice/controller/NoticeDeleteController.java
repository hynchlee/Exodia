package com.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.vo.MemberVo;
import com.semi.notice.service.NoticeService;

@WebServlet("/notice/delete")
public class NoticeDeleteController extends HttpServlet{
	
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String nno = req.getParameter("nno");

			NoticeService ns = new NoticeService();
			int result = ns.noticeDelete(nno);
			
			if (result != 1) {
				throw new Exception();
			}

			resp.sendRedirect(req.getContextPath() + "/notice/list?page=1");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시물 삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
			
		
	}

}
