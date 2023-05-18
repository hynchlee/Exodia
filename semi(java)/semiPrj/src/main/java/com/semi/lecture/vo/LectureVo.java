package com.semi.lecture.vo;

public class LectureVo {
	private String lectureNo;
	private String teacherMemberNo;
	private String lectureCategoryNo;
	private String lectureStartTime;
	private String lectureFinishTime;
	private String lectureOpenDate;
	private String lectureCloseDate;
	private String status;
	private String teacherMemberName;
	private String lectureCategoryName;

	public LectureVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureVo(String lectureNo, String teacherMemberNo, String lectureCategoryNo, String lectureStartTime,
			String lectureFinishTime, String lectureOpenDate, String lectureCloseDate, String status,
			String teacherMemberName, String lectureCategoryName) {
		super();
		this.lectureNo = lectureNo;
		this.teacherMemberNo = teacherMemberNo;
		this.lectureCategoryNo = lectureCategoryNo;
		this.lectureStartTime = lectureStartTime;
		this.lectureFinishTime = lectureFinishTime;
		this.lectureOpenDate = lectureOpenDate;
		this.lectureCloseDate = lectureCloseDate;
		this.status = status;
		this.teacherMemberName = teacherMemberName;
		this.lectureCategoryName = lectureCategoryName;
	}

	public String getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(String lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getTeacherMemberNo() {
		return teacherMemberNo;
	}

	public void setTeacherMemberNo(String teacherMemberNo) {
		this.teacherMemberNo = teacherMemberNo;
	}

	public String getLectureCategoryNo() {
		return lectureCategoryNo;
	}

	public void setLectureCategoryNo(String lectureCategoryNo) {
		this.lectureCategoryNo = lectureCategoryNo;
	}

	public String getLectureStartTime() {
		return lectureStartTime;
	}

	public void setLectureStartTime(String lectureStartTime) {
		this.lectureStartTime = lectureStartTime;
	}

	public String getLectureFinishTime() {
		return lectureFinishTime;
	}

	public void setLectureFinishTime(String lectureFinishTime) {
		this.lectureFinishTime = lectureFinishTime;
	}

	public String getLectureOpenDate() {
		return lectureOpenDate;
	}

	public void setLectureOpenDate(String lectureOpenDate) {
		this.lectureOpenDate = lectureOpenDate;
	}

	public String getLectureCloseDate() {
		return lectureCloseDate;
	}

	public void setLectureCloseDate(String lectureCloseDate) {
		this.lectureCloseDate = lectureCloseDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeacherMemberName() {
		return teacherMemberName;
	}

	public void setTeacherMemberName(String teacherMemberName) {
		this.teacherMemberName = teacherMemberName;
	}

	public String getLectureCategoryName() {
		return lectureCategoryName;
	}

	public void setLectureCategoryName(String lectureCategoryName) {
		this.lectureCategoryName = lectureCategoryName;
	}

	@Override
	public String toString() {
		return "LectureVo [lectureNo=" + lectureNo + ", teacherMemberNo=" + teacherMemberNo + ", lectureCategoryNo="
				+ lectureCategoryNo + ", lectureStartTime=" + lectureStartTime + ", lectureFinishTime="
				+ lectureFinishTime + ", lectureOpenDate=" + lectureOpenDate + ", lectureCloseDate=" + lectureCloseDate
				+ ", status=" + status + ", teacherMemberName=" + teacherMemberName + ", lectureCategoryName="
				+ lectureCategoryName + "]";
	}

}
