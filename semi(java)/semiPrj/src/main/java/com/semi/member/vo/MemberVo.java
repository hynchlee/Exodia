package com.semi.member.vo;

public class MemberVo {
	private String memberNo;
	private String memberId;
	private String memberPwd;
	private String memberNick;
	private String birthNum;
	private String status;
	private String phoneNo;
	private String signDate;
	private String profile;
	private String identity;
	private String leftVacation;
	private String mileage;
	private String role;
	private String projectDivision;
	private String teamNo;

	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVo(String memberNo, String memberId, String memberPwd, String memberNick, String birthNum,
			String status, String phoneNo, String signDate, String profile, String identity, String leftVacation,
			String mileage, String role, String projectDivision, String teamNo) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNick = memberNick;
		this.birthNum = birthNum;
		this.status = status;
		this.phoneNo = phoneNo;
		this.signDate = signDate;
		this.profile = profile;
		this.identity = identity;
		this.leftVacation = leftVacation;
		this.mileage = mileage;
		this.role = role;
		this.projectDivision = projectDivision;
		this.teamNo = teamNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getBirthNum() {
		return birthNum;
	}

	public void setBirthNum(String birthNum) {
		this.birthNum = birthNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getLeftVacation() {
		return leftVacation;
	}

	public void setLeftVacation(String leftVacation) {
		this.leftVacation = leftVacation;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProjectDivision() {
		return projectDivision;
	}

	public void setProjectDivision(String projectDivision) {
		this.projectDivision = projectDivision;
	}

	public String getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(String teamNo) {
		this.teamNo = teamNo;
	}

	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberNick=" + memberNick + ", birthNum=" + birthNum + ", status=" + status + ", phoneNo="
				+ phoneNo + ", signDate=" + signDate + ", profile=" + profile + ", identity=" + identity
				+ ", leftVacation=" + leftVacation + ", mileage=" + mileage + ", role=" + role + ", projectDivision="
				+ projectDivision + ", teamNo=" + teamNo + "]";
	}

}
