package com.semi.qna.vo;

public class QnaVo {
	
	private String qnaNo;
	private String adminNo;
	private String studentMemberNo;
	private String qnaTitle;
	private String qnaContent;
	private String qnaAnswer;
	private String enrollDate;
	private String modifyDate;
	private String photo;
	private String status;
	public String getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(String qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getStudentMemberNo() {
		return studentMemberNo;
	}
	public void setStudentMemberNo(String studentMemberNo) {
		this.studentMemberNo = studentMemberNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaAnswer() {
		return qnaAnswer;
	}
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QnaVo [qnaNo=" + qnaNo + ", adminNo=" + adminNo + ", studentMemberNo=" + studentMemberNo + ", qnaTitle="
				+ qnaTitle + ", qnaContent=" + qnaContent + ", qnaAnswer=" + qnaAnswer + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", photo=" + photo + ", status=" + status + "]";
	}
	public QnaVo(String qnaNo, String adminNo, String studentMemberNo, String qnaTitle, String qnaContent,
			String qnaAnswer, String enrollDate, String modifyDate, String photo, String status) {
		super();
		this.qnaNo = qnaNo;
		this.adminNo = adminNo;
		this.studentMemberNo = studentMemberNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaAnswer = qnaAnswer;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.photo = photo;
		this.status = status;
	}
	public QnaVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
