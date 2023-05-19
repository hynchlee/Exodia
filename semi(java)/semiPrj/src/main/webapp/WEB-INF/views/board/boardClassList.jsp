<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/list.css" rel="stylesheet">
<style>
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

            <div class="board_search">
                <form action="${root}/class/list" method="get" name="searchBoard">
                    <select class="searchCategory" name="searchCategory">
                        <option value="t">제목</option>
                        <option value="c">내용</option>
                    </select>
                    <input type="text" class="searchInput" placeholder="검색어 입력" name="searchText">
                    <input type="button" value="검색" class="searchBtn">
                </form>
            </div>

            <table class="board">
                <thead>
                    <tr>
                        <th style="width: 8%;">No</th>
                        <th>제목</th>
                        <th style="width: 10%;">작성자</th>
                        <th style="width: 15%;">작성일</th>
                        <th style="width: 8%;">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cvoList}" var="cvo">
	                    <tr>
	                        <td>${cvo.boardNo}</td>
	                        <td class="board_title">${cvo.boardTitle}
	                        	<span class="comment_num">[21]</span> 
	                        	<span class="new_btn">New</span>
	                        </td>
	                        <td>${cvo.writerNick}</td>
	                        <td>${cvo.erollDate}</td>
	                        <td>${cvo.hit}</td>
	                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="board_bt">
                <a href="${root}/board/write" class="bt1">글 등록</a>
            </div>
			<div class="board_page">
				<c:if test="${pv.currentPage > 1 }">
					<a href=""><button><<</button></a>
				</c:if>
				<c:forEach items="" var="">
					<a><button>${pv.currentPage}</button></a>
				</c:forEach>
                <c:if test="${pv.currentPage  }">
					<a href=""><button>>></button></a>
				</c:if>
                
            </div>
           
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "우리반 게시판";
</script>
