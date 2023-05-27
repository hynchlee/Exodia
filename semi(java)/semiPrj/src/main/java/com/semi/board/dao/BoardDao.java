package com.semi.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.vo.AnswerVo;
import com.semi.board.vo.BoardVo;
import com.semi.board.vo.ReplyVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.lecture.vo.LectureVo;

public class BoardDao {

//	//목록 조회
//	public List<BoardVo> getBoardClassList(Connection conn, PageVo pv, String memberNo) throws Exception {
//		
//		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, pv.getBeginRow());
//		pstmt.setInt(2, pv.getLastRow());
//		ResultSet rs = pstmt.executeQuery();
//		
//		List<BoardVo> cvoList = new ArrayList<>();
//		while (rs.next()) {
//			
//			String boardNo = rs.getString("BOARD_NO");
//			String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
//			String boardTitle = rs.getString("BOARD_TITLE");
//			String boardContent = rs.getString("BOARD_CONTENT");
//			String enrollDate = rs.getString("ENROLL_DATE");
//			String modifyDate = rs.getString("MODIFY_DATE");
//			String status = rs.getString("STATUS");
//			String hit = rs.getString("HIT");
//			String writerNick = rs.getString("MEMBER_NICK");
//			String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
//			String totalReplies = rs.getString("TOTAL_REPLIES");
//			
//			BoardVo bv = new BoardVo();
//			bv.setBoardNo(boardNo);
//			bv.setBoardCategoryNo(boardCategoryNo);
//			bv.setBoardTitle(boardTitle);
//			bv.setBoardContent(boardContent);
//			bv.setEnrollDate(enrollDate);
//			bv.setModifyDate(modifyDate);
//			bv.setStatus(status);
//			bv.setHit(hit);
//			bv.setWriterNick(writerNick);
//			bv.setBoardCategoryType(boardCategoryType);
//			bv.setTotalReplies(totalReplies);
//			
//			cvoList.add(bv);
//		}
//		
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
//		
//		return cvoList;
//	}
//
//	//검색해서 목록 조회
//	public List<BoardVo> getBoardClassList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {
//
//		String sql = "";
//		
//		if (searchType.equals("classTitle")) {
//			//제목 검색
//			sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 AND B.BOARD_TITLE LIKE ('%' || ? || '%') GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
//		}else if (searchType.equals("classContent")) {
//			//내용 검색
//			sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 AND B.BOARD_CONTENT LIKE ('%' || ? || '%') GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
//		}else {
//			return getBoardClassList(conn, pv);
//		}
//		
//		
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, searchValue);
//		pstmt.setInt(2, pv.getBeginRow());
//		pstmt.setInt(3, pv.getLastRow());
//		ResultSet rs = pstmt.executeQuery();
//		
//		List<BoardVo> cvoList = new ArrayList<>();
//		while (rs.next()) {
//			
//			String boardNo = rs.getString("BOARD_NO");
//			String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
//			String memberNo = rs.getString("MEMBER_NO");
//			String boardTitle = rs.getString("BOARD_TITLE");
//			String boardContent = rs.getString("BOARD_CONTENT");
//			String enrollDate = rs.getString("ENROLL_DATE");
//			String modifyDate = rs.getString("MODIFY_DATE");
//			String status = rs.getString("STATUS");
//			String hit = rs.getString("HIT");
//			String writerNick = rs.getString("MEMBER_NICK");
//			String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
//			String totalReplies = rs.getString("TOTAL_REPLIES");
//			
//			BoardVo bv = new BoardVo();
//			bv.setBoardNo(boardNo);
//			bv.setBoardCategoryNo(boardCategoryNo);
//			bv.setMemberNo(memberNo);
//			bv.setBoardTitle(boardTitle);
//			bv.setBoardContent(boardContent);
//			bv.setEnrollDate(enrollDate);
//			bv.setModifyDate(modifyDate);
//			bv.setStatus(status);
//			bv.setHit(hit);
//			bv.setWriterNick(writerNick);
//			bv.setBoardCategoryType(boardCategoryType);
//			bv.setTotalReplies(totalReplies);
//			
//			cvoList.add(bv);
//		}
//		
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
//		
//		return cvoList;
//
//	}

	//우리반 페이징
	public int getBoardClassListCnt(Connection conn, String searchType, String searchValue, String lno) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'O' AND BOARD_CATEGORY_NO = 3 AND MEMBER_NO IN (SELECT STUDENT_MEMBER_NO FROM STUDENT WHERE LECTURE_NO = ?)";
		if ("classTitle".equals(searchType)) {
			sql += "AND BOARD_TITLE LIKE '%" + searchValue + "%'";
		} else if ("classContent".equals(searchType)) {
			sql += "AND BOARD_CONTENT LIKE '%" + searchValue + "%'";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lno);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	//자유 페이징
	public int getBoardFreeListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS='O' AND BOARD_CATEGORY_NO=1 ";
		if ("freeTitle".equals(searchType)) {
			sql += "AND BOARD_TITLE LIKE '%" + searchValue + "%'";
		} else if ("freeContent".equals(searchType)) {
			sql += "AND BOARD_CONTENT LIKE '%" + searchValue + "%'";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return cnt;
	}

	public List<BoardVo> getBoardFreeList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 1 GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> fvoList = new ArrayList<>();
		while (rs.next()) {
			
			String boardNo = rs.getString("BOARD_NO");
			String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String boardTitle = rs.getString("BOARD_TITLE");
			String boardContent = rs.getString("BOARD_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");
			String writerNick = rs.getString("MEMBER_NICK");
			String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
			String totalReplies = rs.getString("TOTAL_REPLIES");
			
			BoardVo bv = new BoardVo();
			bv.setBoardNo(boardNo);
			bv.setBoardCategoryNo(boardCategoryNo);
			bv.setMemberNo(memberNo);
			bv.setBoardTitle(boardTitle);
			bv.setBoardContent(boardContent);
			bv.setEnrollDate(enrollDate);
			bv.setModifyDate(modifyDate);
			bv.setStatus(status);
			bv.setHit(hit);
			bv.setWriterNick(writerNick);
			bv.setBoardCategoryType(boardCategoryType);
			bv.setTotalReplies(totalReplies);
			
			fvoList.add(bv);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return fvoList;
	}
	
	//자유 검색해서 목록 조회
		public List<BoardVo> getBoardFreeList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {

			String sql = "";
			
			if (searchType.equals("freeTitle")) {
				//제목 검색
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 1 AND B.BOARD_TITLE LIKE ('%' || ? || '%') GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			}else if (searchType.equals("freeContent")) {
				//내용 검색
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 1 AND B.BOARD_CONTENT LIKE ('%' || ? || '%') GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			}else {
				return getBoardFreeList(conn, pv);
			}
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, pv.getBeginRow());
			pstmt.setInt(3, pv.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVo> fvoList = new ArrayList<>();
			while (rs.next()) {
				
				String boardNo = rs.getString("BOARD_NO");
				String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
				String memberNo = rs.getString("MEMBER_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String hit = rs.getString("HIT");
				String writerNick = rs.getString("MEMBER_NICK");
				String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
				String totalReplies = rs.getString("TOTAL_REPLIES");
				
				BoardVo bv = new BoardVo();
				bv.setBoardNo(boardNo);
				bv.setBoardCategoryNo(boardCategoryNo);
				bv.setMemberNo(memberNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardContent(boardContent);
				bv.setEnrollDate(enrollDate);
				bv.setModifyDate(modifyDate);
				bv.setStatus(status);
				bv.setHit(hit);
				bv.setWriterNick(writerNick);
				bv.setBoardCategoryType(boardCategoryType);
				bv.setTotalReplies(totalReplies);
				
				fvoList.add(bv);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return fvoList;

		}

		public int boardWrite(Connection conn, BoardVo bvo) throws Exception {
			
			String sql = "INSERT INTO BOARD ( BOARD_NO ,BOARD_CATEGORY_NO ,MEMBER_NO ,BOARD_TITLE ,BOARD_CONTENT ) VALUES ( SEQ_BOARD_NO.NEXTVAL ,? ,? ,? ,? )";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBoardCategoryNo());
			pstmt.setString(2, bvo.getMemberNo());
			pstmt.setString(3, bvo.getBoardTitle());
			pstmt.setString(4, bvo.getBoardContent());
			int result = pstmt.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result;
		}

		public BoardVo getBoardByNo(Connection conn, String bno) throws Exception {
			
			String sql = "SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, BC.BOARD_CATEGORY_TYPE FROM BOARD B JOIN MEMBER M ON B.MEMBER_NO = M.MEMBER_NO JOIN BOARD_CATEGORY BC ON B.BOARD_CATEGORY_NO = BC.BOARD_CATEGORY_NO WHERE B.STATUS='O' AND B.BOARD_NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			ResultSet rs = pstmt.executeQuery();
			
			BoardVo cvNo = null;
			if (rs.next()) {
				
				String boardNo = rs.getString("BOARD_NO");
				String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
				String memberNo = rs.getString("MEMBER_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String hit = rs.getString("HIT");
				String writerNick = rs.getString("MEMBER_NICK");
				String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
				
				cvNo = new BoardVo();
				cvNo.setBoardNo(boardNo);
				cvNo.setBoardCategoryNo(boardCategoryNo);
				cvNo.setMemberNo(memberNo);
				cvNo.setBoardTitle(boardTitle);
				cvNo.setBoardContent(boardContent);
				cvNo.setEnrollDate(enrollDate);
				cvNo.setModifyDate(modifyDate);
				cvNo.setStatus(status);
				cvNo.setHit(hit);
				cvNo.setWriterNick(writerNick);
				cvNo.setBoardCategoryType(boardCategoryType);
			}
			
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
			return cvNo;
		}
		
		//조회수
		public int increaseHit(Connection conn, String bno) throws Exception {
			
			String sql = "UPDATE BOARD SET HIT = HIT+1 WHERE BOARD_NO=? AND STATUS='O'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			int result = pstmt.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result;
			
		}

		public int editBoard(Connection conn, BoardVo bvo) throws Exception {
			
			String sql = "UPDATE BOARD SET BOARD_TITLE=?, BOARD_CONTENT=?, MODIFY_DATE=SYSDATE WHERE BOARD_NO=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBoardTitle());
			pstmt.setString(2, bvo.getBoardContent());
			pstmt.setString(3, bvo.getBoardNo());
			int result = pstmt.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result;
		}

		//글 삭제
		public int boardDelete(Connection conn, String bno) throws Exception {
			
			String sql = "UPDATE BOARD SET STATUS='X' WHERE BOARD_NO=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			int result = pstmt.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result;
			
		}

		//댓글 리스트
		public List<ReplyVo> getBoardReplyList(Connection conn, String bno) throws Exception {
			
			String sql = "SELECT R.REPLY_NO ,R.WRITER_NO ,R.BOARD_NO ,R.REPLY_CONTENT ,TO_CHAR(R.ENROLL_DATE,'YYYY-MM-DD HH24:MI:SS') AS ENROLL_DATE ,TO_CHAR(R.MODIFY_DATE,'YYYY-MM-DD HH24:MI:SS') AS MODIFY_DATE ,R.STATUS ,M.MEMBER_NICK AS WRITER_NICK FROM REPLY R JOIN MEMBER M ON(M.MEMBER_NO = R.WRITER_NO) WHERE R.STATUS='O' AND R.BOARD_NO=? ORDER BY R.REPLY_NO DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			ResultSet rs = pstmt.executeQuery();
			
			List<ReplyVo> revoList = new ArrayList<>();
			while (rs.next()) {
				String replyNo = rs.getString("REPLY_NO");
				String writerNo = rs.getString("WRITER_NO");
				String replyContent = rs.getString("REPLY_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String writerNick = rs.getString("WRITER_NICK");
				
				ReplyVo rv = new ReplyVo();
				rv.setReplyNo(replyNo);
				rv.setWriterNo(writerNo);
				rv.setReplyContent(replyContent);
				rv.setEnrollDate(enrollDate);
				rv.setModifyDate(modifyDate);
				rv.setStatus(status);
				rv.setWriterNick(writerNick);
				
				revoList.add(rv);
				
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return revoList;
		}

		//전체 목록 조회
		public List<BoardVo> getBoardMyList(Connection conn, PageVo pv) throws Exception {
			
			String sql =  "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pv.getBeginRow());
			pstmt.setInt(2, pv.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVo> bvoList = new ArrayList<>();
			while (rs.next()) {
				
				String boardNo = rs.getString("BOARD_NO");
				String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
				String memberNo = rs.getString("MEMBER_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String hit = rs.getString("HIT");
				String writerNick = rs.getString("MEMBER_NICK");
				String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
				String totalReplies = rs.getString("TOTAL_REPLIES");
				
				BoardVo bv = new BoardVo();
				bv.setBoardNo(boardNo);
				bv.setBoardCategoryNo(boardCategoryNo);
				bv.setMemberNo(memberNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardContent(boardContent);
				bv.setEnrollDate(enrollDate);
				bv.setModifyDate(modifyDate);
				bv.setStatus(status);
				bv.setHit(hit);
				bv.setWriterNick(writerNick);
				bv.setBoardCategoryType(boardCategoryType);
				bv.setTotalReplies(totalReplies);
				
				bvoList.add(bv);
				
			}
			
			return bvoList;
			
		}

		
		//내가쓴글 검색 목록 조회
		public List<BoardVo> getBoardMyList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {
			
			String sql = "";
			
			if (searchType.equals("myTitle")) {
				//제목 검색
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND B.BOARD_TITLE LIKE ('%' || ? || '%') GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			}else if (searchType.equals("myContent")) {
				//내용 검색
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND B.BOARD_CONTENT LIKE ('%' || ? || '%') GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			}else if (searchType.equals("myCategory")) {
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND B.BOARD_CONTENT_NO LIKE ('%' || ? || '%') GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			}else {
				return getBoardMyList(conn, pv);
			}
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, pv.getBeginRow());
			pstmt.setInt(3, pv.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVo> bvoList = new ArrayList<>();
			while (rs.next()) {
				
				String boardNo = rs.getString("BOARD_NO");
				String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
				String memberNo = rs.getString("MEMBER_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String hit = rs.getString("HIT");
				String writerNick = rs.getString("MEMBER_NICK");
				String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
				String totalReplies = rs.getString("TOTAL_REPLIES");
				
				BoardVo bv = new BoardVo();
				bv.setBoardNo(boardNo);
				bv.setBoardCategoryNo(boardCategoryNo);
				bv.setMemberNo(memberNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardContent(boardContent);
				bv.setEnrollDate(enrollDate);
				bv.setModifyDate(modifyDate);
				bv.setStatus(status);
				bv.setHit(hit);
				bv.setWriterNick(writerNick);
				bv.setBoardCategoryType(boardCategoryType);
				bv.setTotalReplies(totalReplies);
				
				bvoList.add(bv);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return bvoList;
			
		}

		//페이징
		public int getBoardMyListCnt(Connection conn, String searchType, String searchValue, String mno) throws Exception {
			
			String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS='O' AND MEMBER_NO=?";
			if ("myTitle".equals(searchType)) {
				sql += "AND BOARD_TITLE LIKE '%" + searchValue + "%'";
			} else if ("myContent".equals(searchType)) {
				sql += "AND BOARD_CONTENT LIKE '%" + searchValue + "%'";
			}
//			}else if ("myCategory".equals(searchType)) {
//				sql += "AND BOARD_CATEGORY_NO LIKE '%" + searchValue + "%'";
//			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			ResultSet rs = pstmt.executeQuery();
			
			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return cnt;
		}

		//댓글 작성
		public int replyWrite(Connection conn, ReplyVo revo) throws Exception {
			
			String sql = "INSERT INTO REPLY(REPLY_NO, WRITER_NO, BOARD_NO, REPLY_CONTENT) VALUES(SEQ_REPLY_NO.NEXTVAL, ?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revo.getWriterNo());;
			pstmt.setString(2, revo.getBoardNo());;
			pstmt.setString(3, revo.getReplyContent());;
			int result = pstmt.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result;
		}

		//답글 조회
		public List<AnswerVo> getReplyAnswerList(Connection conn, String rno) throws Exception {
			
			String sql = "SELECT A.ANSWER_NO ,A.REPLY_NO2 ,A.ANSWER_CONTENT ,TO_CHAR(A.ENROLL_DATE,'YYYY-MM-DD HH24:MI:SS') AS ENROLL_DATE ,TO_CHAR(A.MODIFY_DATE,'YYYY-MM-DD HH24:MI:SS') AS MODIFY_DATE ,A.STATUS FROM ANSWER A JOIN REPLY R ON(A.REPLY_NO2 = R.REPLY_NO) WHERE A.STATUS='O' AND A.REPLY_NO2=? ORDER BY A.ANSWER_NO DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rno);
			ResultSet rs = pstmt.executeQuery();
			
			List<AnswerVo> answerList = new ArrayList<>();
			if (rs.next()) {
				
				String answerNo = rs.getString("ANSWER_NO");
				String answerContent = rs.getString("ANSWER_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				
				AnswerVo av = new AnswerVo();
				av.setAnswerNo(answerNo);
				av.setAnswerContent(answerContent);
				av.setEnrollDate(enrollDate);
				av.setModifyDate(modifyDate);
				av.setStatus(status);
				
				answerList.add(av);
				
			}		
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return answerList;
		}

		public int editReply(Connection conn, ReplyVo revo) throws Exception {
			
			String sql = "UPDATE REPLY SET REPLY_CONTENT=?, MODIFY_DATE=SYSDATE WHERE REPLY_NO=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, revo.getReplyContent());
			pstmt.setString(2, revo.getReplyNo());
			int result = pstmt.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result;
		}

//		public List<LectureVo> teacherLecture(Connection conn, String memberNo) throws Exception {
//			String sql = "SELECT * FROM LECTURE L JOIN MEMBER M ON(L.TEACHER_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE_CATEGORY G ON (G.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE TEACHER_MEMBER_NO = ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memberNo);
//			ResultSet rs = pstmt.executeQuery();
//			
//			List<LectureVo> tvolist = new ArrayList<>();
//			while(rs.next()) {
//				LectureVo vo = new LectureVo();
//				vo.setLectureNo(rs.getString("LECTURE_NO"));
//				vo.setTeacherMemberNo(rs.getString("TEACHER_MEMBER_NO"));
//				vo.setLectureCategoryNo(rs.getString("LECTURE_CATEGORY_NO"));
//				vo.setLectureStartTime(rs.getString("LECTURE_START_TIME"));
//				vo.setLectureFinishTime(rs.getString("LECTURE_FINISH_TIME"));
//				vo.setLectureOpenDate(rs.getString("LECTURE_OPEN_DATE"));
//				vo.setLectureCloseDate(rs.getString("LECTURE_CLOSE_DATE"));
//				vo.setStatus(rs.getString("STATUS"));
//				vo.setTeacherMemberName(rs.getString("MEMBER_NICK"));
//				vo.setLectureCategoryName(rs.getString("LECTURE_NAME"));
//				
//				tvolist.add(vo);
//			}
//			
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//			
//			return tvolist;
//		}

		public List<BoardVo> getBoardTClassList(Connection conn, PageVo pv, String lno) throws Exception {
			
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 AND B.MEMBER_NO IN ( SELECT STUDENT_MEMBER_NO FROM STUDENT WHERE LECTURE_NO = ? ) GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lno);
			pstmt.setInt(2, pv.getBeginRow());
			pstmt.setInt(3, pv.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVo> cvoList = new ArrayList<>();
			while (rs.next()) {
				
				String boardNo = rs.getString("BOARD_NO");
				String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
				String memberNo = rs.getString("MEMBER_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String hit = rs.getString("HIT");
				String writerNick = rs.getString("MEMBER_NICK");
				String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
				String totalReplies = rs.getString("TOTAL_REPLIES");
				
				BoardVo bv = new BoardVo();
				bv.setBoardNo(boardNo);
				bv.setBoardCategoryNo(boardCategoryNo);
				bv.setMemberNo(memberNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardContent(boardContent);
				bv.setEnrollDate(enrollDate);
				bv.setModifyDate(modifyDate);
				bv.setStatus(status);
				bv.setHit(hit);
				bv.setWriterNick(writerNick);
				bv.setBoardCategoryType(boardCategoryType);
				bv.setTotalReplies(totalReplies);
				
				cvoList.add(bv);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return cvoList;
		
		}

		public List<BoardVo> getBoardTClassList(Connection conn, PageVo pv, String searchType, String searchValue,
				String lno) throws Exception {
			
			String sql = "";
			
			if (searchType.equals("classTitle")) {
				//제목 검색
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 AND B.BOARD_TITLE LIKE '%' || ? || '%' AND B.MEMBER_NO IN ( SELECT STUDENT_MEMBER_NO FROM STUDENT WHERE LECTURE_NO = ? ) GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			}else if (searchType.equals("classContent")) {
				//내용 검색
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 AND B.BOARD_CONTENT LIKE '%' || ? || '%' AND B.MEMBER_NO IN ( SELECT STUDENT_MEMBER_NO FROM STUDENT WHERE LECTURE_NO = ? ) GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?;";
			}else {
				return getBoardTClassList(conn, pv, lno);
			}
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchValue);
			pstmt.setInt(2, pv.getBeginRow());
			pstmt.setInt(3, pv.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVo> cvoList = new ArrayList<>();
			while (rs.next()) {
				
				String boardNo = rs.getString("BOARD_NO");
				String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
				String memberNo = rs.getString("MEMBER_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String hit = rs.getString("HIT");
				String writerNick = rs.getString("MEMBER_NICK");
				String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
				String totalReplies = rs.getString("TOTAL_REPLIES");
				
				BoardVo bv = new BoardVo();
				bv.setBoardNo(boardNo);
				bv.setBoardCategoryNo(boardCategoryNo);
				bv.setMemberNo(memberNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardContent(boardContent);
				bv.setEnrollDate(enrollDate);
				bv.setModifyDate(modifyDate);
				bv.setStatus(status);
				bv.setHit(hit);
				bv.setWriterNick(writerNick);
				bv.setBoardCategoryType(boardCategoryType);
				bv.setTotalReplies(totalReplies);
				
				cvoList.add(bv);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return cvoList;
		}

		public List<BoardVo> getBoardClassList(Connection conn, PageVo pv, String memberNo) throws SQLException {
			
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 AND B.MEMBER_NO IN ( SELECT STUDENT_MEMBER_NO FROM STUDENT WHERE LECTURE_NO = ( SELECT LECTURE_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ? ) ) GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			pstmt.setInt(2, pv.getBeginRow());
			pstmt.setInt(3, pv.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVo> scvoList = new ArrayList<>();
			while (rs.next()) {
				
				String boardNo = rs.getString("BOARD_NO");
				String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String status = rs.getString("STATUS");
				String hit = rs.getString("HIT");
				String writerNick = rs.getString("MEMBER_NICK");
				String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
				String totalReplies = rs.getString("TOTAL_REPLIES");
				
				BoardVo bv = new BoardVo();
				bv.setBoardNo(boardNo);
				bv.setBoardCategoryNo(boardCategoryNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardContent(boardContent);
				bv.setEnrollDate(enrollDate);
				bv.setModifyDate(modifyDate);
				bv.setStatus(status);
				bv.setHit(hit);
				bv.setWriterNick(writerNick);
				bv.setBoardCategoryType(boardCategoryType);
				bv.setTotalReplies(totalReplies);
				
				scvoList.add(bv);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return scvoList;
			
		}

		public int getBoardSClassListCnt(Connection conn, String searchType, String searchValue, String memberNo) throws Exception {
			String sql = "SELECT * FROM BOARD WHERE BOARD_CATEGORY_NO = 3 AND MEMBER_NO IN (SELECT STUDENT_MEMBER_NO FROM STUDENT WHERE LECTURE_NO = (SELECT LECTURE_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?))";
			if ("classTitle".equals(searchType)) {
				sql += "AND BOARD_TITLE LIKE '%" + searchValue + "%'";
			} else if ("classContent".equals(searchType)) {
				sql += "AND BOARD_CONTENT LIKE '%" + searchValue + "%'";
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			
			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return cnt;
		}
		

}
