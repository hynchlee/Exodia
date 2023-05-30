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
	
	//검색해서 목록 조회
	public List<ReviewVo> getReviewList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReviewVo> rvoList = dao.getReviewList(conn, pv, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return rvoList;
	}

	//상세 조회
	public ReviewVo getReviewNo(String rno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ReviewVo rvNo = dao.getReviewNo(conn, rno);
		
		JDBCTemplate.close(conn);
		
		return rvNo;
	}

	//리뷰 작성
	public int reviewWrite(ReviewVo rvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.reviewWrite(conn, rvo);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//리뷰 삭제
	public int reviewDelete(String rno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.reviewDelete(conn, rno);
		
		if (result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int editReview(ReviewVo rvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.editBoard(conn, rvo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	//관리자 일괄 삭제
	public int adminBoardDelete(String[] bnoArr) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.adminBoardDelete(conn, bnoArr);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
