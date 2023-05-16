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
                        <div id="selectDiv">
                            <select name="" id="">
                                <option value="student">수강생</option>
                                <option value="date">일자</option>
                                <option value="">출결상태</option>
                            </select>
                            <input type="text" name="attendanceInput">
                            <button type="submit">검색</button>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>일자</div>
                            <div>입실시간</div>
                            <div>퇴실시간</div>
                            <div>수업시간</div>
                            <div>실수업시간</div>
                            <div>출결상태</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
                        <div id="content">
                            <div>수강생</div>
                            <div>YYYY-MM-DD</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                            <div>AAAAAAAA</div>
                        </div>
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