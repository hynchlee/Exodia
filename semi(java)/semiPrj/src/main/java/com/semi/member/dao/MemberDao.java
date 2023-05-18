package com.semi.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.semi.common.db.JDBCTemplate;
import com.semi.member.vo.MemberVo;

public class MemberDao {

	//로그인
	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		//SQL
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs 
		MemberVo loginMember = null;
		if(rs.next()) {
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
			
			loginMember = new MemberVo();
			loginMember.setMemberNo(memberNo);
			loginMember.setMemberId(memberId);
			loginMember.setMemberPwd(memberPwd);
			loginMember.setMemberNick(memberNick);
			loginMember.setBirthNum(birthNum);
			loginMember.setStatus(status);
			loginMember.setPhoneNo(phoneNo);
			loginMember.setSignDate(signDate);
			loginMember.setProfile(profile);
			loginMember.setIdentity(identity);
			loginMember.setLeftVacation(leftVacation);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginMember;
		
	}

}
