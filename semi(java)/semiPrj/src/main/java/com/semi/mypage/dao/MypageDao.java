package com.semi.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.lecture.vo.LectureVo;

public class MypageDao {

	public List<LectureVo> viewStudent(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT M.MEMBER_NICK, G.LECTURE_NAME FROM LECTURE L JOIN STUDENT S ON (L.LECTURE_NO = S.LECTURE_NO) JOIN MEMBER M ON(S.STUDENT_MEMBER_NO = M.MEMBER_NO) JOIN LECTURE_CATEGORY G ON (G.LECTURE_CATEGORY_NO = L.LECTURE_CATEGORY_NO) WHERE TEACHER_MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
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

	
	
}
