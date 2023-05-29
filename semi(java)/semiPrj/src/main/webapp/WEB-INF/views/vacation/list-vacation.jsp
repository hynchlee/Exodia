<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link href="${root}/static/css/vacation/list-vacation.css" rel="stylesheet">
        </head>

        <body>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
                <main>
                    <div id="target">
                        <div id="content" class="head">
                            <div>수강강의</div>
                            <div>담당강사</div>
                            <div>신청기간</div>
                            <div>일수</div>
                            <div>사유</div>
                        </div>
                        <c:forEach items="${list}" var="vo">
							<div id="content">
                            <div class="lectureName">${vo.lectureName}</div>
                            <div>${vo.teacherName}</div>
                            <div>${vo.vacationStart} - ${vo.vacationEnd}</div>
                            <div>${vo.day}</div>
                            <div>${vo.reason}</div>
                        </div>                        
                        </c:forEach>
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
                <%@ include file="/WEB-INF/views/common/footer.jsp" %>

        </body>

        </html>

        <script>
            const title = document.querySelector(".title");
            title.innerHTML = "휴가 내역";

            const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/vacation/list?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pv.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}
        </script>