package com.semi.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.vo.BoardVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;

public class BoardDao {

	//목록 조회
	public List<BoardVo> getBoardList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT B.BOARD_NO ,B.BOARD_CATEGORY_NO ,B.MEMBER_NO ,B.BOARD_TITLE ,B.BOARD_CONTENT ,TO_CHAR(B.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(B.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE ,B.STATUS ,B.HIT ,M.MEMBER_NICK ,C.BOARD_CATEGORY_TYPE FROM BOARD B JOIN MEMBER M ON(B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON(B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) WHERE B.STATUS='O' AND C.BOARD_CATEGORY_NO=3 ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
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
			
			cvoList.add(bv);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cvoList;
	}

	//검색해서 목록 조회
	public List<BoardVo> getBoardList(Connection conn, PageVo pv, String searchType, String searchValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
