package com.semi.lecture.vo;

public class ExamCategoryVo {
	private String examCategoryNo;
	private String lectureCategoryNo;
	private String lectureCategoryName;
	private String examSubject;
	private String status;
	private String enrollDate;

	public ExamCategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamCategoryVo(String examCategoryNo, String lectureCategoryNo, String lectureCategoryName,
			String examSubject, String status, String enrollDate) {
		super();
		this.examCategoryNo = examCategoryNo;
		this.lectureCategoryNo = lectureCategoryNo;
		this.lectureCategoryName = lectureCategoryName;
		this.examSubject = examSubject;
		this.status = status;
		this.enrollDate = enrollDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "ExamCategoryVo [examCategoryNo=" + examCategoryNo + ", lectureCategoryNo=" + lectureCategoryNo
				+ ", lectureCategoryName=" + lectureCategoryName + ", examSubject=" + examSubject + ", status=" + status
				+ ", enrollDate=" + enrollDate + "]";
	}

}