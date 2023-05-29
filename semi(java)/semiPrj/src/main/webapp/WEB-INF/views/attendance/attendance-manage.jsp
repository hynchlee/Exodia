<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link href="${root}/static/css/attendance/attendance-manage.css" rel="stylesheet">
        </head>
        <body>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
                <main>
                    <div id="target">
                        <form action="${root}/attendance/manage" method="post">
                            <div id="selectDiv">
                                <select name="searchType">
                                    <option value="student">수강생</option>
                                </select>
                                <input type="text" class="searchValueElem" name="searchValue"
                                value="" placeholder="검색할 학생">
                                <input type="submit" id="searchButton" value="검색하기">
                            </div>
                        </form>
                        <div id="content">
                            <div>수강생</div>
                            <div>일자</div>
                            <div>입실시간</div>
                            <div>퇴실시간</div>
                            <div>수업시간</div>
                            <div>실수업시간</div>
                            <div>출결상태</div>
                        </div>
                        <c:forEach items="${voList}" var="vo">
							<div id="content">
                            <div>${vo.studentMemberName}</div>
                            <div>${vo.attendanceDate}</div>
                            <div>${vo.checkInTime}</div>
                            <div>${vo.checkOutTime}</div>
                            <div>${vo.inLectureMinutes}</div>
                            <div>${vo.totalLectureMinutes}</div>
                            <div>${vo.status }</div>
                        </div>
                        </c:forEach>
                        <div id="pageDiv">
                            <td id="pageTd" colspan="4">
                                <c:if test="${pageVo.currentPage > 1 }">
                                    <button onclick="pageMove('${pageVo.startPage}');"><<</button> 
                                </c:if>
                                <c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="i">
                                    <button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
                                </c:forEach>
                                <c:if test="${pageVo.currentPage < pageVo.maxPage }">
                                    <button onclick="pageMove('${pageVo.endPage}');">>></button>
                                </c:if>
                            </td>
                        </div>
                    </div>
                </main>
                <%@ include file="/WEB-INF/views/common/footer.jsp" %>

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

            const searchType = '${searchVo.searchType}';
			const searchValue = '${searchVo.searchValue}';

			const searchValueSelectTag = document.querySelector("select[name='searchValue']");
			const searchValueInputTag = document.querySelector("input[name='searchValue']");

			if (searchType.length > 1) {
				initSearchType();
			}

			// 검색 타입 초기셋팅
			function initSearchType() {
				const x = document.querySelector('select > option[value="' + searchType + '"]');
				x.selected = true;
			}


			//서치타입 변경 시 함수 실행
			const searchTypeTag = document.querySelector('select[name="searchType"]');
			searchTypeTag.addEventListener("change", setSearchValueTag);

			function setSearchValueTag() {
				const searchType = searchTypeTag.value;
				setSearchValueTagInput();
			}

			//검색값 영역을 인풋이 보이게 (타입이 카테고리가 아닐 때)
			function setSearchValueTagInput() {
				searchValueInputTag.classList.add("active");
				searchValueInputTag.disabled = false;
				searchValueSelectTag.classList.remove("active");
				searchValueSelectTag.disabled = true;
			}

			setSearchValueTag();

        </script>