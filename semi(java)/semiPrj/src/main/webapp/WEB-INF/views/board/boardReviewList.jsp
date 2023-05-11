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
                <form action="" method="post" name="searchBoard">
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
                    <tr>
                        <td>1</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>반응형 UI/UX 웹콘텐츠 개발자 양성과정</td>
                        <td>아무개</td>
                        <td>2023.05.01</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="board_title">글제목자리</td>
                        <td>반응형 UI/UX 웹콘텐츠 개발자 양성과정</td>
                        <td>아무개</td>
                        <td>2023.05.01</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="board_title">글제목자리</td>
                        <td>반응형 UI/UX 웹콘텐츠 개발자 양성과정</td>
                        <td>아무개</td>
                        <td>2023.05.01</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="board_title">글제목자리</td>
                        <td>반응형 UI/UX 웹콘텐츠 개발자 양성과정</td>
                        <td>아무개</td>
                        <td>2023.05.01</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="board_title">글제목자리</td>
                        <td>반응형 UI/UX 웹콘텐츠 개발자 양성과정</td>
                        <td>아무개</td>
                        <td>2023.05.01</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="board_title">글제목자리</td>
                        <td>반응형 UI/UX 웹콘텐츠 개발자 양성과정</td>
                        <td>아무개</td>
                        <td>2023.05.01</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td class="board_title">글제목자리</td>
                        <td>반응형 UI/UX 웹콘텐츠 개발자 양성과정</td>
                        <td>아무개</td>
                        <td>2023.05.01</td>
                    </tr>
                    
                </tbody>
            </table>
            <div class="board_bt">
                <a href="" class="bt1">후기 등록</a>
            </div>
			<div class="board_page">
                <a href=""><<</a>
                <a href="">1</a>
                <a href="">>></a>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "후기게시판";
</script>