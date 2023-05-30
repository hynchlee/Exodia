package com.semi.introduce.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semi.common.db.JDBCTemplate;
import com.semi.common.page.PageVo;
import com.semi.introduce.dao.IntroduceDao;
import com.semi.member.vo.MemberVo;

public class IntroduceService {
	private IntroduceDao dao = new IntroduceDao();

	public List<MemberVo> getTeacherList(PageVo pageVo) throws SQLException {
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> teacherList = dao.getTeacherList(conn, pageVo);
		JDBCTemplate.close(conn);
		
		return teacherList;
	}
	
	public int getTeacherListCnt() throws SQLException {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.getTeacherListCnt(conn);

		JDBCTemplate.close(conn);
		return result;
	}

	public List<String> getCommentList() {
		List<String> commentList = new ArrayList<>();
		commentList.add("교육기간 동안 초심을 잃지 말고, 열심히 노력하면 좋은 결과가 있을 것입니다. 포기하지 마세요. 하면 됩니다.");
		commentList.add("해킹과 보안 분야로의 첫발을 내딛는 사람의 마음을 이해하고 함께 고민을 나누는 마음가짐으로 수강생 여러분들과 함께 나아가고자 합니다.");
		commentList.add("습득하지 못할 지식과 익힐 수 없는 기술은 없습니다.");
		commentList.add("당장 결과를 원하는 것보다, 차근차근 나 자신을 쌓아가며 완성합시다.");
		commentList.add("무엇이 되었든 같이 해결해 나갈 수 있도록 노력합시다.");
		commentList.add("결과에 대한 고민은 저한테 맡기고 부담 없이 도전하세요.");
		commentList.add("하루하루 항상 새롭게 시작하고, 프로그래머의 삶을 사는데 하루를 소중히 여깁시다. 항상 새로운 것을 배우는 자세를 유지했으면 합니다.");
		commentList.add("6개월 후 여러분은 기대한 바 이상으로 성장할 수 있습니다.");
		commentList.add("프로그래밍은 자신과의 끝없는 대화이다. 자기 자신과 매일 대화하며 성장하는 방법은 진실한 노력뿐 입니다. 끝까지 노력합시다.");
		commentList.add("이 글을 보고 있는 여러분, 도전하려는 마음을 먹었다면 반드시 3일 안에 결심을 행동으로 옮겨 성공에 한발짝 다가가 보세요.");
		commentList.add("유려한 프로그램 언어를 표현하기 위해서는 이해를 바탕으로 암기하여야 합니다. 많은 문법과 용어를 눈에 바르고, 손의 감각으로 익혀 숙련도를 높이십시오.");
		commentList.add("할까 말까 고민이시라면 일단 해보세요. 시도하지 않으면 무조건 0, 일단 시작하면 1~99 입니다!");
		commentList.add("방향을 틀어 남들이 가지 않는, 나만의 길을 걸으며 끈기있게 도전을 하는 내가 주인공인 삶을 살자.");
		commentList.add("프로그래밍에 있어 재능이라는것은 끊임 없는 반복 학습과 열정을 통해 만들어 지는 것 입니다. 포기하지 마십시오!");
		commentList.add("모든 로직은 머리속에서 나오고, 모든 미래는 손 끝에서 이루어 집니다. 자신이 행복한 프로그래머만이 모두가 행복한 미래를 만들 수 있습니다.");
		commentList.add("많은 학생들로부터 '선생님 설명을 들으면 이해가 되는데, 혼자 하려면 못하겠어요'라는 이야기를 자주 듣게 됩니다. 그 이유는 간단합니다. 프로그램은 공부가 아니라 기술의 습득이기 때문입니다. 손으로 많이 쳐보셔야 합니다.");
		commentList.add("공부하는 동안 어려움도 있고 힘든 일도 있습니다. 하지만 무던히 노력하다 보면 성장해 있는 나를 발견하게 될 것입니다.");
		commentList.add("새로운 시작을 앞둔 여러분들을 응원합니다. 그리고 그 옆에 저희가 있겠습니다. IT에 힘찬 새 걸음을 내딛으세요!");
		commentList.add("하고자 하는 의지만 있다면 IT전문가를 향한 초석을 탄탄하게 쌓아 올릴 수 있도록 도와드리겠습니다.");
		commentList.add("스스로 결정한 일이라면 어떤 어려움을 마주해도 극복할 수 있습니다.");
		
		return commentList;
	}
	
}
