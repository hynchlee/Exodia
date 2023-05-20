<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/edit.css" rel="stylesheet">
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
                    <td><input type="text" name="memberId" placeholder="변경불가" disabled></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="memberPwd"></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" name="memberPwd2"></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="memberNick" placeholder="변경불가" disabled></td>
                </tr>
                <tr>
                    <th>주민등록번호</th>
                    <td><input type="text" name="birthNum" placeholder="변경불가" disabled></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="text" name="phoneNo" placeholder="010-0000-0000"></td>
                </tr>
                <tr>
                    <th>프로필 사진</th>
                    <td><input type="text" placeholder="사진명" disabled></td>
                    <td>
                        <div id="dup-check">
                            <label for="profile-file">파일첨부</label>
                            <input id="profile-file" type="file">
                        </div>
                    </td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="수정하기">
                <button id="quit" type="button" onclick="quit();">탈퇴</button>
            </div>

        </form>

    </div>

<script>

    function quit() {
        const result = confirm('정말로 탈퇴하실 건가요?');
        if(result) {
            location.href='${root}/member/quit';
        }
    }

</script>

</body>
</html>


