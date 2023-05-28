package com.semi.attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.attendance.vo.AttendanceVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;

public class AttendanceDao {

	public int selectCnt(Connection conn, String no) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM ATTENDANCE_LIST WHERE STUDENT_MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public List<AttendanceVo> getAttendanceList(Connection conn, PageVo pv, String no) throws Exception {

		String sql = "SELECT ATTENDANCE_DATE, MEMBER_NICK, CHECK_IN_TIME, CHECK_OUT_TIME, AL.STATUS, ((TO_NUMBER(SUBSTR(LECTURE_FINISH_TIME, 1, 2)) - TO_NUMBER(SUBSTR(LECTURE_START_TIME, 1, 2))) * 60 + TO_NUMBER(SUBSTR(LECTURE_FINISH_TIME, 3, 2)) - TO_NUMBER(SUBSTR(LECTURE_START_TIME, 3, 2))) AS TOTAL_LECTURE_MINUTES, (EXTRACT(HOUR FROM (CHECK_OUT_TIME - CHECK_IN_TIME)) * 60 + EXTRACT(MINUTE FROM (CHECK_OUT_TIME - CHECK_IN_TIME))) AS IN_LECTURE_MINUTES FROM LECTURE_CATEGORY LC JOIN LECTURE L ON L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO JOIN STUDENT S ON S.LECTURE_NO = L.LECTURE_NO JOIN ATTENDANCE_LIST AL ON S.STUDENT_MEMBER_NO = AL.STUDENT_MEMBER_NO JOIN MEMBER M ON M.MEMBER_NO = AL.STUDENT_MEMBER_NO WHERE M.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		List<AttendanceVo> list = new ArrayList<>();
		while(rs.next()) {
			String attendanceDate = rs.getString("ATTENDANCE_DATE");
			String studentMemberName = rs.getString("MEMBER_NICK");
			String checkIn = rs.getString("CHECK_IN_TIME");
			String checkOut = rs.getString("CHECK_OUT_TIME");
			String status = rs.getString("STATUS");
			String totalLectureMinutes = rs.getString("TOTAL_LECTURE_MINUTES");
			String inLectureMinutes = rs.getString("IN_LECTURE_MINUTES");
			
			AttendanceVo vo = new AttendanceVo();
			vo.setAttendanceDate(attendanceDate);
			vo.setStudentMemberName(studentMemberName);
			vo.setCheckInTime(checkIn);
			vo.setCheckOutTime(checkOut);
			vo.setStatus(status);
			vo.setTotalLectureMinutes(totalLectureMinutes);
			vo.setInLectureMinutes(inLectureMinutes);
			
			list.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

	public int getAdminAttendanceListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM ( SELECT ATTENDANCE_DATE, STUDENT_MEMBER_NO, M.MEMBER_NICK , CHECK_IN_TIME, CHECK_OUT_TIME, AL.STATUS FROM ATTENDANCE_LIST AL JOIN MEMBER M ON M.MEMBER_NO = AL.STUDENT_MEMBER_NO )";
		if("student".equals(searchType)) {
			sql +="WHERE MEMBER_NICK LIKE '%" + searchValue + "%'";
		}
		
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

	public List<AttendanceVo> getAdminAttendanceList(PageVo pv, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT MEMBER_NO, ATTENDANCE_DATE, MEMBER_NICK, CHECK_IN_TIME, CHECK_OUT_TIME, AL.STATUS, ((TO_NUMBER(SUBSTR(LECTURE_FINISH_TIME, 1, 2)) - TO_NUMBER(SUBSTR(LECTURE_START_TIME, 1, 2))) * 60 + TO_NUMBER(SUBSTR(LECTURE_FINISH_TIME, 3, 2)) - TO_NUMBER(SUBSTR(LECTURE_START_TIME, 3, 2))) AS TOTAL_LECTURE_MINUTES, (EXTRACT(HOUR FROM (CHECK_OUT_TIME - CHECK_IN_TIME)) * 60 + EXTRACT(MINUTE FROM (CHECK_OUT_TIME - CHECK_IN_TIME))) AS IN_LECTURE_MINUTES FROM LECTURE_CATEGORY LC JOIN LECTURE L ON L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO JOIN STUDENT S ON S.LECTURE_NO = L.LECTURE_NO JOIN ATTENDANCE_LIST AL ON S.STUDENT_MEMBER_NO = AL.STUDENT_MEMBER_NO JOIN MEMBER M ON M.MEMBER_NO = AL.STUDENT_MEMBER_NO )T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<AttendanceVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String attendanceDate = rs.getString("ATTENDANCE_DATE");
			String studentMemberNo = rs.getString("MEMBER_NO");
			String studentMemberName = rs.getString("MEMBER_NICK");
			String checkInTime = rs.getString("CHECK_IN_TIME");
			String checkOutTime = rs.getString("CHECK_OUT_TIME");
			String status = rs.getString("STATUS");
			String totalLectureMinutes = rs.getString("TOTAL_LECTURE_MINUTES");
			String inLectureMinutes = rs.getString("IN_LECTURE_MINUTES");
			
			AttendanceVo vo = new AttendanceVo();
			vo.setAttendanceDate(attendanceDate);
			vo.setStudentMemberNo(studentMemberNo);
			vo.setStudentMemberName(studentMemberName);
			vo.setCheckInTime(checkInTime);
			vo.setCheckOutTime(checkOutTime);
			vo.setStatus(status);
			vo.setTotalLectureMinutes(totalLectureMinutes);
			vo.setInLectureMinutes(inLectureMinutes);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	public List<AttendanceVo> getAdminAttendanceList(Connection conn, PageVo pv, String searchType,
			String searchValue) throws Exception {
		
		String sql = "";
		if("student".equals(searchType)) {
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT ATTENDANCE_DATE, S.STUDENT_MEMBER_NO, MEMBER_NICK, CHECK_IN_TIME, CHECK_OUT_TIME, AL.STATUS, ((TO_NUMBER(SUBSTR(LECTURE_FINISH_TIME, 1, 2)) - TO_NUMBER(SUBSTR(LECTURE_START_TIME, 1, 2))) * 60 + TO_NUMBER(SUBSTR(LECTURE_FINISH_TIME, 3, 2)) - TO_NUMBER(SUBSTR(LECTURE_START_TIME, 3, 2))) AS TOTAL_LECTURE_MINUTES, (EXTRACT(HOUR FROM (CHECK_OUT_TIME - CHECK_IN_TIME)) * 60 + EXTRACT(MINUTE FROM (CHECK_OUT_TIME - CHECK_IN_TIME))) AS IN_LECTURE_MINUTES FROM LECTURE_CATEGORY LC JOIN LECTURE L ON L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO JOIN STUDENT S ON S.LECTURE_NO = L.LECTURE_NO JOIN ATTENDANCE_LIST AL ON S.STUDENT_MEMBER_NO = AL.STUDENT_MEMBER_NO JOIN MEMBER M ON M.MEMBER_NO = AL.STUDENT_MEMBER_NO WHERE M.MEMBER_NICK LIKE '%'||?||'%' ORDER BY ATTENDANCE_DATE DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}
		else {
			return getAdminAttendanceList(pv, conn);
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<AttendanceVo> voList = new ArrayList<>();
		while(rs.next()) {
			String attendanceDate = rs.getString("ATTENDANCE_DATE");
			String studentMemberNo = rs.getString("STUDENT_MEMBER_NO");
			String studentMemberName = rs.getString("MEMBER_NICK");
			String checkInTime = rs.getString("CHECK_IN_TIME");
			String checkOutTime = rs.getString("CHECK_OUT_TIME");
			String status = rs.getString("STATUS");
			String totalLectureMinutes = rs.getString("TOTAL_LECTURE_MINUTES");
			String inLectureMinutes = rs.getString("IN_LECTURE_MINUTES");
			
			AttendanceVo vo = new AttendanceVo();
			vo.setAttendanceDate(attendanceDate);
			vo.setStudentMemberNo(studentMemberNo);
			vo.setStudentMemberName(studentMemberName);
			vo.setCheckInTime(checkInTime);
			vo.setCheckOutTime(checkOutTime);
			vo.setStatus(status);
			vo.setTotalLectureMinutes(totalLectureMinutes);
			vo.setInLectureMinutes(inLectureMinutes);
			
			voList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
		
	}
	

}

















