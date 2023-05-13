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
                <a href="${root}/main">
                    <img src="${root}/static/img/header/image_2.png" alt="LOGO">
                </a>
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
            
            <br>
            <br>

            <div>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
                    <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"/>
                </svg>
                <a href="${root}/member/id/find"><b>아이디 찾기</b></a>
                |
                <a href="${root}/member/pwd/find"><b>비밀번호 찾기</b></a>
            </div>

            <br>

            <div>
                아직 회원이 아니세요?
                ㅣ
                <a href="${root}/member/join"><b>회원가입하기</b></a>
            </div>

        </form>

    </div>

</body>
</html>


