<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link rel="stylesheet" href="${root}/static/css/personal/tmypage.css" type="text/css">
			<!-- 제이쿼리 -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
			<style>
				.choiceLecture:hover * {
					background-color: #4998D1;
					color: white;
				}
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
										<thead>
											<tr>
												<td colspan="3" class="line00">공지사항</td>
												<td class="plus01">
													<a href="${root}/notice/list?page=1" class="plus02">더보기</a>
												</td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${notList}" var="notList">
												<tr style="cursor: pointer;">
													<td class="line01">${notList.noticeNo}</td>
													<td class="line01">${notList.adminNick}</td>
													<td class="line01">${notList.noticeTitle}</td>
													<td class="line01">${notList.enrollDate}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</td>
							<td class="td01">
								<div class="profile">
									<div class="innerprofile">
										<div class="logout"><a href="${root}/member/logout">로그아웃</a></div>
										<div class="photo01"></div>
										<div class="identity"><a href="${root}/tmypage">${loginMember.memberNick}님
												(강사)</a></div>
										<div class="class01"><a href="${root}/lecture/test/list2" class="awhite">시험 출제
												하기</a></div>
										<div class="change"><a href="${root}/member/edit">내 정보 수정</a></div>
										<div class="letter"><a href="${root}/letter/receive">쪽지 ${letterCount}</a></div>
										<div class="mywrite"><a href="${root}/my/list?page=1">내가 쓴 글 ${countMyWrite}</a>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td class="td01 td07">
								<div class="date">
									<%@ include file="/WEB-INF/views/teamCalendar/teamCalendar.jsp" %>
								</div>
							</td>
							<td class="td01 td08">
								<div class="todo" style="overflow: auto">
									<span class="teamlisttitle">학생 휴가 내역</span>
									<hr>
									<br>
									<ul>
										<c:forEach items="${vaList}" var="vaList">
											<li class="list02">${vaList.studentName}, 날짜 : (${vaList.vacationStart}) ~
												(${vaList.vacationEnd})</li>
											<li class="list03"> 사유 : ${vaList.reason}</li>
										</c:forEach>
									</ul>
								</div>
							</td>
							<td class="td01 td09">
								<div class="team">
									<div class="teamlist" style="overflow: auto;">
										<span class="teamlisttitle">담당 강의</span>
										<hr>
										<ul>
											<c:forEach items="${tvolist}" var="tvo">
												<ul class="choiceLecture">
													<input hidden type="text" value="${tvo.lectureNo}">
													<li class="list03">${tvo.lectureCategoryName}</li>
													<!--<li class="list02">${tvo.teacherMemberName}</li>-->
												</ul>
												<hr>
											</c:forEach>
										</ul>
									</div>
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
										<table class="innertable02">
											<thead>
												<tr>
													<td colspan="3" class="line00">우리반 게시판</td>
													<td class="plus01">
														<a href="${root}/class/tlist?page=1" class="plus02">더보기</a>
													</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${tcvoList}" var="tcvoList">
													<tr style="cursor: pointer;">
														<td class="line01">${tcvoList.boardNo}</td>
														<td class="line01">${tcvoList.writerNick}</td>
														<td class="line01">${tcvoList.boardTitle}</td>
														<td class="line01">${tcvoList.enrollDate}</td>
													</tr>
												</c:forEach>
											</tbody>
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
												<c:forEach items="${volist}" var="vo">
													<li class="list01 kmsList${vo.memberNo}">
														<input type="checkbox"
															onclick="handleClick('${vo.memberNo}', '${vo.teamNo}','${vo.memberNick}', '${vo.memberId}');">
														${vo.memberNick} (${vo.teamNo}조)
														${vo.projectDivision} ${vo.role}
													</li>
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
			const clArr = document.querySelectorAll('.choiceLecture');
			const title = document.querySelector(".title");
			title.innerHTML = "강사 마이페이지";

			for (const cl of clArr) {
				const lectureNo = cl.querySelector('input').value;

				cl.addEventListener("click", function () {
					$.ajax({
						url: '/semi/tmypage',
						type: 'post',
						data: { lectureNo: lectureNo },
						success: function () {
							location.reload();
						},
						error: function () {
							alert("에러");
						}
					});
				});

				if (lectureNo == "${lectureVo.lectureNo}") {
					cl.style.backgroundColor = "#F0F0F0";
				}
			}

		</script>

		<script>
			$(".innertable01 tbody tr").click(function () {
				//글번호 가져오기 //압도적 감사에오
				const nno = $(this).find('td:first-child').text();
				// const boardTitle = $(this).find('.board_title').text();

				// 페이지 이동을 위한 URL 구성
				const url = '${root}/notice/detail?nno=' + nno;

				// 페이지 이동
				window.location.href = url;

			});
		</script>
		<script>
			$(".innertable02 tbody tr").click(function () {
				//글번호 가져오기 
				const bno = $(this).find('td:first-child').text();
				// const boardTitle = $(this).find('.board_title').text();

				// 페이지 이동을 위한 URL 구성
				const url = '${root}/board/detail?bno=' + bno;

				// 페이지 이동
				window.location.href = url;

			});

			function handleClick(no, teamNo, nick, id) {
				const kms = document.querySelector('.kmsList' + no);
				kms.innerHTML = nick + " (" + teamNo + "조)" + '<select style="margin-left: 10px; height: 50px; font-size: 25px;"> <option value="미니">미니</option> <option value="세미">세미</option> <option value="파이널">파이널</option> </select> <select style="margin-left: 10px; height: 50px; font-size: 25px;"> <option value="조장">조장</option> <option value="디비관리자">디비관리자</option> <option value="형상관리자">형상관리자</option> <option value="이슈관리자">이슈관리자</option> <option value="프론트관리자">프론트관리자</option> </select> <button onclick="updateRole(' + no + ', ' + teamNo + ');" style="width: 100px; height: 50px; color: rgba(255,255,255,1); background: rgba(91,126,217,1); font-size: 25px;">저장</button>';
				kms.removeEventListener('click', handleClick);
				temp = kms.innerHTML;
			}

			function updateRole(no, teamNo) {
				const kms = document.querySelector('.kmsList' + no);
				const select = kms.querySelectorAll('select');

				var params = [no, teamNo];
				for (const s of select) {
					params.push(s.value);
				}

				$.ajax({
					url: '/semi/tmypage',
					type: 'post',
					data: { params: JSON.stringify(params) },
					success: function () {
						location.reload();
					},
					error: function () {
						alert("에러");
					}
				});
			}
		</script>