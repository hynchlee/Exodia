<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/manage.css" rel="stylesheet">
		</head>


		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<div class="wrap_1">
						<div class="menu_1">
							<select class="e112_901">
								<option value="">개강일</option>
								<option value="">지점</option>
								<option value="">진출분야</option>
								<option value="">과정명</option>
							</select> <input type="text" class="e112_902" placeholder="검색어">
							<button class="e112_909">검색</button>
						</div>
					</div>
					<br> <br>

					<div class="wrap_1">
						<table class="e112_923">
							<thead>
								<tr>
									<th>지점</th>
									<th>개강일</th>
									<th>종강일</th>
									<th>담당 강사</th>
									<th>과정명</th>
									<th>수업시간</th>
									<th>정원</th>
									<th>수강료</th>
									<th>현황</th>
									<th>상세보기</th>
									<th>수강신청</th>
									<th>선택</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${lectureList}" var="vo">
									<tr>
										<td>강남</td>
										<td>${vo.lectureOpenDate}</td>
										<td>${vo.lectureCloseDate}</td>
										<td>${vo.teacherMemberName}</td>
										<td>${vo.lectureCategoryName}</td>
										<td>${vo.lectureStartTime}~${vo.lectureFinishTime}</td>
										<td>30</td>
										<td>국비지원</td>
										<td><button>접수완료</button></td>
										<td><button onclick="goDetail()">상세조회</button></td>
										<td><button>수강신청</button></td>
										<td><input type="checkbox" class="checkbox" value="${vo.lectureNo}"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<br>
					<div class="wrap_1">
						<div class="menu_3">
							<div class="btn">
								<button>수정</button>
								<button id="deleteButton" onclick="delButton();">삭제</button>
								<button>추가</button>
							</div>
						</div>
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
			title.innerHTML = "강의 관리";

			function goDetail() {
				var leftPosition = (window.screen.width - 1200) / 2;
				var topPosition = (window.screen.height - 800) / 2;
				var windowFeatures = 'width=1200,height=800,left=' + leftPosition + ',top=' + topPosition;
				window.open("${root}/lecture/detail", '_blank', windowFeatures);
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

			function delButton() {
				const checkboxes = document.querySelectorAll('.checkbox');
				var boxList = [];

				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				$.ajax({
					url: '/semi/lecture/manage',
					type: 'post',
					data: JSON.stringify(boxList),
					contentType: "application/json",
					success: function () {
						alert("삭제완료");
						location.reload();
					},
					error: function () {
						alert("에러");
					}
				});

			}
		</script>