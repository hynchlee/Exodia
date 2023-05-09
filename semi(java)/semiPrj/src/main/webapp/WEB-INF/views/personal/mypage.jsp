<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${root}/static/css/personal/mypage.css" type="text/css">
<style>
	
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<main>
		
		<table class="table01">
			<tr>
				<td colspan="2" class="td01">
					<div class="board">

					</div>
				</td>
				<td class="td01">
					<div class="profile">

					</div>
				</td>
			</tr>
			<tr>
				<td class="td01">
					<div class="date">

					</div>
				</td>
				<td class="td01">
					<div class="todo">

					</div>
				</td>
				<td class="td01">
					<div class="team">

					</div>
				</td>
			</tr>
		</table>

		<br>

		<table class="table02">
			<tr>
				<th class="th02">출결 현황</th>
				<th class="th02">세부 내역</th>
			</tr>
			<tr rowspan="5">
				<td class="td02">
					<div class="classdate">
						
					</div>
				</td>
				<td class="td02">
					<div class="datedetail">

					</div>
				</td>
			</tr>

		</table>


	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>