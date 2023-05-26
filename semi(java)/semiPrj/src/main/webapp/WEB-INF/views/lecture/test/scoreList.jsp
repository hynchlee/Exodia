<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/scoreList.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
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
							<% int i=1; %>
								<c:forEach items="${memberList}" var="vo">
									<form action="${root}/lecture/test/score" method="post">
										<input hidden type="text" name="memberNo" value="${vo.memberNo}">
										<input hidden type="text" name="examCategoryNo"
											value="${problemBankVo.examCategoryNo}">
										<input hidden type="text" name="examSubject"
											value="${problemBankVo.examSubject}">
										<tr>
											<td>
												<%= i%>
											</td>
											<td>${vo.memberNick}</td>
											<td>${vo.score}</td>
											<td>
												<input type="submit" value="채점하기">
											</td>
										</tr>
									</form>
									<% i++; %>
								</c:forEach>
					</table>

					<br><br><br>
					<div class="finish">
						<form action="${root}/lecture/test/scoreList" method="post">
							<input type="text" hidden value="${memberList.get(0).examCategoryNo}" name="examCategoryNo">
							<input type="submit" value="채점 완료" class="finish-btn">
						</form>
					</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			title.innerHTML = "채점";
		</script>