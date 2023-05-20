package com.semi.review.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.review.dao.ReviewDao;
import com.semi.review.vo.ReviewVo;

public class ReviewService {
	
	private final ReviewDao dao = new ReviewDao();

	//페이징
	public int getReviewListCnt() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getReviewListCnt(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//목록 조회
	public List<ReviewVo> getReviewList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReviewVo> rvoList = dao.getReviewList(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return rvoList;
	}

}
