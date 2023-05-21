<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${root}/static/css/personal/mypage.css" type="text/css">
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
							<c:forEach items="${snotList}" var="snotList">
								<tr>
									<td class="line01">${snotList.writerNick}</td>
									<td class="line01">${snotList.boardTitle}</td>
									<td class="line01">${snotList.enrollDate}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</td>
				<td class="td01">
					<div class="profile">
						<div class="innerprofile">
							<div class="logout"><a href="${root}/member/logout">로그아웃</a></div>
							<div class="photo01"></div>
							<div class="identity"><a href="${root}/mypage">${loginMember.memberNick}님 (수강생)</a></div>
							<div class="class01"><a href="${root}/lecture/apply">반응형 UX/UI 웹컨텐츠 개발자 양성과정 A9</a></div>
							<div class="change"><a href="${root}/member/edit">내 정보 수정</a></div>
							<div class="letter"><a href="${root}/letter/receive">쪽지 ${letterCount}</a></div>
							<div class="mywrite"><a href="${root}/my/list">내가 쓴 글 ${countMyWrite}</a></div>
							<div class="point"><a href="/">마일리지</a></div>
							<div class="test"><a href="${root}/lecture/test/list" class="a01">시험 응시</a></div>
							<div class="vacation"><a href="${root}/member/vacation/form" class="a01">휴가 신청</a></div>
							<div class="exit"><a href="/" class="a01">퇴실 하기</a></div>
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
					<div class="teamlist">
						<div class="teamdiv" style="overflow: auto">
							<span class="teamlisttitle">팀 목록</span>
							<hr>
							<ul>
								<c:forEach items="${teamList}" var="teamList">
									<li class="list03">${teamList.memberNick} (${teamList.role})</li>	
									<li class="list02">${teamList.teamName}_${teamList.projectDivision}</li>				
									<hr>			
								</c:forEach>
							</ul>	
						</div>
					</div>
				</td>
			</tr>
		</table>

		<br>

		<table class="table02">
			<tr>
				<th class="th02">출결 현황</th>
				<th class="th02">세부 내역</th>
			</tr>
			<tr rowspan="5">
				<td class="td02">
					<div class="classdate">
						<table class="innertable02">
							<tr class="tr02">
								<th class="td02">총 훈련 일수</th>
								<th class="td02">실시일수</th>
								<th class="td02">출석일</th>
								<th class="td02">결석일</th>
								<th class="td02">출석률(일)</th>
								<th class="td02">출석률(시간)</th>
							</tr>
							<tr class="tr02">
								<td class="td02">--일</td>
								<td class="td02">--일</td>
								<td class="td02">--일</td>
								<td class="td02">--일</td>
								<td class="td02">--%</td>
								<td class="td02">--%</td>
							</tr>
						</table>
					</div>
				</td>
				<td class="td02">
					<div class="datedetail">
						<table class="innertable02">
							<tr class="tr02">
								<th class="td02">출석</th>
								<th class="td02">결석</th>
								<th class="td02">지각</th>
								<th class="td02">조퇴</th>
								<th class="td02">외풀</th>
							</tr>
							<tr class="tr02">
								<td class="td02">--일</td>
								<td class="td02">--일</td>
								<td class="td02">--일</td>
								<td class="td02">--일</td>
								<td class="td02">--일</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>

		</table>

		<table class="table03" width="100%" height="450px">
			<tr>
				<td class="td03">
					<div class="detail01">
						<table class="innertable03">
							<tr class="tr030">
								<td colspan="3" class="td030">출결 내역</td>
								<td class="plus01"><a href="/" class="plus02">더보기</a></td>
							</tr>
							<tr class="tr03">
								<td class="line02">
								<div class="enter">입실</div>
								</td>
								<td class="line02">2023-00-00 00:00:00:00</td>
								<td class="line02">
								<div class="done">퇴실</div>
								</td>
								<td class="line02">2023-00-00 00:00:00:00</td>
							</tr>
							<tr class="tr03">
								<td class="line02">
								<div class="enter">입실</div>
								</td>
								<td class="line02">2023-00-00</td>
								<td class="line02"></td>
								<td class="line02"></td>
							</tr>
							<tr class="tr03">
								<td class="line02">
								<div class="enter">입실</div>
								</td>
								<td class="line02">2023-00-00</td>
								<td class="line02"></td>
								<td class="line02"></td>
							</tr>
						</table>
					</div>
				</td>
				<td class="td03">
					<div class="detail02" style="overflow: auto;">
						<table class="innertable03">
							<tr class="tr030">
								<td colspan="2" class="td030">휴가 내역</td>
								<td class="plus01"><a href="/" class="plus02">더보기</a></td>
							</tr>
							<c:forEach items="${restList}" var="restList">
								<tr class="tr03">
									<td class="line02">
									<div class="vac">휴가</div>
									</td>
									<td class="vaclist">${restList.vacationStart}</td>
									<td class="vaclist">${restList.vacationEnd}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<br><br><br><br><br>

	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>
<script>
	const title = document.querySelector(".title");
	title.innerHTML = "마이페이지";
</script>