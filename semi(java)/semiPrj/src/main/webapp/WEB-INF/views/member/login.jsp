<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/login.css" rel="stylesheet">
</head>
<body>

	<div id="wrap">

        <form action="">
            
            <div id="logo">
                <img src="${root}/static/img/header/image_2.png" alt="LOGO">
            </div>

            <table>
                <tr>
                    <th id="id">아이디</th>
                </tr>
                <tr>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <th id="pwd">비밀번호</th>
                </tr>
                <tr>
                    <td><input type="password"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="로그인">
            </div>

            <div>
                
            </div>

        </form>

    </div>

</body>
</html>


