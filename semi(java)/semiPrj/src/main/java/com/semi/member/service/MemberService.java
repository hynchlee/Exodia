package com.semi.member.service;

import java.sql.Connection;

import com.semi.common.db.JDBCTemplate;
import com.semi.member.dao.MemberDao;
import com.semi.member.vo.MemberVo;

public class MemberService {
	
	private final MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	//로그인
	public MemberVo login(MemberVo vo) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		MemberVo loginMember = dao.login(conn, vo);
		
		//close
		JDBCTemplate.close(conn);
		
		return loginMember;
	
	}

	//아이디 찾기
	public MemberVo findId(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		MemberVo idFind = dao.findId(conn, vo);
		
		//close
		JDBCTemplate.close(conn);

		return idFind;
	
	}

}
