<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/static/css/vacation/admin-vacation.css"
	rel="stylesheet">
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main>
		<div id="target">
			<div id="content"
				style="border: none; background-color: #F0F0F0; height: 40px;">
				<div></div>
				<div>신청자(아이디)</div>
				<div>수강강의</div>
				<div>담당강사</div>
				<div>신청기간</div>
				<div>일수</div>
				<div>사유</div>
				<div>상태</div>
			</div>
			<c:forEach items="${list}" var="vacation">
                <div id="content">
                        <div>
                        <c:if test="${vacation.status == null}">
                            <input type="checkbox" class="checkbox" value="${vacation.vacationRequestListNo}">
                        </c:if>
                        <c:if test="${vacation.status != null}">
                            <input type="checkbox" class="checkboxs" style="visibility:hidden">
                        </c:if>
                        </div>
                    <div>${vacation.studentName}(${vacation.studentId})</div>
                    <div>${vacation.lectureName}</div>
                    <div>${vacation.teacherName}</div>
                    <div>${vacation.vacationStart}-${vacation.vacationEnd}</div>
                    <div>${vacation.day}</div>
                    <div>${vacation.reason}</div>
                    <div>${vacation.status}</div>
                </div>
            </c:forEach>

			<div id="buttonDiv">
				<button id="approval" onclick="approval();">승인</button>
				<button id="refuse" onclick="refuse();">거절</button>
			</div>
			<div id="pageDiv">
                <c:if test="${pv.currentPage > 1 }">
				    <button onclick="pageMove('${pv.startPage}');"><<</button>
                </c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}"
					var="i">
					<button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
				</c:forEach>
                <c:if test="${pv.currentPage < pv.maxPage }">
				    <button onclick="pageMove('${pv.endPage}');">>></button>
                </c:if>
			</div>
		</div>
		<div style="height: 30px;"></div>
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>

</html>

<script>
            const title = document.querySelector(".title");
            title.innerHTML = "휴가 관리";

            const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/vacation/admin?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pv.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}

            function approval() {
				const checkboxes = document.querySelectorAll('.checkbox');
				var boxList = [];

				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
                    }
				}
                console.log(boxList);
				$.ajax({
					url: '/semi/approval/vacation',
					type: 'post',
					data: JSON.stringify(boxList),
					contentType: "application/json",
					success: function () {
						alert("휴가 승인 완료");
						location.reload();
					},
					error: function () {
						alert("에러");
					}
				});

			}

            function refuse() {
				const checkboxes = document.querySelectorAll('.checkbox');
				var boxList = [];

				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
                    }
				}
                console.log(boxList);
				$.ajax({
					url: '/semi/refuse/vacation',
					type: 'post',
					data: JSON.stringify(boxList),
					contentType: "application/json",
					success: function () {
						alert("휴가 취소 완료");
						location.reload();
					},
					error: function () {
						alert("에러");
					}
				});

			}

        </script>