<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/admin/memberManage.css" rel="stylesheet">

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<main>

		<div class="select-area">
			<select>
				<option value="all">전체</option>
				<option value="student">학생</option>
				<option value="teacher">강사</option>
			</select>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>

		<div class="member-info">
			<div id="check-area">
				<input type="checkbox" name="manageMember" value="">
			</div>
			<div>
				<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
			</div>
			<!-- <div id="name">이름</div> -->
			<div id="info">이름 아이디 닉네임 반 가입일자 마일리지 출석률 등등등</div>
		</div>


		<div class="btn-area">
			<button>마일리지 차감</button>
			<button>계정정지</button>
			<button>탈퇴처리</button>
		</div>

		<div class="page-area">
			<button><<</button>
			<button>1</button>
			<button>2</button>
			<button>3</button>
			<button>4</button>
			<button>5</button>
			<button>>></button>
		</div>

	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>