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

}
