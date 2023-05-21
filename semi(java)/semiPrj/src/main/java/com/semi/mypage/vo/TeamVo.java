package com.semi.mypage.vo;

public class TeamVo {

	private String teamNo;
	private String teamName;
	private String teamCalenderNo;
	private String meetingDate;
	private String meetingContent;
	private String teamRoleNo;
	private String studentMemberNo;
	private String role;
	private String projectDivision;
	private String memberNick;
	
	public TeamVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamVo(String teamNo, String teamName, String teamCalenderNo, String meetingDate, String meetingContent,
			String teamRoleNo, String studentMemberNo, String role, String projectDivision, String memberNick) {
		super();
		this.teamNo = teamNo;
		this.teamName = teamName;
		this.teamCalenderNo = teamCalenderNo;
		this.meetingDate = meetingDate;
		this.meetingContent = meetingContent;
		this.teamRoleNo = teamRoleNo;
		this.studentMemberNo = studentMemberNo;
		this.role = role;
		this.projectDivision = projectDivision;
		this.memberNick = memberNick;
	}

	@Override
	public String toString() {
		return "TeamVo [teamNo=" + teamNo + ", teamName=" + teamName + ", teamCalenderNo=" + teamCalenderNo
				+ ", meetingDate=" + meetingDate + ", meetingContent=" + meetingContent + ", teamRoleNo=" + teamRoleNo
				+ ", studentMemberNo=" + studentMemberNo + ", role=" + role + ", projectDivision=" + projectDivision
				+ ", memberNick=" + memberNick + "]";
	}

	public String getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(String teamNo) {
		this.teamNo = teamNo;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	public String getTeamRoleNo() {
		return teamRoleNo;
	}

	public void setTeamRoleNo(String teamRoleNo) {
		this.teamRoleNo = teamRoleNo;
	}

	public String getStudentMemberNo() {
		return studentMemberNo;
	}

	public void setStudentMemberNo(String studentMemberNo) {
		this.studentMemberNo = studentMemberNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProjectDivision() {
		return projectDivision;
	}

	public void setProjectDivision(String projectDivision) {
		this.projectDivision = projectDivision;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	
}
