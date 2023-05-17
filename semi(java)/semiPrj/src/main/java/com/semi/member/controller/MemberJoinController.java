package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.semi.common.file.AttachmentVo;
import com.semi.common.file.FileUploader;
import com.semi.member.vo.MemberVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 2
	)
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{
	
	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파일 처리
		Part f = req.getPart("memberProfile");
		String path = req.getServletContext().getRealPath("/static/img/member/profile/");
		AttachmentVo attachmentVo = FileUploader.saveFile(path, f);
		
		//데꺼
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberName = req.getParameter("memberName");
		String birthNum = req.getParameter("birthNum");
		String phoneNo = req.getParameter("phoneNo");
		String memberNick = req.getParameter("memberNick");
		//String profile = req.getParameter("profile");
		
		//데뭉
		MemberVo vo = new MemberVo();
	
	}

}
