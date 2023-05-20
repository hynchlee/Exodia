package com.semi.lecture.vo;

public class ProblemBankVo {
	private String examProblemNo;
	private String examCategoryNo;
	private String examSubject;
	private String problem;
	private String answer;
	private String problemPoint;

	public ProblemBankVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProblemBankVo(String examProblemNo, String examCategoryNo, String examSubject, String problem, String answer,
			String problemPoint) {
		super();
		this.examProblemNo = examProblemNo;
		this.examCategoryNo = examCategoryNo;
		this.examSubject = examSubject;
		this.problem = problem;
		this.answer = answer;
		this.problemPoint = problemPoint;
	}

	public String getExamProblemNo() {
		return examProblemNo;
	}

	public void setExamProblemNo(String examProblemNo) {
		this.examProblemNo = examProblemNo;
	}

	public String getExamCategoryNo() {
		return examCategoryNo;
	}

	public void setExamCategoryNo(String examCategoryNo) {
		this.examCategoryNo = examCategoryNo;
	}

	public String getExamSubject() {
		return examSubject;
	}

	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getProblemPoint() {
		return problemPoint;
	}

	public void setProblemPoint(String problemPoint) {
		this.problemPoint = problemPoint;
	}

	@Override
	public String toString() {
		return "ProblemBankVo [examProblemNo=" + examProblemNo + ", examCategoryNo=" + examCategoryNo + ", examSubject="
				+ examSubject + ", problem=" + problem + ", answer=" + answer + ", problemPoint=" + problemPoint + "]";
	}

}
