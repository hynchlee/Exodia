package com.semi.attendance.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.admin.vo.AdminVo;
import com.semi.member.vo.MemberVo;

@WebServlet("/attendance/manage")
public class ManageAttendenceController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		AdminVo loginAdmin = (AdminVo) session.getAttribute("loginAdmin");
	
	}
	

}
