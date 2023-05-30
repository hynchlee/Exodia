package com.semi.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.notice.vo.NoticeVo;

public class NoticeDao {

	//목록 페이징
	public int getNoticeListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		
		//쿼리작성
		String sql = "SELECT COUNT(*) FROM NOTICE WHERE STATUS='O'";
		if ("noticeTitle".equals(searchType)) {
			sql += "AND NOTICE_TITLE LIKE '%" + searchValue + "%'";
		}else if ("noticeContent".equals(searchType)) {
			sql += "AND NOTICE_CONTENT LIKE '%" + searchValue + "%'";
		}
		//쿼리 저장 - pstmt에 위의 쿼리 저장 후 DB에 연결 준비
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		//결과값 불러오기
		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	//목록 조회
	public List<NoticeVo> getNoticeList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NOTICE_NO, N.ADMIN_NO, N.NOTICE_TITLE, N.NOTICE_CONTENT, TO_CHAR(N.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(N.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE, N.HIT, N.STATUS, N.PIN, A.ADMIN_NICK FROM NOTICE N JOIN ADMIN A ON (N.ADMIN_NO = A.ADMIN_NO) WHERE N.STATUS = 'O' ORDER BY PIN DESC, NOTICE_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<NoticeVo> nvoList = new ArrayList<>();
		while (rs.next()) {
			String noticeNo = rs.getString("NOTICE_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String noticeTitle = rs.getString("NOTICE_TITLE");
			String noticeContent = rs.getString("NOTICE_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String status = rs.getString("STATUS");
			String adminNick = rs.getString("ADMIN_NICK");
			String pin = rs.getString("PIN");
			
			NoticeVo vo = new NoticeVo();
			vo.setNoticeNo(noticeNo);
			vo.setAdminNo(adminNo);
			vo.setNoticeTitle(noticeTitle);
			vo.setNoticeContent(noticeContent);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setStatus(status);
			vo.setAdminNick(adminNick);
			vo.setPin(pin);
			
			nvoList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return nvoList;
		
	}
	
	//검색해서 목록 조회
	public List<NoticeVo> getNoticeList(Connection conn, PageVo pv, String SearchType, String searchValue) throws Exception {
		
		String sql ="";
		
		if (SearchType.equals("noticeTitle")) {
			//제목 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NOTICE_NO ,N.ADMIN_NO ,N.NOTICE_TITLE ,N.NOTICE_CONTENT ,TO_CHAR(N.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(N.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE ,N.HIT ,N.STATUS ,A.ADMIN_NICK FROM NOTICE N JOIN ADMIN A ON(N.ADMIN_NO = A.ADMIN_NO) WHERE N.STATUS='O' AND N.NOTICE_TITLE LIKE ('%' || ? || '%') ORDER BY NOTICE_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if (SearchType.equals("noticeContent")) {
			//내용 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NOTICE_NO ,N.ADMIN_NO ,N.NOTICE_TITLE ,N.NOTICE_CONTENT ,TO_CHAR(N.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(N.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE ,N.HIT ,N.STATUS ,A.ADMIN_NICK FROM NOTICE N JOIN ADMIN A ON(N.ADMIN_NO = A.ADMIN_NO) WHERE N.STATUS='O' AND N.NOTICE_CONTENT LIKE ('%' || ? || '%') ORDER BY NOTICE_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else {
			return getNoticeList(conn, pv);
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<NoticeVo> nvoList = new ArrayList<>();
		while (rs.next()) {
			String noticeNo = rs.getString("NOTICE_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String noticeTitle = rs.getString("NOTICE_TITLE");
			String noticeContent = rs.getString("NOTICE_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String status = rs.getString("STATUS");
			String adminNick = rs.getString("ADMIN_NICK");
			
			NoticeVo vo = new NoticeVo();
			vo.setNoticeNo(noticeNo);
			vo.setAdminNo(adminNo);
			vo.setNoticeTitle(noticeTitle);
			vo.setNoticeContent(noticeContent);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setStatus(status);
			vo.setAdminNick(adminNick);
			
			nvoList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return nvoList;
		
	}

	public NoticeVo getNoticeByNo(Connection conn, String nno) throws Exception {
		
		String sql = "SELECT N.NOTICE_NO ,N.ADMIN_NO ,N.NOTICE_TITLE ,N.NOTICE_CONTENT ,TO_CHAR(N.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(N.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE ,N.HIT ,N.STATUS ,A.ADMIN_NICK FROM NOTICE N JOIN ADMIN A ON(N.ADMIN_NO = A.ADMIN_NO) WHERE N.STATUS='O' AND N.NOTICE_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nno);
		ResultSet rs = pstmt.executeQuery();
		
		NoticeVo nvNo = null;
		if (rs.next()) {
			String noticeNo = rs.getString("NOTICE_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String noticeTitle = rs.getString("NOTICE_TITLE");
			String noticeContent = rs.getString("NOTICE_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String status = rs.getString("STATUS");
			String adminNick = rs.getString("ADMIN_NICK");
			
			nvNo = new NoticeVo();
			nvNo.setNoticeNo(noticeNo);
			nvNo.setAdminNo(adminNo);
			nvNo.setNoticeTitle(noticeTitle);
			nvNo.setNoticeContent(noticeContent);
			nvNo.setEnrollDate(enrollDate);
			nvNo.setModifyDate(modifyDate);
			nvNo.setHit(hit);
			nvNo.setStatus(status);
			nvNo.setAdminNick(adminNick);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return nvNo;
	}

	//조회수
	public int increaseHit(Connection conn, String nno) throws Exception {
		
		String sql = "UPDATE NOTICE SET HIT = HIT+1 WHERE NOTICE_NO=? AND STATUS='O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nno);
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//글 작성하기
	public int noticeWrite(Connection conn, NoticeVo nvo) throws Exception {
		
		String sql = "INSERT INTO NOTICE(NOTICE_NO,ADMIN_NO,NOTICE_TITLE,NOTICE_CONTENT, PIN) VALUES(SEQ_NOTICE_NO.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nvo.getAdminNo());
		pstmt.setString(2, nvo.getNoticeTitle());
		pstmt.setString(3, nvo.getNoticeContent());
		pstmt.setString(4, nvo.getPin());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}


	public int noticeDelete(Connection conn, String nno) throws Exception {
		
		String sql = "UPDATE NOTICE SET STATUS='X' WHERE NOTICE_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nno);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public int editNotice(Connection conn, NoticeVo nvo) throws Exception {
		
		String sql = "UPDATE NOTICE SET NOTICE_TITLE=?, NOTICE_CONTENT=?, MODIFY_DATE=SYSDATE WHERE NOTICE_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nvo.getNoticeTitle());
		pstmt.setString(2, nvo.getNoticeContent());
		pstmt.setString(3, nvo.getNoticeNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public int adminBoardDelete(Connection conn, String[] bnoArr) throws Exception {
		
		if (bnoArr == null || bnoArr.length == 0) {
	        throw new IllegalArgumentException("bnoArr is empty");
	    }
	    
	    String str = String.join(",", bnoArr);
	    
	    String sql = "UPDATE NOTICE SET STATUS = 'X' WHERE NOTICE_NO IN(" + str + ")";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    int result = pstmt.executeUpdate();
	    
	    JDBCTemplate.close(pstmt);
	    
	    return result;
		
	}
	
	

}
