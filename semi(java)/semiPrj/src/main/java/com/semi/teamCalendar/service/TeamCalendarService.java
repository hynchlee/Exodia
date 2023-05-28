package com.semi.teamCalendar.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.teamCalendar.dao.TeamCalendarDao;
import com.semi.teamCalendar.vo.TeamCalendarVo;

public class TeamCalendarService {
	private static TeamCalendarDao dao = new TeamCalendarDao();

	public int writeCalendar(String memberNo, String[] paramsArr) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.writeCalendar(conn, memberNo, paramsArr);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public List<TeamCalendarVo> getFullCalendar(String memberNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<TeamCalendarVo> voList = dao.getTeamCalendar(conn, memberNo);

		JDBCTemplate.close(conn);
		return voList;
	}

}
