<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/pwdFind.css" rel="stylesheet">
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

        <form action="${root}/member/pwd/find" method="post">
            
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="memberId" placeholder="영어소문자/숫자 조합 4~12자리"></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="memberNick"></td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td><input type="text" name="birthNum" placeholder="숫자 8자리 입력"></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="text" name="phoneNo" placeholder="숫자 11자리 입력"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="비밀번호 찾기" onclick="return validate();">
                <!-- <a href="${root}/member/pwd/find2"><button>비밀번호 찾기</button></a> -->
            </div>

        </form>

    </div>

</body>
</html>

<script>

    //제약조건
    // function validate() {
    //     let memberId = document.querySelector('input[name=memberId]').value;
    //     let memberNick = document.querySelector('input[name=memberNick]').value;
    //     let birthNum = document.querySelector('input[name=birthNum]').value;
    //     let phoneNo = document.querySelector('input[name=phoneNo]').value;

    //     // 아이디 제약조건 - 영어소문자/숫자 조합 4~12자리
    //     if(!(/^[a-z\d]{4,12}$/.test(memberId))) {
    //         alert('유효한 아이디를 입력해주세요.');
            
    //         return false;
    //     }

    //      // 이름이 빈칸인지 확인
    //      if (memberNick.trim().length === 0) {
    //         alert("이름을 입력해주세요.");
    //         return false;
    //     }

    //     //생일 - 숫자 8자리
    //     if (!/^\d{8}$/.test(birthNum)) {
    //         alert("유효한 생년월일을 입력해주세요.");
    //         return false;
    //     }

    //     //전번 - 숫자 11자리
    //     if (!/^\d{11}$/.test(phoneNo)) {
    //         alert("유효한 휴대폰 번호를 입력해주세요.");
    //         return false;
    //     }

    //     return true;
    // }

</script>


