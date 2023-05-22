package com.semi.letter.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.letter.dao.LetterDao;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

public class LetterService {

	private static LetterDao dao = new LetterDao();

	public int writeLetter(LetterVo vo, String sendMemberName) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int result = dao.writeLetter(vo, conn, sendMemberName);

		JDBCTemplate.close(conn);

		return result;
	}

	// 목록 조회
	public List<LetterVo> getLetterList(PageVo pv, String MemberNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterList(conn, pv, MemberNo);

		// close
		JDBCTemplate.close(conn);

		return voList;
	}

	public List<LetterVo> getLetterList(PageVo pv, String searchType, String searchValue, String MemberNo)
			throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterList(conn, pv, searchType, searchValue, MemberNo);

		// close
		JDBCTemplate.close(conn);

		return voList;

	}

	public int getLetterListCnt(String searchType, String searchValue, String MemberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.getLetterListCnt(conn, searchType, searchValue, MemberNo);

		JDBCTemplate.close(conn);

		return cnt;
	}

	public int getLetterListCnt(String searchSR, String searchType, String searchValue, String MemberNo)
			throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.getLetterListCnt(conn, searchType, searchValue, MemberNo);

		JDBCTemplate.close(conn);

		return cnt;
	}

	public int deleteLetter(int[] letterNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int x = 1;
		for (int number : letterNo) {
			int result = dao.deleteLetter(conn, number);

			if (result != 1) {
				x = 0;
				break;
			}

		}

		JDBCTemplate.close(conn);

		return x;
	}

	public int getLetterSendListCnt(String searchType, String searchValue, String MemberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.getLetterSendListCnt(conn, searchType, searchValue, MemberNo);

		JDBCTemplate.close(conn);

		return cnt;
	}

	public List<LetterVo> getLetterSendList(PageVo pv, String MemberNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterSendList(conn, pv, MemberNo);

		// close
		JDBCTemplate.close(conn);

		return voList;

	}

	public List<LetterVo> getLetterSendList(PageVo pv, String searchType, String searchValue, String MemberNo)
			throws SQLException {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterSendList(conn, pv, searchType, searchValue, MemberNo);

		// close
		JDBCTemplate.close(conn);

		return voList;

	}

	public List<LetterVo> getLetterTrashList(String searchSR, PageVo pv, String searchType, String searchValue,
			String memberNo) throws SQLException {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterTrashList(searchSR, conn, pv, searchType, searchValue, memberNo);

		// close
		JDBCTemplate.close(conn);

		return voList;

	}

}
