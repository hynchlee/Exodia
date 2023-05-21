package com.semi.board.vo;

public class ReplyVo {
	
	private String replyNo;
	private String writerNo;
	private String boardNo;
	private String replyContent;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
	private String writerNick;

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}

	public String getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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

	public String getWriterNick() {
		return writerNick;
	}

	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}

	@Override
	public String toString() {
		return "ReplyVo [replyNo=" + replyNo + ", writerNo=" + writerNo + ", boardNo=" + boardNo + ", replyContent="
				+ replyContent + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status
				+ ", writerNick=" + writerNick + "]";
	}

	public ReplyVo(String replyNo, String writerNo, String boardNo, String replyContent, String enrollDate,
			String modifyDate, String status, String writerNick) {
		super();
		this.replyNo = replyNo;
		this.writerNo = writerNo;
		this.boardNo = boardNo;
		this.replyContent = replyContent;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.writerNick = writerNick;
	}

	public ReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
