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
import com.semi.lecture.service.LectureService;
import com.semi.lecture.vo.LectureVo;
import com.semi.member.vo.MemberVo;
import com.semi.mypage.service.MypageService;
import com.semi.notice.vo.NoticeVo;

@WebServlet("/class/tlist")
public class BoardTClassListController extends HttpServlet {

    private final BoardService bs = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession();
            MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
            LectureVo lectureVo = (LectureVo) session.getAttribute("lectureVo");

            if (loginMember == null) {
                throw new IllegalSelectorException();
            }

            String memberNo = loginMember.getMemberNo();

            MypageService ms = new MypageService();
            LectureService ls = new LectureService();
            List<LectureVo> tvolist = ms.teacherLecture(memberNo);

            if (lectureVo == null) {
                lectureVo = tvolist.get(0);
                session.setAttribute("lectureVo", lectureVo);
            }

            List<MemberVo> volist = ls.getMemberList(lectureVo.getLectureNo());

            String searchType = req.getParameter("searchType");
            String searchValue = req.getParameter("searchValue");

            int cnt = bs.getBoardClassListCnt(searchType, searchValue, lectureVo.getLectureNo());
            int page = Integer.parseInt(req.getParameter("page")); // 현재 페이지 받아오기
            PageVo pv = new PageVo(cnt, page, 5, 10);

            // 강사 우리반 게시판 조회
            List<BoardVo> tcvoList = bs.getBoardTClassList(pv, lectureVo.getLectureNo());
//            if (searchType == null || searchType.equals("")) {
//                tcvoList = bs.getBoardTClassList(pv, lectureVo.getLectureNo());
//            } else {
//                tcvoList = bs.getBoardTClassList(pv, searchType, searchValue, lectureVo.getLectureNo());
//            }

            Map<String, String> map = new HashMap<>();
            map.put("searchType", searchType);
            map.put("searchValue", searchValue);

            req.setAttribute("volist", volist);
            req.setAttribute("tvolist", tvolist);
            req.setAttribute("searchVo", map);
            req.setAttribute("pv", pv);
            req.setAttribute("tcvoList", tcvoList);
            req.getRequestDispatcher("/WEB-INF/views/board/boardClassList.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("[Error] class list error");
            e.printStackTrace();

            req.setAttribute("errorMsg", "우리반게시판 목록조회 실패");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            LectureVo lectureVo = (LectureVo) session.getAttribute("lectureVo");

            String lectureNo = req.getParameter("lectureNo");
            LectureService ls = new LectureService();
            lectureVo = ls.getLectureOne(lectureNo);

            session.setAttribute("lectureVo", lectureVo);

            String lectureCategoryName = lectureVo.getLectureCategoryName();
            String lno = lectureVo.getLectureNo();

            req.setAttribute("lectureCategoryName", lectureCategoryName);
            req.setAttribute("lno", lno);
            req.getRequestDispatcher("/WEB-INF/views/board/boardClassList.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("우리반게시판 조회 중 발생");
            e.printStackTrace();

            req.setAttribute("errorMsg", "우리반게시판 조회중 에러발생");
            req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
        }
    }
}
