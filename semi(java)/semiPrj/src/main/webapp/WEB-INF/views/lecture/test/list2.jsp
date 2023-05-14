<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/list2.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main style="height: 2000px;">
					<div class="menubar">
						<select class="e98_1694">
							<option value="">반응형 UX/UI 웹컨텐츠 개발자 양성과정 A8</option>
							<option value="">반응형 UX/UI 웹컨텐츠 개발자 양성과정 A9</option>
						</select>
					</div>
					<table class="list-tbl">
						<thead>
							<tr>
								<th>번호</th>
								<th>교과 구분</th>
								<th>능력단위명</th>
								<th>구분</th>
								<th>평가일</th>
								<th>평가 현황</th>
							</tr>
						</thead>
						<tbody>
							<% for(int i = 0; i < 10; i++) { %>
								<tr>
									<td>1</td>
									<td>NCS 전공교과</td>
									<td>SQL 활용</td>
									<td>서술형(신)</td>
									<td>2023.02.20</td>
									<td>
										<a>시험시작</a>
										<a>시험종료</a>
										<a href="${root}/lecture/test/scoreList">시험채점</a>
									</td>
								</tr>
							<% } %>
						</tbody>
					</table>

					<div class="e112_1541">
						<button class="e112_1542"><<</button>
						<button class="e112_1543">1</button>
						<button class="e112_1544">2</button>
						<button class="e112_1545">3</button>
						<button class="e112_1546">4</button>
						<button class="e112_1547">5</button>
						<button class="e112_1547">>></button>
					</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>
		</html>

		<script>
			const title = document.querySelector('.title');
			title.innerHTML = "평가";
		</script>