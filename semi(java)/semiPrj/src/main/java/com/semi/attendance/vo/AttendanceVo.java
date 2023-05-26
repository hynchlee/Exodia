package com.semi.attendance.vo;

public class AttendanceVo {

	private String attendanceDate;
	private String studentMemberNo;
	private String studentMemberName;
	private String checkInTime;
	private String checkOutTime;
	private String status;
	private String totalLectureMinutes;
	private String inLectureMinutes;
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getStudentMemberNo() {
		return studentMemberNo;
	}
	public void setStudentMemberNo(String studentMemberNo) {
		this.studentMemberNo = studentMemberNo;
	}
	public String getStudentMemberName() {
		return studentMemberName;
	}
	public void setStudentMemberName(String studentMemberName) {
		this.studentMemberName = studentMemberName;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotalLectureMinutes() {
		return totalLectureMinutes;
	}
	public void setTotalLectureMinutes(String totalLectureMinutes) {
		this.totalLectureMinutes = totalLectureMinutes;
	}
	public String getInLectureMinutes() {
		return inLectureMinutes;
	}
	public void setInLectureMinutes(String inLectureMinutes) {
		this.inLectureMinutes = inLectureMinutes;
	}
	public AttendanceVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttendanceVo(String attendanceDate, String studentMemberNo, String studentMemberName, String checkInTime,
			String checkOutTime, String status, String totalLectureMinutes, String inLectureMinutes) {
		super();
		this.attendanceDate = attendanceDate;
		this.studentMemberNo = studentMemberNo;
		this.studentMemberName = studentMemberName;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.status = status;
		this.totalLectureMinutes = totalLectureMinutes;
		this.inLectureMinutes = inLectureMinutes;
	}
	@Override
	public String toString() {
		return "AttendanceVo [attendanceDate=" + attendanceDate + ", studentMemberNo=" + studentMemberNo
				+ ", studentMemberName=" + studentMemberName + ", checkInTime=" + checkInTime + ", checkOutTime="
				+ checkOutTime + ", status=" + status + ", totalLectureMinutes=" + totalLectureMinutes
				+ ", inLectureMinutes=" + inLectureMinutes + "]";
	}
	
	
	
	
	
}
