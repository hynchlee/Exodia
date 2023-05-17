package com.semi.letter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.semi.common.db.JDBCTemplate;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

public class MemberDao {

	public int writeLetter(LetterVo vo, Connection conn, MemberVo loginMember) throws Exception {
		
		
		String sql = "INSERT INTO LETTER (LETTER_NO, SEND_MEMBER_NO, RECEIVE_MEMBER_NO, LETTER_TITLE, LETTER_CONTENT, STATUS) VALUES (SEQ_LETTER_NO.NEXTVAL,?, (SELECT MEMBER_NO FROM MEMBER WHERE ID = ?),?, ?, 'O');"; 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setString(2, vo.getReceiveMemberNo());
		pstmt.setString(3, vo.getLetterTitle());
		pstmt.setString(4, vo.getLetterContent());
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
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
		while(rs.next()) {
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
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
	}

}
























