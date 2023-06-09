<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/admin/adminLogin.css" rel="stylesheet">
<style>
    #logo-img {
        width: 300px;
    }
</style>
</head>
<body>

    <c:if test="${ not empty alertMsg }">
        <script>
           alert('${alertMsg}');
        </script>
     </c:if>
     <c:remove var="alertMsg" scope="session" />

	<div id="wrap">

        <div id="logo">
            <a href="${root}/main">
                <img src="${root}/static/img/header/4.png" alt="LOGO" id="logo-img">
            </a>
        </div>

        <form action="${root}/admin/login" method="post">
            
            <table>
                <tr>
                    <th id="id">관리자 아이디</th>
                </tr>
                <tr>
                    <td><input type="text" name="adminId"></td>
                </tr>
                <tr>
                    <th id="pwd">비밀번호</th>
                </tr>
                <tr>
                    <td><input type="password" name="adminPwd"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="관리자 로그인">
            </div>
            
        </form>

            <!-- <br><br>

            <div>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
                    <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z"/>
                </svg>
                <a href="${root}/member/id/find"><b>아이디 찾기</b></a>
                |
                <a href="${root}/member/pwd/find"><b>비밀번호 찾기</b></a>
            </div> -->

    </div>

</body>
</html>


