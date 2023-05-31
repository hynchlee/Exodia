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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
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

        <form action="${root}/member/join" method="post" enctype="multipart/form-data" onsubmit="return (validateRadio() && validate());">
            
            <div class="radio-area">
                <div class="identity-box">
                    <div id="radio-student">
                        <input type="radio" id="student" name="identity" value="S">
                        <label for="student">학생</label>
                    </div>
                    <div id="radio-teacher">
                        <input type="radio" id="teacher" name="identity" value="T">
                        <label for="teacher">강사</label>
                    </div>
                </div>
            </div>

            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="memberId" placeholder="영어소문자/숫자 조합 4~12자리"></td>
                    <td><button id="dup-check" onclick="checkId();">중복검사</button></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="memberPwd" placeholder="영어소문자/숫자/특수문자 조합 8~15자리"></td>
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
                    <th>생년월일</th>
                    <td><input type="text" name="birthNum" placeholder="숫자 8자리 입력"></td>
                </tr>
                <tr>
                    <th>휴대폰 번호</th>
                    <td><input type="phone" name="phoneNo" placeholder="숫자 11자리 입력"></td>
                </tr>
                <tr>
                    <th>프로필 사진</th>
                    <td><input type="text" id="fileName-zone" placeholder="*선택사항" disabled></td>
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

    //중복검사 여부 확인
    let idChecked = false;
    let isIdAvailable = false;

    //아이디 중복검사
    function checkId() {
        const memberId = document.querySelector('input[name=memberId]');

        event.preventDefault();

        // 아이디 제약조건 - 영어소문자/숫자 조합 4~12자리
        if (!(/^[a-z\d]{4,12}$/.test(memberId.value))) {
            alert('유효한 아이디를 입력해주세요.');
            memberId.focus();
            return;
        }

        $.ajax({
            url : '/semi/member/join/idcheck',
            type : 'post' ,
            data : {
                memberId : memberId.value
            },
            success : function(data) {
                if (data == "ok"){
                    alert("사용 가능한 아이디 입니다.");
                    idChecked = true;
                    isIdAvailable = true;
                }else {
                    alert("사용 불가능한 아이디 입니다.");
                    idChecked = true;
                    isIdAvailable = false;
                    memberId.value = '';
                    memberId.focus();
                }
            },
            error : function(error) {
                alert("중복확인 에러 발생 ...");
                console.log(error);
                idChecked = false;
            },
        })
    }

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


    //신분 선택 필수 조건
    function validateRadio() {
        const radioStudent = document.querySelector('input[value="S"]');
        const radioTeacher = document.querySelector('input[value="T"]');

        if (radioStudent.checked === false && radioTeacher.checked === false) {
            alert('학생 또는 강사를 선택해주세요.');
            return false;
        }
        return true;
    }


    //제약조건
    function validate() {
        let memberId = document.querySelector('input[name=memberId]');
        let memberPwd = document.querySelector('input[name=memberPwd]');
        let memberPwd2 = document.querySelector('input[name=memberPwd2]');
        let memberNick = document.querySelector('input[name=memberNick]');
        let birthNum = document.querySelector('input[name=birthNum]');
        let phoneNo = document.querySelector('input[name=phoneNo]');

        // 아이디 제약조건 - 영어소문자/숫자 조합 4~12자리
        if(!(/^[a-z\d]{4,12}$/.test(memberId.value))) {
            alert('유효한 아이디를 입력해주세요.');
            return false;
        }

        //아이디 중복확인 여부
        if(!idChecked || !isIdAvailable) {
            alert("아이디 중복검사를 해주세요.");
            return false;
        }
        
        // 비번 제약조건 - 영어소문자/숫자/특수문자 조합 8~15자리
        if(!(/^[\w!@#$%^&*-]{8,15}$/.test(memberPwd.value))) {
            alert('유효한 비밀번호를 입력해주세요.');
            return false;
        }

        // 비밀번호 확인
        if(memberPwd.value != memberPwd2.value) {
            alert("비밀번호 일치여부를 확인해주세요.")
            memberPwd2.value = '';
            memberPwd2.focus();

            return false;
        }

        // 이름이 빈칸인지 확인
        if (memberNick.value.trim().length === 0) {
            alert("이름을 입력해주세요.");
            return false;
        }

        //생일 - 숫자 8자리
        if (!/^\d{8}$/.test(birthNum.value)) {
            alert("유효한 생년월일을 입력해주세요.");
            return false;
        }
        
        //전번 - 숫자 11자리
        if (!/^\d{11}$/.test(phoneNo.value)) {
            alert("유효한 휴대폰 번호를 입력해주세요.");
            return false;
        }

        return true;
    }

</script>