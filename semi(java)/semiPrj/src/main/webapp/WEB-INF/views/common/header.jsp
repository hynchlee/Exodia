<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>header</title>

			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

			<link href="https://fonts.googleapis.com/css?family=Noto+Sans KR&display=swap" rel="stylesheet">
			<link href="https://fonts.googleapis.com/css?family=ABeeZee&display=swap" rel="stylesheet">
			<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>
			<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A400%2C600" />
			<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins%3A400%2C600" />
			<link rel="stylesheet" href="${root}/static/css/common/header.css">
		</head>

		<body>
			<c:if test="${ not empty alertMsg }">
				<script>
					alert('${alertMsg}');
				</script>
			</c:if>
			<c:remove var="alertMsg" scope="session" />

			<header>
				<nav>
					<ul>
						<li class="menu1"><a class="logo" href="${root}/main"><img src="/semi/static/img/header/4.png"
									alt="logo" id="logo_img"></a>
						</li>
						<li class="menu2"></li>
						<li class="menu3"><a class="profileImg" href="${root}/mypage"><img
									src="/semi/static/img/header/defaultProfile.png" id="profile_img"></a></li>
						<li class="menu3"><a href="${root}/introduce/greet"> KH소개 </a></li>
						<li class="menu3"><a href="${root}/my/list?page=1"> 게시판 </a></li>
						<li class="menu3"><a href="${root}/introduce/lecture?subject=1">
								강의 </a></li>
						<li class="menu4"></li>
					</ul>
				</nav>
				<div class="submenu">
					<table class="submenu-tbl">
						<tr>
							<td><a href="${root}/introduce/greet">인사말</a></td>
							<td><a href="${root}/notice/list?page=1">공지사항</a></td>
							<td><a href="${root}/introduce/lecture?subject=1">강의 소개</a></td>
							<td></td>
						</tr>
						<tr>
							<td><a href="${root}/introduce/teacher">강사진 소개</a></td>
							<td><a href="${root}/free/list?page=1">자유게시판</a></td>
							<td><a href="${root}/lecture/apply">수강 신청</a></td>
						</tr>
						<tr>
							<td><a href="${root}/introduce/facility?building=1">시설 소개</a></td>
							<td><a href="${root}/qna/list?page=1">문의게시판</a></td>
						</tr>
						<tr>
							<td></td>
							<td><a href="${root}/review/list?page=1">수강후기</a></td>
						</tr>
						<tr>
							<td></td>
							<c:if test="${loginMember.identity eq 'S' }">
								<td><a href="${root}/class/slist?page=1">우리반게시판</a></td>
							</c:if>
							<c:if test="${loginMember.identity eq 'T' }">
								<td><a href="${root}/class/tlist?page=1">우리반게시판</a></td>
							</c:if>
						</tr>
					</table>
				</div>
			</header>
			<section class="banner">
				<p class="title"></p>
				<p class="caption">연중 무휴 | 전국 대표 문의 전화 1544-9970</p>
			</section>
		</body>

		</html>

		<script>
			const logo = document.querySelector('.logo');
			const profileImg = document.querySelector('.profileImg');

			function consolePrint() {
				if ('${loginMember}' != '' && '${loginMember}' != null) {
					console.log("회원 : ${loginMember.memberNick}");
					if ("S" == "${loginMember.identity}") {
						console.log("[수강생]");
					} else if ("T" == "${loginMember.identity}") {
						console.log("[강사]");
						if ('${lectureVo}' != '' && '${lectureVo}' != null) {
							console.log("lectureVo : ${lectureVo}")
						}
					}
				} else if ('${loginAdmin}' != '' && '${loginAdmin}' != null) {
					console.log("loginAdmin : ${loginAdmin.adminId}");
				} else {
					console.log("로그인한 회원이 없습니다");
				}
			}

			function loginShow() {
				const profile_img = document.querySelector('#profile_img');
				if ("${loginMember.profile}" != "") {
					console.log("hi");
					var txt = "/semi/static/img/profile/${loginMember.profile}";
					profile_img.src = txt;
				}
				
				if ('${loginMember.identity}' == 'S') {
					profileImg.href = "${root}/mypage";
				} else if ('${loginMember.identity}' == 'T') {
					profileImg.href = "${root}/tmypage";
				} else if ('${loginAdmin}' != '' && '${loginAdmin}' != null) {
					profileImg.hidden = true;
				} else {
					profileImg.hidden = true;
				}
			}

			consolePrint();
			loginShow();
		</script>