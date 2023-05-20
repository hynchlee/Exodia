package com.semi.lecture.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.lecture.dao.LectureDao;
import com.semi.lecture.vo.LectureVo;
import com.semi.lecture.vo.ProblemBankVo;
import com.semi.member.vo.MemberVo;
import com.semi.lecture.vo.ExamCategoryVo;

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

	public int getProblemListCnt(ProblemBankVo pbv) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getProblemListCnt(conn, pbv);

		JDBCTemplate.close(conn);
		return result;
	}
}
