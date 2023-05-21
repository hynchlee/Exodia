<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/score.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<div class="tit">
						<div class="tit1">${submitAnswerList[0].examSubject}</div>
						<div class="tit2">
							<span>심삼용&nbsp;</span>
							<span class="score"></span>
							<span>점</span>
						</div>
					</div>
					<br><br><br><br><br>

					<% int i=1; %>
						<c:forEach items="${submitAnswerList}" var="vo">
							<div class="problem">
								<div>
									<%= i%>. ${vo.problem} (${vo.problemPoint}점)
								</div>
								<br>
								<div class="hi">
									<textarea style="resize: none;" name="answer">${vo.submitAnswer}</textarea>
									<input class="scoreInput" type="text" value="" placeholder="점수입력">
								</div>
								<br><br><br>
							</div>
							<% i++; %>
						</c:forEach>
						<br>

						<form action="${root}/lecture/test/scoreList" method="post">
							<input hidden type="text" name="examCategoryNo" value="${submitAnswerList[0].examCategoryNo}">
							<input hidden type="text" name="examSubject" value="${submitAnswerList[0].examSubject}">
							<input hidden type="text" name="memberNo" value="${submitAnswerList[0].memberNo}">
							<input hidden type="text" name="totalScore" value="0" class="ts">
							<div class="finish">
								<input class="finish-btn" type="submit" value="채점">
							</div>
						</form>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			const score = document.querySelector('.score');
			const ts = document.querySelector('.ts');

			title.innerHTML = "채점";

			var totalScore = 0;

			function scoreUpdate() {
				totalScore = 0;
				const scoreInputList = document.querySelectorAll('.scoreInput');
				for (const si of scoreInputList) {
					let v = 0;
					if (si.value == "") {
						v = 0;
					} else {
						v = parseInt(si.value);
					}
					totalScore += v;
				}
				score.innerText = totalScore;
				ts.value = totalScore;
			}

			setInterval(scoreUpdate, 100);

		</script>