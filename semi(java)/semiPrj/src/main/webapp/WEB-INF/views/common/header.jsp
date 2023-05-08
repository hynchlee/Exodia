<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>header</title>

			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

			<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>
			<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A400%2C600" />
			<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins%3A400%2C600" />
			<link rel="stylesheet" href="${root}/static/css/common/header.css">
		</head>

		<body>
			<div id="wrap">
				<header>
					<nav>
						<ul>
							<li class="menu1"><a href=""><img src="/semi/static/img/header/image_2.png" alt="logo" id="logo_img"></a>
							</li>
							<li class="menu2"></li>
							<li class="menu3"><img src="/semi/static/img/header/___7.png" alt="profile" id="profile_img"></li>
							<li class="menu3"><a href="">
								KH소개
								<ul class="submenu-1">
									<li></li>
									<li><a href="">서브메뉴1</a></li>
									<li><a href="">서브메뉴2</a></li>
									<li><a href="">서브메뉴3</a></li>
								</ul>
							</a></li>
							<li class="menu3"><a href="">
								게시판
								<ul class="submenu-2">
									<li></li>
									<li><a href="">서브메뉴1</a></li>
									<li><a href="">서브메뉴2</a></li>
									<li><a href="">서브메뉴3</a></li>
								</ul>
							</a></li>
							<li class="menu3"><a href="">
								강의
								<ul class="submenu-3">
									<li></li>
									<li><a href="">서브메뉴1</a></li>
									<li><a href="">서브메뉴2</a></li>
									<li><a href="">서브메뉴3</a></li>
								</ul>
							</a></li>
							<li class="menu3"><a href="">
								강의 과정
								<ul class="submenu-4">
									<li></li>
									<li><a href="">서브메뉴1</a></li>
									<li><a href="">서브메뉴2</a></li>
									<li><a href="">서브메뉴3</a></li>
								</ul>
							</a></li>
							<li class="menu4"></li>
						</ul>
					</nav>
				</header>
				
				<section class="banner">
					<p class="title">공지사항</p>
					<p class="caption">연중 무휴 | 전국 대표 문의 전화 1544-9970</p>
				</section>

				<section class="caption1">
					<div class="container">
						<div class="img1"><img src="/semi/static/img/header/image_42.png" alt="" width="35px"
								height="35px"></div>
						<div class="t1">Address</div>
						<div class="s1">서울특별시 강남구 테헤란로14길 6<br> 남도빌딩 2-6F</div>

						<div class="img2"><img src="/semi/static/img/header/image_43.png" alt="" width="35px"
								height="35px"></div>
						<div class="t2">Contact</div>
						<div class="s2">Tell. 1544-9970 <br> 전국대표문의전화(연중무휴)</div>

						<div class="img3"><img src="/semi/static/img/header/image_44.png" alt="" width="35px"
								height="35px"></div>
						<div class="t3">Information</div>
						<div class="s3">사업자등록번호 851-87-00622 <br> 대표자 : 양진선 | 책임자 : 최홍석 | 개인정보관리책임자 : 양진선</div>
					</div>
				</section>
				<section class="caption2">
					<span>
						서울특별시 강남구 테헤란로14길 6 남도빌딩 2-6F <br>
						KH정보교육원 서울 강남 제2014-01호 사업자등록번호 : 851-87-00622 <br>
						고객센터 : 1544-9970 대표자 : 양진선
					</span>
				</section>
				<footer>
					© 1998-2023 KH information Educational institute All
				</footer>
			</div>

		</body>

		</html>