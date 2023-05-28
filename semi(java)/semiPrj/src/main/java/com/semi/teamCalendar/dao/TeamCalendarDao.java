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

	public int writeCalendar(Connection conn, String memberNo, String[] paramsArr) throws SQLException {
		String sql = "INSERT INTO TEAM_CALENDAR VALUES(SEQ_TEAM_CALENDAR_NO.NEXTVAL, (SELECT TEAM_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?), ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, paramsArr[1].substring(0, 10).replaceAll("-", ""));
		pstmt.setString(3, paramsArr[2].substring(0, 10).replaceAll("-", ""));
		pstmt.setString(4, paramsArr[0]);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}

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
		
		return voList;
	}

}
