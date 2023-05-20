<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/manage.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<div class="tit">${problemList[0][0].examSubject}</div>
					<br><br><br><br>

					<c:forEach items="${problemList}" var="problems">
						<div class="problem">
							<div class="score">
								<div class="a02">${problems[0].problemPoint} 점</div>
							</div>
							<div class="b01">
								<c:forEach items="${problems}" var="p">
									<div class="bb01">
										<div class="bbb01">
											${p.problem}
											<input type="checkbox" class="chk-box">
										</div>
										<div class="bbb02">
											${p.answer}
										</div>
									</div>
								</c:forEach>
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
						</div>
						<br><br><br><br>
					</c:forEach>

					<div class="finish">
						<a href="${root}/lecture/test/info" class="finish-btn">수정</a>
					</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>

		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			title.innerHTML = "시험 관리";

			const pageBtn = document.querySelectorAll('.pageBtn');

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}
		</script>