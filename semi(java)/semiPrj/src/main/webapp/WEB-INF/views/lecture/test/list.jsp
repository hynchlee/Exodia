<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/lecture/test/list.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main>
		<div class="e98_1694">${examCategoryList[0].lectureCategoryName}</div>
		<br>
		<br>
		<table class="list-tbl">
			<thead>
				<tr>
					<th>번호</th>
					<th>단원</th>
					<th>구분</th>
					<th>평가일</th>
					<th>점수</th>
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
						<td></td>
						<td>
							<button onclick="testStart();">시험시작</button>
							<button onclick="testScore();">결과확인</button>
							<button>확인완료</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br>
		<br>
		<div class="wrap_1">
			<div class="menu_2">
				<div id="pageDiv">
					<button onclick="pageMove('${pageVo.startPage}');"><<</button>
					<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}"
						var="i">
						<button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
					</c:forEach>
					<button onclick="pageMove('${pageVo.endPage}');">>></button>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>

<script>
	const title = document.querySelector('.title');
	title.innerHTML = "평가";

	function testStart() {
		location.href = "${root}/lecture/test/start";
	}
	function testScore() {
		location.href = "${root}/lecture/test/score";
	}
	
	const pageBtn = document.querySelectorAll('.pageBtn');

	function pageMove(i) {
		location.href = "${root}/lecture/test/list?page=" + i;
	}

	for (let btn of pageBtn) {
		if (btn.innerHTML == '${pageVo.currentPage}') {
			btn.style.backgroundColor = '#4998D1';
			btn.style.color = 'white';
		}
	}
</script>