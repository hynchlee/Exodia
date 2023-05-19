package com.semi.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.dao.BoardDao;
import com.semi.board.vo.BoardVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.notice.vo.NoticeVo;

public class BoardService {
	
	private final BoardDao dao = new BoardDao();

	//페이징
	public int getBoardListCnt() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getBoardListCnt(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//목록 조회
	public List<BoardVo> getBoardList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> cvoList = dao.getBoardList(conn,pv);
		
		JDBCTemplate.close(conn);
		
		return cvoList;
	}

	//검색해서 목록 조회
	public List<BoardVo> getBoardList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> cvoList = dao.getBoardList(conn,pv,searchType,searchValue);
		
		JDBCTemplate.close(conn);
		
		return cvoList;
	}

}
