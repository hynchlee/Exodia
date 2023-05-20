package com.semi.admin.vo;

public class AdminVo {
	
	private String adminNo;
	private String adminId;
	private String adminPwd;
	private String adminNick;
	private String status;
	private String qualification;
	
	
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminNick() {
		return adminNick;
	}
	public void setAdminNick(String adminNick) {
		this.adminNick = adminNick;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
	@Override
	public String toString() {
		return "AdminVo [adminNo=" + adminNo + ", adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminNick="
				+ adminNick + ", status=" + status + ", qualification=" + qualification + "]";
	}
	
	
	public AdminVo(String adminNo, String adminId, String adminPwd, String adminNick, String status,
			String qualification) {
		super();
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminNick = adminNick;
		this.status = status;
		this.qualification = qualification;
	}
	
	
	public AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
