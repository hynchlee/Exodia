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

	public List<LectureVo> getLectureList(PageVo pageVo, String searchType, String searchValue) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<LectureVo> lectureList = dao.getLectureList(conn, pageVo, searchType, searchValue);

		JDBCTemplate.close(conn);
		return lectureList;
	}
	
	public List<LectureVo> getLectureList(PageVo pageVo, String searchType, String searchValue, String currentDate) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<LectureVo> lectureList = dao.getLectureList(conn, pageVo, searchType, searchValue, currentDate);

		JDBCTemplate.close(conn);
		return lectureList;
	}

	public List<ExamCategoryVo> getExamCategoryList(PageVo pageVo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<ExamCategoryVo> examCategoryList = dao.getExamCategoryList(conn, pageVo);

		JDBCTemplate.close(conn);
		return examCategoryList;
	}

	public List<ExamCategoryVo> getExamCategoryList(PageVo pageVo, String searchType, String searchValue)
			throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<ExamCategoryVo> examCategoryList = dao.getExamCategoryList(conn, pageVo, searchType, searchValue);

		JDBCTemplate.close(conn);
		return examCategoryList;
	}

	public List<ExamCategoryVo> getExamCategoryList(PageVo pageVo, MemberVo loginMember) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<ExamCategoryVo> examCategoryList = dao.getExamCategoryList(conn, pageVo, loginMember);

		JDBCTemplate.close(conn);
		return examCategoryList;
	}

	public List<ExamCategoryVo> getExamCategoryList2(PageVo pageVo, String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<ExamCategoryVo> examCategoryList = dao.getExamCategoryList2(conn, pageVo, lectureNo);

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
	
	public int getLectureListCnt(String searchType, String searchValue) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getLectureListCnt(conn, searchType, searchValue);

		JDBCTemplate.close(conn);
		return result;
	}

	public int getLectureListCnt(String searchType, String searchValue, String currentDate) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getLectureListCnt(conn, searchType, searchValue, currentDate);

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

	public int getExamCategoryListCnt2(String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getExamCategoryListCnt2(conn, lectureNo);

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

	public LectureVo getLectureOne(String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		LectureVo vo = dao.getLectureOne(conn, lectureNo);

		JDBCTemplate.close(conn);

		return vo;
	}

	public String getLectureNo(String memberNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		String result = dao.getLectureNo(conn, memberNo);

		JDBCTemplate.close(conn);

		return result;
	}

	public List<MemberVo> getMemberList(String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<MemberVo> memberList = dao.getMemberList(conn, lectureNo);

		JDBCTemplate.close(conn);

		return memberList;
	}

	public List<LectureMemberVo> getMemberList(String examCategoryNo, String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<LectureMemberVo> memberList = dao.getMemberList(conn, examCategoryNo, lectureNo);

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

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public int lectureApplyOne(String lectureNo, String memberNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.lectureApplyOne(conn, lectureNo, memberNo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public int submitAnswers(String memberNo, String examCategoryNo, String[] examProblemNoArr, String[] answerArr)
			throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		int result = 1;

		for (int i = 0; i < examProblemNoArr.length; i++) {
			int result2 = dao.updateAnswer(conn, memberNo, examCategoryNo, examProblemNoArr[i], answerArr[i]);

			if (result2 == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
				result = 0;
			}
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public int deleteLecture(int[] lectureNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();

		int result = 1;
		for (int number : lectureNo) {
			int result2 = dao.deleteLecture(conn, number);
			
			if (result2 == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
				result = 0;
			}
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteProblem(int[] examProblemNoArr) throws Exception {
		Connection conn = JDBCTemplate.getConnection();

		int result = 1;
		for (int number : examProblemNoArr) {
			int result2 = dao.deleteProblem(conn, number);
			
			if (result2 == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
				result = 0;
			}
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public int modifyLectureOne(String[] params) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.modifyLectureOne(conn, params);
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		return result;
	}
	
	public int modifyTestOne(String[] params) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.modifyTestOne(conn, params);
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public int insertLectureOne(String[] params) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.insertLectureOne(conn, params);
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertProblemOne(String[] params) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.insertProblemOne(conn, params);
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public int testStart(String examCategoryNo, String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> studentList = dao.getMemberList(conn, lectureNo);
		int result = 1;
		int[] pointArr = {10, 20, 30, 40};
		int[] problemNoArr = new int[4];
		
		for (int i = 0; i < pointArr.length; i++) {
			problemNoArr[i] = dao.getProblemNo(conn, pointArr[i], examCategoryNo);
		}
		
		for (MemberVo lmv : studentList) {
			int temp1 = dao.insertExamList(conn, examCategoryNo, lmv.getMemberNo());
			for (int problemNo : problemNoArr) {
				int temp2 = dao.insertSubmitAnswer(conn, problemNo);
				
				if (temp2 == 1) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
					result = 0;
				}
			}
			
			if (temp1 == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
				result = 0;
			}
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public int testEnd(String examCategoryNo, String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.testEnd(conn, examCategoryNo, lectureNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public int scoreEnd(String examCategoryNo, String lectureNo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.scoreEnd(conn, examCategoryNo, lectureNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		return result;
	}

	public List<ExamCategoryVo> updateExamStatusList(List<ExamCategoryVo> examCategoryList, String memberNo)
			throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<ExamCategoryVo> updatedList = examCategoryList;
		for (ExamCategoryVo ecv : updatedList) {
			String[] arr = dao.plusParams(conn, ecv.getExamCategoryNo(), memberNo);
			ecv.setStatus(arr[0]);
			ecv.setEnrollDate(arr[1]);
			ecv.setScore(arr[2]);
		}

		JDBCTemplate.close(conn);
		return updatedList;
	}

	public int scoreAnswers(String examCategoryNo, String memberNo, String[] proNoArr, String[] scoreArr) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = 1;
		for (int i = 0; i < proNoArr.length; i++) {
			int result2 = dao.scoreAnswerOne(conn, examCategoryNo, memberNo, proNoArr[i], scoreArr[i]);
			if (result2 > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
				result = 0;
			}
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public List<MemberVo> getTeacherList() throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		List<MemberVo> teacherList = dao.getTeacherList(conn);

		JDBCTemplate.close(conn);

		return teacherList;
	}
}
