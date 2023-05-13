<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가원</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/vacationForm.css" rel="stylesheet">
</head>
<body>

	<div id="wrap">

        <form action="">
            
            <div id="logo">
                <a href="${root}/main">
                    <img src="${root}/static/img/header/image_2.png" alt="LOGO">
                </a>
            </div>

            <span><h1>휴 가 원</h1></span>

            <table>
                <tr>
                    <th>휴가일수</th>
                    <td><input id="vac-days" type="number">&nbsp; 일</td>
                </tr>
                <tr>
                    <th>휴가기간</th>
                    <td id="vac-period">
                        <input id="start-date" type="date"> ~ <input id="end-date" type="date">
                    </td>
                </tr>
                <tr>
                    <th>휴가사유</th>
                    <td><input type="text" placeholder="간단하게 작성해주세요"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="제출">
            </div>

        </form>

    </div>

</body>
</html>

