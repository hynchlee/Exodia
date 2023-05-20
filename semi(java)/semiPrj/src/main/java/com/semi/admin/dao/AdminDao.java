package com.semi.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.semi.admin.vo.AdminVo;
import com.semi.common.db.JDBCTemplate;

public class AdminDao {

	//관리자 로그인
	public AdminVo adminLogin(Connection conn, AdminVo vo) throws Exception {

		//sql
		String sql = "SELECT * FROM ADMIN WHERE ADMIN_ID = ? AND ADMIN_PWD = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAdminId());
		pstmt.setString(2, vo.getAdminPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		AdminVo loginAdmin = null;
		if(rs.next()) {
			String adminNo = rs.getString("ADMIN_NO");
			String adminId = rs.getString("ADMIN_ID");
			String adminPwd = rs.getString("ADMIN_PWD");
			String adminNick = rs.getString("ADMIN_NICK");
			String status = rs.getString("STATUS");
			String qualification = rs.getString("QUALIFICATION");
			
			loginAdmin = new AdminVo();
			loginAdmin.setAdminNo(adminNo);
			loginAdmin.setAdminId(adminId);
			loginAdmin.setAdminPwd(adminPwd);
			loginAdmin.setAdminNick(adminNick);
			loginAdmin.setStatus(status);
			loginAdmin.setQualification(qualification);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginAdmin;
	
	}

}
