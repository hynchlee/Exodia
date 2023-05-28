<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
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
							<input class="en" type="text" hidden value="${vo.examProblemNo}">
							<div class="problem">
								<div>
									<%= i%>. ${vo.problem} (${vo.problemPoint}점)
								</div>
								<br>
								<div class="hi">
									<textarea readonly style="resize: none;" name="answer">${vo.submitAnswer}</textarea>
									<input class="scoreInput" type="text" value="" placeholder="점수입력">
								</div>
								<br><br><br>
							</div>
							<% i++; %>
						</c:forEach>
						<br>

						<div class="finish">
							<button class="finish-btn" onclick="scoreButton();">채점</button>
						</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			const score = document.querySelector('.score');
			const enArr = document.querySelectorAll('.en');

			title.innerHTML = "채점";

			var totalScore = 0;
			var scoreList = [];

			function scoreUpdate() {
				scoreList = [];
				totalScore = 0;
				const scoreInputList = document.querySelectorAll('.scoreInput');
				for (const si of scoreInputList) {
					let v = 0;
					if (si.value != "") {
						scoreList.push(si.value);
						v = parseInt(si.value);
					}
					totalScore += v;
				}
				score.innerText = totalScore;
			}

			function scoreButton() {
				const params = [];
				const proNoList = [];
				params.push('${submitAnswerList[0].examCategoryNo}');
				params.push('${submitAnswerList[0].memberNo}');
				params.push('${submitAnswerList[0].examSubject}');
				params.push(score.innerText);

				for (const en of enArr) {
					proNoList.push(en.value);
				}

				$.ajax({
					url: '/semi/lecture/test/score',
					type: 'post',
					data: {
						params : JSON.stringify(params),
						proNoList : JSON.stringify(proNoList),
						scoreList : JSON.stringify(scoreList)
					},
					success: function () {
						alert("채점완료");
						location.href = "${root}/lecture/test/scoreList?examCategoryNo=" + params[0] + "&examSubject=" + params[2];
					},
					error: function () {
						alert("에러");
					}
				});
			}

			setInterval(scoreUpdate, 100);
		</script>