<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/introduce/teacher.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<% for (int i=0; i < 5; i++) { %>
						<div class="wrap_1">
							<div class="bigMenu">
								<% for (int j=0; j < 2; j++) { %>
									<div class="menu_1">
										<div class="pfl">
											<img src="${root}/static/img/introduce/___7.png" alt="logo"
												id="profile_img_1" class="profile_img">
											<div id="e98_1481" class="profile_name">심1용 강사</div>
										</div>

										<div id="e98_1" class="intro_div">
											現) KH정보교육원 강사 <br> 일단 해보자! <br> 할까 말까 고민이시라면 일단 해보세요. <br>
											시도하지 않으면 무조건 0, 일단 시작하면 1~99 입니다!
										</div>
									</div>
									<% } %>
							</div>
						</div>
						<br>
						<% } %>

						<br><br>
						<div class="wrap_1">
							<div class="bigMenu2">
								<div id="pageDiv">
									<button><<</button>
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
			title.innerHTML = "강사진 소개";
		</script>