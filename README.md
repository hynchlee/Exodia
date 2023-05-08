# Exodia
[JSP 프리셋]

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[페이지 이름]</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
 		<main style="height: 100px;">
  			[여기서 작업]
 		</main>
 	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>

<script>
	const title = document.querySelector('.title');
	title.innerHTML = "[제목 수정]";
</script>
