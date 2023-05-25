package com.semi.board.vo;

public class BoardPhotoVo {

	private String boardPhotoNo;
	private String boardNo;
	private String photo;
	public String getBoardPhotoNo() {
		return boardPhotoNo;
	}
	public void setBoardPhotoNo(String boardPhotoNo) {
		this.boardPhotoNo = boardPhotoNo;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "BoardPhotoVo [boardPhotoNo=" + boardPhotoNo + ", boardNo=" + boardNo + ", photo=" + photo + "]";
	}
	public BoardPhotoVo(String boardPhotoNo, String boardNo, String photo) {
		super();
		this.boardPhotoNo = boardPhotoNo;
		this.boardNo = boardNo;
		this.photo = photo;
	}
	public BoardPhotoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
