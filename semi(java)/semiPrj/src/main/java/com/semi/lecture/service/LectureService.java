package com.semi.lecture.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.lecture.dao.LectureDao;
import com.semi.lecture.vo.LectureVo;

public class LectureService {
	private LectureDao dao = new LectureDao();

	public List<LectureVo> getLectureList(PageVo pageVo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<LectureVo> LectureList = dao.getLectureList(conn, pageVo);
		JDBCTemplate.close(conn);
		
		return LectureList;
	}
	
	public int getLectureListCnt() throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getLectureListCnt(conn);

		JDBCTemplate.close(conn);
		return result;
	}
}
