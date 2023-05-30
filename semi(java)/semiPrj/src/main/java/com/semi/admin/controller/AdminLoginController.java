package com.semi.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.service.AdminService;
import com.semi.admin.vo.AdminVo;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{
	
	//관리자 로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminVo loginAdmin = (AdminVo) req.getSession().getAttribute("loginAdmin");
		
		if(loginAdmin == null) {
			req.getRequestDispatcher("/WEB-INF/views/admin/adminLogin.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "이미 관리자 로그인 상태입니다.");
			resp.sendRedirect(req.getContextPath() + "/main");
		}
	}
	
	//관리자 로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//데꺼
			String adminId = req.getParameter("adminId");
			String adminPwd = req.getParameter("adminPwd");
			
			//데뭉
			AdminVo vo = new AdminVo();
			vo.setAdminId(adminId);
			vo.setAdminPwd(adminPwd);
			
			//서비스
			AdminService as = new AdminService();
			AdminVo loginAdmin = as.adminLogin(vo);
			
			//화면
			if (loginAdmin != null) {
				req.getSession().setAttribute("loginAdmin", loginAdmin);
				String root = req.getContextPath();
				resp.sendRedirect(root + "/main");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] admin login fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "관리자 로그인 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
			
	}
	
}

