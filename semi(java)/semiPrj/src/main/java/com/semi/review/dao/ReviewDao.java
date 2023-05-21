package com.semi.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.review.vo.ReviewVo;

public class ReviewDao {

	//페이징
	public int getReviewListCnt(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM REVIEW WHERE STATUS='O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	//목록 조회
	public List<ReviewVo> getReviewList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT V.REVIEW_NO ,V.MEMBER_NO ,V.REVIEW_TITLE ,V.REVIEW_CONTENT ,TO_CHAR(V.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(V.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE ,V.PHOTO ,V.STATUS ,M.MEMBER_NICK ,LC.LECTURE_NAME FROM REVIEW V JOIN MEMBER M ON(V.MEMBER_NO = M.MEMBER_NO) JOIN STUDENT D ON(D.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE L ON(L.LECTURE_NO = D.LECTURE_NO) JOIN LECTURE_CATEGORY LC ON(LC.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE V.STATUS = 'O' ORDER BY V.REVIEW_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<ReviewVo> rvoList = new ArrayList<>();
		while (rs.next()) {
			
			String reviewNo = rs.getString("REVIEW_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String reviewTitle = rs.getString("REVIEW_TITLE");
			String reviewContent = rs.getString("REVIEW_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String photo = rs.getString("PHOTO");
			String status = rs.getString("STATUS");
			String writerNick = rs.getString("MEMBER_NICK");
			String lectureName = rs.getString("LECTURE_NAME");
			
			ReviewVo rv = new ReviewVo();
			rv.setReviewNo(reviewNo);
			rv.setMemberNo(memberNo);
			rv.setReviewTitle(reviewTitle);
			rv.setReviewContent(reviewContent);
			rv.setEnrollDate(enrollDate);
			rv.setModifyDate(modifyDate);
			rv.setPhoto(photo);
			rv.setStatus(status);
			rv.setWriterNick(writerNick);
			rv.setLectureName(lectureName);
			
			rvoList.add(rv);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return rvoList;
	}

	//상세조회
	public ReviewVo getReviewNo(Connection conn, String rno) throws Exception {
		
		String sql = "SELECT V.REVIEW_NO ,V.MEMBER_NO ,V.REVIEW_TITLE ,V.REVIEW_CONTENT ,TO_CHAR(V.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(V.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE ,V.PHOTO ,V.STATUS ,M.MEMBER_NICK ,LC.LECTURE_NAME, M.IDENTITY FROM REVIEW V JOIN MEMBER M ON(V.MEMBER_NO = M.MEMBER_NO) JOIN STUDENT D ON(D.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE L ON(L.LECTURE_NO = D.LECTURE_NO) JOIN LECTURE_CATEGORY LC ON(LC.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE V.STATUS = 'O' AND V.REVIEW_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rno);
		ResultSet rs = pstmt.executeQuery();
		
		ReviewVo rvNo = new ReviewVo();
		if (rs.next()) {
			String reviewNo = rs.getString("REVIEW_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String reviewTitle = rs.getString("REVIEW_TITLE");
			String reviewContent = rs.getString("REVIEW_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String photo = rs.getString("PHOTO");
			String status = rs.getString("STATUS");
			String writerNick = rs.getString("MEMBER_NICK");
			String lectureName = rs.getString("LECTURE_NAME");
			
			rvNo = new ReviewVo();
			rvNo.setReviewNo(reviewNo);
			rvNo.setMemberNo(memberNo);
			rvNo.setReviewTitle(reviewTitle);
			rvNo.setReviewContent(reviewContent);
			rvNo.setEnrollDate(enrollDate);
			rvNo.setModifyDate(modifyDate);
			rvNo.setPhoto(photo);
			rvNo.setStatus(status);
			rvNo.setWriterNick(writerNick);
			rvNo.setLectureName(lectureName);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return rvNo;
	}

	//작성
	public int reviewWrite(Connection conn, ReviewVo rvo) throws Exception {
		
		String sql = "INSERT INTO REVIEW(REVIEW_NO,MEMBER_NO,REVIEW_TITLE,REVIEW_CONTENT) VALUES (SEQ_REVIEW_NO.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rvo.getMemberNo());
		pstmt.setString(2, rvo.getReviewTitle());
		pstmt.setString(3, rvo.getReviewContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//삭제
	public int reviewDelete(Connection conn, String rno) throws Exception {
		
		String sql = "UPDATE REVIEW SET STATUS='X' WHERE REVIEW_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rno);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int editBoard(Connection conn, ReviewVo rvo) throws Exception {
		
		String sql = "UPDATE REVIEW SET REVIEW_TITLE=?, REVIEW_CONTENT=?, MODIFY_DATE=SYSDATE WHERE REVIEW_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rvo.getReviewTitle());
		pstmt.setString(2, rvo.getReviewContent());
		pstmt.setString(3, rvo.getReviewNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
