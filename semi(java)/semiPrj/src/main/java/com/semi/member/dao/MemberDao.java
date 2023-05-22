package com.semi.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureCategoryVo;
import com.semi.member.vo.MemberVo;

public class MemberDao {
	
	//회원가입
	public int join(Connection conn, MemberVo vo) throws Exception {

		//sql
		String sql = "INSERT INTO MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PWD, MEMBER_NICK, BIRTH_NUM, PHONE_NO, IDENTITY, PROFILE) VALUES (SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		pstmt.setString(4, vo.getBirthNum());
		pstmt.setString(5, vo.getPhoneNo());
		pstmt.setString(6, vo.getIdentity());
		pstmt.setString(7, vo.getProfile());
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			String sql2 = "INSERT INTO STUDENT (STUDENT_MEMBER_NO) VALUES (SEQ_MEMBER_NO.CURRVAL)";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			int result2 = pstmt2.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result2;
		}
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
//		String sql2 = "INSERT INTO STUDENT (STUDENT_MEMBER_NO) VALUES (SEQ_MEMBER_NO.NEXTVAL)";
//		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//		int result2 = pstmt2.executeUpdate();
//		
//		JDBCTemplate.close(pstmt);
//		
//		if (result == 1 && result2 == 1) {
//			return result;
//		}else {
//			throw new Exception();
//		}
		
	}

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

	//아이디 찾기
	public MemberVo findId(Connection conn, MemberVo vo) throws Exception {

		//SQL
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NICK = ? AND PHONE_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNick());
		pstmt.setString(2, vo.getPhoneNo());
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs 
		MemberVo idFind = null;
		
		if(rs.next()) {
			idFind = new MemberVo();
			String memberId = rs.getString("MEMBER_ID");
			idFind.setMemberId(memberId);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return idFind;
	
	}

	//비번찾기
	public MemberVo findPwd(Connection conn, MemberVo vo) throws Exception {

		//SQL
		String sql = "SELECT MEMBER_PWD FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_NICK = ? AND BIRTH_NUM = ? AND PHONE_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberNick());
		pstmt.setString(3, vo.getBirthNum());
		pstmt.setString(4, vo.getPhoneNo());
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		MemberVo pwdFind = null;
		
		if(rs.next()) {
			pwdFind = new MemberVo();
			String memberPwd = rs.getString("MEMBER_PWD");
			pwdFind.setMemberPwd(memberPwd);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pwdFind;
	
	}

	//정보수정
	public int edit(Connection conn, MemberVo editVo) throws Exception {
		
		String sql = "UPDATE MEMBER SET PHONE_NO = ?, PROFILE = ?";
		
		if(editVo.getMemberPwd() != null && editVo.getMemberPwd().length() > 0) {
			sql += ", MEMBER_PWD = ?";
		}
		
		sql += " WHERE MEMBER_NO = ? AND STATUS = 'O'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, editVo.getPhoneNo());
		pstmt.setString(2, editVo.getProfile());
		if(editVo.getMemberPwd() != null && editVo.getMemberPwd().length() > 0) {
			pstmt.setString(3, editVo.getMemberPwd());
			pstmt.setString(4, editVo.getMemberNo());
		}else {
			pstmt.setString(3, editVo.getMemberNo());
		}
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//회원번호로 회원조회
	public MemberVo selectOneByNo(Connection conn, MemberVo loginMember) throws Exception {

		String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = loginMember;
		if(rs.next()) {
			String memberPwd = rs.getString("MEMBER_PWD");
			String phoneNo = rs.getString("PHONE_NO");
			String profile = rs.getString("PROFILE");
		
			vo.setMemberPwd(memberPwd);
			vo.setPhoneNo(phoneNo);
			vo.setProfile(profile);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
		
	}

	//탈퇴
	public int quit(Connection conn, String memberNo) throws Exception {
		String sql = "UPDATE MEMBER SET STATUS = 'X' WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public List<LectureCategoryVo> getSlecture(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT LECTURE_NAME FROM MEMBER M JOIN STUDENT S ON(M.MEMBER_NO = S.STUDENT_MEMBER_NO) JOIN LECTURE L ON (S.LECTURE_NO = L.LECTURE_NO) JOIN LECTURE_CATEGORY LC ON (L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO) WHERE M.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		List<LectureCategoryVo> memberLecture = new ArrayList<>();
		while(rs.next()) {
			String lectureName = rs.getString("LECTURE_NAME");
			
			LectureCategoryVo vo = new LectureCategoryVo();
			vo.setLectureName(lectureName);
			
			memberLecture.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return memberLecture;
	
	}



}
