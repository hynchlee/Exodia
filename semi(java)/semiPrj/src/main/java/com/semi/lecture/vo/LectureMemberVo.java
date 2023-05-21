package com.semi.lecture.vo;

import com.semi.member.vo.MemberVo;

public class LectureMemberVo extends MemberVo {
	private String score;
	private String examCategoryNo;

	public LectureMemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureMemberVo(String score, String examCategoryNo) {
		super();
		this.score = score;
		this.examCategoryNo = examCategoryNo;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getExamCategoryNo() {
		return examCategoryNo;
	}

	public void setExamCategoryNo(String examCategoryNo) {
		this.examCategoryNo = examCategoryNo;
	}

	@Override
	public String toString() {
		return "LectureMemberVo [score=" + score + ", examCategoryNo=" + examCategoryNo + "]";
	}

}
