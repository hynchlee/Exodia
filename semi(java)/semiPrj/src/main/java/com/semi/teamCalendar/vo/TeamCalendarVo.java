package com.semi.teamCalendar.vo;

public class TeamCalendarVo {
	private String teamCalendarNo;
	private String teamNo;
	private String startDate;
	private String endDate;
	private String meetingContent;

	public TeamCalendarVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamCalendarVo(String teamCalendarNo, String teamNo, String startDate, String endDate,
			String meetingContent) {
		super();
		this.teamCalendarNo = teamCalendarNo;
		this.teamNo = teamNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.meetingContent = meetingContent;
	}

	public String getTeamCalendarNo() {
		return teamCalendarNo;
	}

	public void setTeamCalendarNo(String teamCalendarNo) {
		this.teamCalendarNo = teamCalendarNo;
	}

	public String getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(String teamNo) {
		this.teamNo = teamNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMeetingContent() {
		return meetingContent;
	}

	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}

	@Override
	public String toString() {
		return "FullCalendarVo [teamCalendarNo=" + teamCalendarNo + ", teamNo=" + teamNo + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", meetingContent=" + meetingContent + "]";
	}

}
