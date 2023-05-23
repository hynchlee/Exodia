package com.semi.attendance.vo;

public class AttendanceVo {

	private String attendanceDate;
	private String StudentMemberNo;
	private String checkInTime;
	private String checkOutTime;
	private String status;
	public AttendanceVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttendanceVo(String attendanceDate, String studentMemberNo, String checkInTime, String checkOutTime,
			String status) {
		super();
		this.attendanceDate = attendanceDate;
		StudentMemberNo = studentMemberNo;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.status = status;
	}
	@Override
	public String toString() {
		return "AttendanceVo [attendanceDate=" + attendanceDate + ", StudentMemberNo=" + StudentMemberNo
				+ ", checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime + ", status=" + status + "]";
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getStudentMemberNo() {
		return StudentMemberNo;
	}
	public void setStudentMemberNo(String studentMemberNo) {
		StudentMemberNo = studentMemberNo;
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
	
	
	
	
}
