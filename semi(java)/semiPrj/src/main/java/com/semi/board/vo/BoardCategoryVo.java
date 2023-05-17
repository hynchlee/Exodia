package com.semi.board.vo;

public class BoardCategoryVo {
	
	private String boardCategoryNo;
	private String boardCategoryType;
	public String getBoardCategoryNo() {
		return boardCategoryNo;
	}
	public void setBoardCategoryNo(String boardCategoryNo) {
		this.boardCategoryNo = boardCategoryNo;
	}
	public String getBoardCategoryType() {
		return boardCategoryType;
	}
	public void setBoardCategoryType(String boardCategoryType) {
		this.boardCategoryType = boardCategoryType;
	}
	@Override
	public String toString() {
		return "BoardCategoryVo [boardCategoryNo=" + boardCategoryNo + ", boardCategoryType=" + boardCategoryType + "]";
	}
	public BoardCategoryVo(String boardCategoryNo, String boardCategoryType) {
		super();
		this.boardCategoryNo = boardCategoryNo;
		this.boardCategoryType = boardCategoryType;
	}
	public BoardCategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
