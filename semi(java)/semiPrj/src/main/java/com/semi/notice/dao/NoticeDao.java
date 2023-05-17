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

	public int selectCnt(Connection conn) throws Exception {
		
		//쿼리작성
		String sql = "SELECT COUNT(*) FROM NOTICE WHERE STATUS='O'";
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

	public List<NoticeVo> selectNoticeList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT RNUM, T.BOARD_NO, T.BOARD_CATEGORY_NO, T.MEMBER_NO, T.BOARD_TITLE, T.BOARD_CONTENT, TO_CHAR(T.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, T.MODIFY_DATE, T.STATUS, T.HIT, T.MEMBER_NICK FROM ( SELECT ROWNUM RNUM, B.*, M.MEMBER_NICK FROM BOARD B INNER JOIN MEMBER M ON B.MEMBER_NO = M.MEMBER_NO WHERE B.STATUS = 'O' ORDER BY B.BOARD_NO DESC ) T WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<NoticeVo> list = new ArrayList<>();
		while(rs.next()) {
			
			//데이터 꺼내기
			String noticeNo = rs.getString("NOTICE_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String noticeTitle = rs.getString("NOTICE_TITLE");
			String noticeContent = rs.getString("NOTICE_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String status = rs.getString("STATUS");
			String memberNick = rs.getString("MEMBER_NICK");
			
			// 데이터 뭉치기
			NoticeVo vo = new NoticeVo();
			vo.setNoticeNo(noticeNo);
			vo.setAdminNo(adminNo);
			vo.setNoticeTitle(noticeTitle);
			vo.setNoticeContent(noticeContent);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setStatus(status);
			vo.setMemberNick(memberNick);
			
			list.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

}
