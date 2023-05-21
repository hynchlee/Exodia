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
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style>
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<main>
			<c:if test="${not empty loginMember}">
				<div class="myClass">
	                <ul>
	                    <li class="loginName">${loginMember.memberNick} 님 환영합니다</li>
	                    <li class="class">(스마트웹&콘텐츠개발)반응형 UI/UX 웹콘텐츠 개발자 양성과정A</li>
	                    <li class="classRoom">[강남 362] 2022. 12. 30 ~ 2023. 08. 16 ｜ 15:30 ~ 22:00 (심원용 강사 ｜ 김리아 취업담임)</li>
	                </ul>
	            </div>
			</c:if>

            <div class="board_search">
                <form action="${root}/review/list" method="get" name="searchBoard">
                    <input type="hidden" name="page" value="1">
                    <select class="searchCategory" name="searchCategory">
                        <option value="cn">강좌</option>
                    </select>
                    <select class="selectCategory" name="selectCategory">
                        <option value="1">sw개발자</option>
                        <option value="1">정보보안</option>
                        <option value="1">풀스택</option>
                    </select>
                    <input type="button" value="검색" class="searchBtn">
                </form>
            </div>

            <table class="board">
                <thead>
                    <tr>
                        <th style="width: 5%;">No</th>
                        <th>제목</th>
                        <th style="width: 25%;">강좌명</th>
                        <th style="width: 8%;">작성자</th>
                        <th style="width: 10%;">작성일</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${rvoList}" var="rvo">
	                    <tr>
	                        <td>${rvo.reviewNo}</td>
	                        <td class="board_title">${rvo.reviewTitle}</td>
	                        <td>${rvo.lectureName}</td>
	                        <td>${rvo.writerNick}</td>
	                        <td>${rvo.enrollDate}</td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
            
            <c:if test="${not empty loginMember && loginMember.identity eq 'S'}">
	            <div class="board_bt">
	                <a href="${root}/review/write" class="bt1">후기 등록</a>
	            </div>
            </c:if>
            
			<div class="board_page">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/review/list?page=${pv.currentPage-1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button><<</button></a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
					<c:if test="${pv.currentPage ne i}">
						<a href="${root}/review/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>${i}</button></a>
					</c:if>
					<c:if test="${pv.currentPage eq i}">
						<a><button class="active">${i}</button></a>
					</c:if>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/review/list?page=${pv.currentPage+1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>>></button></a>
				</c:if>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "수강후기";

    // // 서버에서 searchType 값을 JavaScript 변수로 설정
    // const searchType = "${searchVo.searchType}";

    // // 검색 타입
    // const nc = document.querySelector(`select > option[value="${searchType}"]`);
    // if (nc) {
    // nc.selected = true;
    // }

    $(".board tbody tr").click(function(){
        //글번호 가져오기
        const rno = $(this).find('td:first-child').text();
        // const boardTitle = $(this).find('.board_title').text();
      
        // 페이지 이동을 위한 URL 구성
        const url = '${root}/review/detail?rno=' + rno;
        
        // 페이지 이동
        window.location.href = url;

    });
</script>
