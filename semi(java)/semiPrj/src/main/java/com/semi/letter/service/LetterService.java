package com.semi.letter.service;

import java.sql.Connection;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.letter.dao.LetterDao;
import com.semi.letter.vo.LetterVo;
import com.semi.member.vo.MemberVo;

public class LetterService {

   public int writeLetter(LetterVo vo, MemberVo loginMember) throws Exception {
      Connection conn = JDBCTemplate.getConnection();

      LetterDao dao = new LetterDao();
      int result = dao.writeLetter(vo, conn, loginMember);

      JDBCTemplate.close(conn);

      return result;
   }

   public List<LetterVo> letterList() throws Exception {

      Connection conn = JDBCTemplate.getConnection();
      
      LetterDao dao = new LetterDao();
      List<LetterVo> voList = dao.letterList(conn);
      
      JDBCTemplate.close(conn);      
      
      return voList;
   }

}