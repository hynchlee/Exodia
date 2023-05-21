package com.semi.letter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

public class LetterDao {

	public int writeLetter(LetterVo vo, Connection conn, String sendMemberName) throws Exception {

		String sql = "INSERT INTO LETTER (LETTER_NO, SEND_MEMBER_NO, RECEIVE_MEMBER_NO, LETTER_TITLE, LETTER_CONTENT, STATUS) VALUES (SEQ_LETTER_NO.NEXTVAL,(SELECT MEMBER_NO FROM MEMBER WHERE MEMBER_NICK = ?), (SELECT MEMBER_NO FROM MEMBER WHERE MEMBER_NICK = ?),?, ?, 'O')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sendMemberName);
		pstmt.setString(2, vo.getReceiveMemberName());
		pstmt.setString(3, vo.getLetterTitle());
		pstmt.setString(3, vo.getLetterContent());
		int result = pstmt.executeUpdate();

		if (result == 1) {
			JDBCTemplate.commit(conn);
		}

		else {
			JDBCTemplate.rollback(conn);
		}

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

	// 紐⑸줉 議고쉶
	public List<LetterVo> getLetterList(Connection conn, PageVo pv) throws Exception {

		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT L.LETTER_NO , L.LETTER_TITLE , L.LETTER_CONTENT , L.SEND_MEMBER_NO , L.ENROLL_DATE , L.STATUS , M.MEMBER_NICK FROM LETTER L JOIN MEMBER M ON(L.SEND_MEMBER_NO = M.MEMBER_NO) WHERE L.STATUS = 'O' ORDER BY MEMBER_NO DESC )T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {

			String no = rs.getString("LETTER_NO");
			String memberNick = rs.getString("MEMBER_NICK");
			String letterTitle = rs.getString("LETTER_TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");

			LetterVo vo = new LetterVo();
			vo.setSendMemberName(memberNick);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			vo.setLetterNo(no);

			voList.add(vo);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;
	}

	// 寃��깋�빐�꽌 議고쉶
	public List<LetterVo> getLetterList(Connection conn, PageVo pv, String searchType, String searchValue)
			throws Exception {

		String sql = "";

		if (searchType.equals("writer")) {
			// SQL (�옉�꽦�옄 寃��깋)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER M JOIN LETTER L ON (M.MEMBER_NO = L.SEND_MEMBER_NO) WHERE L.STATUS = 'O' AND M.MEMBER_NICK LIKE '%'||?||'%' ORDER BY M.MEMBER_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		} else if (searchType.equals("title")) {
			// SQL (�궡�슜 寃��깋)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER M JOIN LETTER L ON (M.MEMBER_NO = L.SEND_MEMBER_NO) WHERE L.STATUS = 'O' AND L.LETTER_TITLE LIKE '%'||?||'%' ORDER BY M.MEMBER_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		} else {
			// 媛믪씠 �씠�긽�븿 => 湲곕낯 紐⑸줉 議고쉶
			return getLetterList(conn, pv);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {

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
		if ("title".equals(searchType)) {
			sql += "AND TITLE LIKE '%" + searchValue + "%'";
		} else if ("writer".equals(searchType)) {
			sql += "AND MEMBER_NICK '%" + searchValue + "%'";
		}

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

	public int deleteLetter(Connection conn, int number) throws Exception {
		
		String sql = "UPDATE LETTER SET STATUS = 'X' WHERE LETTER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, number);

		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(pstmt);

		return result;
	}

}
