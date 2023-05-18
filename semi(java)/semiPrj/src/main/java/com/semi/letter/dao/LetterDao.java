package com.semi.letter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

public class LetterDao {

	public int writeLetter(LetterVo vo, Connection conn, MemberVo loginMember) throws Exception {

		String sql = "INSERT INTO LETTER (LETTER_NO, SEND_MEMBER_NO, RECEIVE_MEMBER_NO, LETTER_TITLE, LETTER_CONTENT, STATUS) VALUES (SEQ_LETTER_NO.NEXTVAL,?, (SELECT MEMBER_NO FROM MEMBER WHERE ID = ?),?, ?, 'O');";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setString(2, vo.getReceiveMemberNo());
		pstmt.setString(3, vo.getLetterTitle());
		pstmt.setString(4, vo.getLetterContent());
		int result = pstmt.executeUpdate();

		if (result == 1) {
			JDBCTemplate.commit(conn);
		}

		JDBCTemplate.rollback(conn);

		JDBCTemplate.close(pstmt);

		return result;
	}

	public List<LetterVo> letterList(Connection conn) throws Exception {

		String sql = "SELECT * FROM LETTER L JOIN MEMBER M ON L.SEND_MEMBER_NO = M.MEMBER_NO ORDER BY LETTER_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {
			String id = rs.getString("MEMBER_ID");
			String title = rs.getString("LETTER_TITLE");
			String content = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");

			LetterVo vo = new LetterVo();

			vo.setSendMemberName(id);
			vo.setLetterTitle(title);
			vo.setLetterContent(content);
			vo.setEnrollDate(enrollDate);

			voList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;
	}

	//목록 조회
	public List<LetterVo> getLetterList(Connection conn, PageVo pv) throws Exception {

		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT L.LETTER_NO , L.LETTER_TITLE , L.LETTER_CONTENT , L.SEND_MEMBER_NO , L.ENROLL_DATE , L.STATUS , M.MEMBER_NICK FROM LETTER L JOIN MEMBER M ON(L.SEND_MEMBER_NO = M.MEMBER_NO) WHERE L.STATUS = 'O' ORDER BY MEMBER_NO DESC )T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<LetterVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String memberNick = rs.getString("MEMBER_NICK");
			String letterTitle = rs.getString("LETTER_TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			LetterVo vo = new LetterVo();
			vo.setSendMemberName(memberNick);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			
			voList.add(vo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	//검색해서 조회
	public List<LetterVo> getLetterList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {

		String sql = "";

		if (searchType.equals("writer")) {
			// SQL (작성자 검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER M JOIN LETTER L ON (M.MEMBER_NO = L.SEND_MEMBER_NO) WHERE L.STATUS = 'O' AND M.MEMBER_NICK LIKE '%'||?||'%' ORDER BY M.MEMBER_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		} else if (searchType.equals("title")) {
			// SQL (내용 검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER M JOIN LETTER L ON (M.MEMBER_NO = L.SEND_MEMBER_NO) WHERE L.STATUS = 'O' AND L.LETTER_TITLE LIKE '%'||?||'%' ORDER BY M.MEMBER_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		} else {
			// 값이 이상함 => 기본 목록 조회
			return getLetterList(conn, pv);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<LetterVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String memberNick = rs.getString("MEMBER_NICK");
			String letterTitle = rs.getString("LETTER_TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			LetterVo vo = new LetterVo();
			vo.setSendMemberName(memberNick);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			
			voList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
		
	}

	public int getLetterListCnt(Connection conn, String searchType, String searchValue) throws Exception {

		String sql = "SELECT COUNT(*) FROM ( SELECT L.LETTER_NO , L.LETTER_TITLE , L.LETTER_CONTENT , L.SEND_MEMBER_NO , L.ENROLL_DATE , L.STATUS , M.MEMBER_NICK FROM LETTER L JOIN MEMBER M ON(L.SEND_MEMBER_NO = M.MEMBER_NO) ) WHERE STATUS = 'O'";
		if("title".equals(searchType)) {
			sql += "AND TITLE LIKE '%" + searchValue + "%'";
		}
		else if ("writer".equals(searchType)) {
			sql += "AND MEMBER_NICK '%" + searchValue + "%'";
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
	
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
		
	}

}
