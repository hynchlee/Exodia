<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/lecture/test/scoreList.css"
	rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main>
		<div class="e98_1694">${problemBankVo.examSubject}</div>
		<br><br>
		<table class="list-tbl">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>점수</th>
					<th>평가 현황</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memberList}" var="vo">
				<tr>
					<td>1</td>
					<td>${vo.memberNick}</td>
					<td></td>
					<td>
						<button onclick="scorePerson();">채점하기</button>
					</td>
				</tr>
				</c:forEach>
		</table>

		<br><br><br>
		<div class="finish">
			<a href="${root}/lecture/test/list2" class="finish-btn">채점 완료</a>
		</div>

	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>

<script>
	const title = document.querySelector('.title');
	title.innerHTML = "채점";

	function scorePerson() {
		location.href="${root}/lecture/test/score";
	}
</script>