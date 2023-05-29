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

        <div id="logo">
            <a href="${root}/main">
                <img src="${root}/static/img/header/4.png" alt="LOGO" id="logo-img">
            </a>
        </div>

        <form action="${root}/member/edit" method="post" enctype="multipart/form-data">

            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="memberId" value="${loginMember.memberId}" disabled></td>
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
                    <td><input type="text" name="memberNick" value="${loginMember.memberNick}" disabled></td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td><input type="text" name="birthNum" value="${loginMember.birthNum}" disabled></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="text" name="phoneNo" value="${loginMember.phoneNo}"></td>
                </tr>
                <tr>
                    <th>프로필 사진</th>
                    <td><input type="text" id="fileName-zone" value="${loginMember.profile}" disabled></td>
                    <td>
                        <div id="dup-check">
                            <label for="profile-file">파일첨부</label>
                            <input id="profile-file" type="file" name="profile" onchange="printName()">
                        </div>
                    </td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="수정하기">
                <button type="button" onclick="quit();">탈퇴</button>
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

    // //비번 입력해야 수정하기 활성
	// function checkValidation(){
	// 	const memberPwd = document.querySelector("input[name=memberPwd]").value;
    //     if(memberPwd.length >= 1){
    //         return true;
    //     }
    //     return false;
	// }

    //탈퇴
    function quit(){
        result = confirm('정말로 탈퇴하시겠습니까?');
        if(result) {
            location.href='${root}/member/quit';
        }
    }

</script>

