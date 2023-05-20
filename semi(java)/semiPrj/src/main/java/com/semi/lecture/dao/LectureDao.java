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
import com.semi.member.vo.MemberVo;
import com.semi.lecture.vo.ExamCategoryVo;

public class LectureDao {

	public List<LectureVo> getLectureList(Connection conn, PageVo pageVo) throws SQLException {
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT * FROM LECTURE L JOIN LECTURE_CATEGORY LC ON L.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO JOIN MEMBER M ON L.TEACHER_MEMBER_NO = M.MEMBER_NO WHERE L.STATUS = 'O' ORDER BY L.LECTURE_OPEN_DATE ) A ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageVo.getBeginRow());
		pstmt.setInt(2, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<LectureVo> lectureList = new ArrayList();
		
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
		
		while(rs.next()) {
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
	
	public List<ExamCategoryVo> getExamCategoryList(Connection conn, PageVo pageVo, MemberVo loginMember) throws SQLException {
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM ( SELECT * FROM EXAM_CATEGORY EC JOIN LECTURE_CATEGORY LC ON EC.LECTURE_CATEGORY_NO = LC.LECTURE_CATEGORY_NO WHERE EC.LECTURE_CATEGORY_NO = (SELECT LECTURE_CATEGORY_NO FROM LECTURE WHERE LECTURE_NO = (SELECT LECTURE_NO FROM STUDENT WHERE STUDENT_MEMBER_NO = ?) ) ORDER BY EC.EXAM_CATEGORY_NO )A ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setInt(2, pageVo.getBeginRow());
		pstmt.setInt(3, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<ExamCategoryVo> ExamCategoryList = new ArrayList();
		
		while(rs.next()) {
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
		while(rs.next()) {
			String problemPoint = rs.getString(1);
			problemPointList.add(problemPoint);
		}
		
		return problemPointList;
	}

	public List<List<ProblemBankVo>> getProblemList(Connection conn, ProblemBankVo pbv, List<String> ProblemPointList) throws SQLException {
		List<List<ProblemBankVo>> problemList = new ArrayList<>();
		
		for (String point : ProblemPointList) {
			List<ProblemBankVo> problemBank = new ArrayList<>();
			String sql = "SELECT * FROM PROBLEM_BANK WHERE PROBLEM_POINT = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, point);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
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

}
