package com.semi.mypage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.attendance.vo.AttendanceVo;
import com.semi.board.vo.BoardVo;
import com.semi.calender.vo.CalenderVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureVo;
import com.semi.letter.vo.LetterVo;
import com.semi.mypage.dao.MypageDao;
import com.semi.mypage.vo.TeamVo;
import com.semi.notice.vo.NoticeVo;
import com.semi.teamCalendar.vo.TeamCalendarVo;
import com.semi.vacation.vo.VacationVo;

public class MypageService {

	public List<LectureVo> viewStudent(String lectureNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<LectureVo> volist = mdao.viewStudent(conn, lectureNo);
		
		JDBCTemplate.close(conn);
		
		return volist;
		
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

	public List<TeamVo> teamList(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<TeamVo> teamList = mdao.teamList(conn, memberNo);
		
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

	public int checkIn(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		int result = mdao.checkIn(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return result;
	
	}

	public int checkout(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		int result = mdao.checkOut(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public List<NoticeVo> showNotice() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<NoticeVo> notList = mdao.showNotice(conn);
		
		JDBCTemplate.close(conn);
		
		return notList;
	}

	public List<BoardVo> getBoardTClassList(String lno) throws Exception {
	
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();	
		List<BoardVo> tcvoList = mdao.getBoardTClassList(conn, lno);
		
		JDBCTemplate.close(conn);
		
		return tcvoList;
		
	}

	public List<TeamCalendarVo> todoList(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<TeamCalendarVo> todoList = mdao.todoList(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return todoList;
		
	}

	public List<CalenderVo> ttodoList(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<CalenderVo> ttodoList = mdao.ttodoList(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return ttodoList;
	
	}

	public List<LectureVo> showLecture() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<LectureVo> lvoList = mdao.showLecture(conn);
		
		JDBCTemplate.close(conn);
		
		return lvoList;
		
	}

	public List<LectureVo> showSecuLecture() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		List<LectureVo> secuList = mdao.showSecuLecture(conn);
		
		JDBCTemplate.close(conn);
		
		return secuList;
		
	}

	public List<VacationVo> watchingStudent(String lectureNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();	
		List<VacationVo> vaList = mdao.watchingStudent(conn, lectureNo);
		
		JDBCTemplate.close(conn);
		
		return vaList;
		
	}

	public String leftVacation(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		String leftVacation = mdao.leftVacation(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return leftVacation;
		
	}

	public int inTimes(String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		int inTimes = mdao.inTimes(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return inTimes;
	
	}

	public int notCome(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		int result = mdao.notCome(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public int late(String memberNo) throws Exception {
		
Connection conn = JDBCTemplate.getConnection();
		
		MypageDao mdao = new MypageDao();
		int result = mdao.late(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
