package com.semi.review.vo;

public class ReviewVo {
	
	private String reviewNo;
	private String memberNo;
	private String reviewTitle;
	private String reviewContent;
	private String enrollDate;
	private String modifyDate;
	private String photo;
	private String status;
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
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
		return "ReviewVo [reviewNo=" + reviewNo + ", memberNo=" + memberNo + ", reviewTitle=" + reviewTitle
				+ ", reviewContent=" + reviewContent + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate
				+ ", photo=" + photo + ", status=" + status + "]";
	}
	public ReviewVo(String reviewNo, String memberNo, String reviewTitle, String reviewContent, String enrollDate,
			String modifyDate, String photo, String status) {
		super();
		this.reviewNo = reviewNo;
		this.memberNo = memberNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.photo = photo;
		this.status = status;
	}
	public ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
