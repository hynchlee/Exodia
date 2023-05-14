<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${root}/static/css/adminmenu/menu.css" type="text/css">
</head>
<body>

	<div class="wrap">
	
		<div class="logo"></div>
		
		<div class="t01">관리 메뉴</div>
	
		<div><a href="/회원관리페이지" class="a01">회원 관리</a></div>
		<div><a href="/휴가관리페이지" class="a02">휴가 관리</a></div>
		<div><a href="/시험관리페이지" class="a03">시험 관리</a></div>
		<div><a href="/강의관리페이지" class="a04">강의 관리</a></div>
		<div><a href="/게시판관리페이지" class="a05">게시판 관리</a></div>
		<div><a href="/배너관리페이지" class="a06">배너 관리</a></div>
	
	</div>


</body>
</html>