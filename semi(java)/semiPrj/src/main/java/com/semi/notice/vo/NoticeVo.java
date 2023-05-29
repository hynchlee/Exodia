package com.semi.notice.vo;

public class NoticeVo {
	
	private String noticeNo;
	private String adminNo;
	private String noticeTitle;
	private String noticeContent;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String status;
	private String adminNick;
	private String pin;
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdminNick() {
		return adminNick;
	}
	public void setAdminNick(String adminNick) {
		this.adminNick = adminNick;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", adminNo=" + adminNo + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate
				+ ", hit=" + hit + ", status=" + status + ", adminNick=" + adminNick + ", pin=" + pin + "]";
	}
	public NoticeVo(String noticeNo, String adminNo, String noticeTitle, String noticeContent, String enrollDate,
			String modifyDate, String hit, String status, String adminNick, String pin) {
		super();
		this.noticeNo = noticeNo;
		this.adminNo = adminNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.status = status;
		this.adminNick = adminNick;
		this.pin = pin;
	}
	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}