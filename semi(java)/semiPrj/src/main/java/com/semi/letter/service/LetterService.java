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

	public int writeLetter(LetterVo vo, MemberVo loginMember) throws Exception {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.writeLetter(vo, conn, loginMember);

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

	public int letterDelete(List<String> boxList) {
	    Connection conn = JDBCTemplate.getConnection();
	    int result = 0;
	    
	    try {
	        // 트랜잭션 시작
	        conn.setAutoCommit(false);
	        
	        // boxList를 이용하여 삭제 작업 수행
	        for (String letterNo : boxList) {
	            result += dao.letterDelete(conn, letterNo);
	        }
	        
	        // 트랜잭션 커밋
	        conn.commit();
	    } catch (Exception e) {
	        // 트랜잭션 롤백
	        JDBCTemplate.rollback(conn);
	        e.printStackTrace();
	    } finally {
	        // 트랜잭션 종료 및 커넥션 반환
	        JDBCTemplate.close(conn);
	    }
	    
	    return result;
	}
	
}











