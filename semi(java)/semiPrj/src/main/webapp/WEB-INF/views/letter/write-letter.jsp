<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>
	<head>
		<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="${root}/static/css/letter/write-letter.css" rel="stylesheet">
		
	</head>
	<body>
		<%@ include file="/WEB-INF/views/common/header.jsp" %>

			<main>
				<div id="side-bar">
					<div>
						<div id="select-button">
							<img src="${root}/static/img/letter/쪽지 쓰기.png">
							<button id="write-letter">쪽지 쓰기</button>
						</div>
					</div>
					<div>
						<div id="select-button">
							<img src="${root}/static/img/letter/보낸 쪽지.png">
							<button id="sent-letter">보낸 쪽지</button>
						</div>

					</div>
					<div>
						<div id="select-button">
							<img src="${root}/static/img/letter/받은 쪽지.png">
							<button id="receive-letter">받은 쪽지</button>
						</div>

					</div>
					<div>
						<div id="select-button">
							<img src="${root}/static/img/letter/휴지통.png">
							<button id="trash-can">휴지통</button>
						</div>
					</div>
				</div>
				
				
				
			</main>

			<%@ include file="/WEB-INF/views/common/footer.jsp" %>

	</body>
	</html>

	<script>
		const title = document.querySelector(".title");
		title.innerHTML = "쪽지";
	</script>