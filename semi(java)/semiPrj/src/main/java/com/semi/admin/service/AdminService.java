package com.semi.admin.service;

import java.sql.Connection;

import com.semi.admin.dao.AdminDao;
import com.semi.admin.vo.AdminVo;
import com.semi.common.db.JDBCTemplate;

public class AdminService {
	
	//dao 객체 생성
	private final AdminDao dao;
	public AdminService() {
		dao = new AdminDao();
	}

	//관리자 로그인
	public AdminVo adminLogin(AdminVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		AdminVo loginAdmin = dao.adminLogin(conn, vo);
		//close
		JDBCTemplate.close(conn);
		
		return loginAdmin;
	}

}
