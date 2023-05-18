package com.semi.lecture.vo;

public class TestInfoVo {
	private String examCategoryNo;
	private String lectureCategoryNo;
	private String lectureCategoryName;
	private String examSubject;

	public TestInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestInfoVo(String examCategoryNo, String lectureCategoryNo, String lectureCategoryName, String examSubject) {
		super();
		this.examCategoryNo = examCategoryNo;
		this.lectureCategoryNo = lectureCategoryNo;
		this.lectureCategoryName = lectureCategoryName;
		this.examSubject = examSubject;
	}

	public String getExamCategoryNo() {
		return examCategoryNo;
	}

	public void setExamCategoryNo(String examCategoryNo) {
		this.examCategoryNo = examCategoryNo;
	}

	public String getLectureCategoryNo() {
		return lectureCategoryNo;
	}

	public void setLectureCategoryNo(String lectureCategoryNo) {
		this.lectureCategoryNo = lectureCategoryNo;
	}

	public String getLectureCategoryName() {
		return lectureCategoryName;
	}

	public void setLectureCategoryName(String lectureCategoryName) {
		this.lectureCategoryName = lectureCategoryName;
	}

	public String getExamSubject() {
		return examSubject;
	}

	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}

	@Override
	public String toString() {
		return "TestInfoVo [examCategoryNo=" + examCategoryNo + ", lectureCategoryNo=" + lectureCategoryNo
				+ ", lectureCategoryName=" + lectureCategoryName + ", examSubject=" + examSubject + "]";
	}

}
