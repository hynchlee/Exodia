<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>휴가원</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/member/vacationForm.css" rel="stylesheet">
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

        <form action="${root}/member/vacation/form" method="post" onsubmit="return (validate() && submitCheck())">
            
            <span><h1>휴 가 원</h1></span>

            <table>
                <tr>
                    <th>휴가일수</th>
                    <td><input id="vac-days" type="number" disabled>&nbsp; 일</td>
                </tr>
                <tr>
                    <th>휴가기간</th>
                    <td id="vac-period">
                        <input id="start-date" name="vacationStart" type="date"> ~ <input id="end-date" name="vacationEnd" type="date">
                    </td>
                </tr>
                <tr>
                    <th>휴가사유</th>
                    <td><input type="text" name="reason" placeholder="간단하게 작성해주세요"></td>
                </tr>
            </table>

            <div id="submit-box">
                <input type="submit" value="제출">
            </div>

        </form>

    </div>

</body>
</html>

<script>

    //달력 가공
    const endDate = document.querySelector('#end-date');
    const vacDays = document.querySelector('#vac-days');
    const startDate = document.querySelector('#start-date');

    const today = new Date();
    today.setMinutes(today.getMinutes() - today.getTimezoneOffset());
    const nowISOString = today.toISOString().split('T')[0];

    const tomorrow = new Date(today);
    tomorrow.setDate(today.getDate() + 1);
    const tomorrowISOString = tomorrow.toISOString().split('T')[0];

    startDate.min = tomorrowISOString;
    startDate.value = tomorrowISOString;
    endDate.min = tomorrowISOString;
    endDate.value = tomorrowISOString;

    const updateVacDays = () => {
        const days = (new Date(endDate.value) - new Date(startDate.value)) / (1000 * 60 * 60 * 24) + 1;
        vacDays.value = (!isNaN(days) && days >= 0) ? days : '';
    };

    const validateEndDate = () => {
        if (new Date(endDate.value) < new Date(startDate.value)) {
            endDate.value = startDate.value;
        }
    };

    startDate.addEventListener('input', () => {
        endDate.min = startDate.value;
        validateEndDate();
        updateVacDays();
    });

    endDate.addEventListener('input', () => {
        validateEndDate();
        updateVacDays();
    });

    updateVacDays();


    //제약조건
    function validate() {
        const vacDay = document.querySelector('#vac-days');
        let reason = document.querySelector('input[name=reason]').value;
        //잔여기간 보다 길면 제출 불가

        if (parseInt("${loginMember.leftVacation}") < vacDay.value) {
            alert("선택하신 기간이 잔여휴가보다 많습니다. 날짜를 다시 지정해주세요.");
            return false;
        }
        //사유 빈칸이면 제출 불가
        if (reason.trim().length === 0) {
            alert("사유를 입력해주세요.");
            return false;
        }

        return true;
    }

    function submitCheck() {
        if (confirm('제출 시 수정 및 취소 불가능합니다. 정말 제출하시겠습니까?')) {
            alert('제출되었습니다.');
            return true;
        } else {
            alert('제출이 취소되었습니다.');
            return false;
        }
    }

  </script>
  