<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/lecture/test/result.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main>
		<div class="tit">
			<div class="tit1">${submitAnswerList[0].examSubject}</div>
			<div class="tit2">
				<span>심삼용&nbsp;</span> <span class="score">${submitAnswerList[0].score}</span> <span>점</span>
			</div>
		</div>
		<br> <br> <br> <br> <br>

		<%
		int i = 1;
		%>
		<c:forEach items="${submitAnswerList}" var="vo">

			<div class="problem">
				<div class="rere">
					<div><%=i%>. ${vo.problem} ([미구현]점)
					</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;[정답] (${vo.problemPoint}점)</div>
				</div>
				<br>
				<div class="hi">
					<textarea readonly style="resize: none;" name="answer"> ${vo.submitAnswer}</textarea>
					<textarea readonly style="resize: none;" name="answer"> ${vo.answer}</textarea>
				</div>
				<br> <br> <br>
			</div>
			<%
			i++;
			%>
		</c:forEach>

		<br>
		<div class="finish">
			<input type="submit" class="finish-btn" value="확인 완료">
		</div>

	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>

</html>

<script>
	const score = document.querySelector('.score');
	const title = document.querySelector('.title');
	title.innerHTML = "시험 결과";
</script>