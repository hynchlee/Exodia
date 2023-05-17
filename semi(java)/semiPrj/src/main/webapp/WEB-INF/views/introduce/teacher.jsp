<%@page import="com.semi.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/introduce/teacher.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main style="height: 1220px">
		<%
		List<MemberVo> teacherList = (List<MemberVo>) request.getAttribute("teacherList");
		%>

		<%
		for (int i = 0; i < teacherList.size(); i = i + 2) {
		%>
		<div class="wrap_1">
			<div class="bigMenu">
				<div class="menu_1">
					<div class="pfl">
						<img src="${root}/static/img/introduce/___7.png" alt="logo"
							id="profile_img_1" class="profile_img">
						<div id="e98_1481" class="profile_name"><%=teacherList.get(i).getMemberNick() %></div>
					</div>

					<div id="e98_1" class="intro_div">
						現) KH정보교육원 강사 <br> 일단 해보자! <br> 할까 말까 고민이시라면 일단 해보세요. <br>
						시도하지 않으면 무조건 0, 일단 시작하면 1~99 입니다!
					</div>
				</div>
				<% if(i + 1 < teacherList.size()) {%>
				<div class="menu_1">
					<div class="pfl">
						<img src="${root}/static/img/introduce/___7.png" alt="logo"
							id="profile_img_1" class="profile_img">
						<div id="e98_1481" class="profile_name"><%=teacherList.get(i+1).getMemberNick() %></div>
					</div>

					<div id="e98_1" class="intro_div">
						現) KH정보교육원 강사 <br> 일단 해보자! <br> 할까 말까 고민이시라면 일단 해보세요. <br>
						시도하지 않으면 무조건 0, 일단 시작하면 1~99 입니다!
					</div>
				</div>
				<% } %>
			</div>
		</div>
		<br><br><br>
		<%
		}
		%>
		<br> <br> <br>
		<div class="wrap_1">
			<div class="bigMenu2">
				<div id="pageDiv">
					<button onclick="pageMove('${pageVo.startPage}');"><<</button>
					<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}"
						var="i">
						<button onclick="pageMove('${i}');">${i}</button>
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
	title.innerHTML = "강사진 소개";

	function pageMove(i) {
		location.href = "${root}/introduce/teacher?page=" + i;
	}
</script>