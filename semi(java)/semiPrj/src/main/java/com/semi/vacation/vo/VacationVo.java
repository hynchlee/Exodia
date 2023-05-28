package com.semi.vacation.vo;

public class VacationVo {

	private String vacationRequestListNo;
	private String memberNo;
	private String teacherName;
	private String lectureName;
	private String day;
	private String vacationStart;
	private String vacationEnd;
	private String status;
	private String reason;
	public String getVacationRequestListNo() {
		return vacationRequestListNo;
	}
	public void setVacationRequestListNo(String vacationRequestListNo) {
		this.vacationRequestListNo = vacationRequestListNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getVacationStart() {
		return vacationStart;
	}
	public void setVacationStart(String vacationStart) {
		this.vacationStart = vacationStart;
	}
	public String getVacationEnd() {
		return vacationEnd;
	}
	public void setVacationEnd(String vacationEnd) {
		this.vacationEnd = vacationEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public VacationVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VacationVo(String vacationRequestListNo, String memberNo, String teacherName, String lectureName, String day,
			String vacationStart, String vacationEnd, String status, String reason) {
		super();
		this.vacationRequestListNo = vacationRequestListNo;
		this.memberNo = memberNo;
		this.teacherName = teacherName;
		this.lectureName = lectureName;
		this.day = day;
		this.vacationStart = vacationStart;
		this.vacationEnd = vacationEnd;
		this.status = status;
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "VacationVo [vacationRequestListNo=" + vacationRequestListNo + ", memberNo=" + memberNo
				+ ", teacherName=" + teacherName + ", lectureName=" + lectureName + ", day=" + day + ", vacationStart="
				+ vacationStart + ", vacationEnd=" + vacationEnd + ", status=" + status + ", reason=" + reason + "]";
	}
	
	
	
}
