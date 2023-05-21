package com.semi.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.qna.vo.QnaVo;

public class QnaDao {

	
	//페이징
	public int getQnaListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM QNA WHERE STATUS='O'";
		if ("qnaTitle".equals(searchType)) {
			sql += "AND QNA_TITLE LIKE '%" + searchValue + "%'";
		}else if ("qnaContent".equals(searchType)) {
			sql += "AND QNA_CONTENT LIKE '%" + searchValue + "%'";
		}
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

	//목록 조회
	public List<QnaVo> getBoardQnaList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT Q.QNA_NO ,Q.ADMIN_NO ,Q.STUDENT_MEMBER_NO ,Q.QNA_TITLE ,Q.QNA_CONTENT ,Q.QNA_ANSWER ,TO_CHAR(Q.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(Q.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE ,Q.PHOTO ,Q.STATUS ,M.MEMBER_NICK FROM QNA Q JOIN STUDENT S ON(S.STUDENT_MEMBER_NO = Q.STUDENT_MEMBER_NO) JOIN MEMBER M ON(S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN ADMIN A ON(A.ADMIN_NO = Q.ADMIN_NO) WHERE Q.STATUS='O' ORDER BY Q.QNA_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaVo> qvoList = new ArrayList<>();
		while (rs.next()) {
			
			String qnaNo = rs.getString("QNA_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String studentMemberNo = rs.getString("STUDENT_MEMBER_NO");
			String qnaTitle = rs.getString("QNA_TITLE");
			String qnaContent = rs.getString("QNA_CONTENT");
			String qnaAnswer = rs.getString("QNA_ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String photo = rs.getString("PHOTO");
			String status = rs.getString("STATUS");
			String writerNick = rs.getString("MEMBER_NICK");
			
			QnaVo qv = new QnaVo();
			qv.setQnaNo(qnaNo);
			qv.setAdminNo(adminNo);
			qv.setStudentMemberNo(studentMemberNo);
			qv.setQnaTitle(qnaTitle);
			qv.setQnaContent(qnaContent);
			qv.setQnaAnswer(qnaAnswer);
			qv.setEnrollDate(enrollDate);
			qv.setModifyDate(modifyDate);
			qv.setPhoto(photo);
			qv.setStatus(status);
			qv.setWriterNick(writerNick);

			qvoList.add(qv);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return qvoList;
	}

	public List<QnaVo> getBoardQnaList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {
		
		String sql = "";
		
		if (searchType.equals("qnaTitle")) {
			//제목 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT Q.QNA_NO ,Q.ADMIN_NO ,Q.STUDENT_MEMBER_NO ,Q.QNA_TITLE ,Q.QNA_CONTENT ,Q.QNA_ANSWER ,TO_CHAR(Q.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(Q.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE ,Q.PHOTO ,Q.STATUS ,M.MEMBER_NICK FROM QNA Q JOIN STUDENT S ON(S.STUDENT_MEMBER_NO = Q.STUDENT_MEMBER_NO) JOIN MEMBER M ON(S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN ADMIN A ON(A.ADMIN_NO = Q.ADMIN_NO) WHERE Q.STATUS='O' AND Q.QNA_TITLE LIKE ('%' || ? || '%') ORDER BY Q.QNA_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if (searchType.equals("freeContent")) {
			//내용 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM ,T.* FROM ( SELECT Q.QNA_NO ,Q.ADMIN_NO ,Q.STUDENT_MEMBER_NO ,Q.QNA_TITLE ,Q.QNA_CONTENT ,Q.QNA_ANSWER ,TO_CHAR(Q.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(Q.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE ,Q.PHOTO ,Q.STATUS ,M.MEMBER_NICK FROM QNA Q JOIN STUDENT S ON(S.STUDENT_MEMBER_NO = Q.STUDENT_MEMBER_NO) JOIN MEMBER M ON(S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN ADMIN A ON(A.ADMIN_NO = Q.ADMIN_NO) WHERE Q.STATUS='O' AND Q.QNA_CONTENT LIKE ('%' || ? || '%') ORDER BY Q.QNA_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else {
			return getBoardQnaList(conn, pv);
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<QnaVo> qvoList = new ArrayList<>();
		while (rs.next()) {
			
			String qnaNo = rs.getString("QNA_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String studentMemberNo = rs.getString("STUDENT_MEMBER_NO");
			String qnaTitle = rs.getString("QNA_TITLE");
			String qnaContent = rs.getString("QNA_CONTENT");
			String qnaAnswer = rs.getString("QNA_ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String photo = rs.getString("PHOTO");
			String status = rs.getString("STATUS");
			String writerNick = rs.getString("MEMBER_NICK");
			
			QnaVo qv = new QnaVo();
			qv.setQnaNo(qnaNo);
			qv.setAdminNo(adminNo);
			qv.setStudentMemberNo(studentMemberNo);
			qv.setQnaTitle(qnaTitle);
			qv.setQnaContent(qnaContent);
			qv.setQnaAnswer(qnaAnswer);
			qv.setEnrollDate(enrollDate);
			qv.setModifyDate(modifyDate);
			qv.setPhoto(photo);
			qv.setStatus(status);
			qv.setWriterNick(writerNick);

			qvoList.add(qv);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return qvoList;
		
	}

	public QnaVo getQnaByNo(Connection conn, String qno) throws Exception {
		
		String sql = "SELECT Q.QNA_NO ,Q.ADMIN_NO ,Q.STUDENT_MEMBER_NO ,Q.QNA_TITLE ,Q.QNA_CONTENT ,Q.QNA_ANSWER ,TO_CHAR(Q.ENROLL_DATE,'YYYY.MM.DD') AS ENROLL_DATE ,TO_CHAR(Q.MODIFY_DATE,'YYYY.MM.DD') AS MODIFY_DATE ,Q.PHOTO ,Q.STATUS ,M.MEMBER_NICK ,LC.LECTURE_NAME,A.ADMIN_NICK,M.MEMBER_NO FROM QNA Q JOIN STUDENT S ON(S.STUDENT_MEMBER_NO = Q.STUDENT_MEMBER_NO) JOIN LECTURE L ON(L.LECTURE_NO = S.LECTURE_NO) JOIN LECTURE_CATEGORY LC ON(LC.LECTURE_CATEGORY_NO=L.LECTURE_CATEGORY_NO) JOIN MEMBER M ON(S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN ADMIN A ON(A.ADMIN_NO = Q.ADMIN_NO) WHERE Q.STATUS='O' AND Q.QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qno);
		ResultSet rs = pstmt.executeQuery();
		
		QnaVo qvNo = new QnaVo();
		if (rs.next()) {
			
			String qnaNo = rs.getString("QNA_NO");
			String adminNo = rs.getString("ADMIN_NO");
			String studentMemberNo = rs.getString("STUDENT_MEMBER_NO");
			String qnaTitle = rs.getString("QNA_TITLE");
			String qnaContent = rs.getString("QNA_CONTENT");
			String qnaAnswer = rs.getString("QNA_ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String photo = rs.getString("PHOTO");
			String status = rs.getString("STATUS");
			String writerNick = rs.getString("MEMBER_NICK");
			String lectureName = rs.getString("LECTURE_NAME");
			String adminNick = rs.getString("ADMIN_NICK");
			String memberNo = rs.getString("MEMBER_NO");
			
			qvNo = new QnaVo();
			qvNo.setQnaNo(qnaNo);
			qvNo.setAdminNo(adminNo);
			qvNo.setStudentMemberNo(studentMemberNo);
			qvNo.setQnaTitle(qnaTitle);
			qvNo.setQnaContent(qnaContent);
			qvNo.setQnaAnswer(qnaAnswer);
			qvNo.setEnrollDate(enrollDate);
			qvNo.setModifyDate(modifyDate);
			qvNo.setPhoto(photo);
			qvNo.setStatus(status);
			qvNo.setWriterNick(writerNick);
			qvNo.setLectureName(lectureName);
			qvNo.setAdminNick(adminNick);
			qvNo.setMemberNo(memberNo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return qvNo;
	}

}
