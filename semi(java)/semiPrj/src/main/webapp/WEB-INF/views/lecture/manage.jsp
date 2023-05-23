<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/manage.css" rel="stylesheet">

		<style>
			input, select {
				margin: 0;
				padding: 0;
			}
		</style>
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
									<th class="lname">과정명</th>
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
									<tr class="tr${vo.lectureNo}">
										<td>강남</td>
										<td class="td" hidden>${vo.lectureNo}</td>
										<td class="td">${vo.lectureOpenDate}</td>
										<td class="td">${vo.lectureCloseDate}</td>
										<td class="td">${vo.teacherMemberName}</td>
										<td class="td">${vo.lectureCategoryName}</td>
										<td class="td">${vo.lectureStartTime}~${vo.lectureFinishTime}</td>
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
								<button class="modbtn1" onclick="modButton1();">수정</button>
								<button class="modbtn2" hidden onclick="modButton2();">저장</button>
								<button onclick="delButton();">삭제</button>
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
			const modbtn1 = document.querySelector('.modbtn1');
			const modbtn2 = document.querySelector('.modbtn2');
			const checkboxes = document.querySelectorAll('.checkbox');
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

			function modButton1() {
				var boxList = [];
				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				for (const chbox of boxList) {
					const tr = document.querySelector('.tr' + chbox);
					const tds = tr.querySelectorAll('.td');
	
					tds.forEach(td => {
						const txt = td.innerText;
						td.innerHTML = '<input style="text-align:center; width: 100%; height: 76px;" type="text" value="' + txt + '">';
					});
					tds[3].innerHTML = '<select style="text-align:center; width: 100%; height: 80px;"> <c:forEach items="${lectureList}" var="vo"> <option value="${vo.teacherMemberNo}">${vo.teacherMemberName}</option> </c:forEach> </select>';
					tds[4].innerHTML = '<select style="text-align:center; width: 100%; height: 80px;"> <c:forEach items="${lectureList}" var="vo"> <option value="${vo.lectureCategoryNo}">${vo.lectureCategoryName}</option> </c:forEach> </select>';
				}

				modbtn1.hidden = true;
				modbtn2.hidden = false;
			}

			function modButton2() {
				var boxList = [];
				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				for (const chbox of boxList) {
					const tr = document.querySelector('.tr' + chbox);
					const tds = tr.querySelectorAll('.td');
					var bList = [];

					
					bList.push(tds[0].querySelector('input').value);
					bList.push(tds[1].querySelector('input').value);
					bList.push(tds[2].querySelector('input').value);
					bList.push(tds[3].querySelector('select').value);
					bList.push(tds[4].querySelector('select').value);
					bList.push(tds[5].querySelector('input').value);
	
					$.ajax({
						url: '/semi/lecture/manage/modify',
						type: 'post',
						data: JSON.stringify(bList),
						contentType: "application/json",
						success: function () {
							location.reload();
						},
						error: function () {
							alert("에러");
						}
					});
				}
				
				alert("수정 완료");
				modbtn1.hidden = false;
				modbtn2.hidden = true;
			}

			function delButton() {
				var boxList = [];

				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				$.ajax({
					url: '/semi/lecture/manage/delete',
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