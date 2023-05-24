package com.semi.lecture.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.page.PageVo;
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.letter.service.LetterService;

@WebServlet("/lecture/manage/insert")
public class LectureManageInsertController extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

			String[] strNumbers = json.replaceAll("\\s+", " ").replace("[", "").replace("]", "").replace("\"", "")
					.split(",");

			int result = ls.insertLectureOne(strNumbers);
			if (result != 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("ERROR (강의 추가)");
			e.printStackTrace();
		}

	}
}
