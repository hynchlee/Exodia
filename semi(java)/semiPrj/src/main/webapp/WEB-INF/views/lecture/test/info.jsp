<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/lecture/test/info.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main style="height: 1870px;">
		<form class="e98_1694">
			<select>
				<option>제목</option>
				<option>작성자</option>
				<option>작성일자</option>				
			</select>
			<input type="text">
			<input type="submit" value="검색">
		</form>
		<table class="list-tbl">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일자</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < 10; i++) {
				%>
				<tr>
					<td>1</td>
					<td>프로그래밍 언어 응용</td>
					<td>ADMIN01</td>
					<td>YYYY-MM-DD 24:00</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>

<script>
	const title = document.querySelector('.title');
	title.innerHTML = "시험 정보";
</script>