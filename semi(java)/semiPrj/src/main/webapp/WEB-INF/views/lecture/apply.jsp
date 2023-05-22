<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/apply.css" rel="stylesheet">
		</head>


		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<form action="${root}/lecture/apply" method="get">
					<div class="wrap_1">
						<div class="menu_1">
								<select name="searchType">
									<option value="lectureOpenDate">개강일</option>
									<option value="teacher">강사</option>
									<option value="lectureCategoryName">과정명</option>
									<option value="lectureStartTime">수업시간</option>
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
									<th>지점</th>
									<th>개강일</th>
									<th>종강일</th>
									<th>강사</th>
									<th>과정명</th>
									<th>수업시간</th>
									<th>정원</th>
									<th>수강료</th>
									<th>상세보기</th>
									<th>수강신청</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${lectureList}" var="vo">
									<form action="${root}/lecture/apply" method="post">
										<tr>
											<input hidden type="text" name="lectureNo" value="${vo.lectureNo}">
											<td>강남</td>
											<td>${vo.lectureOpenDate}</td>
											<td>${vo.lectureCloseDate}</td>
											<td>${vo.teacherMemberName}</td>
											<td>${vo.lectureCategoryName}</td>
											<td>${vo.lectureStartTime}~${vo.lectureFinishTime}</td>
											<td>30</td>
											<td>국비지원</td>
											<td><button class="bbtn"
													onclick="goDetail(event, '${vo.lectureNo}')">상세조회</button></td>
											<td><input class="bbtn" type="submit" value="수강신청"></td>
										</tr>
									</form>
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
			title.innerHTML = "수강신청";

			function goDetail(event, lectureNo) {
				event.preventDefault();
				console.log(event.target);
				var leftPosition = (window.screen.width - 1200) / 2;
				var topPosition = (window.screen.height - 800) / 2;
				var windowFeatures = 'width=1200,height=800,left=' + leftPosition + ',top=' + topPosition;
				window.open("${root}/lecture/detail?lectureNo=" + lectureNo, '_blank', windowFeatures);
			}

			const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/lecture/apply?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}
		</script>