package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
	
	//작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/boardWrite.jsp").forward(req, resp);
	}
	
	//작성하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//로그인유저 회원번호 가져오기
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			if(loginMember == null) {
				req.setAttribute("errorMsg", "로그인 해주세요");
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
				return;
			}
			
			//데꺼
			String boardTitle = req.getParameter("boardTitle");
            String boardContent = req.getParameter("boardContent");
            String boardCategoryNo = req.getParameter("boardCategoryNo");
            String boardWriterNo = loginMember.getMemberNo();
			
			//데뭉
            BoardVo bvo = new BoardVo();
            bvo.setBoardTitle(boardTitle);
            bvo.setBoardCategoryNo(boardCategoryNo);
            bvo.setBoardContent(boardContent);
            bvo.setMemberNo(boardWriterNo);
			
			//서비스
            BoardService bs = new BoardService();
            int result = bs.boardWrite(bvo);
			
			//화면
			if (result == 1) {
				resp.sendRedirect(req.getContextPath() + "/board/write");
			}else {
				throw new IllegalStateException("게시글 작성 결과 1이 아님");
			}
		} catch (Exception e) {
			System.out.println("[ERROR] board write error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
		
	}

}
