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
import com.semi.vacation.vo.VacationVo;

public class MemberDao {
	
	//회원가입
	public int join(Connection conn, MemberVo vo) throws Exception {

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
		
		//학생 테이블 칼럼 추가
		if (result == 1) {
			String sql2 = "INSERT INTO STUDENT (STUDENT_MEMBER_NO) VALUES (SEQ_MEMBER_NO.CURRVAL)";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			int result2 = pstmt2.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result2;
		}
		
		JDBCTemplate.close(pstmt);
		
		return result;
				
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
	
	//로그인 시 강의명 담기
	public List<LectureCategoryVo> getLecture(Connection conn, String memberNo, String identity) throws Exception {

		String sql = "";
		if ( "S".equals(identity) ) {
			sql = "SELECT LECTURE_NAME FROM MEMBER M JOIN STUDENT S ON(M.MEMBER_NO = S.STUDENT_MEMBER_NO) JOIN LECTURE L ON (S.LECTURE_NO = L.LECTURE_NO) JOIN LECTURE_CATEGORY LC ON (L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO) WHERE M.MEMBER_NO = ? AND M.IDENTITY = ?";
		}
		else if(( "T".equals(identity) )) {
			sql = "SELECT LECTURE_NAME FROM MEMBER M JOIN LECTURE L ON(M.MEMBER_NO = L.TEACHER_MEMBER_NO) JOIN LECTURE_CATEGORY LC ON (L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO) WHERE M.MEMBER_NO = ? AND M.IDENTITY = ?";
		}
		else {
			throw new Exception();
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, identity);
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
		String sql = "SELECT MEMBER_NO, MEMBER_PWD FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_NICK = ? AND BIRTH_NUM = ? AND PHONE_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberNick());
		pstmt.setString(3, vo.getBirthNum());
		pstmt.setString(4, vo.getPhoneNo());
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		MemberVo pwdFind = null;
		
		if(rs.next()) {
			String memberNo = rs.getString("MEMBER_NO");
			String memberPwd = rs.getString("MEMBER_PWD");

			pwdFind = new MemberVo();
			pwdFind.setMemberNo(memberNo);
			pwdFind.setMemberPwd(memberPwd);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pwdFind;
	
	}
	
	//비번갱신
	public int renewPwd(Connection conn, MemberVo vo) throws Exception {

		String sql = "UPDATE MEMBER SET MEMBER_PWD = ? WHERE MEMBER_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberPwd());
		pstmt.setString(2, vo.getMemberNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	
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

	//휴가신청
	public int requestVacation(Connection conn, VacationVo vo) throws Exception {

		String sql = "INSERT INTO VACATION_REQUEST_LIST (VACATION_REQUEST_LIST_NO, MEMBER_NO, REASON, VACATION_START, VACATION_END, STATUS) VALUES (SEQ_VACATION_REQUEST_LIST_NO.NEXTVAL, ?, ?, ?, ?, 'X')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNo());
		pstmt.setString(2, vo.getReason());
		pstmt.setString(3, vo.getVacationStart());
		pstmt.setString(4, vo.getVacationEnd());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	
	}
	
	//회원 수 세기
	public int countMember(Connection conn) throws Exception {
		//SQL
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//tx || rs
		int listCount = 0;
		if(rs.next()) {
			listCount = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return listCount;
	}

}
