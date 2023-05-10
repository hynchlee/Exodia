<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/list.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main style="height: 1870px;">
					<div class="e98_1694"></div>
					<table class="list-tbl">
						<thead>
							<tr>
								<th>번호</th>
								<th>교과 구분</th>
								<th>능력단위명</th>
								<th>구분</th>
								<th>평가일</th>
								<th>점수</th>
								<th>평가 현황</th>
							</tr>
						</thead>
						<tbody>
							<% for(int i = 0; i < 20; i++) { %>
								<tr>
									<td>1</td>
									<td>NCS 전공교과</td>
									<td>SQL 활용</td>
									<td>서술형(신)</td>
									<td>2023.02.20</td>
									<td>94.00</td>
									<td>
										<button>평가완료</button>
										<button>결과확인</button>
										<button>확인완료</button>
									</td>
								</tr>
							<% } %>
						</tbody>
					</table>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>
		</html>

		<script>
			const title = document.querySelector('.title');
			title.innerHTML = "평가";
		</script>