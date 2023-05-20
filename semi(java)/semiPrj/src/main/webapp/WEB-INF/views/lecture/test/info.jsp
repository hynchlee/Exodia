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
					<div class="wrap_1">
						<div class="menu_1">
							<select class="e112_901">
								<option value="">강의</option>
								<option value="">단원</option>
								<option value="">작성자</option>
								<option value="">작성일자</option>
							</select> <input type="text" class="e112_902" placeholder="검색어">
							<button class="e112_909">검색</button>
						</div>
					</div>
					<br> <br>

					<div class="wrap_1">
						<table class="e112_923">
							<thead>
								<tr>
									<th>번호</th>
									<th>강의</th>
									<th>단원</th>
									<th>수정자</th>
									<th>수정 일자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${examCategoryList}" var="vo">
									<tr>
										<td id="no">${vo.examCategoryNo}</td>
										<td>${vo.lectureCategoryName}</td>
										<td id="subject">${vo.examSubject}</td>
										<td>ADMIN01</td>
										<td>YYYY-MM-DD 24:00</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br> <br>
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