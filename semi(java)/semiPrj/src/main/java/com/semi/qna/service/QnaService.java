package com.semi.qna.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.qna.dao.QnaDao;
import com.semi.qna.vo.QnaVo;

public class QnaService {
	
	private final QnaDao dao = new QnaDao();

	//페이징
	public int getQnaListCnt(String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getQnaListCnt(conn, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//목록 조회
	public List<QnaVo> getBoardQnaList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<QnaVo> qvoList = dao.getBoardQnaList(conn,pv);
		
		JDBCTemplate.close(conn);
		
		return qvoList;
	}

	//목록 검색해서 조회
	public List<QnaVo> getBoardQnaList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<QnaVo> qvoList = dao.getBoardQnaList(conn,pv,searchType,searchValue);
		
		JDBCTemplate.close(conn);
		
		return qvoList;
		
	}

	public QnaVo getQnaByNo(String qno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		QnaVo qvNo = dao.getQnaByNo(conn,qno);
		
		JDBCTemplate.close(conn);
		
		return qvNo;
	}

	//질문 작성
	public int qnaWrite(QnaVo qvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.qnaWrite(conn, qvo);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//질문 삭제
	public int qnaDelete(String qno) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.qnaDelete(conn, qno);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//질문 수정
	public int editQna(QnaVo qvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.editQna(conn, qvo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//답변 작성하기
	public int answerWriteQna(QnaVo qvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.answerWriteQna(conn, qvo);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	//답변 수정하기
	public int answerEditQna(QnaVo qvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.answerEditQna(conn, qvo);
		
		if (result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	
	public int adminBoardDelete(String[] bnoArr) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.adminBoardDelete(conn, bnoArr);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}



}
