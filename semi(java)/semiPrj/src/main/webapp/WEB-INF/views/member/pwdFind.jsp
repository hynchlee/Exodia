<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/pwdFind.css" rel="stylesheet">
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
                    <th>아이디</th>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <th>주민등록번호</th>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="text"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="비밀번호 찾기">
                <!-- <a href="${root}/member/pwd/find2"><button>비밀번호 찾기</button></a> -->
            </div>

        </form>

    </div>

</body>
</html>


