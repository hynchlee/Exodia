<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${root}/static/css/personal/tmypage.css" type="text/css">
<style>
	
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<main>
		
		<table class="table01">
			<tr>
				<td colspan="2" class="td01">
					<div class="board">
						<table class="innertable01">
							<tr>
								<td colspan="2" class="line00">공지사항</td>
								<td class="plus01">
								<a href="${root}/notice/list" class="plus02">더보기</a>
								</td>
							</tr>
							<tr>
								<td class="line01">작성자</td>
								<td class="line01">내용내용내용내용내용내용내용</td>
								<td class="line01">2023-xx-xx</td>
							</tr>
							<tr>
								<td class="line01">작성자</td>
								<td class="line01">내용내용내용내용내용내용내용</td>
								<td class="line01">2023-xx-xx</td>
							</tr>
							<tr>
								<td class="line01">작성자</td>
								<td class="line01">내용내용내용내용내용내용내용</td>
								<td class="line01">2023-xx-xx</td>
							</tr>
						</table>
					</div>
				</td>
				<td class="td01">
					<div class="profile">
						<div class="innerprofile">
		          		<div class="logout"><a href="${root}/member/logout">로그아웃</a></div>
						<div class="photo01"></div>
						<div class="identity"><a href="${root}/tmypage">${loginMember.memberNick}님 (강사)</a></div>
						<div class="class01"><a href="${root}/lecture/apply" class="awhite">강의 목록 보기</a></div>
						<div class="change"><a href="${root}/member/edit">내 정보 수정</a></div>
						<div class="letter"><a href="${root}/letter/receive">쪽지</a></div>
						<div class="mywrite"><a href="${root}/my/list">내가 쓴 글</a></div>
					</div>
					</div>
				</td>
			</tr>
			<tr>
				<td class="td01 td07">
					<div class="date">
						date Info
					</div>
				</td>
				<td class="td01 td08">
					<div class="todo">
						schedule Info
					</div>
				</td>
				<td class="td01 td09">
					<div class="team">
						담당 강의
					</div>
				</td>
			</tr>
		</table>

		<br>

		<div class="infowrap">
			<table class="fulltable">
				<tr>
					<td class="classboard">
						<div class="innercb">
							<table class="innertable01">
							<tr>
								<td colspan="2" class="line00">우리반 게시판</td>
								<td class="plus01">
								<a href="${root}/class/list" class="plus02">더보기</a>
								</td>
							</tr>
							<tr>
								<td class="line01">작성자</td>
								<td class="line01">내용내용내용내용내용내용내용</td>
								<td class="line01">2023-xx-xx</td>
							</tr>
							<tr>
								<td class="line01">작성자</td>
								<td class="line01">내용내용내용내용내용내용내용</td>
								<td class="line01">2023-xx-xx</td>
							</tr>
							<tr>
								<td class="line01">작성자</td>
								<td class="line01">내용내용내용내용내용내용내용</td>
								<td class="line01">2023-xx-xx</td>
							</tr>
						</table>
						</div>
					</td>
					<td class="classlist">
						<div class="innercl" style="overflow: auto;">
							<div class="list01">
							<span class="stlist">학생 리스트</span>
							<br>
							<hr>
							<ul>
								<c:forEach items="${volist}" var="volist">
									<li class="list01">${volist.teacherMemberName}</li>				
									<li class="list02">${volist.lectureCategoryName}</li>	
									<hr>			
								</c:forEach>
							</ul>							
							</div>
						</div>
					</td>
				</tr>
			</table>	
		</div>

		<br><br><br><br><br>

	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>
<script>
	const title = document.querySelector(".title");
	title.innerHTML = "강사 마이페이지";
</script>