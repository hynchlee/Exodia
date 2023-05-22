package com.semi.lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;

@WebServlet("/lecture/detail")
public class LectureDetailController extends HttpServlet{
	private final LectureService ls = new LectureService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String lectureNo = req.getParameter("lectureNo");
			LectureVo lecture = ls.getLectureOne(lectureNo);
			
			req.setAttribute("lecture", lecture);
			req.getRequestDispatcher("/WEB-INF/views/lecture/detail.jsp").forward(req, resp);			
		} catch (Exception e) {
			System.out.println("ERROR(상세 조회)");
		}
		
	}
}