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
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
                        </div>
                        <div id="content">
                            <div>반응형</div>
                            <div>심원용</div>
                            <div>2023-12-12 ~ 2023-12-12</div>
                            <div>n</div>
                            <div>피곤</div>
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
                    <div style="height: 30px;"></div>
                </main>
                <%@ include file="/WEB-INF/views/common/footer.jsp" %>

        </body>

        </html>

        <script>
            const title = document.querySelector(".title");
            title.innerHTML = "휴가 내역";
        </script>