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
									<td></td>
									<td class="bbb">
										<button>시작</button>
										<button>종료</button>
										<form action="${root}/lecture/test/scoreList" method="post">
											<input hidden type="text" name="examCategoryNo" value="${vo.examCategoryNo}">
											<input hidden type="text" name="examSubject" value="${vo.examSubject}">
											<input type="submit" value="채점">
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<br><br>

					<div class="wrap_1">
						<div class="menu_2">
							<div id="pageDiv">
								<button onclick="pageMove('${pageVo.startPage}');">
									<<</button>
										<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="i">
											<button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
										</c:forEach>
										<button onclick="pageMove('${pageVo.endPage}');">>></button>
							</div>
						</div>
					</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
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