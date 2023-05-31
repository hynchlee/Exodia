package com.semi.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.admin.service.AdminService;
import com.semi.admin.vo.AdminVo;
import com.semi.common.page.PageVo;
import com.semi.member.service.MemberService;
import com.semi.member.vo.MemberVo;

@WebServlet("/admin/member/manage")
public class AdminMemberController extends HttpServlet{
	
	//회원관리
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			AdminVo loginAdmin = (AdminVo) req.getSession().getAttribute("loginAdmin");
			
			if(loginAdmin != null) {
				
				String searchType = req.getParameter("searchType");
				String searchValue = req.getParameter("searchValue");
				
				MemberService ms = new MemberService();
				
				int cnt = ms.getMemberListCnt(searchType, searchValue);
				String page_ = req.getParameter("page");
				if(page_ == null) {
					page_ = "1";
				}
				int page = Integer.parseInt(page_);
				PageVo pv = new PageVo(cnt, page, 5, 10);
				
				//서비스
				AdminService as = new AdminService();
				List<MemberVo> memberList = null;
				
				if(searchType == null || searchType.equals("")) {
					memberList = as.getMemberList(pv);
				}else {
					memberList = as.getMemberList(pv, searchType, searchValue);
				}
				
				Map<String, String> map = new HashMap<>();
				map.put("searchType", searchType);
				map.put("searchValue", searchValue);
				
				//화면
				req.setAttribute("searchVo", map);
				req.setAttribute("pv", pv);
				req.setAttribute("memberList", memberList);
				req.getRequestDispatcher("/WEB-INF/views/admin/memberManage.jsp").forward(req, resp);
				
//				//데이터준비
//				MemberService ms = new MemberService();
//				int listCount = ms.countMember();
//				String page = req.getParameter("page");
//				if(page == null) page = "1";
//				int currentPage = Integer.parseInt(page);
//				int pageLimit = 5;
//				int boardLimit = 10;
//				PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
//				
//				//서비스
//				AdminService as = new AdminService();
//				List<MemberVo> memberList = as.getMemberList(pv);
//
//				//화면
//				req.setAttribute("pv", pv);
//				req.setAttribute("memberList", memberList);
//				req.getRequestDispatcher("/WEB-INF/views/admin/memberManage.jsp").forward(req, resp);
				
			}else {
				req.getSession().setAttribute("alertMsg", "관리자 권한 필요");
				resp.sendRedirect(req.getContextPath() + "/main");
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] get member list fail ...");
			e.printStackTrace();
			
			req.setAttribute("alertMsg", "회원목록 조회 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/admin/adminMenu.jsp").forward(req, resp);
		}
	
	}
	
}

