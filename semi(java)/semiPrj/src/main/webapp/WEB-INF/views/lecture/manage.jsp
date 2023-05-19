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
							</select>
							<input type="text" class="e112_902" placeholder="검색어">
							<button class="e112_909">검색</button>
						</div>
					</div>
					<br><br>

					<div class="wrap_1">
						<table class="e112_923">
							<thead>
								<tr>
									<th>개강일</th>
									<th>지점</th>
									<th>진출분야</th>
									<th>과정명</th>
									<th>회차</th>
									<th>정원</th>
									<th>수강료</th>
									<th>현황</th>
									<th>상세보기</th>
									<th>수강신청</th>
									<th>선택</th>
								</tr>
							</thead>
							<tbody>
								<% for(int i=0; i < 10; i++) {%>
									<tr>
										<td>YYYY-MM-DD</td>
										<td>강남</td>
										<td>자바개발자</td>
										<td>공공데이터 융합 자바개발자 양성과정</td>
										<td>1</td>
										<td>30</td>
										<td>국비지원</td>
										<td><button>접수완료</button></td>
										<td><button onclick="goDetail()">상세조회</button></td>
										<td><button>수강신청</button></td>
										<td><input type="checkbox"></td>
									</tr>
									<% } %>
							</tbody>
						</table>
					</div>

					<br>
					<div class="wrap_1">
						<div class="menu_3">
							<div class="btn">
								<button>수정</button>
								<button>삭제</button>
								<button>추가</button>
							</div>
						</div>
					</div>

					<br><br>

					<div class="wrap_1">
						<div class="menu_2">
							<div id="pageDiv">
								<button>
									<<</button>
										<button>1</button>
										<button>2</button>
										<button>3</button>
										<button>4</button>
										<button>5</button>
										<button>>></button>
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
		</script>