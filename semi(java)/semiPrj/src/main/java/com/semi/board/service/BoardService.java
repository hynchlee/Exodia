package com.semi.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.dao.BoardDao;
import com.semi.board.vo.AnswerVo;
import com.semi.board.vo.BoardVo;
import com.semi.board.vo.ReplyVo;
import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.lecture.vo.LectureVo;
import com.semi.mypage.dao.MypageDao;
import com.semi.notice.vo.NoticeVo;

public class BoardService {
	
	private final BoardDao dao = new BoardDao();

	//우리반 페이징
	public int getBoardClassListCnt(String lno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getBoardClassListCnt(conn,lno);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

//	//우리반 목록 조회
	public List<BoardVo> getBoardClassList(PageVo pv, String studentMemberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> cvoList = dao.getBoardClassList(conn,pv,studentMemberNo);
		
		JDBCTemplate.close(conn);
		
		return cvoList;
	}

////	//우리반 검색해서 목록 조회
//	public List<BoardVo> getBoardClassList(PageVo pv, String searchType, String searchValue) throws Exception {
//		
//		Connection conn = JDBCTemplate.getConnection();
//		
//		List<BoardVo> cvoList = dao.getBoardClassList(conn,pv,searchType,searchValue);
//		
//		JDBCTemplate.close(conn);
//		
//		return cvoList;
//	}

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
		
		BoardVo cvNo = null;
		//conn
		try (Connection conn = JDBCTemplate.getConnection();){
			//update
			int result = dao.increaseHit(conn , bno);
			
			if(result == 1) {
				//select
				cvNo = dao.getBoardByNo(conn , bno);
			}else {
				throw new Exception();
			}
		}
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

	//댓글
	public List<ReplyVo> getBoardReplyList(String bno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ReplyVo> revoList = dao.getBoardReplyList(conn, bno);
		
		JDBCTemplate.close(conn);
		
		return revoList;
	}

	//내가쓴글 목록 조회
	public List<BoardVo> getBoardMyList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> bvoList = dao.getBoardMyList(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return bvoList;
	}

	//내가 쓴글 검색 목록 조회
	public List<BoardVo> getBoardMyList(PageVo pv, String searchType, String searchValue) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> bvoList = dao.getBoardMyList(conn, pv, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return bvoList;
	}

	//페이징
	public int getBoardMyListCnt(String searchType, String searchValue, String mno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getBoardMyListCnt(conn, searchType, searchValue, mno);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//댓글쓰기
	public int replyWrite(ReplyVo revo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.replyWrite(conn, revo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//답글 조회
	public List<AnswerVo> getReplyAnswerList(String rno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<AnswerVo> answerList = dao.getReplyAnswerList(conn, rno);
		
		JDBCTemplate.close(conn);
		
		return answerList;
	}

	

	public int editReply(ReplyVo revo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.editReply(conn, revo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
	

	public List<BoardVo> getBoardTClassList(PageVo pv, String lno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardVo> tcvoList = dao.getBoardTClassList(conn,pv,lno);
		
		JDBCTemplate.close(conn);
		
		return tcvoList;
	}

//	public List<BoardVo> getBoardTClassList(PageVo pv, String searchType, String searchValue, String lno) throws Exception {
//
//		Connection conn = JDBCTemplate.getConnection();
//		
//		List<BoardVo> tcvoList = dao.getBoardTClassList(conn,pv,searchType, searchValue, lno);
//		
//		JDBCTemplate.close(conn);
//		
//		return tcvoList;
//	}

//	public List<BoardVo> getBoardSClassList(PageVo pv, String memberNo) throws Exception {
//		Connection conn = JDBCTemplate.getConnection();
//		
//		List<BoardVo> scvoList = dao.getBoardSClassList(conn,pv,memberNo);
//		
//		JDBCTemplate.close(conn);
//		
//		return scvoList;
//	}

	public int getBoardSClassListCnt(String studentMemberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getBoardSClassListCnt(conn,studentMemberNo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public String getStudentMemberNo(String memberNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String studentMemberNo = dao.getStudentMemberNo(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return studentMemberNo;
	}

	public int replyDelete(String rno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.replyDelete(conn, rno);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int answerWrite(AnswerVo avo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.answerWrite(conn, avo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}


}
