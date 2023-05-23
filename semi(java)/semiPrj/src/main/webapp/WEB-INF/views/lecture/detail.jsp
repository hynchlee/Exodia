<%@page import="com.semi.lecture.vo.LectureVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/detail.css" rel="stylesheet">
		</head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		</head>

		<body>
			<% LectureVo vo = (LectureVo) request.getAttribute("lecture"); %>

			<div class="menu_1">
				<img src="${root}/static/img/header/4.png" alt="logo" class="logo_img">
				<div class="wrap">
					<div class="cate1">강의 정보</div>
					<div class="wrap_1">
						<table class="lecture-dtl">
							<tr>
								<td>강의명</td>
								<td>${lecture.lectureCategoryName}</td>
							</tr>
							<tr>
								<td>강의실</td>
								<td>강남 3관 6층 362호</td>
							</tr>
							<tr>
								<td>강사</td>
								<td>${lecture.teacherMemberName}</td>
							</tr>
							<tr>
								<td>강의 기간</td>
								<td>${lecture.lectureOpenDate} ~ ${lecture.lectureCloseDate}</td>
							</tr>
							<tr>
								<td id="last-td">강의 시간</td>
								<td id="last-td">${lecture.lectureStartTime} ~ ${lecture.lectureFinishTime}</td>
							</tr>
						</table>
					</div>

					<div class="cate2">커리큘럼</div>
					<div class="wrap_1">
						<% if(Integer.parseInt(vo.getLectureCategoryNo()) < 7) { %>
						<img src="${root}/static/img/introduce/curr1.png" alt="logo" class="currImg" onclick="showImageInNewWindow(this)">
						<% } else {%> 
						<img src="${root}/static/img/introduce/curr2.png" alt="logo" class="currImg" onclick="showImageInNewWindow(this)">
						<% } %>
					</div>
					<div class="hi"></div>
				</div>
			</div>
		</body>

		</html>

		<script>
			function showImageInNewWindow(imageElement) {
				var imageUrl = imageElement.getAttribute('src');
				var leftPosition = (window.screen.width - imageElement.naturalWidth) / 2;
				var topPosition = (window.screen.height - imageElement.naturalHeight) / 2;
				var windowFeatures = 'width=' + imageElement.naturalWidth + ',height=' + imageElement.naturalHeight + ',left=' + leftPosition + ',top=' + topPosition;
				window.open(imageUrl, '_blank', windowFeatures);
			}
		</script>