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
					<div class="tit">프로그래밍 언어 응용</div>
					<br><br><br><br>
					<% for(int j=0; j < 3; j++) { %>
						<div class="problem">
							<div class="score">
								<div class="a02">배점 : 2점</div>
							</div>
							<div class="b01">
								<% for(int i=0; i < 10; i++) { %>
									<div class="bb01">
										<div class="bbb01">
											1. 프로그래밍이란 ?
											<input type="checkbox" class="chk-box">
										</div>
										<div class="bbb02">
											모범답안 : 컴퓨터의 프로그램을 작성하는 일. 일반적으로는 프로그램의 작성 방법의 결정, 코딩(coding), 에러 수정 등의 작업
											모두를
											가리키지만 코딩만을 가리킬 떄도 있음.
										</div>
									</div>
									<% } %>
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
						<% } %>

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
			title.innerHTML = "시험 관리";
		</script>