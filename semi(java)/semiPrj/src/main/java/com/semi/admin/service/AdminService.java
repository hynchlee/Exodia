package com.semi.admin.service;

import java.sql.Connection;
import java.util.List;

import com.semi.admin.dao.AdminDao;
import com.semi.admin.vo.AdminVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.member.vo.MemberVo;

public class AdminService {
	
	//dao 객체 생성
	private final AdminDao dao;
	public AdminService() {
		dao = new AdminDao();
	}

	//관리자 로그인
	public AdminVo adminLogin(AdminVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		AdminVo loginAdmin = dao.adminLogin(conn, vo);
		//close
		JDBCTemplate.close(conn);
		
		return loginAdmin;
	}

	//회원 목록 조회
	public List<MemberVo> getMemberList(PageVo pv) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		List<MemberVo> memberList = dao.getMemberList(conn, pv);
		//close
		JDBCTemplate.close(conn);
		
		return memberList;
	}

	//회원 제재
	public int stopMember(String[] noArr) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.stopMember(conn, noArr);
		
		//tx||rs
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//회원 탈퇴처리
	public int quitMember(String[] noArr) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.quitMember(conn, noArr);
		
		//tx||rs
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
