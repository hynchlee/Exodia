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

@WebServlet("/lecture/manage/delete")
public class LectureManageDeleteController extends HttpServlet {
	private final LectureService ls = new LectureService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

			String[] strNumbers = json.replaceAll("\\s", "").replace("[", "").replace("]", "").replace("\"", "")
					.split(",");

			int[] lectureNo = new int[strNumbers.length];

			for (int i = 0; i < lectureNo.length; i++) {
				lectureNo[i] = Integer.parseInt(strNumbers[i]);
			}

			int result = ls.deleteLecture(lectureNo);
			if (result != 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("error(강의 관리)");
		}

	}
}
