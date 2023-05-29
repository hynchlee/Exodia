package com.semi.vacation.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.vo.AdminVo;
import com.semi.vacation.service.VacationService;

@WebServlet("/refuse/vacation")
public class RefuseVacationController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo) session.getAttribute("loginAdmin");

		if (loginAdmin == null) {
			req.setAttribute("errorMsg", "관리자 로그인을 먼저 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			return;
		}

		try {
			String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

			String[] strNumbers = json.replaceAll("\\s", "").replace("[", "").replace("]", "").replace("\"", "")
					.split(",");

			int[] vacationRequestNum = new int[strNumbers.length];

			for (int i = 0; i < vacationRequestNum.length; i++) {
				vacationRequestNum[i] = Integer.parseInt(strNumbers[i]);
			}

			VacationService vs = new VacationService();
			int result = vs.updateVacationRefuse(vacationRequestNum);

			if (result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/vacation/admin-vacation.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println("관리자 휴가 거절 중 오류");
			e.printStackTrace();
		}

	}

}
