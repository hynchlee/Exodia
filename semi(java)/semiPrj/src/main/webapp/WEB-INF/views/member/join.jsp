<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/join.css" rel="stylesheet">
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

        <form action="${root}/member/join" method="post"  enctype="multipart/form-data">
            
            <div class="radio-area">
                <div class="identity-box">
                    <div id="radio-student">
                        <input type="radio" name="identity" value="S">
                        <label for="student">학생</label>
                    </div>
                    <div id="radio-teacher">
                        <input type="radio" name="identity" value="T">
                        <label for="teacher">강사</label>
                    </div>
                </div>
            </div>

            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="memberId" placeholder="영어/숫자 조합 n자리"></td>
                    <td><button id="dup-check">중복검사</button></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="memberPwd" placeholder="영어/숫자 조합 n자리"></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" name="memberPwd2"></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="memberNick"></td>
                </tr>
                <tr>
                    <th>주민등록번호</th>
                    <td><input type="text" name="birthNum" placeholder="숫자 13자리 입력"></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="phone" name="phoneNo"></td>
                </tr>
                <tr>
                    <th>프로필 사진</th>
                    <td><input type="text" id="fileName-zone" disabled></td>
                    <td>
                        <div id="file-attachment">
                            <label for="profile-file">파일첨부</label>
                            <input id="profile-file" type="file" name="profile" onchange="printName()">
                        </div>
                    </td>
                </tr>
            </table>

            <div>
                <input type="submit" value="회원가입">
            </div>

        </form>

    </div>

</body>
</html>

<script>

    //첨부파일 이름 출력
    function printName() {
        const file = document.querySelector("input[type=file]");
        const fileNameZone = document.querySelector("#fileName-zone");
        let fileName = '';

        if (file.files.length > 0) {
            fileName = file.files[0].name;
        }

        fileNameZone.value = fileName;
        console.log(fileName);
    };

</script>