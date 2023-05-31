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

	public int writeLetter(LetterVo vo, Connection conn, String sendMemberId) throws Exception {

		String sql = "INSERT INTO LETTER (LETTER_NO, SEND_MEMBER_NO, RECEIVE_MEMBER_NO, LETTER_TITLE, LETTER_CONTENT, STATUS) VALUES (SEQ_LETTER_NO.NEXTVAL, (SELECT MEMBER_NO FROM (SELECT MEMBER_NO, ROW_NUMBER() OVER(ORDER BY ROWNUM DESC) AS RN FROM MEMBER WHERE MEMBER_ID = ?) WHERE RN = 1), (SELECT MEMBER_NO FROM (SELECT MEMBER_NO, ROW_NUMBER() OVER(ORDER BY ROWNUM DESC) AS RN FROM MEMBER WHERE MEMBER_ID = ?) WHERE RN = 1), ?, ?, 'O')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sendMemberId);
		pstmt.setString(2, vo.getReceiveMemberName());
		pstmt.setString(3, vo.getLetterTitle());
		pstmt.setString(4, vo.getLetterContent());
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

		String sql = "SELECT * FROM LETTER L JOIN MEMBER M ON L.SEND_MEMBER_NO = M.MEMBER_NO ORDER BY LETTER_NO DESC";
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

	// 그냥 목록 조회
	public List<LetterVo> getLetterList(Connection conn, PageVo pv, String MemberNo) throws Exception {

		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT L.LETTER_NO, L.LETTER_TITLE, L.LETTER_CONTENT, L.RECEIVE_MEMBER_NO, L.SEND_MEMBER_NO, L.ENROLL_DATE, L.STATUS, M.MEMBER_NICK, M.MEMBER_ID FROM LETTER L JOIN MEMBER M ON (L.SEND_MEMBER_NO = M.MEMBER_NO) WHERE L.STATUS = 'O' AND L.RECEIVE_MEMBER_NO = ? ORDER BY L.ENROLL_DATE DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberNo);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {

			String no = rs.getString("LETTER_NO");
			String memberNick = rs.getString("MEMBER_NICK");
			String memberId = rs.getString("MEMBER_ID");
			String letterTitle = rs.getString("LETTER_TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");

			LetterVo vo = new LetterVo();
			vo.setSendMemberName(memberNick);
			vo.setSendMemberId(memberId);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			vo.setLetterNo(no);

			voList.add(vo);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;
	}

	// 검색해서 조회하기
	public List<LetterVo> getLetterList(Connection conn, PageVo pv, String searchType, String searchValue,
			String MemberNo) throws Exception {

		String sql = "";

		if (searchType.equals("writer")) {
			// SQL (작성자)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT M.MEMBER_NICK, M.MEMBER_ID, L.* FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.SEND_MEMBER_NO WHERE L.STATUS = 'O' AND L.RECEIVE_MEMBER_NO IN (SELECT MEMBER_NO FROM MEMBER WHERE M.MEMBER_NICK LIKE '%'||?||'%' AND L.STATUS = 'O') ORDER BY ENROLL_DATE ) T ) WHERE RECEIVE_MEMBER_NO = ? AND RNUM BETWEEN ? AND ?";
		} else if (searchType.equals("title")) {
			// SQL (내용)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT M.MEMBER_NICK, M.MEMBER_ID, L.* FROM MEMBER M JOIN LETTER L ON (M.MEMBER_NO = L.SEND_MEMBER_NO) WHERE L.STATUS = 'O' AND L.LETTER_TITLE LIKE '%'||?||'%' ORDER BY L.ENROLL_DATE DESC ) T ) WHERE RECEIVE_MEMBER_NO = ? AND RNUM BETWEEN ? AND ?";
		} else {
			//
			return getLetterList(conn, pv, MemberNo);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setString(2, MemberNo);
		pstmt.setInt(3, pv.getBeginRow());
		pstmt.setInt(4, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {

			String no = rs.getString("LETTER_NO");
			String sendMemberNo = rs.getString("SEND_MEMBER_NO");
			String sendMemberName = rs.getString("MEMBER_NICK");
			String sendMemberId = rs.getString("MEMBER_ID");
			String letterTitle = rs.getString("LETTER_TITLE");
			String letterContent = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");

			LetterVo vo = new LetterVo();
			vo.setSendMemberName(sendMemberName);
			vo.setSendMemberNo(sendMemberNo);
			vo.setSendMemberId(sendMemberId);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			vo.setLetterNo(no);
			vo.setLetterContent(letterContent);
			vo.setStatus(status);

			voList.add(vo);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;

	}

	public int getLetterListCnt(Connection conn, String searchType, String searchValue, String MemberNo)
			throws Exception {
		String sql = "SELECT COUNT(*) FROM ( SELECT L.LETTER_NO, L.LETTER_TITLE, L.LETTER_CONTENT, L.SEND_MEMBER_NO, L.ENROLL_DATE, L.STATUS, M.MEMBER_NICK FROM LETTER L JOIN MEMBER M ON (L.RECEIVE_MEMBER_NO = M.MEMBER_NO) WHERE L.STATUS = 'O' AND L.RECEIVE_MEMBER_NO = ? ";

		if ("title".equals(searchType)) {
			sql += "AND L.LETTER_TITLE LIKE '%" + searchValue + "%'";
		} else if ("writer".equals(searchType)) {
			sql += "AND M.MEMBER_NICK LIKE '%" + searchValue + "%'";
		}

		sql += ")";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberNo);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public int deleteReceiveLetter(Connection conn, int number) throws Exception {

		String sql = "UPDATE LETTER SET STATUS = 'X' WHERE LETTER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, number);

		int result = pstmt.executeUpdate();

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(pstmt);

		return result;
	}

	public int deleteSentLetter(Connection conn, int number) throws Exception {

		String sql = "UPDATE LETTER SET STATUS = 'X' WHERE LETTER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, number);

		int result = pstmt.executeUpdate();

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(pstmt);

		return result;
	}

	/* 여기서부터는 보낸 편지 */

	public int getLetterSendListCnt(Connection conn, String searchType, String searchValue, String MemberNo)
			throws Exception {

		String sql = "SELECT COUNT(*) FROM ( SELECT L.LETTER_NO, L.LETTER_TITLE, L.LETTER_CONTENT, L.RECEIVE_MEMBER_NO, L.ENROLL_DATE, L.STATUS, M.MEMBER_NICK FROM LETTER L JOIN MEMBER M ON (L.RECEIVE_MEMBER_NO = M.MEMBER_NO) WHERE L.STATUS = 'O' AND L.SEND_MEMBER_NO = ? ";

		if ("title".equals(searchType)) {
			sql += "AND L.LETTER_TITLE LIKE '%" + searchValue + "%' ";
		} else if ("writer".equals(searchType)) {
			sql += "AND M.MEMBER_NICK LIKE '%" + searchValue + "%' ";
		}

		sql += ") x";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberNo);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public List<LetterVo> getLetterSendList(Connection conn, PageVo pv, String MemberNo) throws SQLException {

		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT L.LETTER_NO, L.LETTER_TITLE, L.LETTER_CONTENT, L.SEND_MEMBER_NO, L.RECEIVE_MEMBER_NO, L.ENROLL_DATE, L.STATUS, M1.MEMBER_NICK AS SEND_MEMBER_NAME, M2.MEMBER_NICK AS RECEIVE_MEMBER_NAME, M2.MEMBER_ID AS RECEIVE_MEMBER_ID FROM LETTER L JOIN MEMBER M1 ON (L.SEND_MEMBER_NO = M1.MEMBER_NO) JOIN MEMBER M2 ON (L.RECEIVE_MEMBER_NO = M2.MEMBER_NO) WHERE L.STATUS = 'O' AND L.SEND_MEMBER_NO = ? ORDER BY L.ENROLL_DATE DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, MemberNo);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {

			String no = rs.getString("LETTER_NO");
			String sendMemberNo = rs.getString("SEND_MEMBER_NO");
			String sendMemberName = rs.getString("SEND_MEMBER_NAME");
			String receiveNo = rs.getString("RECEIVE_MEMBER_NO");
			String receiveName = rs.getString("RECEIVE_MEMBER_NAME");
			String receiveId = rs.getString("RECEIVE_MEMBER_ID");
			String letterTitle = rs.getString("LETTER_TITLE");
			String letterContent = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");

			LetterVo vo = new LetterVo();
			vo.setSendMemberName(sendMemberName);
			vo.setSendMemberNo(sendMemberNo);
			vo.setReceiveMemberNo(receiveNo);
			vo.setReceiveMemberName(receiveName);
			vo.setReceiveMemberId(receiveId);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			vo.setLetterNo(no);
			vo.setLetterContent(letterContent);
			vo.setStatus(status);

			voList.add(vo);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;
	}

	public List<LetterVo> getLetterSendList(Connection conn, PageVo pv, String searchType, String searchValue,
			String MemberNo) throws SQLException {

		String sql = "";

		if (searchType.equals("writer")) {
			// SQL (작성자 검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT M.MEMBER_NICK RECEIVE_MEMBER_NAME, M.MEMBER_ID RECEIVE_MEMBER_ID, L.* FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.RECEIVE_MEMBER_NO WHERE L.STATUS = 'O' AND L.LETTER_TITLE IN (SELECT LETTER_TITLE FROM LETTER WHERE MEMBER_NICK LIKE ? ) ORDER BY ENROLL_DATE DESC) T ) WHERE SEND_MEMBER_NO = ? AND RNUM BETWEEN ? AND ?";
		} else if (searchType.equals("title")) {
			// SQL (내용 검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT M.MEMBER_NICK RECEIVE_MEMBER_NAME, M.MEMBER_ID RECEIVE_MEMBER_ID, L.* FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.RECEIVE_MEMBER_NO WHERE L.STATUS = 'O' AND L.LETTER_TITLE IN (SELECT LETTER_TITLE FROM LETTER WHERE LETTER_TITLE LIKE ? ) ORDER BY ENROLL_DATE DESC) T ) WHERE SEND_MEMBER_NO = ? AND RNUM BETWEEN ? AND ?";
		} else {
			// 값이 입력되지 않은 경우 => 기본 게시판 일반 목록 조회
			return getLetterSendList(conn, pv, MemberNo);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + searchValue + "%");
		pstmt.setString(2, MemberNo);
		pstmt.setInt(3, pv.getBeginRow());
		pstmt.setInt(4, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {
			String receiveMemberName = rs.getString("RECEIVE_MEMBER_NAME");
			String receiveMemberId = rs.getString("RECEIVE_MEMBER_ID");
			String letterTitle = rs.getString("LETTER_TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");

			LetterVo vo = new LetterVo();
			vo.setReceiveMemberName(receiveMemberName);
			vo.setReceiveMemberId(receiveMemberId);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);

			voList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;
	}

	public List<LetterVo> getLetterTrashList(String searchSR, Connection conn, PageVo pv, String searchType,
			String searchValue, String memberNo) throws SQLException {
		String sql = "";

		if (searchSR.equals("receiveLetter")) {
			sql = "SELECT * FROM LETTER WHERE ";
			if (searchType.equals("writer")) {
				// SQL (�옉�꽦�옄 寃��깋)
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER M JOIN LETTER L ON (M.MEMBER_NO = L.SEND_MEMBER_NO) WHERE L.STATUS = 'O' AND M.MEMBER_NICK LIKE '%'||?||'%' ORDER BY L.ENROLL_DATE DESC ) T ) WHERE SEND_MEMBER_NO = ? RNUM BETWEEN ? AND ?";
			} else if (searchType.equals("title")) {
				// SQL (�궡�슜 寃��깋)
				sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER M JOIN LETTER L ON (M.MEMBER_NO = L.SEND_MEMBER_NO) WHERE L.STATUS = 'O' AND L.LETTER_TITLE LIKE '%'||?||'%' ORDER BY L.ENROLL_DATE DESC ) T ) WHERE SEND_MEMBER_NO = ? RNUM BETWEEN ? AND ?";
			} else {
				// 媛믪씠 �씠�긽�븿 => 湲곕낯 紐⑸줉 議고쉶
//				return getLetterTrashList(conn, pv, memberNo);
			}
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, searchValue);
		pstmt.setInt(3, pv.getBeginRow());
		pstmt.setInt(4, pv.getLastRow());
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

	public int deleteTrashLetter(Connection conn, int number) throws Exception {

		String sql = "UPDATE LETTER SET STATUS = 'XX' WHERE LETTER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, number);
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}

	public LetterVo selectSendOneByNo(String bno, Connection conn) throws Exception {

		String sql = "SELECT LETTER_TITLE, LETTER_CONTENT, TO_CHAR(ENROLL_DATE,'YYYY-MM-DD HH24\"시\"') ENROLL_DATE, MEMBER_NICK FROM LETTER L JOIN MEMBER M ON MEMBER_NO = RECEIVE_MEMBER_NO WHERE LETTER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bno);
		ResultSet rs = pstmt.executeQuery();

		LetterVo vo = null;

		if (rs.next()) {
			String title = rs.getString("LETTER_TITLE");
			String content = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String receiver = rs.getString("MEMBER_NICK");

			vo = new LetterVo();
			vo.setLetterTitle(title);
			vo.setReceiveMemberName(receiver);
			vo.setLetterContent(content);
			vo.setEnrollDate(enrollDate);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}

	public LetterVo selectReceiveOneByNo(String bno, Connection conn) throws Exception {
		String sql = "SELECT LETTER_TITLE, LETTER_CONTENT, TO_CHAR(ENROLL_DATE,'YYYY-MM-DD HH24\"시\"') ENROLL_DATE, MEMBER_NICK FROM LETTER L JOIN MEMBER M ON MEMBER_NO = SEND_MEMBER_NO WHERE LETTER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bno);
		ResultSet rs = pstmt.executeQuery();

		LetterVo vo = null;

		if (rs.next()) {
			String title = rs.getString("LETTER_TITLE");
			String content = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String sender = rs.getString("MEMBER_NICK");

			vo = new LetterVo();
			vo.setLetterTitle(title);
			vo.setSendMemberName(sender);
			vo.setLetterContent(content);
			vo.setEnrollDate(enrollDate);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;

	}

	public int getLetterTrashListCnt(Connection conn, String searchType, String searchValue, String memberNo)
			throws Exception {
		String sql = "SELECT COUNT(*) FROM ( SELECT L.LETTER_NO, L.LETTER_TITLE, L.LETTER_CONTENT, L.SEND_MEMBER_NO, L.ENROLL_DATE, L.STATUS, M.MEMBER_NICK FROM LETTER L JOIN MEMBER M ON (L.RECEIVE_MEMBER_NO = M.MEMBER_NO) WHERE L.STATUS = 'X' AND (L.RECEIVE_MEMBER_NO = ? OR L.SEND_MEMBER_NO = ?) ";

		if ("sender".equals(searchType)) {
			sql += "AND M.MEMBER_NO = L.SEND_MEMBER_NO AND M.MEMBER_NICK LIKE '%" + searchValue + "%' )";
		} else if ("receiver".equals(searchType)) {
			sql += "AND M.MEMBER_NO = L.RECEIVE_MEMBER_NO AND M.MEMBER_NICK LIKE '%" + searchValue + "%' )";
		} else if ("title".equals(searchType)) {
			sql += "AND L.LETTER_TITLE LIKE '%" + searchValue + "%' )";
		} else {
			sql += " )"; 
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, memberNo);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public List<LetterVo> getLetterTrashList(Connection conn, PageVo pv, String memberNo) throws Exception {

		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT M2.MEMBER_ID AS RECEIVE_ID, M1.MEMBER_ID AS SEND_ID, L.LETTER_NO, L.LETTER_TITLE, L.LETTER_CONTENT, L.SEND_MEMBER_NO, L.RECEIVE_MEMBER_NO, L.ENROLL_DATE, L.STATUS, M1.MEMBER_NICK AS SEND_MEMBER_NAME, M2.MEMBER_NICK AS RECEIVE_MEMBER_NAME FROM LETTER L JOIN MEMBER M1 ON (L.SEND_MEMBER_NO = M1.MEMBER_NO) JOIN MEMBER M2 ON (L.RECEIVE_MEMBER_NO = M2.MEMBER_NO) WHERE L.STATUS = 'X' AND (L.SEND_MEMBER_NO = ? OR L.RECEIVE_MEMBER_NO = ?) ORDER BY L.ENROLL_DATE DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(memberNo));
		pstmt.setInt(2, Integer.parseInt(memberNo));
		pstmt.setInt(3, pv.getBeginRow());
		pstmt.setInt(4, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {

			String no = rs.getString("LETTER_NO");
			String sendMemberNo = rs.getString("SEND_MEMBER_NO");
			String sendMemberName = rs.getString("SEND_MEMBER_NAME");
			String sendMemberId = rs.getString("SEND_ID");
			String receiveNo = rs.getString("RECEIVE_MEMBER_NO");
			String receiveName = rs.getString("RECEIVE_MEMBER_NAME");
			String receiveMemberId = rs.getString("RECEIVE_ID");
			String letterTitle = rs.getString("LETTER_TITLE");
			String letterContent = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");

			LetterVo vo = new LetterVo();
			vo.setSendMemberName(sendMemberName);
			vo.setSendMemberNo(sendMemberNo);
			vo.setSendMemberId(sendMemberId);
			vo.setReceiveMemberNo(receiveNo);
			vo.setReceiveMemberName(receiveName);
			vo.setReceiveMemberId(receiveMemberId);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			vo.setLetterNo(no);
			vo.setLetterContent(letterContent);
			vo.setStatus(status);

			voList.add(vo);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;

	}

	public List<LetterVo> getLetterTrashList(Connection conn, PageVo pv, String searchType, String searchValue,
			String memberNo) throws Exception {

		String sql = "";

		if (searchType.equals("sender")) {
			// SQL (작성자)
			sql = "SELECT T.*, SENDER.MEMBER_ID AS SENDER_ID, SENDER.MEMBER_NICK AS SENDER_NICK, RECEIVER.MEMBER_ID AS RECEIVER_ID, RECEIVER.MEMBER_NICK AS RECEIVER_NICK FROM ( SELECT ROWNUM RNUM, L.* FROM ( SELECT L.* FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.SEND_MEMBER_NO WHERE L.STATUS = 'X' AND M.MEMBER_NICK LIKE '%'||?||'%' AND L.RECEIVE_MEMBER_NO IN ( SELECT MEMBER_NO FROM MEMBER WHERE L.STATUS = 'X' ) ORDER BY ENROLL_DATE DESC ) L ) T JOIN MEMBER SENDER ON T.SEND_MEMBER_NO = SENDER.MEMBER_NO JOIN MEMBER RECEIVER ON T.RECEIVE_MEMBER_NO = RECEIVER.MEMBER_NO WHERE (RECEIVE_MEMBER_NO = ? OR SEND_MEMBER_NO = ?) AND RNUM BETWEEN ? AND ?";
		} else if (searchType.equals("receiver")) {
			sql = "SELECT T.*, SENDER.MEMBER_ID AS SENDER_ID, SENDER.MEMBER_NICK AS SENDER_NICK, RECEIVER.MEMBER_ID AS RECEIVER_ID, RECEIVER.MEMBER_NICK AS RECEIVER_NICK FROM ( SELECT ROWNUM RNUM, L.* FROM ( SELECT L.* FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.RECEIVE_MEMBER_NO WHERE L.STATUS = 'X' AND M.MEMBER_NICK LIKE '%'||?||'%' AND L.RECEIVE_MEMBER_NO IN ( SELECT MEMBER_NO FROM MEMBER WHERE L.STATUS = 'X' ) ORDER BY ENROLL_DATE DESC ) L ) T JOIN MEMBER SENDER ON T.SEND_MEMBER_NO = SENDER.MEMBER_NO JOIN MEMBER RECEIVER ON T.RECEIVE_MEMBER_NO = RECEIVER.MEMBER_NO WHERE (RECEIVE_MEMBER_NO = ? OR SEND_MEMBER_NO = ?) AND RNUM BETWEEN ? AND ?";
		} else if (searchType.equals("title")) {
			// SQL (내용)
			sql = "SELECT T.*, SENDER.MEMBER_ID AS SENDER_ID, SENDER.MEMBER_NICK AS SENDER_NICK, RECEIVER.MEMBER_ID AS RECEIVER_ID, RECEIVER.MEMBER_NICK AS RECEIVER_NICK FROM ( SELECT ROWNUM RNUM, L.* FROM ( SELECT L.* FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.SEND_MEMBER_NO WHERE L.STATUS = 'X' AND L.RECEIVE_MEMBER_NO IN ( SELECT MEMBER_NO FROM MEMBER WHERE L.LETTER_TITLE LIKE '%'||?||'%' AND L.STATUS = 'X' ) ORDER BY ENROLL_DATE DESC ) L ) T JOIN MEMBER SENDER ON T.SEND_MEMBER_NO = SENDER.MEMBER_NO JOIN MEMBER RECEIVER ON T.RECEIVE_MEMBER_NO = RECEIVER.MEMBER_NO WHERE (RECEIVE_MEMBER_NO = ? OR SEND_MEMBER_NO = ?) AND RNUM BETWEEN ? AND ?";
		} else {
			//
			return getLetterTrashList(conn, pv, memberNo);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setString(2, memberNo);
		pstmt.setString(3, memberNo);
		pstmt.setInt(4, pv.getBeginRow());
		pstmt.setInt(5, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LetterVo> voList = new ArrayList<>();
		while (rs.next()) {

			String no = rs.getString("LETTER_NO");
			String sendMemberName = rs.getString("SENDER_NICK");
			String sendMemberId = rs.getString("SENDER_ID");
			String receivememberName = rs.getString("RECEIVER_NICK");
			String receiveMemberId = rs.getString("RECEIVER_ID");
			String letterTitle = rs.getString("LETTER_TITLE");
			String letterContent = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String status = rs.getString("STATUS");

			LetterVo vo = new LetterVo();
			vo.setSendMemberName(sendMemberName);
			vo.setLetterTitle(letterTitle);
			vo.setEnrollDate(enrollDate);
			vo.setLetterNo(no);
			vo.setLetterContent(letterContent);
			vo.setStatus(status);
			vo.setSendMemberId(sendMemberId);
			vo.setReceiveMemberId(receiveMemberId);
			vo.setReceiveMemberName(receivememberName);

			voList.add(vo);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return voList;

	}

	public List<MemberVo> getMemberList(Connection conn) throws Exception {

		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , T.* FROM ( SELECT M.*, S.MILEAGE FROM MEMBER M LEFT OUTER JOIN STUDENT S ON (M.MEMBER_NO = S.STUDENT_MEMBER_NO) ORDER BY MEMBER_NO DESC ) T )";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		List<MemberVo> memberList = new ArrayList<>();

		while (rs.next()) {
			String memberNo = rs.getString("MEMBER_NO");
			String memberId = rs.getString("MEMBER_ID");
			String memberPwd = rs.getString("MEMBER_PWD");
			String memberNick = rs.getString("MEMBER_NICK");
			String birthNum = rs.getString("BIRTH_NUM");
			String status = rs.getString("STATUS");
			String phoneNo = rs.getString("PHONE_NO");
			String signDate = rs.getString("SIGN_DATE");
			String profile = rs.getString("PROFILE");
			String identity = rs.getString("IDENTITY");
			String leftVacation = rs.getString("LEFT_VACATION");
			String mileage = rs.getString("MILEAGE");

			MemberVo vo = new MemberVo();
			vo.setMemberNo(memberNo);
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberNick(memberNick);
			vo.setBirthNum(birthNum);
			vo.setStatus(status);
			vo.setPhoneNo(phoneNo);
			vo.setSignDate(signDate);
			vo.setProfile(profile);
			vo.setIdentity(identity);
			vo.setLeftVacation(leftVacation);
			vo.setMileage(mileage);

			memberList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return memberList;

	}

	public LetterVo selectTrashOneByNo(String bno, Connection conn) throws Exception {
		String sql = "SELECT LETTER_TITLE, LETTER_CONTENT, TO_CHAR(ENROLL_DATE,'YYYY-MM-DD HH24\"시\"') ENROLL_DATE, (SELECT MEMBER_NICK FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.SEND_MEMBER_NO WHERE LETTER_NO = ?) AS SENDER, (SELECT MEMBER_ID FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.SEND_MEMBER_NO WHERE LETTER_NO = ?) AS SENDER_ID,  (SELECT MEMBER_NICK FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.RECEIVE_MEMBER_NO WHERE LETTER_NO = ?) AS RECEIVER,   (SELECT MEMBER_ID FROM MEMBER M JOIN LETTER L ON M.MEMBER_NO = L.RECEIVE_MEMBER_NO WHERE LETTER_NO = ?) AS RECEIVER_ID FROM LETTER L JOIN MEMBER M ON MEMBER_NO = SEND_MEMBER_NO WHERE LETTER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bno);
		pstmt.setString(2, bno);
		pstmt.setString(3, bno);
		pstmt.setString(4, bno);
		pstmt.setString(5, bno);
		ResultSet rs = pstmt.executeQuery();

		LetterVo vo = null;

		if (rs.next()) {
			String title = rs.getString("LETTER_TITLE");
			String content = rs.getString("LETTER_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String sender = rs.getString("SENDER");
			String senderId = rs.getString("SENDER_ID");
			String receiver = rs.getString("RECEIVER");
			String receiverId = rs.getString("RECEIVER_ID");

			vo = new LetterVo();
			vo.setLetterTitle(title);
			vo.setSendMemberName(sender);
			vo.setSendMemberId(senderId);
			vo.setLetterContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setReceiveMemberName(receiver);
			vo.setReceiveMemberId(receiverId);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}

}
