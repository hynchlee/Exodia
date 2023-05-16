<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="${root}/static/css/calendar/detail-calendar.css">
</head>

<body>
  <%@ include file="/WEB-INF/views/common/header.jsp" %>
  <main>
    <div id="wrap">
      <div id="imgDiv">
        <img src="${root}/static/img/calender/캘린더.png" width="50px" height="50px">
        <div><h1>일정 등록</h1></div>
      </div>
      
      <div id="content">
        <div>
        </div>
        <div>
          <input type="date" name="date">
        </div>
      </div>
      <div id="footer">
        <div id="calendarDiv">
          <%@ include file="/WEB-INF/views/common/calendar.jsp"%>
        </div>
        </div>
      </div>
    </div>
  </main>
  <%@ include file="/WEB-INF/views/common/footer.jsp" %>

  <script>
    const title = document.querySelector(".title");
    title.innerHTML = "캘린더";
  </script>
</body>
</html>