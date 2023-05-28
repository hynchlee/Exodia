package com.semi.calender.vo;

public class CalenderVo {

	private String teamCalenderNo;
	private String meetingDate;
	private String meetingContent;
	private String teamNo;
	
	//필요할 수도 있어서 부가적 추가.. 필요 없으면 제거
	private String studentMemberNo;
	private String teamName;
	
	public CalenderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CalenderVo(String teamCalenderNo, String meetingDate, String meetingContent, String teamNo,
			String studentMemberNo, String teamName) {
		super();
		this.teamCalenderNo = teamCalenderNo;
		this.meetingDate = meetingDate;
		this.meetingContent = meetingContent;
		this.teamNo = teamNo;
		this.studentMemberNo = studentMemberNo;
		this.teamName = teamName;
	}
	
	@Override
	public String toString() {
		return "CalenderVo [teamCalenderNo=" + teamCalenderNo + ", meetingDate=" + meetingDate + ", meetingContent="
				+ meetingContent + ", teamNo=" + teamNo + ", studentMemberNo=" + studentMemberNo + ", teamName="
				+ teamName + "]";
	}
	
	public String getTeamCalenderNo() {
		return teamCalenderNo;
	}
	public void setTeamCalenderNo(String teamCalenderNo) {
		this.teamCalenderNo = teamCalenderNo;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getMeetingContent() {
		return meetingContent;
	}
	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}
	public String getTeamNo() {
		return teamNo;
	}
	public void setTeamNo(String teamNo) {
		this.teamNo = teamNo;
	}
	public String getStudentMemberNo() {
		return studentMemberNo;
	}
	public void setStudentMemberNo(String studentMemberNo) {
		this.studentMemberNo = studentMemberNo;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
