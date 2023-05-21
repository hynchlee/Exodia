package com.semi.mypage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.vo.BoardVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureVo;
import com.semi.letter.vo.LetterVo;
import com.semi.mypage.dao.MypageDao;
import com.semi.mypage.vo.TeamVo;
import com.semi.vacation.vo.VacationVo;

public class MypageService {

	public List<LectureVo> viewStudent(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<LectureVo> volist = mdao.viewStudent(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return volist;
		
		
	}

	public List<BoardVo> showNotice() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<BoardVo> notList = mdao.showNotice(conn);
		
		JDBCTemplate.close(conn);
		
		return notList;
		
	}

	public List<BoardVo> freeboard() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<BoardVo> freeList = mdao.freeBoard(conn);
		
		JDBCTemplate.close(conn);
		
		return freeList;
	
	}

	public List<BoardVo> showNotice02() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<BoardVo> snotList = mdao.showNotice02(conn);
		
		JDBCTemplate.close(conn);
		
		return snotList;
	
	}

	public String countLetter01(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String letterCount01 = mdao.countLetter01(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return letterCount01;
		
	}

	public String countMyWrite(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String countMyWrite = mdao.countMyWrite(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return countMyWrite;
	}

	public List<LectureVo> teacherLecture(String memberNo) throws Exception {
	
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<LectureVo> tvolist = mdao.teacherLecture(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return tvolist;
	
	}

	public List<TeamVo> teamList() throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<TeamVo> teamList = mdao.teamList(conn);
		
		JDBCTemplate.close(conn);
		
		return teamList;
	
	}

	public List<VacationVo> restList(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<VacationVo> restList = mdao.restList(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return restList;
		
	}

}
