<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/qnalist.css" rel="stylesheet">
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
            
            <form action="${root}/qna/list">
                <div class="board_search">
                    <div class="qna_control">
                        <label>
                            <input type="radio" name="contact" value="a_all" checked />
                            <span>전체글</span>
                          </label>
                        <label>
                            <input type="radio" name="contact" value="a_n"/>
                            <span>답변대기</span>
                          </label>
                          <label>
                            <input type="radio" name="contact" value="a_y" />
                            <span>답변완료</span>
                          </label>
                    </div>
            </form>
                <form action="${root}/qna/list" method="get" name="searchBoard">
                	<input type="hidden" name="page" value="1">
                    <select class="searchCategory" name="searchType">
                        <option value="qnaTitle">제목</option>
                        <option value="qnaContent">내용</option>
                    </select>
                    <input type="text" class="searchInput" placeholder="검색어 입력" value="${searchVo.searchValue}" name="searchValue">
                    <input type="submit" value="검색" class="searchBtn">
                </form>
            </div>
            
            <table class="board">
                <thead>
                    <tr>
                        <th style="width: 8%;">No</th>
                        <th style="width: 10%;">작성자</th>
                        <th>제목</th>
                        <th style="width: 15%;">작성일</th>
                        <th style="width: 8%;">답변상태</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${qvoList}" var="qvo">
	                    <tr>
	                        <td>${qvo.qnaNo}</td>
	                        <td>${qvo.writerNick}</td>
	                        <td class="board_title">${qvo.qnaTitle}</td>
	                        <td>${qvo.enrollDate}</td>
	                        <td class="state">
	                        	<c:if test="${not empty qvo.qnaAnswer}">
		                            <button class="bt_y">완료</button>
	                        	</c:if>
	                        	<c:if test="${empty qvo.qnaAnswer}">
		                            <button class="bt_n">대기</button>
	                        	</c:if>
	                        </td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
            <!-- 관리자나 강사가 클릭하면 다른 창 -->
            <c:if test="${not empty loginMember}">
	            <div class="board_bt">
	                <a href="${root}/board/write" class="bt1">질문하기</a>
	            </div>
            </c:if>
            <c:if test="${not empty loginAdmin}">
	            <div class="board_bt">
	                <a href="${root}/qna/answer/write" class="bt1">답변하기</a>
	            </div>
            </c:if>
            
			<div class="board_page">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/qna/list?page=${pv.currentPage-1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button><<</button></a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
					<c:if test="${pv.currentPage ne i}">
						<a href="${root}/qna/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>${i}</button></a>
					</c:if>
					<c:if test="${pv.currentPage eq i}">
						<a><button class="active">${i}</button></a>
					</c:if>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/qna/list?page=${pv.currentPage+1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>>></button></a>
				</c:if>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "문의게시판";
</script>
<script>

    //검색 타입
    const nc = document.querySelector('select > option[value="${searchVo.searchType}"]');
    nc.selected = true;

</script>