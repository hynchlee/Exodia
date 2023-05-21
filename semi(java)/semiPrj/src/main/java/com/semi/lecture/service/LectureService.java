package com.semi.lecture.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.lecture.dao.LectureDao;
import com.semi.lecture.vo.LectureVo;
import com.semi.lecture.vo.ProblemBankVo;
import com.semi.lecture.vo.SubmitAnswerVo;
import com.semi.member.vo.MemberVo;
import com.semi.lecture.vo.ExamCategoryVo;
import com.semi.lecture.vo.LectureMemberVo;

public class LectureService {
	private LectureDao dao = new LectureDao();

	public List<LectureVo> getLectureList(PageVo pageVo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<LectureVo> lectureList = dao.getLectureList(conn, pageVo);

		JDBCTemplate.close(conn);
		return lectureList;
	}

	public List<ExamCategoryVo> getExamCategoryList(PageVo pageVo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<ExamCategoryVo> examCategoryList = dao.getExamCategoryList(conn, pageVo);

		JDBCTemplate.close(conn);
		return examCategoryList;
	}
	
	public List<ExamCategoryVo> getExamCategoryList(PageVo pageVo, MemberVo loginMember) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<ExamCategoryVo> examCategoryList = dao.getExamCategoryList(conn, pageVo, loginMember);

		JDBCTemplate.close(conn);
		return examCategoryList;
	}
	
	public List<ExamCategoryVo> getExamCategoryList2(PageVo pageVo, MemberVo loginMember) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<ExamCategoryVo> examCategoryList = dao.getExamCategoryList2(conn, pageVo, loginMember);

		JDBCTemplate.close(conn);
		return examCategoryList;
	}

	public List<List<ProblemBankVo>> getProblemList(ProblemBankVo pbv) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<String> problemPointList = dao.getProblemPointList(conn, pbv);
		List<List<ProblemBankVo>> problemList = dao.getProblemList(conn, pbv, problemPointList);

		JDBCTemplate.close(conn);
		return problemList;
	}

	public int getLectureListCnt() throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getLectureListCnt(conn);

		JDBCTemplate.close(conn);
		return result;
	}

	public int getExamCategoryListCnt() throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getExamCategoryListCnt(conn);

		JDBCTemplate.close(conn);
		return result;
	}
	
	public int getExamCategoryListCnt(MemberVo loginMember) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getExamCategoryListCnt(conn, loginMember);

		JDBCTemplate.close(conn);
		return result;
	}
	
	public int getExamCategoryListCnt2(MemberVo loginMember) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getExamCategoryListCnt2(conn, loginMember);

		JDBCTemplate.close(conn);
		return result;
	}

	public int getProblemListCnt(ProblemBankVo pbv) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getProblemListCnt(conn, pbv);

		JDBCTemplate.close(conn);
		return result;
	}

	public LectureVo getLectureOne(String lectureCategoryNo, String memberNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		LectureVo vo = dao.getLectureOne(conn, lectureCategoryNo, memberNo);

		JDBCTemplate.close(conn);
		
		return vo;
	}

	public List<LectureMemberVo> getMemberList(ProblemBankVo pbv, LectureVo lectureVo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<LectureMemberVo> memberList = dao.getMemberList(conn, pbv, lectureVo);

		JDBCTemplate.close(conn);
		
		return memberList;
	}
	
	public List<SubmitAnswerVo> getSubmitAnswerList(ProblemBankVo pbv) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<SubmitAnswerVo> submitAnswerList = dao.getSubmitAnswerList(conn, pbv);

		JDBCTemplate.close(conn);
		
		return submitAnswerList;
	}

	public List<SubmitAnswerVo> getSubmitAnswerList(ProblemBankVo pbv, String memberNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<SubmitAnswerVo> submitAnswerList = dao.getSubmitAnswerList(conn, pbv, memberNo);

		JDBCTemplate.close(conn);
		
		return submitAnswerList;
	}

	public int scoreOne(String examCategoryNo, String memberNo, String totalScore) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.scoreOne(conn, examCategoryNo, memberNo, totalScore);

		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
}
