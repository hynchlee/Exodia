package com.semi.letter.service;

import java.sql.Connection;
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

	public List<LetterVo> getLetterList(PageVo pv) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterList(conn, pv);

		// close
		JDBCTemplate.close(conn);

		return voList;
	}

	public List<LetterVo> getLetterList(PageVo pv, String searchType, String searchValue) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		List<LetterVo> voList = dao.getLetterList(conn, pv, searchType, searchValue);

		// close
		JDBCTemplate.close(conn);

		return voList;

	}

	public int getLetterListCnt(String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getLetterListCnt(conn, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int deleteLetter(int[] letterNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int x = 1;
		for(int number:letterNo) {
			int result = dao.deleteLetter(conn, number);
			
			if(result != 1) { 
				x = 0;
				break;
			}
			
		}
		
		JDBCTemplate.close(conn);
		
		return x;
	}

	
	
}











