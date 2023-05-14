<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            <link href="${root}/static/css/attendence/attendence-manage.css" rel="stylesheet">
        </head>
        <body>
            <%@ include file="/WEB-INF/views/common/header.jsp" %>
                <main>
                    <div id="target">
                        <div id="selectDiv">
                            <select>
                                <option>학생 선택</option>
                                <option value="학생1">학생1</option>
                                <option value="학생2">학생2</option>
                                <option value="학생3">학생3</option>
                                <option value="학생4">학생4</option>
                                <option value="학생5">학생5</option>
                                <option value="학생6">학생6</option>
                                <option value="학생7">학생7</option>
                            </select>
                        </div>
                        <div id="content">
                            <div>일자</div>
                            <div>입실시간</div>
                            <div>퇴실시간</div>
                            <div>수업시간</div>
                            <div>실수업시간</div>
                            <div>출결상태</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="pageDiv">
                            <button><</button>
                            <button>1</button>
                            <button>2</button>
                            <button>3</button>
                            <button>4</button>
                            <button>5</button>
                            <button>></button>
                        </div>
                    </div>
                </main>
                <%@ include file="/WEB-INF/views/common/footer.jsp" %>

        </body>

        </html>

        <script>
            const title = document.querySelector(".title");
            title.innerHTML = "출결 내역";
        </script>