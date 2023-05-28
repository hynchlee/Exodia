package com.semi.vacation.service;

import java.sql.Connection;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.vacation.dao.VacationDao;
import com.semi.vacation.vo.VacationVo;


public class VacationService {

	private final VacationDao dao = new VacationDao();
	
	public int getVacationCnt(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.getVacationCnt(conn, no);

		JDBCTemplate.close(conn);

		return cnt;

	}

	public List<VacationVo> getVacationList(PageVo pv, String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		List<VacationVo> list = dao.getVacationList(conn, pv, no);

		JDBCTemplate.close(conn);

		return list;
	}

	public int getAdminVacationCnt() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();

		int cnt = dao.getVacationCnt(conn);

		JDBCTemplate.close(conn);

		return cnt;
		
	}

	public List<VacationVo> getAdminVacationList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();

		List<VacationVo> list = dao.getAdminVacationList(conn, pv);

		JDBCTemplate.close(conn);

		return list;
	}

}
