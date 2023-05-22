package com.semi.vacation.vo;

public class VacationVo {

	private String vacationRequestListNo;
	private String memberNo;
	private String vacationStart;
	private String vacationEnd;
	private String status;
	
	public VacationVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VacationVo(String vacationRequestListNo, String memberNo, String vacationStart, String vacationEnd,
			String status) {
		super();
		this.vacationRequestListNo = vacationRequestListNo;
		this.memberNo = memberNo;
		this.vacationStart = vacationStart;
		this.vacationEnd = vacationEnd;
		this.status = status;
	}

	@Override
	public String toString() {
		return "VacationVo [vacationRequestListNo=" + vacationRequestListNo + ", memberNo=" + memberNo
				+ ", vacationStart=" + vacationStart + ", vacationEnd=" + vacationEnd + ", status=" + status + "]";
	}

	public String getVacationRequestListNo() {
		return vacationRequestListNo;
	}

	public void setVacationRequestListNo(String vacationRequestListNo) {
		this.vacationRequestListNo = vacationRequestListNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getVacationStart() {
		return vacationStart;
	}

	public void setVacationStart(String vacationStart) {
		this.vacationStart = vacationStart;
	}

	public String getVacationEnd() {
		return vacationEnd;
	}

	public void setVacationEnd(String vacationEnd) {
		this.vacationEnd = vacationEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}