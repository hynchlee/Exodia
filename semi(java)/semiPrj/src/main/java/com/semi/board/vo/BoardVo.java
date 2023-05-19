package com.semi.board.vo;

public class BoardVo {
	
	private String boardNo;
	private String boardCategoryNo;
	private String memberNo;
	private String boardTitle;
	private String boardContent;
	private String enrollDate;
	private String modifyDate;
	private String status;
	private String hit;
	
	private String writerNick;
	private String boardCategoryType;
	private String totalReplies;
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardCategoryNo() {
		return boardCategoryNo;
	}
	public void setBoardCategoryNo(String boardCategoryNo) {
		this.boardCategoryNo = boardCategoryNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
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
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public String getBoardCategoryType() {
		return boardCategoryType;
	}
	public void setBoardCategoryType(String boardCategoryType) {
		this.boardCategoryType = boardCategoryType;
	}
	public String getTotalReplies() {
		return totalReplies;
	}
	public void setTotalReplies(String totalReplies) {
		this.totalReplies = totalReplies;
	}
	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", boardCategoryNo=" + boardCategoryNo + ", memberNo=" + memberNo
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", status=" + status + ", hit=" + hit + ", writerNick=" + writerNick
				+ ", boardCategoryType=" + boardCategoryType + ", totalReplies=" + totalReplies + "]";
	}
	public BoardVo(String boardNo, String boardCategoryNo, String memberNo, String boardTitle, String boardContent,
			String enrollDate, String modifyDate, String status, String hit, String writerNick,
			String boardCategoryType, String totalReplies) {
		super();
		this.boardNo = boardNo;
		this.boardCategoryNo = boardCategoryNo;
		this.memberNo = memberNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
		this.hit = hit;
		this.writerNick = writerNick;
		this.boardCategoryType = boardCategoryType;
		this.totalReplies = totalReplies;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
