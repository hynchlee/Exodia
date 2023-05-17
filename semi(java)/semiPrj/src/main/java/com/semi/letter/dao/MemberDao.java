package com.semi.letter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
