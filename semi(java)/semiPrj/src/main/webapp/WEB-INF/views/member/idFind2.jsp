<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/idFind2.css" rel="stylesheet">
<style>
    #logo-img {
        width: 300px;
    }
</style>
</head>
<body>

	<div id="wrap">

        <form action="">
            
            <div id="logo">
                <a href="${root}/main">
                    <img src="${root}/static/img/header/4.png" alt="LOGO" id="logo-img">
                </a>
            </div>

            <table>
                <tr>
                    <th id="ment1">회원님의 아이디는</th>
                </tr>
                <tr>
                    <td><input type="text" value="${idFind.memberId}" disabled></td>
                </tr>
                <tr>
                    <th id="ment2">입니다</th>
                </tr>
            </table>

            <br>
            <br>

            <div>
                <a href="${root}/main"><b>홈으로</b></a>
                |
                <a href="${root}/member/login"><b>로그인</b></a>
            </div>

        </form>

    </div>

</body>
</html>


