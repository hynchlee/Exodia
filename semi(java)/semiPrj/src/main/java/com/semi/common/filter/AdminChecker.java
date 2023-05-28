//package com.semi.common.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import com.semi.admin.vo.AdminVo;
//
//@WebFilter("/admin/*")
//public class AdminChecker implements Filter {
//	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		System.out.println("어드민 체크 ...");
//		
//		HttpServletRequest req = (HttpServletRequest) request;
//		
//	    // 요청 URI가 "/admin/login"인 경우 필터를 적용하지 않음
//	    String requestURI = req.getRequestURI();
//	    if (requestURI.endsWith("/admin/login")) {
//	        chain.doFilter(request, response);
//	        return;
//	    }
//		
//		//관리자 체크
//		HttpSession session = req.getSession();
//		AdminVo loginAdmin = (AdminVo) session.getAttribute("loginAdmin");
//		if(loginAdmin == null) {
//			throw new IllegalStateException("관리자만 가능");
//		}
//		
//		chain.doFilter(req, response);
//	}
//
//}
