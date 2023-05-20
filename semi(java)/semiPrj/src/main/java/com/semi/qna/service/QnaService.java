package com.semi.qna.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.qna.dao.QnaDao;
import com.semi.qna.vo.QnaVo;

public class QnaService {
	
	private final QnaDao dao = new QnaDao();

	//페이징
	public int getQnaListCnt(String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getQnaListCnt(conn, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//목록 조회
	public List<QnaVo> getBoardQnaList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<QnaVo> qvoList = dao.getBoardQnaList(conn,pv);
		
		JDBCTemplate.close(conn);
		
		return qvoList;
	}

	//목록 검색해서 조회
	public List<QnaVo> getBoardQnaList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<QnaVo> qvoList = dao.getBoardQnaList(conn,pv,searchType,searchValue);
		
		JDBCTemplate.close(conn);
		
		return qvoList;
		
	}

}
