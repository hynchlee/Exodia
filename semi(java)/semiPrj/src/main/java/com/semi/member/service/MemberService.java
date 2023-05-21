package com.semi.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.common.db.JDBCTemplate;
import com.semi.member.dao.MemberDao;
import com.semi.member.vo.MemberVo;

public class MemberService {
	
	//dao 객체 생성
	private final MemberDao dao;
	public MemberService() {
		dao = new MemberDao();
	}
	
	//회원가입
	public int join(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.join(conn, vo);
		
		//tx||rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
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
	
	//비번 찾기
	public MemberVo findPwd(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		MemberVo pwdFind = dao.findPwd(conn, vo);
		//close
		JDBCTemplate.close(conn);
		
		return pwdFind;
	}

	//정보수정
	public MemberVo edit(MemberVo vo) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo updatedMember = null;
		
		//SQL
		int result = dao.edit(conn, vo);
		
		//tx || rs
		if(result == 1) {
			updatedMember = dao.selectOneByNo(conn, vo.getMemberNo());
			if(updatedMember == null) {
				throw new Exception();
			}
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return updatedMember;
	
	}

	public int quit(String memberNo) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		int result = dao.quit(conn, memberNo);
		
		//tx||rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	

}
