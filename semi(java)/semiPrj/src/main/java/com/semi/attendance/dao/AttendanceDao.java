package com.semi.attendance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.semi.attendance.vo.AttendanceVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;

public class AttendanceDao {

	public int selectCnt(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM ATTENDANCE_LIST";
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
	

}

















