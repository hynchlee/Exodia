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
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<form action="${root}/lecture/manage" method="get">
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
									<th>담당 강사</th>
									<th class="lname">과정명</th>
									<th>수업시간</th>
									<th>정원</th>
									<th>수강료</th>
									<th>상세보기</th>
									<th>선택</th>
								</tr>
							</thead>
							<tbody class="tbd">
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
										<td><button class="bbtn"
												onclick="goDetail(event, '${vo.lectureNo}')">상세조회</button></td>
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
								<button onclick="plusButton();">추가</button>
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
			const tbd = document.querySelector('.tbd');
			title.innerHTML = "강의 관리";

			function goDetail(event, lectureNo) {
				event.preventDefault();
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

			function modButton1() {
				var boxList = [];
				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				if (boxList.length == 0) {
					alert("수정할 강의를 선택해주세요");
					return;
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
					tds[5].innerHTML = '<select style="text-align:center; width: 100%; height: 80px;"> <c:forEach items="${lectureList}" var="vo"> <option value="${vo.lectureStartTime}~${vo.lectureFinishTime}">${vo.lectureStartTime}~${vo.lectureFinishTime}</option> </c:forEach> </select>';
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
					bList.push('mod');
					bList.push(tds[0].querySelector('input').value);
					bList.push(tds[1].querySelector('input').value);
					bList.push(tds[2].querySelector('input').value);
					bList.push(tds[3].querySelector('select').value);
					bList.push(tds[4].querySelector('select').value);
					bList.push(tds[5].querySelector('select').value);

					$.ajax({
						url: '/semi/lecture/manage',
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
				boxList.push('del');
				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				if (boxList.length == 1) {
					alert("삭제할 강의를 선택해주세요");
					return;
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

			function plusButton() {
				var txt = tbd.innerHTML;
				var plusTxt = '<tr class="newTr"> <td>강남</td> <td><input type="text" style="text-align:center; width: 100%; height: 76px;"></td> <td><input type="text" style="text-align:center; width: 100%; height: 76px;"></td> <td><select style="text-align:center; width: 100%; height: 80px;"> <c:forEach items="${lectureList}" var="vo"> <option value="${vo.teacherMemberNo}">${vo.teacherMemberName}</option> </c:forEach> </select></td> <td><select style="text-align:center; width: 100%; height: 80px;"> <c:forEach items="${lectureList}" var="vo"> <option value="${vo.lectureCategoryNo}">${vo.lectureCategoryName}</option> </c:forEach> </select></td> <td><select style="text-align:center; width: 100%; height: 80px;"> <c:forEach items="${lectureList}" var="vo"> <option value="${vo.lectureStartTime}~${vo.lectureFinishTime}">${vo.lectureStartTime}~${vo.lectureFinishTime}</option> </c:forEach> </select></td> <td>30</td> <td>국비지원</td> <td><button class="bbtn" onclick="goDetail(event, "${vo.lectureNo}")">상세조회</button></td> <td><button onclick="plusSave();">저장</button></td> </tr>';
				tbd.innerHTML = plusTxt + txt;
			}

			function plusSave() {
				var boxList = [];
				const newTr = document.querySelector('.newTr');
				var selectElements = newTr.querySelectorAll('select');
				var inputElements = newTr.querySelectorAll('input');

				boxList.push('plus');
				inputElements.forEach(function (inputElement) {
					boxList.push(inputElement.value);
				});
				selectElements.forEach(function (selectElement) {
					boxList.push(selectElement.value);
				});

				$.ajax({
					url: '/semi/lecture/manage',
					type: 'post',
					data: JSON.stringify(boxList),
					contentType: "application/json",
					success: function () {
						alert("강의 추가 완료");
						location.reload();
					},
					error: function () {
						alert("에러");
					}
				});
			}
		</script>