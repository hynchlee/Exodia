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
			<div class="menu_1">
				<img src="${root}/static/img/header/image_2.png" alt="logo" class="logo_img">
				<div class="wrap">
					<div class="cate1">강의 정보</div>
					<div class="wrap_1">
						<table class="lecture-dtl">
							<tr>
								<td>강의명</th>
								<td>(스마트웹&콘텐츠개발) 반응형 UI/UX 웹콘텐츠 개발자 양성과정 A9</th>
							</tr>
							<tr>
								<td>강의실</td>
								<td>강남 3관 6층 362호</td>
							</tr>
							<tr>
								<td>강사</td>
								<td>심원용</td>
							</tr>
							<tr>
								<td>강의 기간</td>
								<td>2022 12 30 ~ 2023 08 16</td>
							</tr>
							<tr>
								<td id="last-td">강의 시간</td>
								<td id="last-td">15:30 ~ 22:00</td>
							</tr>
						</table>
					</div>

					<div class="cate2">커리큘럼</div>
					<div class="wrap_1">
						<img src="${root}/static/img/introduce/curr1.png" alt="logo" class="currImg">
					</div>
					<div class="hi"></div>
				</div>
			</div>



		</body>

		</html>