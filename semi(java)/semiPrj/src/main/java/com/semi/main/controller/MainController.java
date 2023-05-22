package com.semi.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.vo.AdminVo;
import com.semi.member.vo.MemberVo;
import com.semi.mypage.service.MypageService;

@WebServlet(urlPatterns = "/main")
public class MainController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			AdminVo loginAdmin = (AdminVo) req.getSession().getAttribute("loginAdmin");

			if (loginMember != null) {
				String memberNo = loginMember.getMemberNo();
				MypageService ms = new MypageService();
				String letterCount = ms.countLetter01(memberNo);
				String countMyWrite = ms.countMyWrite(memberNo);
				req.setAttribute("letterCount", letterCount);
				req.setAttribute("countMyWrite", countMyWrite);
				
				if (loginMember.getIdentity().equals("S")) {
					req.getRequestDispatcher("/WEB-INF/views/main/smain.jsp").forward(req, resp);
				} else if (loginMember.getIdentity().equals("T")) {
					req.getRequestDispatcher("/WEB-INF/views/main/tmain.jsp").forward(req, resp);
				}
			} else if (loginAdmin != null) {
				req.getRequestDispatcher("/WEB-INF/views/main/mmain.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/views/main/main.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println("main 조회 중 에러 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "main 조회중 에러발생");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}

	}

}
