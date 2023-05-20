package com.semi.mypage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.vo.BoardVo;
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

	public List<BoardVo> showNotice() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<BoardVo> notList = mdao.showNotice(conn);
		
		JDBCTemplate.close(conn);
		
		return notList;
		
	}

	public List<BoardVo> freeboard() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<BoardVo> freeList = mdao.freeBoard(conn);
		
		JDBCTemplate.close(conn);
		
		return freeList;
	
	}

	public List<BoardVo> showNotice02() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<BoardVo> snotList = mdao.showNotice02(conn);
		
		JDBCTemplate.close(conn);
		
		return snotList;
	
	}

}
