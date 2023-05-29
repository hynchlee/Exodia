<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/idFind.css" rel="stylesheet">
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

        <form action="${root}/member/id/find" method="POST">

            <table>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="memberNick"></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="text" name="phoneNo" placeholder="숫자 11자리 입력"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="아이디 찾기" onclick="return validate();">
            </div>

        </form>

    </div>

</body>
</html>

<script>

    //제약조건
    function validate() {
        let memberNick = document.querySelector('input[name=memberNick]').value;
        let phoneNo = document.querySelector('input[name=phoneNo]').value;

        // 이름이 빈칸인지 확인
        if (memberNick.trim().length === 0) {
            alert("이름을 입력해주세요.");
            return false;
        }

        //전번 - 숫자 11자리
        if (!/^\d{11}$/.test(phoneNo)) {
            alert("유효한 휴대폰 번호를 입력해주세요.");
            return false;
        }

        return true;
    }

</script>


