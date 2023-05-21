package com.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.qna.service.QnaService;
import com.semi.qna.vo.QnaVo;

@WebServlet("/qna/detail")
public class BoardQnaAnswerController extends HttpServlet{
	
	//관리자한테만 보이는 페이지
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String qno = req.getParameter("qnaNo");
			
			QnaService qs = new QnaService();
			QnaVo qvNo = qs.getQnaByNo(qno);
			
			if (qvNo == null) {
				throw new Exception();
			}
			
			req.setAttribute("qvNo", qvNo);
			req.getRequestDispatcher("/WEB-INF/views/board/qnaAnswerEdit.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "잘못된 접근");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage");
		}
		
	}

}
