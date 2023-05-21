package com.semi.mypage.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.vo.BoardVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureVo;
import com.semi.mypage.vo.TeamVo;

public class MypageDao {

	public List<LectureVo> viewStudent(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT M.MEMBER_NICK, G.LECTURE_NAME FROM LECTURE L JOIN STUDENT S ON (L.LECTURE_NO = S.LECTURE_NO) JOIN MEMBER M ON(S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE_CATEGORY G ON (G.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE TEACHER_MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<LectureVo> volist = new ArrayList<>();
		while(rs.next()) {
			String memberNick = rs.getString("MEMBER_NICK");
			String lectureName = rs.getString("LECTURE_NAME");
			
			LectureVo vo = new LectureVo();
			vo.setTeacherMemberName(memberNick);
			vo.setLectureCategoryName(lectureName);
			
			volist.add(vo);
				
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return volist;
	}

	public List<BoardVo> showNotice(Connection conn) throws Exception {

		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 1 GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN 1 AND 3";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> notList = new ArrayList<>();
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
			
			notList.add(bv);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return notList;
	
	}

	public List<BoardVo> freeBoard(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 1 GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN 1 AND 3";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> freeList = new ArrayList<>();
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
			
			freeList.add(bv);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return freeList;
	}

	public List<BoardVo> showNotice02(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 1 GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN 1 AND 3";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> snotList = new ArrayList<>();
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
			
			snotList.add(bv);
		
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return snotList;
		
	}

	public String countLetter01(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM LETTER WHERE RECEIVE_MEMBER_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String letterCount01 = null;
		while(rs.next()) {
			letterCount01 = rs.getString("Count(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return letterCount01;
	}

	public String countMyWrite(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM BOARD WHERE MEMBER_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String countMyWrite = null;
		while(rs.next()) {
			countMyWrite = rs.getString("Count(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return countMyWrite;
	}

	public List<LectureVo> teacherLecture(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT M.MEMBER_NICK, G.LECTURE_NAME FROM LECTURE L JOIN MEMBER M ON(L.TEACHER_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE_CATEGORY G ON (G.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE TEACHER_MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<LectureVo> tvolist = new ArrayList<>();
		while(rs.next()) {
			String memberNick = rs.getString("MEMBER_NICK");
			String lectureName = rs.getString("LECTURE_NAME");
			
			LectureVo vo = new LectureVo();
			vo.setTeacherMemberName(memberNick);
			vo.setLectureCategoryName(lectureName);
			
			tvolist.add(vo);
				
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return tvolist;
	
	}

	public List<TeamVo> teamList(Connection conn) throws Exception {

		String sql = "SELECT M.MEMBER_NICK, T.TEAM_NAME, TR.ROLE, TR.PROJECT_DIVISION FROM TEAM T JOIN STUDENT S ON(S.TEAM_NO = T.TEAM_NO) JOIN TEAM_ROLE TR ON (TR.STUDENT_MEMBER_NO = S.STUDENT_MEMBER_NO) JOIN MEMBER M ON (M.MEMBER_NO = S.STUDENT_MEMBER_NO) WHERE IDENTITY = 'S'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<TeamVo> teamList = new ArrayList<>();
		while (rs.next()) {
			
			String memberNick = rs.getString("MEMBER_NICK");
			String teamName = rs.getString("TEAM_NAME");
			String role = rs.getString("ROLE");
			String projectDivision = rs.getString("PROJECT_DIVISION");
			
			TeamVo tv = new TeamVo();
			tv.setMemberNick(memberNick);
			tv.setTeamName(teamName);
			tv.setRole(role);
			tv.setProjectDivision(projectDivision);
			
			teamList.add(tv);
		
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return teamList;
	
	}

	
	
}
