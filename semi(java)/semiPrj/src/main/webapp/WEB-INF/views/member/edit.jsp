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
                    <th>아이디</th>
                    <td><input type="text" placeholder="변경불가" disabled></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password"></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password"></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" placeholder="변경불가" disabled></td>
                </tr>
                <tr>
                    <th>주민등록번호</th>
                    <td><input type="text" placeholder="변경불가" disabled></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="text" placeholder="010-0000-0000"></td>
                </tr>
                <tr>
                    <th>닉네임</th>
                    <td><input type="text" placeholder="닉네임"></td>
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


