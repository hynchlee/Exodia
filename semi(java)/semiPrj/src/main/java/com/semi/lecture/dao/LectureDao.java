package com.semi.lecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.lecture.vo.LectureVo;
import com.semi.lecture.vo.ProblemBankVo;
import com.semi.lecture.vo.SubmitAnswerVo;
import com.semi.member.vo.MemberVo;
import com.semi.lecture.vo.ExamCategoryVo;
import com.semi.lecture.vo.LectureMemberVo;

public class LectureDao {

	public List<LectureVo> getLectureList(Connection conn, PageVo pageVo) throws SQLException {
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT * FROM LECTURE L JOIN LECTURE_CATEGORY LC ON L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO JOIN MEMBER M ON L.TEACHER_MEMBER_NO = M.MEMBER_NO WHERE L.STATUS = 'O' ORDER BY L.LECTURE_OPEN_DATE ) A ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageVo.getBeginRow());
		pstmt.setInt(2, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<LectureVo> lectureList = new ArrayList();

		while (rs.next()) {
			LectureVo vo = new LectureVo();
			vo.setLectureNo(rs.getString("LECTURE_NO"));
			vo.setTeacherMemberNo(rs.getString("TEACHER_MEMBER_NO"));
			vo.setLectureCategoryNo(rs.getString("LECTURE_CATEGORY_NO"));
			vo.setLectureStartTime(rs.getString("LECTURE_START_TIME"));
			vo.setLectureFinishTime(rs.getString("LECTURE_FINISH_TIME"));
			vo.setLectureOpenDate(rs.getString("LECTURE_OPEN_DATE"));
			vo.setLectureCloseDate(rs.getString("LECTURE_CLOSE_DATE"));
			vo.setStatus(rs.getString("STATUS"));
			vo.setLectureCategoryName(rs.getString("LECTURE_NAME"));
			vo.setTeacherMemberName(rs.getString("MEMBER_NICK"));
			lectureList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return lectureList;
	}

	public List<ExamCategoryVo> getExamCategoryList(Connection conn, PageVo pageVo) throws SQLException {
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT * FROM EXAM_CATEGORY EC JOIN LECTURE_CATEGORY LC ON EC.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageVo.getBeginRow());
		pstmt.setInt(2, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<ExamCategoryVo> ExamCategoryList = new ArrayList();

		while (rs.next()) {
			ExamCategoryVo vo = new ExamCategoryVo();
			vo.setExamCategoryNo(rs.getString("EXAM_CATEGORY_NO"));
			vo.setLectureCategoryNo(rs.getString("LECTURE_CATEGORY_NO"));
			vo.setExamSubject(rs.getString("EXAM_SUBJECT"));
			vo.setLectureCategoryName(rs.getString("LECTURE_NAME"));
			ExamCategoryList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return ExamCategoryList;
	}

	public List<ExamCategoryVo> getExamCategoryList(Connection conn, PageVo pageVo, MemberVo loginMember)
			throws SQLException {
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT * FROM EXAM_CATEGORY EC JOIN LECTURE_CATEGORY LC ON EC.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO WHERE EC.LECTURE_CATEGORY_NO = (SELECT LECTURE_CATEGORY_NO FROM LECTURE WHERE LECTURE_NO = (SELECT LECTURE_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?) ) ORDER BY EC.EXAM_CATEGORY_NO )A ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setInt(2, pageVo.getBeginRow());
		pstmt.setInt(3, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<ExamCategoryVo> ExamCategoryList = new ArrayList();

		while (rs.next()) {
			ExamCategoryVo vo = new ExamCategoryVo();
			vo.setExamCategoryNo(rs.getString("EXAM_CATEGORY_NO"));
			vo.setLectureCategoryNo(rs.getString("LECTURE_CATEGORY_NO"));
			vo.setExamSubject(rs.getString("EXAM_SUBJECT"));
			vo.setLectureCategoryName(rs.getString("LECTURE_NAME"));
			ExamCategoryList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return ExamCategoryList;
	}

	public List<ExamCategoryVo> getExamCategoryList2(Connection conn, PageVo pageVo, MemberVo loginMember)
			throws SQLException {
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT * FROM EXAM_CATEGORY EC JOIN LECTURE_CATEGORY LC ON EC.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO WHERE EC.LECTURE_CATEGORY_NO = (SELECT LECTURE_CATEGORY_NO FROM LECTURE WHERE TEACHER_MEMBER_NO = ?) ORDER BY EC.EXAM_CATEGORY_NO )A )WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setInt(2, pageVo.getBeginRow());
		pstmt.setInt(3, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<ExamCategoryVo> ExamCategoryList = new ArrayList();

		while (rs.next()) {
			ExamCategoryVo vo = new ExamCategoryVo();
			vo.setExamCategoryNo(rs.getString("EXAM_CATEGORY_NO"));
			vo.setLectureCategoryNo(rs.getString("LECTURE_CATEGORY_NO"));
			vo.setExamSubject(rs.getString("EXAM_SUBJECT"));
			vo.setLectureCategoryName(rs.getString("LECTURE_NAME"));
			ExamCategoryList.add(vo);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return ExamCategoryList;
	}

	public List<String> getProblemPointList(Connection conn, ProblemBankVo pbv) throws SQLException {
		String sql = "SELECT DISTINCT PROBLEM_POINT FROM PROBLEM_BANK WHERE EXAM_CATEGORY_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pbv.getExamCategoryNo());
		ResultSet rs = pstmt.executeQuery();

		List<String> problemPointList = new ArrayList<>();
		while (rs.next()) {
			String problemPoint = rs.getString(1);
			problemPointList.add(problemPoint);
		}

		return problemPointList;
	}

	public List<List<ProblemBankVo>> getProblemList(Connection conn, ProblemBankVo pbv, List<String> ProblemPointList)
			throws SQLException {
		List<List<ProblemBankVo>> problemList = new ArrayList<>();

		for (String point : ProblemPointList) {
			List<ProblemBankVo> problemBank = new ArrayList<>();
			String sql = "SELECT * FROM PROBLEM_BANK WHERE PROBLEM_POINT = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, point);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ProblemBankVo vo = new ProblemBankVo();
				vo.setExamProblemNo(rs.getString("EXAM_PROBLEM_NO"));
				vo.setExamCategoryNo(rs.getString("EXAM_CATEGORY_NO"));
				vo.setExamSubject(pbv.getExamSubject());
				vo.setProblem(rs.getString("PROBLEM"));
				vo.setAnswer(rs.getString("ANSWER"));
				vo.setProblemPoint(rs.getString("PROBLEM_POINT"));

				problemBank.add(vo);
			}
			problemList.add(problemBank);
		}

		return problemList;
	}

	public int getLectureListCnt(Connection conn) throws SQLException {
		String sql = "SELECT COUNT(*) FROM LECTURE WHERE STATUS = 'O'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public int getExamCategoryListCnt(Connection conn) throws SQLException {
		String sql = "SELECT COUNT(*) FROM EXAM_CATEGORY";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public int getExamCategoryListCnt(Connection conn, MemberVo loginMember) throws SQLException {
		String sql = "SELECT COUNT(*) FROM EXAM_CATEGORY WHERE LECTURE_CATEGORY_NO = (SELECT LECTURE_CATEGORY_NO FROM LECTURE WHERE LECTURE_NO = (SELECT LECTURE_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public int getExamCategoryListCnt2(Connection conn, MemberVo loginMember) throws SQLException {
		String sql = "SELECT COUNT(*) FROM EXAM_CATEGORY WHERE LECTURE_CATEGORY_NO = (SELECT LECTURE_CATEGORY_NO FROM LECTURE WHERE TEACHER_MEMBER_NO = ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public int getProblemListCnt(Connection conn, ProblemBankVo pbv) throws SQLException {
		String sql = "SELECT COUNT(DISTINCT PROBLEM_POINT) AS DISTINCT_COUNT FROM PROBLEM_BANK WHERE EXAM_CATEGORY_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pbv.getExamCategoryNo());
		ResultSet rs = pstmt.executeQuery();

		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public LectureVo getLectureOne(Connection conn, String lectureCategoryNo, String memberNo) throws SQLException {
		String sql = "SELECT * FROM LECTURE L JOIN MEMBER M ON M.MEMBER_NO = L.TEACHER_MEMBER_NO JOIN LECTURE_CATEGORY LC ON LC.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO WHERE L.TEACHER_MEMBER_NO = ? AND L.LECTURE_CATEGORY_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, lectureCategoryNo);
		ResultSet rs = pstmt.executeQuery();

		LectureVo vo = null;
		if (rs.next()) {
			vo = new LectureVo();
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
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}
	
	public LectureVo getLectureOne(Connection conn, String lectureNo) throws SQLException {
		String sql = "SELECT * FROM LECTURE L JOIN MEMBER M ON M.MEMBER_NO = L.TEACHER_MEMBER_NO JOIN LECTURE_CATEGORY LC ON L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO WHERE LECTURE_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lectureNo);
		ResultSet rs = pstmt.executeQuery();

		LectureVo vo = null;
		if (rs.next()) {
			vo = new LectureVo();
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
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}

	public List<LectureMemberVo> getMemberList(Connection conn, ProblemBankVo pbv,LectureVo lectureVo) throws SQLException {
		String sql = "SELECT * FROM MEMBER M JOIN STUDENT S ON M.MEMBER_NO = S.STUDENT_MEMBER_NO JOIN EXAM_LIST EL ON EL.MEMBER_NO = M.MEMBER_NO WHERE LECTURE_NO = ? AND EXAM_CATEGORY_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lectureVo.getLectureNo());
		pstmt.setString(2, pbv.getExamCategoryNo());
		ResultSet rs = pstmt.executeQuery();

		List<LectureMemberVo> memberList = new ArrayList<>();
		while (rs.next()) {
			LectureMemberVo vo = new LectureMemberVo();
			vo.setMemberNo(rs.getString("MEMBER_NO"));
			vo.setMemberNick(rs.getString("MEMBER_NICK"));
			vo.setScore(rs.getString("SCORE"));
			memberList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return memberList;
	}

	public List<SubmitAnswerVo> getSubmitAnswerList(Connection conn, ProblemBankVo pbv) throws SQLException {
		String sql = "SELECT * FROM EXAM_LIST EL JOIN SUBMIT_ANSWER SA ON SA.EXAM_SCORE_NO = EL.EXAM_SCORE_NO JOIN PROBLEM_BANK PB ON PB.EXAM_PROBLEM_NO = SA.EXAM_PROBLEM_NO JOIN MEMBER M ON M.MEMBER_NO = EL.MEMBER_NO WHERE EL.EXAM_CATEGORY_NO = ? ORDER BY SA.EXAM_PROBLEM_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pbv.getExamCategoryNo());
		ResultSet rs = pstmt.executeQuery();

		List<SubmitAnswerVo> submitAnswerList = new ArrayList<>();
		while (rs.next()) {
			SubmitAnswerVo sav = new SubmitAnswerVo();
			sav.setExamCategoryNo(rs.getString("EXAM_CATEGORY_NO"));
			sav.setExamSubject(pbv.getExamSubject());
			sav.setMemberNo(rs.getString("MEMBER_NO"));
			sav.setMemberNick(rs.getString("MEMBER_NICK"));
			sav.setScore(rs.getString("SCORE"));
			sav.setProblem(rs.getString("PROBLEM"));
			sav.setSubmitAnswer(rs.getString("SUBMIT_ANSWER"));
			sav.setAnswer(rs.getString("ANSWER"));
			sav.setProblemPoint(rs.getString("PROBLEM_POINT"));

			submitAnswerList.add(sav);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return submitAnswerList;
	}

	public List<SubmitAnswerVo> getSubmitAnswerList(Connection conn, ProblemBankVo pbv, String memberNo)
			throws SQLException {
		String sql = "SELECT * FROM EXAM_LIST EL JOIN SUBMIT_ANSWER SA ON SA.EXAM_SCORE_NO = EL.EXAM_SCORE_NO JOIN PROBLEM_BANK PB ON PB.EXAM_PROBLEM_NO = SA.EXAM_PROBLEM_NO JOIN MEMBER M ON M.MEMBER_NO = EL.MEMBER_NO WHERE EL.MEMBER_NO = ? AND EL.EXAM_CATEGORY_NO = ? ORDER BY SA.EXAM_PROBLEM_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, pbv.getExamCategoryNo());
		ResultSet rs = pstmt.executeQuery();

		List<SubmitAnswerVo> submitAnswerList = new ArrayList<>();
		while (rs.next()) {
			SubmitAnswerVo sav = new SubmitAnswerVo();
			sav.setExamCategoryNo(rs.getString("EXAM_CATEGORY_NO"));
			sav.setExamSubject(pbv.getExamSubject());
			sav.setMemberNo(rs.getString("MEMBER_NO"));
			sav.setMemberNick(rs.getString("MEMBER_NICK"));
			sav.setScore(rs.getString("SCORE"));
			sav.setExamProblemNo(rs.getString("EXAM_PROBLEM_NO"));
			sav.setProblem(rs.getString("PROBLEM"));
			sav.setScorePoint(rs.getString("SCORE_POINT"));
			sav.setSubmitAnswer(rs.getString("SUBMIT_ANSWER"));
			sav.setAnswer(rs.getString("ANSWER"));
			sav.setProblemPoint(rs.getString("PROBLEM_POINT"));

			submitAnswerList.add(sav);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return submitAnswerList;
	}

	public int scoreOne(Connection conn, String examCategoryNo, String memberNo, String totalScore) throws SQLException {
		String sql = "UPDATE EXAM_LIST SET SCORE = ? WHERE EXAM_CATEGORY_NO = ? AND MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, totalScore);
		pstmt.setString(2, examCategoryNo);
		pstmt.setString(3, memberNo);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int lectureApplyOne(Connection conn, String lectureNo, String memberNo) throws SQLException {
		String sql = "UPDATE STUDENT SET LECTURE_NO = ? WHERE STUDENT_MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lectureNo);
		pstmt.setString(2, memberNo);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	public int selectAnswerCnt(Connection conn, String memberNo, String examCategoryNo, String examProblemNo, String answer) throws SQLException {
		String sql = "SELECT COUNT(*) FROM SUBMIT_ANSWER WHERE EXAM_SCORE_NO = (SELECT EXAM_SCORE_NO FROM EXAM_LIST WHERE EXAM_CATEGORY_NO = ? AND MEMBER_NO = ?) AND EXAM_PROBLEM_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, examCategoryNo);
		pstmt.setString(2, memberNo);
		pstmt.setString(3, examProblemNo);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	public int insertAnswer(Connection conn, String memberNo, String examCategoryNo, String examProblemNo, String answer) throws SQLException {
		String sql = "INSERT INTO SUBMIT_ANSWER VALUES(SEQ_SUBMIT_ANSWER_NO.NEXTVAL, (SELECT EXAM_SCORE_NO FROM EXAM_LIST WHERE EXAM_CATEGORY_NO = ? AND MEMBER_NO = ?), ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, examCategoryNo);
		pstmt.setString(2, memberNo);
		pstmt.setString(3, examProblemNo);
		pstmt.setString(4, answer);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	public int updateAnswer(Connection conn, String memberNo, String examCategoryNo, String examProblemNo, String answer) throws SQLException {
		String sql = "UPDATE SUBMIT_ANSWER SET SUBMIT_ANSWER = ? WHERE EXAM_SCORE_NO = (SELECT EXAM_SCORE_NO FROM EXAM_LIST WHERE EXAM_CATEGORY_NO = ? AND MEMBER_NO = ?) AND EXAM_PROBLEM_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, answer);
		pstmt.setString(2, examCategoryNo);
		pstmt.setString(3, memberNo);
		pstmt.setString(4, examProblemNo);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}
}
