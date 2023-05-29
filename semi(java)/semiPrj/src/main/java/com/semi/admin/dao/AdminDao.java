package com.semi.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.admin.vo.AdminVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.member.vo.MemberVo;

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

	//회원 목록 조회
	public List<MemberVo> getMemberList(Connection conn, PageVo pv) throws Exception {

		//sql
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT M.*, S.MILEAGE FROM MEMBER M LEFT OUTER JOIN STUDENT S ON (M.MEMBER_NO = S.STUDENT_MEMBER_NO) ORDER BY MEMBER_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		List<MemberVo> memberList = new ArrayList<>();
		
		while(rs.next()) {
			String memberNo = rs.getString("MEMBER_NO");
			String memberId = rs.getString("MEMBER_ID");
			String memberPwd = rs.getString("MEMBER_PWD");
			String memberNick = rs.getString("MEMBER_NICK");
			String birthNum = rs.getString("BIRTH_NUM");
			String status = rs.getString("STATUS");
			String phoneNo = rs.getString("PHONE_NO");
			String signDate = rs.getString("SIGN_DATE");
			String profile = rs.getString("PROFILE");
			String identity = rs.getString("IDENTITY");
			String leftVacation = rs.getString("LEFT_VACATION");
			String mileage = rs.getString("MILEAGE");
			
			MemberVo vo = new MemberVo();
			vo.setMemberNo(memberNo);
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberNick(memberNick);
			vo.setBirthNum(birthNum);
			vo.setStatus(status);
			vo.setPhoneNo(phoneNo);
			vo.setSignDate(signDate);
			vo.setProfile(profile);
			vo.setIdentity(identity);
			vo.setLeftVacation(leftVacation);
			vo.setMileage(mileage);
						
			memberList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return memberList;
	
	}

	//회원 정지
	public int stopMember(Connection conn, String[] noArr) throws Exception {

		String str = String.join("," , noArr);
		
		//sql
		String sql = "UPDATE MEMBER SET STATUS = 'S' WHERE MEMBER_NO IN (" + str + ")";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	
	}

}
