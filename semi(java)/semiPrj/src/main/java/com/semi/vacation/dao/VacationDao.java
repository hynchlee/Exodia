package com.semi.vacation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.vacation.vo.VacationVo;

public class VacationDao {

	public int getVacationCnt(Connection conn, String no) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM VACATION_REQUEST_LIST WHERE MEMBER_NO = ?";
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

	public List<VacationVo> getVacationList(Connection conn, PageVo pv, String no) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT RNUM, VACATION_REQUEST_LIST_NO, DAY, LECTURE_NAME, MEMBER_NICK, MEMBER_NO, REASON, VACATION_START, VACATION_END FROM ( SELECT ROWNUM RNUM, VACATION_REQUEST_LIST_NO, (TO_DATE(VACATION_END, 'YYYYMMDD') - TO_DATE(VACATION_START, 'YYYYMMDD') + 1) AS DAY, LECTURE_NAME, T.MEMBER_NICK MEMBER_NICK, VRL.MEMBER_NO, REASON, VACATION_START, VACATION_END FROM VACATION_REQUEST_LIST VRL JOIN MEMBER M ON M.MEMBER_NO = VRL.MEMBER_NO JOIN STUDENT S ON S.STUDENT_MEMBER_NO = M.MEMBER_NO JOIN LECTURE L ON L.LECTURE_NO = S.LECTURE_NO JOIN LECTURE_CATEGORY LG ON L.LECTURE_CATEGORY_NO = LG.LECTURE_CATEGORY_NO JOIN (SELECT DISTINCT MEMBER_NICK, MEMBER_NO FROM MEMBER) T ON L.TEACHER_MEMBER_NO = T.MEMBER_NO WHERE VRL.MEMBER_NO = ? AND IDENTITY = 'S' ORDER BY VACATION_REQUEST_LIST_NO DESC ) WHERE RNUM BETWEEN ? AND ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<VacationVo> voList = new ArrayList<>();
		while(rs.next()) {
			String vacationNo = rs.getString("VACATION_REQUEST_LIST_NO");
			String lecureName = rs.getString("LECTURE_NAME");
			String memberNick = rs.getString("MEMBER_NICK");
			String memberNo = rs.getString("MEMBER_NO");
			String day = rs.getString("DAY");
			String reason = rs.getString("REASON");
			String vacationStart = rs.getString("VACATION_START");
			String vacationEnd = rs.getString("VACATION_END");
			
			VacationVo vo = new VacationVo();
			vo.setVacationRequestListNo(vacationNo);
			vo.setLectureName(lecureName);
			vo.setTeacherName(memberNick);
			vo.setMemberNo(memberNo);
			vo.setReason(reason);
			vo.setVacationStart(vacationStart);
			vo.setVacationEnd(vacationEnd);
			vo.setDay(day);
			
			voList.add(vo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
		
	}

	public int getVacationCnt(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM VACATION_REQUEST_LIST";
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

	public List<VacationVo> getAdminVacationList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT RNUM, STATUS, VACATION_REQUEST_LIST_NO, DAY, LECTURE_NAME, MEMBER_NICK, MEMBER_NO, STUDENT_NAME, STUDENT_ID, REASON, VACATION_START, VACATION_END FROM ( SELECT ROWNUM RNUM, VRL.STATUS AS STATUS, VACATION_REQUEST_LIST_NO, (TO_DATE(VACATION_END, 'YYYYMMDD') - TO_DATE(VACATION_START, 'YYYYMMDD') + 1) AS DAY, LECTURE_NAME, M.MEMBER_NICK MEMBER_NICK, VRL.MEMBER_NO, M.MEMBER_NICK AS STUDENT_NAME, M.MEMBER_ID AS STUDENT_ID, REASON, VACATION_START, VACATION_END FROM VACATION_REQUEST_LIST VRL JOIN MEMBER M ON M.MEMBER_NO = VRL.MEMBER_NO JOIN STUDENT S ON S.STUDENT_MEMBER_NO = M.MEMBER_NO JOIN LECTURE L ON L.LECTURE_NO = S.LECTURE_NO JOIN LECTURE_CATEGORY LG ON L.LECTURE_CATEGORY_NO = LG.LECTURE_CATEGORY_NO JOIN (SELECT DISTINCT MEMBER_NICK, MEMBER_NO FROM MEMBER) T ON L.TEACHER_MEMBER_NO = T.MEMBER_NO ORDER BY VACATION_REQUEST_LIST_NO DESC ) WHERE RNUM BETWEEN ? AND ? )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<VacationVo> voList = new ArrayList<>();
		while(rs.next()) {
			String vacationNo = rs.getString("VACATION_REQUEST_LIST_NO");
			String lecureName = rs.getString("LECTURE_NAME");
			String memberNick = rs.getString("MEMBER_NICK");
			String memberNo = rs.getString("MEMBER_NO");
			String studentName = rs.getString("STUDENT_NAME");
			String studentId = rs.getString("STUDENT_ID");
			String day = rs.getString("DAY");
			String reason = rs.getString("REASON");
			String vacationStart = rs.getString("VACATION_START");
			String vacationEnd = rs.getString("VACATION_END");
			String status = rs.getString("STATUS");
			
			VacationVo vo = new VacationVo();
			vo.setVacationRequestListNo(vacationNo);
			vo.setLectureName(lecureName);
			vo.setTeacherName(memberNick);
			vo.setMemberNo(memberNo);
			vo.setReason(reason);
			vo.setVacationStart(vacationStart);
			vo.setVacationEnd(vacationEnd);
			vo.setDay(day);
			vo.setStudentId(studentId);
			vo.setStudentName(studentName);
			vo.setStatus(status);
			
			voList.add(vo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
		
	}

}
