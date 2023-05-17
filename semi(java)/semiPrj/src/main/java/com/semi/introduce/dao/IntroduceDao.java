package com.semi.introduce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.member.vo.MemberVo;

public class IntroduceDao {

	public List<MemberVo> getTeacherList(Connection conn, PageVo pageVo) throws SQLException {
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, M.* FROM ( SELECT * FROM MEMBER WHERE IDENTITY = 'T' AND STATUS = 'O' )M ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageVo.getBeginRow());
		pstmt.setInt(2, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<MemberVo> teacherList = new ArrayList();
		
		while(rs.next()) {
			MemberVo vo = new MemberVo();
			vo.setMemberNo(rs.getString("MEMBER_NO"));
			vo.setMemberId(rs.getString("MEMBER_ID"));
			vo.setMemberPwd(rs.getString("MEMBER_PWD"));
			vo.setMemberNick(rs.getString("MEMBER_NICK"));
			vo.setBirthNum(rs.getString("BIRTH_NUM"));
			vo.setStatus(rs.getString("STATUS"));
			vo.setPhoneNo(rs.getString("PHONE_NO"));
			vo.setSignDate(rs.getString("SIGN_DATE"));
			vo.setProfile(rs.getString("PROFILE"));
			vo.setIdentity(rs.getString("IDENTITY"));
			vo.setLeftVacation(rs.getString("LEFT_VACATION"));
			
			teacherList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return teacherList;
	}

	public int getTeacherListCnt(Connection conn) throws SQLException {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE IDENTITY = 'T' AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

}
