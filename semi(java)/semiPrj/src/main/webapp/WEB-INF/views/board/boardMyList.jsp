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
                    <li class="loginName">${loginMember.memberNick} 님 환영합니다</li>
                    <li class="class">${memberLecture[0].lectureName}</li>
                </ul>
            </div>

            <div class="board_search">
                <form action="${root}/my/list" method="post" name="searchBoard">
                    <input type="hidden" name="page" value="1">
                    <select class="searchCategory" name="searchCategory">
                        <option value="myTitle">제목</option>
                        <option value="myContent">내용</option>
                        <option value="myCategory">카테고리</option>
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
                        <th style="width: 10%;">카테고리</th>
                        <th style="width: 15%;">작성일</th>
                        <th style="width: 8%;">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${bvoList}" var="bvo">
	                	<c:if test="${loginMember.memberNo == bvo.memberNo}">
	                    <tr>
	                        <td>${bvo.boardNo}</td>
	                        <td class="board_title">${bvo.boardTitle}
		                        <c:if test="${bvo.totalReplies > 0}">
			                        <span class="comment_num">[${bvo.totalReplies}]</span>
		                        </c:if>
	                        </td>
	                        <td>${bvo.boardCategoryType}</td>
	                        <td>${bvo.enrollDate}</td>
	                        <td>${bvo.hit}</td>
	                    </tr>
	                	</c:if>
                    </c:forEach>
                </tbody>
            </table>
            
			<div class="board_page">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/my/list?page=${pv.currentPage-1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button><<</button></a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
					<c:if test="${pv.currentPage ne i}">
						<a href="${root}/my/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>${i}</button></a>
					</c:if>
					<c:if test="${pv.currentPage eq i}">
						<a><button class="active">${i}</button></a>
					</c:if>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/my/list?page=${pv.currentPage+1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>>></button></a>
				</c:if>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "내가 쓴 글";
	
	$(".board tbody tr").click(function(){
        //글번호 가져오기
        const bno = $(this).find('td:first-child').text();
        //const boardTitle = $(this).find('.board_title').text();
      
        // 페이지 이동을 위한 URL 구성
        const url = '${root}/board/detail?bno=' + bno;
        
        // 페이지 이동
        window.location.href = url;

    });
</script>