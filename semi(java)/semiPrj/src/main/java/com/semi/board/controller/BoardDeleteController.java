package com.semi.board.controller;

import java.awt.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.semi.board.service.BoardService;
import com.semi.member.vo.MemberVo;
import com.semi.notice.service.NoticeService;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet{
	
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String bno = req.getParameter("bno");

			BoardService bs = new BoardService();
			int result = bs.boardDelete(bno);
			
			if (result != 1) {
				throw new Exception();
			}

			resp.sendRedirect(req.getContextPath() + "/board/write");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시물 삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
			
		
	}
	
	//관리자가 일괄 삭제
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String str = req.getParameter("bnoArr");
			if (str == null) {
			    resp.getWriter().write("bnoArr parameter is missing");
			} else {
			    Gson gson = new Gson();
			    String[] bnoArr = gson.fromJson(str, String[].class);
			    
			    BoardService bs = new BoardService();
			    int result = bs.adminBoardDelete(bnoArr);
			    
			    if (result <= 0) {
			        throw new IllegalStateException();
			    }
			    
			    resp.getWriter().write("success");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("fail");
		}
		
	}

}
