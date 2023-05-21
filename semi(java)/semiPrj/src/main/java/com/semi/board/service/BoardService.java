package com.semi.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.dao.BoardDao;
import com.semi.board.vo.BoardVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.notice.vo.NoticeVo;

public class BoardService {
	
	private final BoardDao dao = new BoardDao();

	//우리반 페이징
	public int getBoardClassListCnt(String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getBoardClassListCnt(conn, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//우리반 목록 조회
	public List<BoardVo> getBoardClassList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> cvoList = dao.getBoardClassList(conn,pv);
		
		JDBCTemplate.close(conn);
		
		return cvoList;
	}

	//우리반 검색해서 목록 조회
	public List<BoardVo> getBoardClassList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> cvoList = dao.getBoardClassList(conn,pv,searchType,searchValue);
		
		JDBCTemplate.close(conn);
		
		return cvoList;
	}

	//자유 페이징
	public int getBoardFreeListCnt(String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getBoardFreeListCnt(conn, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//자유 목록 조회
	public List<BoardVo> getBoardFreeList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> fvoList = dao.getBoardFreeList(conn,pv);
	
		JDBCTemplate.close(conn);
		
		return fvoList;
	}

	//자유 검색해서 목록 조회
	public List<BoardVo> getBoardFreeList(PageVo pv, String searchType, String searchValue) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> fvoList = dao.getBoardFreeList(conn,pv,searchType,searchValue);
		
		JDBCTemplate.close(conn);
		
		return fvoList;
	}

	//게시글 작성
	public int boardWrite(BoardVo bvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.boardWrite(conn, bvo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//조회
	public BoardVo getBoardByNo(String bno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수
		int result = dao.increaseHit(conn, bno);
		if (result != 1) {
			JDBCTemplate.rollback(conn);
			throw new Exception();
		}
		
		BoardVo cvNo = dao.getBoardByNo(conn,bno);
		
		JDBCTemplate.commit(conn);
		
		JDBCTemplate.close(conn);
		
		return cvNo;
	}
	
	//수정하기
	public int editBoard(BoardVo bvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.editBoard(conn, bvo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int boardDelete(String bno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.boardDelete(conn, bno);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
				
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
