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
import com.semi.member.service.MemberService;

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
		
		try {
			
			//데꺼
			String identity = req.getParameter("identity");
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			String birthNum = req.getParameter("birthNum");
			String phoneNo = req.getParameter("phoneNo");
			//파일처리 (프사)
			Part profile = req.getPart("profile");
			//사진 첨부해야 지정된 경로에 사진 저장 
			AttachmentVo attachmentVo = new AttachmentVo();
			String path = req.getServletContext().getRealPath("/static/img/profile/");
			if(profile.getSize() > 0) {
				attachmentVo = FileUploader.saveFile(path, profile);
			}
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setIdentity(identity);
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberNick(memberNick);
			vo.setBirthNum(birthNum);
			vo.setPhoneNo(phoneNo);
			vo.setProfile(attachmentVo.getChangeName());
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			//화면
			if(result == 1) {
				String root = req.getContextPath();
				req.getSession().setAttribute("alertMsg", "회원가입 성공!");
				resp.sendRedirect(root + "/main");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] join fail ...");
			e.printStackTrace();
			
			req.setAttribute("alertMsg", "회원가입 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views//member/join.jsp").forward(req, resp);
		}
	
	}

}
