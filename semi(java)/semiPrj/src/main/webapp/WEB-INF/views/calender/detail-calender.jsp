<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="${root}/static/css/calender/detail-calender.css">
</head>

<body>
  <%@ include file="/WEB-INF/views/common/header.jsp" %>
  <main>
    <div id="wrap">
      <h1><img src="${root}/static/img/calender/캘린더.png" width="50px" height="50px">일정 등록</h1>
      <div id="content">
        <div>
          <input type="text" name="date">
        </div>
        <button onclick="location.href='saveSchedulePage.jsp';">저장하기</button>
      </div>
      <textarea></textarea>
      <div id="footer">
        <div></div>
        <div id="buttonDiv"><button><</button> 날짜 이동 <button>></button></div>
        <div id="backButton">
            <button>수정하기</button>
            <button>뒤로가기</button>
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