package com.semi.lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lecture/test/start")
public class TestStartController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] answerArr = req.getParameterValues("answer");
		
		// 업데이트 
		
		
		
		resp.sendRedirect("semi/lecture/test/list");
	}
}
