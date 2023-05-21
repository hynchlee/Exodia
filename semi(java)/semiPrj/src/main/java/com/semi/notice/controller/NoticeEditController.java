package com.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.vo.AdminVo;
import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.member.vo.MemberVo;
import com.semi.notice.service.NoticeService;
import com.semi.notice.vo.NoticeVo;
import com.semi.review.service.ReviewService;
import com.semi.review.vo.ReviewVo;

@WebServlet("/notice/edit")
public class NoticeEditController extends HttpServlet{
	
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인유저 회원번호 가져오기
		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin");
		if(loginAdmin == null) {
			req.setAttribute("errorMsg", "접근 권한 없음");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		try {
			String nno = req.getParameter("nno");
			
			NoticeService ns = new NoticeService();
			NoticeVo nvNo = ns.getNoticeByNo(nno);
			
			req.setAttribute("nvNo", nvNo);
			req.getRequestDispatcher("/WEB-INF/views/notice/noticeEdit.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("[ERROR] board edit error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	//수정 작업
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String nno = req.getParameter("nno");
			String boardTitle = req.getParameter("boardTitle");
	        String boardContent = req.getParameter("boardContent");

	        NoticeVo nvo = new NoticeVo();
	        nvo.setNoticeNo(nno);
	        nvo.setNoticeTitle(boardTitle);
	        nvo.setNoticeContent(boardContent);
	        
	        NoticeService ns = new NoticeService();
	        int result = ns.editNotice(nvo);
	        
	        if (result != 1) {
				throw new Exception();
			}
	        
	        resp.sendRedirect(req.getContextPath() + "/notice/detail?nno=" + nno);
	        
		} catch (Exception e) {
			System.out.println("[ERROR] board edit error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
