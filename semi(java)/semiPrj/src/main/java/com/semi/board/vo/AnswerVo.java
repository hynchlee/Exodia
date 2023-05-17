package com.semi.board.vo;

public class AnswerVo {
	
	private String answerNo;
	private String replyNo2;
	private String answerContent;
	private String enrollDate;
	private String modifyDate;
	private String status;
	public String getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(String answerNo) {
		this.answerNo = answerNo;
	}
	public String getReplyNo2() {
		return replyNo2;
	}
	public void setReplyNo2(String replyNo2) {
		this.replyNo2 = replyNo2;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AnswerVo [answerNo=" + answerNo + ", replyNo2=" + replyNo2 + ", answerContent=" + answerContent
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	public AnswerVo(String answerNo, String replyNo2, String answerContent, String enrollDate, String modifyDate,
			String status) {
		super();
		this.answerNo = answerNo;
		this.replyNo2 = replyNo2;
		this.answerContent = answerContent;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public AnswerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
