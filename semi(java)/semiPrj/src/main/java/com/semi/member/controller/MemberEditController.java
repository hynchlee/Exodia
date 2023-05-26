package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.semi.common.file.AttachmentVo;
import com.semi.common.file.FileUploader;
import com.semi.member.service.MemberService;
import com.semi.member.vo.MemberVo;

@WebServlet("/member/edit")
public class MemberEditController extends HttpServlet{
	
	//회원정보 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		
		if(loginMember != null) {
			req.getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("alertMsg", "로그인을 먼저 해주세요");
			resp.sendRedirect(req.getContextPath() + "/main");
		}
	}
	
	//회원정보 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			
			//파일 처리
			Part f = req.getPart("profile");
			String path = req.getServletContext().getRealPath("/static/img/profile/");
			AttachmentVo attachmentVo = FileUploader.saveFile(path, f);
			
			//데꺼
			String memberNo = loginMember.getMemberNo();
			String memberPwd = req.getParameter("memberPwd");
			String phoneNo = req.getParameter("phoneNo");
			
			//데뭉
			MemberVo editVo = new MemberVo();
			editVo.setMemberNo(memberNo);
			editVo.setMemberPwd(memberPwd);
			editVo.setPhoneNo(phoneNo);
			editVo.setProfile(attachmentVo.getChangeName());
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo updatedMember = ms.edit(editVo, loginMember);
			
			//화면
			if(updatedMember != null) {
				req.getSession().setAttribute("alertMsg", "회원정보 수정 성공!");
				req.getSession().setAttribute("loginMember", updatedMember);
				String root = req.getContextPath();
				resp.sendRedirect(root + "/main");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] edit fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원정보수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
	
	
}
