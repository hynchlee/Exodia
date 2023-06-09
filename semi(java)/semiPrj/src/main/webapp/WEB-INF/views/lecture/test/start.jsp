<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/lecture/test/start.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main>
		<form action="${root}/lecture/test/start" method="post">
			<input hidden type="text" name="examCategoryNo" value= "${submitAnswerList[0].examCategoryNo}"> 
			<div class="tit">
				<div class="tit1">${submitAnswerList[0].examSubject}</div>
				<div class="tit2">
					<span>&nbsp;</span> <span class="score"></span> <span></span>
				</div>
			</div>
			<br> <br> <br> <br> <br>

			<%
			int i = 1;
			%>
			<c:forEach items="${submitAnswerList}" var="vo">
				<input hidden type="text" name="examProblemNo" value= "${vo.examProblemNo}"> 
				<div class="problem">
					<div>
						<%=i%>. ${vo.problem} (${vo.problemPoint}점)
					</div>
					<br>
					<div class="hi">
						<textarea style="resize: none;" name="answer">${vo.submitAnswer}</textarea>
					</div>
					<br> <br> <br>
				</div>
				<%
				i++;
				%>
			</c:forEach>

			<br>
			<div class="finish">
				<input type="submit" class="finish-btn" value="제출">
			</div>
		</form>
	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>

</html>

<script>
	const title = document.querySelector('.title');
	title.innerHTML = "시험";
</script>