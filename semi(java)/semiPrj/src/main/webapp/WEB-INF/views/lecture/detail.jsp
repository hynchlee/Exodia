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

			<div class="wrap">
				<div class="cate1">강의 정보</div>

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

				<div class="cate2">커리큘럼</div>

				<table class="lecture-curr">
					<tr>
						<td rowspan="3">소프트웨어 개발언어 기본 문법</td>
						<td>프로그래밍 언어 활용</td>
						<td rowspan="3">JAVA</td>
					</tr>
					<tr>
						<td>프로그래밍 언어 응용</td>
					</tr>
					<tr>
						<td>네트워크 프로그래밍 구현</td>
					</tr>
					<tr>
						<td rowspan="3">SQL 활용 및 DB 설계</td>
						<td>데이터베이스 구현</td>
						<td rowspan="3">ORACLE</td>
					</tr>
					<tr>
						<td>SQL 활용</td>
					</tr>
					<tr>
						<td>SQL 활용</td>
					</tr>
					<tr>
						<td>OT / 수료식</td>
						<td>SQL 응용</td>
						<td></td>
					</tr>
				</table>



			</div>

			<img src="${root}/static/img/header/image_2.png" alt="logo" class="logo_img">
		</body>

		</html>