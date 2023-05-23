<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${root}/static/css/admin/adminMenu.css" type="text/css">
</head>
<body>

	<div class="wrap">
	
		<div class="logo"></div>
		
		<div class="t01">관리 메뉴</div>
	
		<div><a href="${root}/admin/member/manage" class="a01">회원 관리</a></div>
		<div><a href="${root}/vacation/admin" class="a02">휴가 관리</a></div>
		<div><a href="${root}/lecture/test/info" class="a03">시험 관리</a></div>
		<div><a href="${root}/lecture/manage" class="a04">강의 관리</a></div>
		<div><a href="${root}" class="a05">게시판 관리</a></div>
		<div><a href="${root}" class="a06">배너 관리</a></div>
	
	</div>


</body>
</html>