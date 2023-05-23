package com.semi.letter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.letter.service.LetterService;
import com.semi.letter.vo.LetterVo;

@WebServlet("/letter/detail")
public class DetailLetterController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			String no = req.getParameter("no");
			
			LetterService ls = new LetterService();
			LetterVo vo = ls.selectLetterOneByNo(no);
			
			if(vo != null) {
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/WEB-INF/views/letter/detail.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상세조회 중 오류 발생");
		}
		
	}
	
}
