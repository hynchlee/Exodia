package com.semi.letter.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

	public int deleteReceiveLetter(int[] letterNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int x = 1;
		for (int number : letterNo) {
			int result = dao.deleteReceiveLetter(conn, number);
			if (result == 1) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
				x = 0;
				break;
			}
		}

		JDBCTemplate.close(conn);

		return x;
	}

	public int deleteSentLetter(int[] letterNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int x = 1;
		for (int number : letterNo) {
			int result = dao.deleteSentLetter(conn, number);

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

	public int deleteTrashLetter(int[] letterNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int x = 1;
		for (int number : letterNo) {
			int result = dao.deleteTrashLetter(conn, number);

			if (result != 1) {
				x = 0;
				break;
			}

		}

		JDBCTemplate.close(conn);

		return x;
	}

	public LetterVo selectSendOneByNo(String bno) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		LetterVo vo = dao.selectSendOneByNo(bno, conn);

		JDBCTemplate.close(conn);

		return vo;

	}

	public LetterVo selectReceiveOneByNo(String bno) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		LetterVo vo = dao.selectReceiveOneByNo(bno, conn);

		JDBCTemplate.close(conn);

		return vo;

	}

	public int getLetterTrashListCnt(String searchType, String searchValue, String memberNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.getLetterTrashListCnt(conn, searchType, searchValue, memberNo);

		JDBCTemplate.close(conn);

		return cnt;

	}

	public List<LetterVo> getLetterTrashList(PageVo pv, String memberNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterTrashList(conn, pv, memberNo);

		// close
		JDBCTemplate.close(conn);

		return voList;

	}

	public List<LetterVo> getLetterTrashList(PageVo pv, String searchType, String searchValue, String memberNo)
			throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterTrashList(conn, pv, searchType, searchValue, memberNo);

		// close
		JDBCTemplate.close(conn);

		return voList;

	}

	public List<MemberVo> getMemberList() throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();
		// sql
		List<MemberVo> memberList = dao.getMemberList(conn);
		// close
		JDBCTemplate.close(conn);

		return memberList;

	}

}
