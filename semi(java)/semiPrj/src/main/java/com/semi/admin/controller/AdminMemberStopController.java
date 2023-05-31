package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.admin.service.AdminService;

@WebServlet("/admin/member/stop")
public class AdminMemberStopController extends HttpServlet{

	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데이터
			String str = req.getParameter("noArr");
			Gson gson = new Gson();
			String[] noArr = gson.fromJson(str, String[].class);
			
			//서비스
			AdminService as = new AdminService();
			int result = as.stopMember(noArr);
			
			//결과
			if(result <= 0) {
				resp.getWriter().write("회원 제재 실패 ...");
				throw new Exception();
			}
			resp.getWriter().write("회원 제재 성공!");
			
		}catch(Exception e) {
			System.out.println("[ERROR] stop member fail ...");
			e.printStackTrace();
			
			req.setAttribute("alertMsg", "회원 제재 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/admin/adminMenu.jsp").forward(req, resp);
		}
		
	}
	
}
