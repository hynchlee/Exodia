package com.semi.lecture.vo;

public class SubmitAnswerVo {
	private String examCategoryNo;
	private String examSubject;
	private String memberNo;
	private String memberNick;
	private String score;
	private String examProblemNo;
	private String problem;
	private String submitAnswer;
	private String answer;
	private String problemPoint;
	private String scorePoint;

	public SubmitAnswerVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubmitAnswerVo(String examCategoryNo, String examSubject, String memberNo, String memberNick, String score,
			String examProblemNo, String problem, String submitAnswer, String answer, String problemPoint,
			String scorePoint) {
		super();
		this.examCategoryNo = examCategoryNo;
		this.examSubject = examSubject;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.score = score;
		this.examProblemNo = examProblemNo;
		this.problem = problem;
		this.submitAnswer = submitAnswer;
		this.answer = answer;
		this.problemPoint = problemPoint;
		this.scorePoint = scorePoint;
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

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getExamProblemNo() {
		return examProblemNo;
	}

	public void setExamProblemNo(String examProblemNo) {
		this.examProblemNo = examProblemNo;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSubmitAnswer() {
		return submitAnswer;
	}

	public void setSubmitAnswer(String submitAnswer) {
		this.submitAnswer = submitAnswer;
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

	public String getScorePoint() {
		return scorePoint;
	}

	public void setScorePoint(String scorePoint) {
		this.scorePoint = scorePoint;
	}

	@Override
	public String toString() {
		return "SubmitAnswerVo [examCategoryNo=" + examCategoryNo + ", examSubject=" + examSubject + ", memberNo="
				+ memberNo + ", memberNick=" + memberNick + ", score=" + score + ", examProblemNo=" + examProblemNo
				+ ", problem=" + problem + ", submitAnswer=" + submitAnswer + ", answer=" + answer + ", problemPoint="
				+ problemPoint + ", scorePoint=" + scorePoint + "]";
	}

}
