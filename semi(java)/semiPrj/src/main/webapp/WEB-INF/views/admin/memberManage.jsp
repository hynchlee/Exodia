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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
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

		<c:forEach items="${memberList}" var="member">
			<div class="member-info">
				<div id="check-area">
					<input type="checkbox" name="manageMember" value="">
				</div>
				<div>
					<img id="profile-img" src="${root}/static/img/introduce/___7.png" alt="profile" id="profile_img_1" class="profile_img">
				</div>
				<div id="info">
					<table>
						<tr>
							<th>이름</th>
							<td>${member.memberNick}</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>${member.memberId}</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td>${member.birthNum}</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${member.phoneNo}</td>
						</tr>
						<tr>
							<th>신분</th>
							<td>
								<c:if test="${member.identity == 'T'}">
									강사
								</c:if>
								<c:if test="${member.identity == 'S'}">
									학생
								</c:if>
							</td>
						</tr>
					</table>

					<table>
						<tr>
							<th>가입일시</th>
							<td>${member.signDate}</td>
						</tr>
						<tr>
							<th>잔여휴가</th>
							<td>${member.leftVacation}일</td>
						</tr>
						<tr>
							<th>마일리지</th>
							<td>
								<c:if test="${member.mileage != null}">
									${member.mileage} 점
								</c:if>
								<c:if test="${member.mileage == null}">
									-
								</c:if>
							</td>
						</tr>
						<tr>
							<th>회원상태</th>
							<td>
								<c:if test="${member.status == 'O'}">
									정상
								</c:if>
								<c:if test="${member.status == 'S'}">
									정지
								</c:if>
								<c:if test="${member.status == 'X'}">
									탈퇴
								</c:if>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</c:forEach>

		


		<div class="btn-area">
			<button>마일리지 차감</button>
			<button>계정정지</button>
			<button>탈퇴처리</button>
		</div>

		<div class="page-area">
			<!-- <button><<</button>
			<button>1</button>
			<button>2</button>
			<button>3</button>
			<button>4</button>
			<button>5</button>
			<button>>></button> -->
			<c:if test="${ pv.currentPage > 1 }">
				<a href="${pageContext.request.contextPath}/admin/member/manage?page=${pv.currentPage-1}"><button><<</button></a>
			</c:if>
			<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
				<a href="${pageContext.request.contextPath}/admin/member/manage?page=${i}"><button>${i}</button></a>
			</c:forEach>
			<c:if test="${ pv.currentPage < pv.maxPage }">
				<a href="${pageContext.request.contextPath}/admin/member/manage?page=${pv.currentPage+1}"><button>>></button></a>
			</c:if>

		</div>

	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

	<script>

		const title = document.querySelector(".title");
		title.innerText = '회원 관리';
		
		const caption = document.querySelector(".caption");
		caption.innerText = '';


	</script>
</body>
</html>