package com.semi.introduce.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.introduce.dao.IntroduceDao;
import com.semi.member.vo.MemberVo;

public class IntroduceService {
	private IntroduceDao dao = new IntroduceDao();

	public List<MemberVo> getTeacherList(PageVo pageVo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> teacherList = dao.getTeacherList(conn, pageVo);
		JDBCTemplate.close(conn);
		
		return teacherList;
	}
	
	public int getTeacherListCnt() throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getTeacherListCnt(conn);

		JDBCTemplate.close(conn);
		return result;
	}
	
}
