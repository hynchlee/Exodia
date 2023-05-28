package com.semi.attendance.service;

import java.sql.Connection;
import java.util.List;

import com.semi.attendance.dao.AttendanceDao;
import com.semi.attendance.vo.AttendanceVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.letter.vo.LetterVo;

public class AttendanceService {
	
	private final AttendanceDao dao = new AttendanceDao();

	public int selectCnt(String no) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn, no);
		
		JDBCTemplate.close(conn);
		
		return cnt;
		
	}

	public List<AttendanceVo> getAttendanceList(PageVo pv, String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<AttendanceVo> list = dao.getAttendanceList(conn, pv, no);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int getAdminAttendanceListCnt(String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.getAdminAttendanceListCnt(conn, searchType, searchValue);

		JDBCTemplate.close(conn);

		return cnt;
	}

	public List<AttendanceVo> getAdminAttendanceList(PageVo pv) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<AttendanceVo> voList = dao.getAdminAttendanceList(pv, conn);
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}

	public List<AttendanceVo> getAdminAttendanceList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<AttendanceVo> voList = dao.getAdminAttendanceList(conn, pv, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

}
