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
								<option value="">제목</option>
								<option value="">작성자</option>
								<option value="">작성일자</option>
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
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일자</th>
								</tr>
							</thead>
							<tbody>
								<% for (int i=0; i < 10; i++) { %>
									<tr>
										<td>1</td>
										<td>프로그래밍 언어 응용</td>
										<td>ADMIN01</td>
										<td>YYYY-MM-DD 24:00</td>
									</tr>
									<% } %>
							</tbody>
						</table>
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
			const trArr = document.querySelectorAll('tr');

			for (const tr of trArr) {
				tr.addEventListener("click", function() {
					location.href = "${root}/lecture/test/manage";
				});
			}

			title.innerHTML = "시험 정보";
		</script>