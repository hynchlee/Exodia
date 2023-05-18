package com.semi.letter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.letter.service.LetterService;
import com.semi.letter.vo.LetterVo;

@WebServlet("/letter/receive")
public class ReceiveLetterController extends HttpServlet{
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
      try {
         LetterService bs = new LetterService();
         List<LetterVo> voList = bs.letterList();
         
         req.setAttribute("voList", voList);
         req.getRequestDispatcher("/WEB-INF/views/letter/receive-letter.jsp").forward(req, resp);
         
      } catch (Exception e) {
         System.out.println("받은 쪽지 조회중 에러 발생");
         e.printStackTrace();
         
         req.setAttribute("errorMsg", "받은 쪽지 조회 에러");
         req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
         
      }
   
   }

}