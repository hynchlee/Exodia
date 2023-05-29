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

        <form action="${root}/member/pwd/renew" method="post">
            
            <table>
                <tr>
                    <th>새 비밀번호</th>
                    <td><input type="password" name="memberPwd" placeholder="영어/숫자 조합 n자리"></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" name="memberPwd2"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="비밀번호 재발급">
            </div>

        </form>

    </div>

</body>
</html>

<script>

    // //제약조건
    // function validate() {
    //     let memberPwd = document.querySelector('input[name=memberPwd]').value;
    //     let memberPwd2 = document.querySelector('input[name=memberPwd2]').value;
        
    //     // 비번 제약조건 - 영어소문자/숫자/특수문자 조합 8~15자리
    //     if(!(/^[\w!@#$%^&*-]{8,15}$/.test(memberPwd))) {
    //         alert('유효한 비밀번호를 입력해주세요.');
            
    //         return false;
    //     }

    //     // 비밀번호 확인
    //     if(memberPwd !== memberPwd2) {
    //         alert("동일한 비밀번호 값을 입력해주세요.")
    //         memberPwd2.value = '';
    //         memberPwd2.focus();

    //         return false;
    //     }

    //     return true;
    // }

</script>

