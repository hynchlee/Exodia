<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="${root}/static/css/calendar/write-calendar.css">
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
          <input type="text" placeholder="제목을 작성해주세요">
        </div>
        <div>
          <input type="date" name="date">
        </div>
      </div>
      <textarea placeholder="내용을 입력해주세요"></textarea>
      <div id="footer">
        <div></div>
        <div id="buttonDiv"><button><</button> 날짜 이동 <button>></button></div>
        <div id="saveButton"><button>저장하기</button>
        </div>
      </div>
    </div>
  </main>
  <%@ include file="/WEB-INF/views/common/footer.jsp" %>

  <script>
    const title = document.querySelector(".title");
    title.innerHTML = "캘린더 작성";
  </script>
</body>
</html>