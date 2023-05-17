package com.semi.letter.service;

import java.sql.Connection;

import com.semi.common.db.JDBCTemplate;
import com.semi.letter.dao.MemberDao;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

public class LetterService {

	public int writeLetter(LetterVo vo, MemberVo loginMember) throws Exception {
		Connection conn = JDBCTemplate.getConnection();

		MemberDao dao = new MemberDao();
		int result = dao.writeLetter(vo, conn, loginMember);

		JDBCTemplate.close(conn);

		return result;
	}

}
