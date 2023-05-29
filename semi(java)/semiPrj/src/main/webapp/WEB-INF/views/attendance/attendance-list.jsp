<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/static/css/attendance/attendance-list.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main>
		<div id="target">
			<div id="content">
				<div>일자</div>
				<div>입실시간</div>
				<div>퇴실시간</div>
				<div>수업시간</div>
				<div>실수업시간</div>
				<div>출결상태</div>
			</div>
            <c:forEach items="${list}" var="attendance">
                <div id="content">
                    <div>${attendance.attendanceDate}</div>
                    <div>${attendance.checkInTime}</div>
                    <div>
                        <c:choose>
                            <c:when test="${attendance.inLectureMinutes == null}">
                                ----
                            </c:when>
                            <c:otherwise>
                                ${attendance.checkOutTime}
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div>${attendance.totalLectureMinutes}</div>
                    <div>
                        <c:choose>
                            <c:when test="${attendance.inLectureMinutes == null}">
                                ----
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${attendance.inLectureMinutes > attendance.totalLectureMinutes}">
                                        ${attendance.totalLectureMinutes}
                                    </c:when>
                                    <c:otherwise>
                                        ${attendance.inLectureMinutes}
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div>${attendance.status}</div>
                </div>
            </c:forEach>
			<div id="pageDiv">
				<td id="pageTd" colspan="4">
                    <c:if test="${pageVo.currentPage > 1 }">
					    <button onclick="pageMove('${pageVo.startPage}');"><<</button> 
                    </c:if>
                    <c:forEach
						begin="${pageVo.startPage}" end="${pageVo.endPage}" var="i">
						<button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
					</c:forEach>
                    <c:if test="${pageVo.currentPage < pageVo.maxPage }">
					    <button onclick="pageMove('${pageVo.endPage}');">>></button>
                    </c:if>
				</td>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>

</html>

<script>
            const title = document.querySelector(".title");
            title.innerHTML = "출결 내역";

            const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/attendance/manage?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}
        </script>