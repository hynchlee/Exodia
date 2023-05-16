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
		<div class="e98_1694">SQL 활용</div>
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
				<%
				for (int i = 0; i < 10; i++) {
				%>
				<tr>
					<td>1</td>
					<td>심원용</td>
					<td>94.00</td>
					<td>
						<button onclick="scorePerson();">채점하기</button>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
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
	title.innerHTML = "평가";

	function scorePerson() {
		location.href="${root}/lecture/test/score";
	}
</script>