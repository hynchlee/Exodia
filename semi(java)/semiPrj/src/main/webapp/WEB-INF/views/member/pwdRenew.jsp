<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재발급</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/pwdRenew.css" rel="stylesheet">
<style>
    #logo-img {
        width: 300px;
    }
</style>
</head>
<body>

	<div id="wrap">

        <div id="logo">
            <a href="${root}/main">
                <img src="${root}/static/img/header/4.png" alt="LOGO" id="logo-img">
            </a>
        </div>

        <form action="${root}/member/pwd/renew" method="post">
            
            <table>
                <tr>
                    <th>새 비밀번호</th>
                    <td><input type="password"></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="비밀번호 재발급">
            </div>

        </form>

    </div>

</body>
</html>


