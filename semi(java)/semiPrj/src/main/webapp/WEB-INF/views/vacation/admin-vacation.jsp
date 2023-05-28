<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link href="${root}/static/css/vacation/admin-vacation.css" rel="stylesheet">
        </head>

        <body>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
                <main>
                    <div id="target">
                        <div id="content" style="border: none;
                        background-color: #F0F0F0;
                        height: 40px;">
                            <div></div>
                            <div>신청자(아이디)</div>
                            <div>수강강의</div>
                            <div>담당강사</div>
                            <div>신청기간</div>
                            <div>일수</div>
                            <div>사유</div>
                        </div>
                        <div id="content">
                            <div><input type="checkbox"></div>
                            <div>심원용(1dragon)</div>
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="buttonDiv">
                            <button id="deleteButton" onclick="delButton();">삭제하기</button>
                        </div>
                        <div id="pageDiv">
                            <button onclick="pageMove('${pageVo.startPage}');"><<</button>
                                <c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="i">
                                    <button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
                                </c:forEach>
                            <button onclick="pageMove('${pageVo.endPage}');">>></button>
                        </div>
                    </div>
                    <div style="height: 30px;"></div>
                </main>
                <%@ include file="/WEB-INF/views/common/footer.jsp" %>

        </body>

        </html>

        <script>
            const title = document.querySelector(".title");
            title.innerHTML = "휴가 관리";

            const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/vacation/list?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}
        </script>