package com.semi.mypage.dao;

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
import com.semi.mypage.vo.TeamVo;
import com.semi.notice.vo.NoticeVo;
import com.semi.teamCalendar.vo.TeamCalendarVo;
import com.semi.vacation.vo.VacationVo;

public class MypageDao {

	public List<LectureVo> viewStudent(Connection conn, String lectureNo) throws Exception {

		String sql = "SELECT * FROM LECTURE L JOIN STUDENT S ON (L.LECTURE_NO = S.LECTURE_NO) JOIN MEMBER M ON(S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE_CATEGORY G ON (G.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE L.LECTURE_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lectureNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<LectureVo> volist = new ArrayList<>();
		while(rs.next()) {
			String memberNick = rs.getString("MEMBER_NICK");
			String lectureName = rs.getString("LECTURE_NAME");
			
			LectureVo vo = new LectureVo();
			vo.setTeacherMemberName(memberNick);
			vo.setLectureCategoryName(lectureName);
			
			volist.add(vo);
				
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return volist;
	}

	public List<NoticeVo> showNotice02(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NOTICE_NO ,N.ADMIN_NO ,N.NOTICE_TITLE ,N.NOTICE_CONTENT ,TO_CHAR(N.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(N.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE ,N.HIT ,N.STATUS ,A.ADMIN_NICK FROM NOTICE N JOIN ADMIN A ON(N.ADMIN_NO = A.ADMIN_NO) WHERE N.STATUS='O' ORDER BY NOTICE_NO DESC ) T ) WHERE RNUM BETWEEN 1 AND 3";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<NoticeVo> snotList = new ArrayList<>();
		while (rs.next()) {
			String noticeNo = rs.getString("NOTICE_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String noticeTitle = rs.getString("NOTICE_TITLE");
			String noticeContent = rs.getString("NOTICE_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String status = rs.getString("STATUS");
			String adminNick = rs.getString("ADMIN_NICK");
			
			NoticeVo vo = new NoticeVo();
			vo.setNoticeNo(noticeNo);
			vo.setAdminNo(adminNo);
			vo.setNoticeTitle(noticeTitle);
			vo.setNoticeContent(noticeContent);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setStatus(status);
			vo.setAdminNick(adminNick);
			
			snotList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return snotList;
		
	}

	public String countLetter01(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM LETTER WHERE RECEIVE_MEMBER_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String letterCount01 = null;
		while(rs.next()) {
			letterCount01 = rs.getString("Count(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return letterCount01;
	}

	public String countMyWrite(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM BOARD WHERE MEMBER_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String countMyWrite = null;
		while(rs.next()) {
			countMyWrite = rs.getString("Count(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return countMyWrite;
	}

	public List<LectureVo> teacherLecture(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT * FROM LECTURE L JOIN MEMBER M ON(L.TEACHER_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE_CATEGORY G ON (G.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE TEACHER_MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<LectureVo> tvolist = new ArrayList<>();
		while(rs.next()) {
			LectureVo vo = new LectureVo();
			vo.setLectureNo(rs.getString("LECTURE_NO"));
			vo.setTeacherMemberNo(rs.getString("TEACHER_MEMBER_NO"));
			vo.setLectureCategoryNo(rs.getString("LECTURE_CATEGORY_NO"));
			vo.setLectureStartTime(rs.getString("LECTURE_START_TIME"));
			vo.setLectureFinishTime(rs.getString("LECTURE_FINISH_TIME"));
			vo.setLectureOpenDate(rs.getString("LECTURE_OPEN_DATE"));
			vo.setLectureCloseDate(rs.getString("LECTURE_CLOSE_DATE"));
			vo.setStatus(rs.getString("STATUS"));
			vo.setTeacherMemberName(rs.getString("MEMBER_NICK"));
			vo.setLectureCategoryName(rs.getString("LECTURE_NAME"));
			
			tvolist.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return tvolist;
	
	}

	public List<TeamVo> teamList(Connection conn) throws Exception {

		String sql = "SELECT M.MEMBER_NICK, T.TEAM_NAME, TR.ROLE, TR.PROJECT_DIVISION, TR.STATUS FROM TEAM T JOIN STUDENT S ON(S.TEAM_NO = T.TEAM_NO) JOIN TEAM_ROLE TR ON (TR.STUDENT_MEMBER_NO = S.STUDENT_MEMBER_NO) JOIN MEMBER M ON (M.MEMBER_NO = S.STUDENT_MEMBER_NO) WHERE M.IDENTITY = 'S' AND TR.STATUS = 'O' ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<TeamVo> teamList = new ArrayList<>();
		while (rs.next()) {
			
			String memberNick = rs.getString("MEMBER_NICK");
			String teamName = rs.getString("TEAM_NAME");
			String role = rs.getString("ROLE");
			String projectDivision = rs.getString("PROJECT_DIVISION");
			
			TeamVo tv = new TeamVo();
			tv.setMemberNick(memberNick);
			tv.setTeamName(teamName);
			tv.setRole(role);
			tv.setProjectDivision(projectDivision);
			
			teamList.add(tv);
		
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return teamList;
	
	}

	public List<VacationVo> restList(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT VACATION_REQUEST_LIST_NO, TO_CHAR(TO_DATE(VACATION_START), 'YYYY-MM-DD') VACATION_START, TO_CHAR(TO_DATE(VACATION_END), 'YYYY-MM-DD') VACATION_END, STATUS, REASON FROM VACATION_REQUEST_LIST WHERE MEMBER_NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<VacationVo> restList = new ArrayList<>();
		while (rs.next()) {
			
			String vacationRequestListNo = rs.getString("VACATION_REQUEST_LIST_NO");
			String vacationStart = rs.getString("VACATION_START");
			String vacationEnd = rs.getString("VACATION_END");
			String status = rs.getString("STATUS");
			String reason = rs.getString("REASON");
			
			VacationVo vv = new VacationVo();
			vv.setVacationRequestListNo(vacationRequestListNo);
			vv.setVacationStart(vacationStart);
			vv.setVacationEnd(vacationEnd);
			vv.setStatus(status);
			vv.setReason(reason);
			
			restList.add(vv);
		
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return restList;
	
	}

	public String lectureStart(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT TO_CHAR(TO_DATE(L.LECTURE_OPEN_DATE), 'YYYY-MM-DD') STARTDATE, TO_CHAR(TO_DATE(L.LECTURE_CLOSE_DATE), 'YYYY-MM-DD') ENDDATE FROM MEMBER M JOIN STUDENT S ON (M.MEMBER_NO = S.STUDENT_MEMBER_NO) JOIN LECTURE L ON (L.LECTURE_NO = S.LECTURE_NO) WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String lectureStart = null;
		while(rs.next()) {
			lectureStart = rs.getString("STARTDATE");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return lectureStart;
	
	}

	public String lectureEnd(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT TO_CHAR(TO_DATE(L.LECTURE_OPEN_DATE), 'YYYY-MM-DD') STARTDATE, TO_CHAR(TO_DATE(L.LECTURE_CLOSE_DATE), 'YYYY-MM-DD') ENDDATE FROM MEMBER M JOIN STUDENT S ON (M.MEMBER_NO = S.STUDENT_MEMBER_NO) JOIN LECTURE L ON (L.LECTURE_NO = S.LECTURE_NO) WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String lectureEnd = null;
		while(rs.next()) {
			lectureEnd = rs.getString("ENDDATE");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return lectureEnd;
	}

	public String checkDate(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM ATTENDANCE_LIST WHERE STUDENT_MEMBER_NO = ? AND STATUS = 'O' OR STATUS = 'L' OR STATUS = 'E' OR STATUS = 'G'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String checkDate = null;
		while(rs.next()) {
			checkDate = rs.getString("COUNT(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return checkDate;
		
	}

	public String runDate(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM ATTENDANCE_LIST WHERE STUDENT_MEMBER_NO = ? AND STATUS = 'X'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String runDate = null;
		while(rs.next()) {
			runDate = rs.getString("COUNT(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return runDate;
	
	}

	public String lateDate(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM ATTENDANCE_LIST WHERE STUDENT_MEMBER_NO = ? AND STATUS = 'L'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String lateDate = null;
		while(rs.next()) {
			lateDate = rs.getString("COUNT(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return lateDate;
	
	}

	public String earlyDate(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM ATTENDANCE_LIST WHERE STUDENT_MEMBER_NO = ? AND STATUS = 'L'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String earlyDate = null;
		while(rs.next()) {
			earlyDate = rs.getString("COUNT(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return earlyDate;
	
	}

	public String getoutDate(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT COUNT(*) FROM ATTENDANCE_LIST WHERE STUDENT_MEMBER_NO = ? AND STATUS = 'G'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		String getoutDate = null;
		while(rs.next()) {
			getoutDate = rs.getString("COUNT(*)");			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return getoutDate;
	
	}

	public List<AttendanceVo> AttendanceList(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT TO_CHAR(CHECK_IN_TIME, 'YY-MM-DD HH24:MI:SS')CIT , TO_CHAR(CHECK_OUT_TIME, 'YY-MM-DD HH24:MI:SS')COT FROM ATTENDANCE_LIST WHERE STUDENT_MEMBER_NO = ? ORDER BY ATTENDANCE_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<AttendanceVo> avoList = new ArrayList<>();
		while (rs.next()) {
			
			String checkinTime = rs.getString("CIT");
			String checkOutTime = rs.getString("COT");
			
			AttendanceVo av = new AttendanceVo();
			av.setCheckInTime(checkinTime);
			av.setCheckOutTime(checkOutTime);
			
			avoList.add(av);
		
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return avoList;
	
	}

	public int checkIn(Connection conn, String memberNo) throws Exception {

		String sql = "INSERT INTO ATTENDANCE_LIST (ATTENDANCE_DATE, STUDENT_MEMBER_NO, CHECK_IN_TIME, STATUS) VALUES (SYSDATE, ?, SYSDATE, 'X')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		int result = pstmt.executeUpdate();
	
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public int checkOut(Connection conn, String memberNo) throws Exception {
		
		String sql = "UPDATE ATTENDANCE_LIST SET CHECK_OUT_TIME = SYSDATE, STATUS = 'O' WHERE ATTENDANCE_DATE = TO_CHAR(SYSDATE, 'YY/MM/DD') AND STUDENT_MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		int result = pstmt.executeUpdate();
	
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(pstmt);
		
		return result;
	
	}

	public List<NoticeVo> showNotice(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT N.NOTICE_NO ,N.ADMIN_NO ,N.NOTICE_TITLE ,N.NOTICE_CONTENT ,TO_CHAR(N.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(N.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE ,N.HIT ,N.STATUS ,A.ADMIN_NICK FROM NOTICE N JOIN ADMIN A ON(N.ADMIN_NO = A.ADMIN_NO) WHERE N.STATUS='O' ORDER BY NOTICE_NO DESC ) T ) WHERE RNUM BETWEEN 1 AND 3";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<NoticeVo> notList = new ArrayList<>();
		while (rs.next()) {
			String noticeNo = rs.getString("NOTICE_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String noticeTitle = rs.getString("NOTICE_TITLE");
			String noticeContent = rs.getString("NOTICE_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String status = rs.getString("STATUS");
			String adminNick = rs.getString("ADMIN_NICK");
			
			NoticeVo vo = new NoticeVo();
			vo.setNoticeNo(noticeNo);
			vo.setAdminNo(adminNo);
			vo.setNoticeTitle(noticeTitle);
			vo.setNoticeContent(noticeContent);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setStatus(status);
			vo.setAdminNick(adminNick);
			
			notList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return notList;
		
	}

	public List<BoardVo> getBoardTClassList(Connection conn, String lno) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, TO_CHAR(B.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, TO_CHAR(B.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE, COUNT(R.REPLY_NO) AS TOTAL_REPLIES FROM BOARD B JOIN MEMBER M ON (B.MEMBER_NO = M.MEMBER_NO) JOIN BOARD_CATEGORY C ON (B.BOARD_CATEGORY_NO = C.BOARD_CATEGORY_NO) LEFT JOIN REPLY R ON (B.BOARD_NO = R.BOARD_NO) WHERE B.STATUS = 'O' AND C.BOARD_CATEGORY_NO = 3 AND B.MEMBER_NO IN ( SELECT STUDENT_MEMBER_NO FROM STUDENT WHERE LECTURE_NO = ? ) GROUP BY B.BOARD_NO, B.BOARD_CATEGORY_NO, B.MEMBER_NO, B.BOARD_TITLE, B.BOARD_CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.STATUS, B.HIT, M.MEMBER_NICK, C.BOARD_CATEGORY_TYPE ORDER BY B.BOARD_NO DESC ) T ) WHERE RNUM BETWEEN 1 AND 3";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lno);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> tcvoList = new ArrayList<>();
		while (rs.next()) {
			
			String boardNo = rs.getString("BOARD_NO");
			String boardCategoryNo = rs.getString("BOARD_CATEGORY_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String boardTitle = rs.getString("BOARD_TITLE");
			String boardContent = rs.getString("BOARD_CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			String hit = rs.getString("HIT");
			String writerNick = rs.getString("MEMBER_NICK");
			String boardCategoryType = rs.getString("BOARD_CATEGORY_TYPE");
			String totalReplies = rs.getString("TOTAL_REPLIES");
			
			BoardVo bv = new BoardVo();
			bv.setBoardNo(boardNo);
			bv.setBoardCategoryNo(boardCategoryNo);
			bv.setMemberNo(memberNo);
			bv.setBoardTitle(boardTitle);
			bv.setBoardContent(boardContent);
			bv.setEnrollDate(enrollDate);
			bv.setModifyDate(modifyDate);
			bv.setStatus(status);
			bv.setHit(hit);
			bv.setWriterNick(writerNick);
			bv.setBoardCategoryType(boardCategoryType);
			bv.setTotalReplies(totalReplies);
			
			tcvoList.add(bv);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return tcvoList;
		
	}

	public List<TeamCalendarVo> todoList(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT T.TEAM_NO, C.TEAM_CALENDAR_NO, TO_CHAR(TO_DATE(C.START_DATE), 'MM/DD') SD, TO_CHAR(TO_DATE(C.END_DATE), 'MM/DD') ED, C.MEETING_CONTENT FROM STUDENT S JOIN MEMBER M ON (S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN TEAM T ON (S.TEAM_NO = T.TEAM_NO) JOIN TEAM_CALENDAR C ON (C.TEAM_NO = T.TEAM_NO) WHERE MEMBER_NO = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<TeamCalendarVo> todoList = new ArrayList<>();
		while (rs.next()) {
			
			String teamNo = rs.getString("TEAM_NO");
			String teamCalendarNo = rs.getString("TEAM_CALENDAR_NO");
			String startDate = rs.getString("SD");
			String endDate = rs.getString("ED");
			String meetingContent = rs.getString("MEETING_CONTENT");
			
			TeamCalendarVo tv = new TeamCalendarVo();
			tv.setTeamNo(teamNo);
			tv.setTeamCalendarNo(teamCalendarNo);
			tv.setStartDate(startDate);
			tv.setEndDate(endDate);
			tv.setMeetingContent(meetingContent);
			
			todoList.add(tv);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return todoList;
		
	}

	public List<CalenderVo> ttodoList(Connection conn, String memberNo) throws Exception {
		
		String sql = "SELECT T.TEAM_NO, T.TEAM_NAME, S.STUDENT_MEMBER_NO, C.TEAM_CALENDAR_NO, C.MEETING_CONTENT FROM STUDENT S JOIN MEMBER M ON (S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN TEAM T ON (S.TEAM_NO = T.TEAM_NO) JOIN TEAM_CALENDAR C ON (C.TEAM_NO = T.TEAM_NO) WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<CalenderVo> ttodoList = new ArrayList<>();
		while (rs.next()) {
			
			String teamNo = rs.getString("TEAM_NO");
			String teamName = rs.getString("TEAM_NAME");
			String studentMemberNo = rs.getString("STUDENT_MEMBER_NO");
			String teamCalenderNo = rs.getString("TEAM_CALENDAR_NO");
			String meetingContent = rs.getString("MEETING_CONTENT");
			
			CalenderVo cv = new CalenderVo();
			cv.setTeamNo(teamNo);
			cv.setTeamName(teamName);
			cv.setTeamCalenderNo(teamCalenderNo);
			cv.setStudentMemberNo(studentMemberNo);
			cv.setMeetingContent(meetingContent);
			
			ttodoList.add(cv);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return ttodoList;
		
	}

	public List<LectureVo> showLecture(Connection conn) throws Exception {
		
		String sql = "SELECT L.LECTURE_NO, L.TEACHER_MEMBER_NO, L.LECTURE_CATEGORY_NO, L.LECTURE_START_TIME, L.LECTURE_FINISH_TIME, TO_CHAR(TO_DATE(L.LECTURE_OPEN_DATE), 'MM/DD') LECTURE_OPEN_DATE, TO_CHAR(TO_DATE(L.LECTURE_CLOSE_DATE), 'MM/DD') LECTURE_CLOSE_DATE, L.STATUS, L.PLACE, LC.LECTURE_CATEGORY_NO, LC.LECTURE_NAME FROM LECTURE L JOIN LECTURE_CATEGORY LC ON (L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO) WHERE L.LECTURE_CATEGORY_NO = 1 AND STATUS = 'O' ORDER BY LECTURE_OPEN_DATE DESC ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<LectureVo> lvoList = new ArrayList<>();
		while (rs.next()) {
			
			String lectureNo = rs.getString("LECTURE_NO");
			String teacherMemberNo = rs.getString("TEACHER_MEMBER_NO");
			String lectureCategoryNo = rs.getString("LECTURE_CATEGORY_NO");
			String lectureStartTime = rs.getString("LECTURE_START_TIME");
			String lectureFinishTime = rs.getString("LECTURE_FINISH_TIME");
			String lectureOpenDate = rs.getString("LECTURE_OPEN_DATE");
			String lectureCloseDate = rs.getString("LECTURE_CLOSE_DATE");
			String place = rs.getString("PLACE");
			String lectureName = rs.getString("LECTURE_NAME");
			
			LectureVo lv = new LectureVo();
			lv.setLectureNo(lectureNo);
			lv.setTeacherMemberNo(teacherMemberNo);
			lv.setLectureCategoryNo(lectureCategoryNo);
			lv.setLectureStartTime(lectureStartTime);
			lv.setLectureFinishTime(lectureFinishTime);
			lv.setLectureOpenDate(lectureOpenDate);
			lv.setLectureCloseDate(lectureCloseDate);
			lv.setPlace(place);
			lv.setLectureCategoryName(lectureName);
			
			lvoList.add(lv);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return lvoList;
		
	}

	public List<LectureVo> showSecuLecture(Connection conn) throws Exception {
		
		String sql = "SELECT L.LECTURE_NO, L.TEACHER_MEMBER_NO, L.LECTURE_CATEGORY_NO, L.LECTURE_START_TIME, L.LECTURE_FINISH_TIME, TO_CHAR(TO_DATE(L.LECTURE_OPEN_DATE), 'MM/DD') LECTURE_OPEN_DATE, TO_CHAR(TO_DATE(L.LECTURE_CLOSE_DATE), 'MM/DD') LECTURE_CLOSE_DATE, L.STATUS, L.PLACE, LC.LECTURE_CATEGORY_NO, LC.LECTURE_NAME FROM LECTURE L JOIN LECTURE_CATEGORY LC ON (L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO) WHERE L.LECTURE_CATEGORY_NO = 2 AND STATUS = 'O' ORDER BY LECTURE_OPEN_DATE DESC ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<LectureVo> secuList = new ArrayList<>();
		while (rs.next()) {
			
			String lectureNo = rs.getString("LECTURE_NO");
			String teacherMemberNo = rs.getString("TEACHER_MEMBER_NO");
			String lectureCategoryNo = rs.getString("LECTURE_CATEGORY_NO");
			String lectureStartTime = rs.getString("LECTURE_START_TIME");
			String lectureFinishTime = rs.getString("LECTURE_FINISH_TIME");
			String lectureOpenDate = rs.getString("LECTURE_OPEN_DATE");
			String lectureCloseDate = rs.getString("LECTURE_CLOSE_DATE");
			String place = rs.getString("PLACE");
			String lectureName = rs.getString("LECTURE_NAME");
			
			LectureVo lv = new LectureVo();
			lv.setLectureNo(lectureNo);
			lv.setTeacherMemberNo(teacherMemberNo);
			lv.setLectureCategoryNo(lectureCategoryNo);
			lv.setLectureStartTime(lectureStartTime);
			lv.setLectureFinishTime(lectureFinishTime);
			lv.setLectureOpenDate(lectureOpenDate);
			lv.setLectureCloseDate(lectureCloseDate);
			lv.setPlace(place);
			lv.setLectureCategoryName(lectureName);
			
			secuList.add(lv);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return secuList;
		
	}

	public List<VacationVo> watchingStudent(Connection conn, String lectureNo) throws Exception {

		String sql = " SELECT M.MEMBER_NICK, V.reason, TO_CHAR(TO_DATE(VACATION_START), 'MM/DD') VACATION_START, TO_CHAR(TO_DATE(VACATION_END), 'MM/DD') VACATION_END FROM VACATION_REQUEST_LIST V JOIN STUDENT S ON (S.STUDENT_MEMBER_NO = V.MEMBER_NO) JOIN MEMBER M ON (M.MEMBER_NO = V.MEMBER_NO) WHERE V.STATUS = 'O' AND M.STATUS = 'O'  AND M.IDENTITY = 'S' AND LECTURE_NO = ? ORDER BY VACATION_START DESC ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lectureNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<VacationVo> vaList = new ArrayList<>();
		while (rs.next()) {
			String memberNick = rs.getString("MEMBER_NICK");
			String reason = rs.getString("REASON");
			String vacationStart = rs.getString("VACATION_START");
			String vacationEnd = rs.getString("VACATION_END");
			
			VacationVo vv = new VacationVo();
			vv.setStudentName(memberNick);
			vv.setReason(reason);
			vv.setVacationStart(vacationStart);
			vv.setVacationEnd(vacationEnd);
			
			vaList.add(vv);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vaList;
	
	}
		
	

	
	
}
