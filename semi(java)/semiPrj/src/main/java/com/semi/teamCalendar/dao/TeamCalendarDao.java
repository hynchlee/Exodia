package com.semi.teamCalendar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.teamCalendar.vo.TeamCalendarVo;

public class TeamCalendarDao {


	public List<TeamCalendarVo> getTeamCalendar(Connection conn, String memberNo) throws SQLException {
		String sql = "SELECT * FROM TEAM_CALENDAR WHERE TEAM_NO = (SELECT TEAM_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<TeamCalendarVo> voList = new ArrayList<>();
		while(rs.next()) {
			TeamCalendarVo vo = new TeamCalendarVo();
			vo.setTeamCalendarNo(rs.getString("TEAM_CALENDAR_NO"));
			vo.setTeamNo(rs.getString("TEAM_NO"));
			vo.setStartDate(rs.getString("START_DATE"));
			vo.setEndDate(rs.getString("END_DATE"));
			vo.setMeetingContent(rs.getString("MEETING_CONTENT"));
			
			voList.add(vo);
		}
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

	public int writeCalendar(Connection conn, String memberNo, String[] paramsArr) throws SQLException {
		String sql = "INSERT INTO TEAM_CALENDAR VALUES(SEQ_TEAM_CALENDAR_NO.NEXTVAL, (SELECT TEAM_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?), ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		int startDate = Integer.parseInt(paramsArr[2].substring(0, 10).replaceAll("-", "")) + 1;
		int endDate = Integer.parseInt(paramsArr[3].substring(0, 10).replaceAll("-", "")) + 1;

		pstmt.setString(1, memberNo);
		pstmt.setString(2, Integer.toString(startDate));
		pstmt.setString(3, Integer.toString(endDate));
		pstmt.setString(4, paramsArr[1]);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		return result;
	}

	public int modifyCalendar(Connection conn, String memberNo, String[] paramsArr) throws SQLException {
		String sql = "UPDATE TEAM_CALENDAR SET START_DATE = ?, END_DATE = ? WHERE TEAM_NO = (SELECT TEAM_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?) AND MEETING_CONTENT = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		int startDate = Integer.parseInt(paramsArr[2].substring(0, 10).replaceAll("-", "")) + 1;
		int endDate = Integer.parseInt(paramsArr[3].substring(0, 10).replaceAll("-", "")) + 1;

		pstmt.setString(1, Integer.toString(startDate));
		pstmt.setString(2, Integer.toString(endDate));
		pstmt.setString(3, memberNo);
		pstmt.setString(4, paramsArr[1]);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		return result;
	}

	public int deleteCalendar(Connection conn, String memberNo, String[] paramsArr) throws SQLException {
		String sql = "DELETE TEAM_CALENDAR WHERE START_DATE = ? AND END_DATE = ? AND TEAM_NO = (SELECT TEAM_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?) AND MEETING_CONTENT = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		int startDate = Integer.parseInt(paramsArr[2].substring(0, 10).replaceAll("-", "")) + 1;
		int endDate = Integer.parseInt(paramsArr[3].substring(0, 10).replaceAll("-", "")) + 1;

		pstmt.setString(1, Integer.toString(startDate));
		pstmt.setString(2, Integer.toString(endDate));
		pstmt.setString(3, memberNo);
		pstmt.setString(4, paramsArr[1]);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		return result;
	}

	public List<TeamCalendarVo> tgetTeamCalendar(Connection conn, String lectureNo) throws SQLException {
		String sql = "SELECT M.MEMBER_NICK, V.reason, VACATION_START, VACATION_END FROM VACATION_REQUEST_LIST V JOIN STUDENT S ON (S.STUDENT_MEMBER_NO = V.MEMBER_NO) JOIN MEMBER M ON (M.MEMBER_NO = V.MEMBER_NO) WHERE V.STATUS = 'O' AND M.STATUS = 'O'  AND M.IDENTITY = 'S' AND LECTURE_NO = ? ORDER BY VACATION_START DESC ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lectureNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<TeamCalendarVo> voList = new ArrayList<>();
		while(rs.next()) {
			TeamCalendarVo vo = new TeamCalendarVo();
			vo.setStartDate(rs.getString("VACATION_START"));
			vo.setEndDate(rs.getString("VACATION_END"));
			vo.setMeetingContent(rs.getString("MEMBER_NICK"));
			
			voList.add(vo);
		}
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}

}
