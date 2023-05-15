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
							<div class="identity">~~~님 (수강생)</div>
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
						teammate info
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
					<div class="detail02">
						<table class="innertable03">
							<tr class="tr030">
								<td colspan="2" class="td030">휴가 내역</td>
								<td class="plus01"><a href="/" class="plus02">더보기</a></td>
							</tr>
							<tr class="tr03">
								<td class="line02">
								<div class="vac">휴가</div>
								</td>
								<td class="line02">2023-00-00</td>
								<td class="line02">휴가 사유</td>
							</tr>
							<tr class="tr03">
								<td class="line02">
								<div class="vac">휴가</div>
								</td>
								<td class="line02">2023-00-00</td>
								<td class="line02">휴가 사유</td>
							</tr>
							<tr class="tr03">
								<td class="line02">
								<div class="vac">휴가</div>
								</td>
								<td class="line02">2023-00-00</td>
								<td class="line02">휴가 사유</td>
							</tr>
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