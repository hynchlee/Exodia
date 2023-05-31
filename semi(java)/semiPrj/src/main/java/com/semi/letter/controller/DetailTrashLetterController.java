package com.semi.letter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.letter.service.LetterService;
import com.semi.letter.vo.LetterVo;

@WebServlet("/letter/trash/detail")
public class DetailTrashLetterController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			String bno = req.getParameter("bno");
			
			LetterService ls = new LetterService();
			
			LetterVo vo = ls.selectTrashOneByNo(bno);
			
			if(vo != null) {
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/WEB-INF/views/letter/detail-trash-letter.jsp").forward(req, resp);
			}
			else {
				throw new Exception();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("휴지통 메세지 상세조회 중 오류 발생");
			req.setAttribute("errorMsg", "휴지통 메세지 상세조회 중 오류 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
	
}
