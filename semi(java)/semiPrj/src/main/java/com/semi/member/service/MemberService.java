package com.semi.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureCategoryVo;
import com.semi.member.dao.MemberDao;
import com.semi.member.vo.MemberVo;
import com.semi.vacation.vo.VacationVo;

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
	
	//아이디 중복검사
	public int checkId(String memberId) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.checkId(conn, memberId);
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
	
	//로그인 시 강의명 담기
	public List<LectureCategoryVo> getLecture(String memberNo, String identity) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		List<LectureCategoryVo> memberLecture = (List<LectureCategoryVo>) dao.getLecture(conn, memberNo, identity);
		//close
		JDBCTemplate.close(conn);
		
		return memberLecture;
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
	
	//비번갱신
	public int renewPwd(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.renewPwd(conn, vo);
		
		//tx||rs
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//정보수정
	public MemberVo edit(MemberVo editVo, MemberVo loginMember) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//SQL
		int result = dao.edit(conn, editVo);

		MemberVo updatedMember = loginMember;
		//tx || rs
		if(result == 1) {
			updatedMember = dao.selectOneByNo(conn, loginMember);
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
	
	//탈퇴
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

	//휴가신청
	public int requestVacation(VacationVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int result = dao.requestVacation(conn, vo);
		
		//tx || rs
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//회원 수 세기
	public int countMember() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		int listCount = dao.countMember(conn);
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}

}
