<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/start.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main style="height: 2000px;">
					<div class="tit">
						<div class="tit1">요구사항 확인</div>
						
					</div>
					<% for(int i=0; i < 3; i++) { %>
						<div class="problem">
							<div>1. 다음과 같은 요구사항에 맞춰 구성하여 보고서 작성 후 제출하시오 (20점)</div>
							<br>
							<div class="hi">
								<textarea style="resize: none;" name="answer"></textarea>
								<input type="submit" value="저장">
							</div>
							<br><br>
						</div>
						<% } %>

						<br>
						<div class="finish">
							<button class="finish-btn">제출</button>
						</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			title.innerHTML = "시험";
		</script>