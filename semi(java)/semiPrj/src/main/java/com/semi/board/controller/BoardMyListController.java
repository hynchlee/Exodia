package com.semi.board.controller;

import java.io.IOException;
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
import com.semi.member.vo.MemberVo;
import com.semi.notice.vo.NoticeVo;

@WebServlet("/my/list")
public class BoardMyListController extends HttpServlet{

	private final BoardService bs = new BoardService();
	//목록
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");

		String mno = null;
		if (loginMember != null) {
		    mno = loginMember.getMemberNo();
		} else {
		    // 로그인되지 않은 경우에 대한 처리
//		    req.setAttribute("errorMsg", "접근 권한 없음; 로그인해주세요");
//		    req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/member/login");
		}
		
		try {
					
				String searchType = req.getParameter("searchType");
				String searchValue = req.getParameter("searchValue");
	
				int cnt = bs.getBoardMyListCnt(searchType, searchValue, mno);
				int page = Integer.parseInt(req.getParameter("page")); //현재 페이지 받아오기
				PageVo pv = new PageVo(cnt, page, 5, 10);
				
				List<BoardVo> bvoList = bs.getBoardMyList(pv);
				if (searchType == null || searchType.equals("")) {
					bvoList = bs.getBoardMyList(pv);
				}else {
					bvoList = bs.getBoardMyList(pv, searchType, searchValue);
				}
				
				Map<String, String> map = new HashMap<>();
				map.put("searchType", searchType);
				map.put("searchValue", searchValue);
	//			
	//			//화면
				req.setAttribute("searchVo", map);
				req.setAttribute("pv", pv);
				req.setAttribute("bvoList", bvoList);
				req.getRequestDispatcher("/WEB-INF/views/board/boardMyList.jsp").forward(req, resp);
				
			} catch (Exception e) {
				System.out.println("[Error] my list error");
				e.printStackTrace();
				
				req.setAttribute("errorMsg", "내가쓴글 목록조회 실패");
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}
	}

}
