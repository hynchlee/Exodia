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
			<header>
				<nav>
					<ul>
						<li class="menu1"><a href=""><img src="/semi/static/img/header/image_2.png" alt="logo"
									id="logo_img"></a>
						</li>
						<li class="menu2"></li>
						<li class="menu3"><img src="/semi/static/img/header/___7.png" alt="profile" id="profile_img">
						</li>
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
		</body>

		</html>