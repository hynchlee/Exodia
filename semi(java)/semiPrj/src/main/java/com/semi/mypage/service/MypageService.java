package com.semi.mypage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.attendance.vo.AttendanceVo;
import com.semi.board.vo.BoardVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureVo;
import com.semi.letter.vo.LetterVo;
import com.semi.mypage.dao.MypageDao;
import com.semi.mypage.vo.TeamVo;
import com.semi.notice.vo.NoticeVo;
import com.semi.vacation.vo.VacationVo;

public class MypageService {

	public List<LectureVo> viewStudent(String lectureNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<LectureVo> volist = mdao.viewStudent(conn, lectureNo);
		
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

	public List<NoticeVo> showNotice02() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<NoticeVo> snotList = mdao.showNotice02(conn);
		
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

	public String lecturestart(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String lectureStart = mdao.lectureStart(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return lectureStart;
	
	}

	public String lectureEnd(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String lectureEnd = mdao.lectureEnd(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return lectureEnd;
		
	}

	public String checkDate(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String checkDate = mdao.checkDate(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return checkDate;
	}

	public String runDate(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String runDate = mdao.runDate(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return runDate;
	
	}

	public String lateDate(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String lateDate = mdao.lateDate(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return lateDate;
	
	}

	public String earlyDate(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String earlyDate = mdao.earlyDate(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return earlyDate;
	
		
	}

	public String getoutDate(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String getoutDate = mdao.getoutDate(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return getoutDate;
	
	}

	public List<AttendanceVo> AttendanceList(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<AttendanceVo> avoList = mdao.AttendanceList(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return avoList;
	
	}

}
