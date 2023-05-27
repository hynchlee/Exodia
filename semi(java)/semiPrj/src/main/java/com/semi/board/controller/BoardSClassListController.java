package com.semi.board.controller;

import java.io.IOException;
import java.nio.channels.IllegalSelectorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.board.service.BoardService;
import com.semi.board.vo.BoardVo;
import com.semi.common.page.PageVo;
import com.semi.lecture.vo.LectureVo;
import com.semi.member.vo.MemberVo;
import com.semi.notice.vo.NoticeVo;

@WebServlet("/class/slist")
public class BoardSClassListController extends HttpServlet{

	private final BoardService bs = new BoardService();
	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
            MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
            LectureVo lectureVo = (LectureVo) session.getAttribute("lectureVo");

            if (loginMember == null) {
                throw new IllegalSelectorException();
            }

            String memberNo = loginMember.getMemberNo();
			
			
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");

			int cnt = bs.getBoardSClassListCnt(searchType, searchValue, memberNo);
			int page = Integer.parseInt(req.getParameter("page")); //현재 페이지 받아오기
			PageVo pv = new PageVo(cnt, page, 5, 10);
			
			List<BoardVo> cvoList = bs.getBoardClassList(pv, memberNo);
//			if (searchType == null || searchType.equals("")) {
//				
//			}else {
//				cvoList = bs.getBoardClassList(pv, searchType, searchValue, memberNo);
//			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
//			
//			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("cvoList", cvoList);
			req.getRequestDispatcher("/WEB-INF/views/board/boardSClassList.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[Error] class list error");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "우리반게시판 목록조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}