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
	                    <li class="class">${memberLecture[0].lectureName}</li>
	                </ul>
	            </div>
			</c:if>
            
            <div class="board_search">
                <form action="${root}/notice/list" method="get" name="searchBoard">
                	<input type="hidden" name="page" value="1">
                    <select class="searchCategory" name="searchType">
                        <option value="noticeTitle">제목</option>
                        <option value="noticeContent">내용</option>
                    </select>
                    <input type="text" class="searchInput" placeholder="검색어 입력" value="${searchVo.searchValue}" name="searchValue">
                    <input type="submit" value="검색" class="searchBtn">
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
                   	<c:forEach items="${nvoList}" var="nvo">
                    	<tr>
	                        <td>${nvo.noticeNo}</td>
	                        <td class="board_title">${nvo.noticeTitle}
	                        	<span class="new_btn">New</span>
	                        </td>
	                        <td>${nvo.adminNick}</td>
	                        <td>${nvo.enrollDate}</td>
	                        <td>${nvo.hit}</td>
                    	</tr>
                   	</c:forEach>
                </tbody>
            </table>
            
            <c:if test="${not empty loginAdmin}">
	            <div class="board_bt">
	                <a href="${root}/notice/write" class="bt1">글 등록</a>
	            </div>
            </c:if>
            
			<div class="board_page">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/notice/list?page=${pv.currentPage-1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button><<</button></a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
					<c:if test="${pv.currentPage ne i}">
						<a href="${root}/notice/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>${i}</button></a>
					</c:if>
					<c:if test="${pv.currentPage eq i}">
						<a><button class="active">${i}</button></a>
					</c:if>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/notice/list?page=${pv.currentPage+1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>>></button></a>
				</c:if>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "공지사항";

    // 서버에서 searchType 값을 JavaScript 변수로 설정
    const searchType = "${searchVo.searchType}";

    // 검색 타입
    const nc = document.querySelector(`select > option[value="${searchVo.searchType}"]`);
    if (nc) {
    nc.selected = true;
    }

    $(".board tbody tr").click(function(){
        //글번호 가져오기
        const nno = $(this).find('td:first-child').text();
        // const boardTitle = $(this).find('.board_title').text();
      
        // 페이지 이동을 위한 URL 구성
        const url = '${root}/notice/detail?nno=' + nno;
        
        // 페이지 이동
        window.location.href = url;

    });
    
 	// 현재 날짜와 등록일(enrollDate)이 일치하는 경우 .new_btn 요소 활성화
    const enrollDate = "${nvo.enrollDate}"; // JSP에서 가져온 등록일(enrollDate) 값
    const currentDate = new Date().toLocaleDateString('ko-KR', { year: 'numeric', month: '2-digit', day: '2-digit' }).replace(/\./g, '-'); // 현재 날짜를 'YYYY-MM-DD' 형식으로 가져옴

    if (enrollDate === currentDate) {
        const newBtn = document.querySelector('.new_btn');
        newBtn.style.display = 'inline-block'; // .new_btn 요소를 보이도록 설정
    }
</script>
