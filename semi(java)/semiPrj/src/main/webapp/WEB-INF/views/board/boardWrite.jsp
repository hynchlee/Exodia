<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/write.css" rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<main>
			<div class="myClass">
                <ul>
                    <li class="loginName">유저님 환영합니다</li>
                    <li class="class">(스마트웹&콘텐츠개발)반응형 UI/UX 웹콘텐츠 개발자 양성과정A</li>
                    <li class="classRoom">[강남 362] 2022. 12. 30 ~ 2023. 08. 16 ｜ 15:30 ~ 22:00 (심원용 강사 ｜ 김리아 취업담임)</li>
                </ul>
            </div>

            <hr>

            <div class="write_wrap">
                <input type="text" placeholder="제목을 입력해주세요." required>
                <select name="category" id="select_category" >
                    <option value="">우리반 게시판</option>
                    <option value="">자유게시판</option>
                    <option value="">문의게시판</option>
                    <option value="">후기게시판</option>
                    <option value="">공지사항</option>
                </select>
                <textarea name="content" class="content_input" placeholder="내용을 입력해주세요." required></textarea>
                <input type="file" name="select_file">
            </div>

            <div class="board_bt">
                <input type="submit" value="작성완료" class="bt1">
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "게시글 작성";
</script>