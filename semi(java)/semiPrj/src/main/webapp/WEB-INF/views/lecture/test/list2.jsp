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
				<main>
					<div class="menubar">
						<div class="e98_1694">${examCategoryList[0].lectureCategoryName}</div>
					</div>
					<br><br>

					<table class="list-tbl">
						<thead>
							<tr>
								<th>번호</th>
								<th>단원</th>
								<th>구분</th>
								<th>평가일</th>
								<th class="last-th">평가 현황</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${examCategoryList}" var="vo">
								<tr>
									<td id="no">${vo.examCategoryNo}</td>
									<td id="subject">${vo.examSubject}</td>
									<td>서술형(신)</td>
									<td>${vo.enrollDate}</td>
									<td class="bbb">
										<c:if test="${vo.status == null}">
											<form action="${root}/lecture/test/list2" method="post">
												<input hidden type="text" name="type" value="start">
												<input hidden type="text" name="examCategoryNo"
													value="${vo.examCategoryNo}">
												<input hidden type="text" name="lectureNo"
													value="${lectureVo.lectureNo}">
												<input type="submit" value="시작">
											</form>
										</c:if>
										<c:if test="${vo.status == 'X'}">
											<form action="${root}/lecture/test/list2" method="post">
												<input hidden type="text" name="type" value="end">
												<input hidden type="text" name="examCategoryNo"
													value="${vo.examCategoryNo}">
												<input hidden type="text" name="lectureNo"
													value="${lectureVo.lectureNo}">
												<input type="submit" value="종료" class="finInput">
											</form>
										</c:if>
										<c:if test="${vo.status == 'S'}">
											<form action="${root}/lecture/test/scoreList" method="get">
												<input hidden type="text" name="examCategoryNo"
													value="${vo.examCategoryNo}">
												<input hidden type="text" name="examSubject" value="${vo.examSubject}">
												<input type="submit" value="채점" class="scoreInput">
											</form>
										</c:if>
										<c:if test="${vo.status == 'O'}">
											<button class="fffooo">완료</button>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br><br>

					<div class="wrap_1">
						<div class="menu_2">
							<div id="pageDiv">
								<c:if test="${pageVo.currentPage > 1 }">
									<button onclick="pageMove('${pageVo.startPage}');">
										<<</button>
								</c:if>
								<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="i">
									<button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
								</c:forEach>
								<c:if test="${pageVo.currentPage < pageVo.maxPage }">
									<button onclick="pageMove('${pageVo.endPage}');">>></button>
								</c:if>
							</div>
						</div>
					</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			const finRed = document.querySelector('.finRed');
			title.innerHTML = "평가";

			const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/lecture/test/list2?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}
		</script>