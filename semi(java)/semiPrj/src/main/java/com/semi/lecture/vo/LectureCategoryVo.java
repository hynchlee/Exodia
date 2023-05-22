package com.semi.lecture.vo;

public class LectureCategoryVo {
	
	private String lectureCategoryNo;
	private String lectureName;
	
	
	public String getLectureCategoryNo() {
		return lectureCategoryNo;
	}
	public void setLectureCategoryNo(String lectureCategoryNo) {
		this.lectureCategoryNo = lectureCategoryNo;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	
	
	@Override
	public String toString() {
		return "LectureCategoryVo [lectureCategoryNo=" + lectureCategoryNo + ", lectureName=" + lectureName + "]";
	}
	
	
	public LectureCategoryVo(String lectureCategoryNo, String lectureName) {
		super();
		this.lectureCategoryNo = lectureCategoryNo;
		this.lectureName = lectureName;
	}
	
	
	public LectureCategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
