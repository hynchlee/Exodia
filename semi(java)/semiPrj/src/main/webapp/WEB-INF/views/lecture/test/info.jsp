<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/info.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<form action="${root}/lecture/test/info" method="get">
						<div class="wrap_1">
							<div class="menu_1">
								<select name="searchType">
									<option value="name">강의명</option>
									<option value="unit">단원</option>
								</select>
								<input type="text" class="searchValueElem e112_902" name="searchValue"
									value="${searchVo.searchValue}" placeholder="검색할내용">
								<input type="submit" id="searchButton" class="e112_909" value="검색하기">
							</div>
						</div>
					</form>
					<br> <br>

					<div class="wrap_1">
						<table class="e112_923">
							<thead>
								<tr>
									<th>번호</th>
									<th>강의명</th>
									<th>단원</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${examCategoryList}" var="vo">
									<tr>
										<td id="no">${vo.examCategoryNo}</td>
										<td>${vo.lectureCategoryName}</td>
										<td id="subject">${vo.examSubject}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br> <br>
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
			const trArr = document.querySelectorAll('tr');

			for (const tr of trArr) {
				tr.addEventListener("click", function () {
					const no = tr.querySelector('#no').innerText;
					const subject = tr.querySelector('#subject').innerText;
					location.href = "${root}/lecture/test/manage?no=" + no + "&subject=" + subject;
				});
			}

			title.innerHTML = "시험 정보";

			const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/lecture/test/info?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}
		</script>