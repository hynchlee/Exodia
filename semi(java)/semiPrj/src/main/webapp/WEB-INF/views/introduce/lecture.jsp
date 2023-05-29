<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/introduce/lecture.css" rel="stylesheet">
		</head>


		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>

					<div class="wrap_1">
						<div class="menu_1">
							<a href="${root}/introduce/lecture?subject=1" class="e112">개발자 양성과정
							</a>
							<a href="${root}/introduce/lecture?subject=2" class="e112">정보보안 전문가
							</a>
						</div>
					</div>

					<div class="wrap_1">
						<div class="menu_2">
							<div class="curr1">
								<br><br><br>
								<img src="${root}/static/img/introduce/currmenu1.png" alt="logo">
								<br><br><br>
								<img src="${root}/static/img/introduce/curr1.png" alt="logo">
								<br><br><br>
								<img src="${root}/static/img/introduce/curr2.png" alt="logo">
							</div>
							<div class="curr2">
								<br><br><br>
								<img src="${root}/static/img/introduce/curr3.png" alt="logo">
							</div>
						</div>
					</div>
					<br><br><br><br>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			const curr1 = document.querySelector('.curr1');
			const curr2 = document.querySelector('.curr2');

			title.innerHTML = "강의 소개";

			const e112_List = document.querySelectorAll('.e112');

			for (let i = 0; i < e112_List.length; i++) {
				if ('${param.subject}' == i + 1) {
					e112_List[i].style.backgroundColor = 'rgba(104.70051661133766, 176.69292032718658, 228.4374949336052, 1)';
					e112_List[i].style.color = 'white';
				}
			}

			if ('${param.subject}' == 2) {
				curr1.style.display = 'none';
				curr2.style.display = 'block';
			} else {
				curr1.style.display = 'block';
				curr2.style.display = 'none';
			}
		</script>