package com.semi.mypage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureVo;
import com.semi.mypage.dao.MypageDao;

public class MypageService {

	public List<LectureVo> viewStudent(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<LectureVo> volist = mdao.viewStudent(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return volist;
		
		
	}

}
