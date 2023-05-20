package com.semi.notice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.notice.dao.NoticeDao;
import com.semi.notice.vo.NoticeVo;

public class NoticeService {
	
	private final NoticeDao dao = new NoticeDao();

	//목록 조회
	public List<NoticeVo> getNoticeList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<NoticeVo> nvoList = dao.getNoticeList(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return nvoList;
	}

	//검색해서 목록 조회
	public List<NoticeVo> getNoticeList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<NoticeVo> nvoList = dao.getNoticeList(conn, pv, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return nvoList;
	}

	//목록 페이징
	public int getNoticeListCnt(String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getNoticeListCnt(conn, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

}
