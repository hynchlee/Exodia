package com.semi.letter.vo;

public class LetterVo {

	private String letterNo;
	private String sendMemberNo;
	private String sendMemberName;
	private String receiveMemberNo;
	private String receiveMemberName;
	private String letterTitle;
	private String letterContent;
	private String enrollDate;
	private String status;
	public String getLetterNo() {
		return letterNo;
	}
	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}
	public String getSendMemberNo() {
		return sendMemberNo;
	}
	public void setSendMemberNo(String sendMemberNo) {
		this.sendMemberNo = sendMemberNo;
	}
	public String getSendMemberName() {
		return sendMemberName;
	}
	public void setSendMemberName(String sendMemberName) {
		this.sendMemberName = sendMemberName;
	}
	public String getReceiveMemberNo() {
		return receiveMemberNo;
	}
	public void setReceiveMemberNo(String receiveMemberNo) {
		this.receiveMemberNo = receiveMemberNo;
	}
	public String getReceiveMemberName() {
		return receiveMemberName;
	}
	public void setReceiveMemberName(String receiveMemberName) {
		this.receiveMemberName = receiveMemberName;
	}
	public String getLetterTitle() {
		return letterTitle;
	}
	public void setLetterTitle(String letterTitle) {
		this.letterTitle = letterTitle;
	}
	public String getLetterContent() {
		return letterContent;
	}
	public void setLetterContent(String letterContent) {
		this.letterContent = letterContent;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LetterVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LetterVo(String letterNo, String sendMemberNo, String sendMemberName, String receiveMemberNo,
			String receiveMemberName, String letterTitle, String letterContent, String enrollDate, String status) {
		super();
		this.letterNo = letterNo;
		this.sendMemberNo = sendMemberNo;
		this.sendMemberName = sendMemberName;
		this.receiveMemberNo = receiveMemberNo;
		this.receiveMemberName = receiveMemberName;
		this.letterTitle = letterTitle;
		this.letterContent = letterContent;
		this.enrollDate = enrollDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "LetterVo [letterNo=" + letterNo + ", sendMemberNo=" + sendMemberNo + ", sendMemberName="
				+ sendMemberName + ", receiveMemberNo=" + receiveMemberNo + ", receiveMemberName=" + receiveMemberName
				+ ", letterTitle=" + letterTitle + ", letterContent=" + letterContent + ", enrollDate=" + enrollDate
				+ ", status=" + status + "]";
	}
	
}
