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
</head>
<body>

	<div id="wrap">

        <form action="">
            
            <div id="logo">
                <img src="${root}/static/img/header/image_2.png" alt="LOGO">
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
                <input type="submit" value="확인">
            </div>

        </form>

    </div>

</body>
</html>


