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
								<a href="공지사항으로" class="plus02">더보기</a>
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
							<div class="photo01"></div>
							<div class="identity">~~~님 (강사)</div>
							<div class="class01">반응형 UX/UI 웹컨텐츠 개발자 양성과정 A9</div>
							<div class="change">내 정보 수정</div>
							<div class="letter">쪽지</div>
							<div class="mywrite">내가 쓴 글</div>
							<div class="point">마일리지</div>
							<div class="test">시험 응시</div>
							<div class="vacation">휴가 신청</div>
							<div class="exit">퇴실 하기</div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td class="td01">
					<div class="date">
						date Info
					</div>
				</td>
				<td class="td01">
					<div class="todo">
						schedule Info
					</div>
				</td>
				<td class="td01">
					<div class="team">
						담당 강의
					</div>
				</td>
			</tr>
		</table>

		<br>

		

		<br><br><br><br><br>

	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>
<script>
	const title = document.querySelector(".title");
	title.innerHTML = "강사 마이페이지";
</script>