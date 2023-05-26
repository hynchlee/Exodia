package com.semi.attendance.service;

import java.sql.Connection;
import java.util.List;

import com.semi.attendance.dao.AttendanceDao;
import com.semi.attendance.vo.AttendanceVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;

public class AttendanceService {
	
	private final AttendanceDao dao = new AttendanceDao();

	public int selectCnt() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
		
	}

	public List<AttendanceVo> getAttendanceList(PageVo pv, String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<AttendanceVo> list = dao.getAttendanceList(conn, pv, no);
		
		JDBCTemplate.close(conn);
		
		return list;
	}


}
