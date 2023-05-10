<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/introduce/facility.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main style="height: 2400px;">
					<div class="facility-menu">
						<div class="e112">강남지원 1관</div>
						<div class="e112">강남지원 2관</div>
						<div class="e112">강남지원 3관</div>
						<div class="e112">종로지원</div>
						<div class="e112">당산지원</div>
					</div>

					<div id="map" style="width:85%; height:600px; left: 7.5%; top: 200px; position: relative;"></div>

					<div class="e112_1077">
						주소 : 서울시 강남구 테헤란로 10길 9 그랑프리 빌딩 4F, 5F, 7F
					</div>
					<div class="e112_1078">
						주변 정류장
					</div>
					<div class="e112_1079">
						주변 지하철 역
					</div>
					<div class="e112_1080">
						지하철 2호선 강남역 1번 출구
					</div>
					<div class="e112_1081">
						지하철 2호선 역삼역 3번 출구
					</div>
					<img src="${root}/static/img/introduce/subway.PNG" alt="logo" class="e112_1083">
					<img src="${root}/static/img/introduce/bus.PNG" alt="logo" class="e112_1084">
					
					<div class="e112_1085">2</div>
					<div class="e112_1086">2</div>

					<div class="e112_1093">
						역삼역.포스코타워역삼
					</div>
					
					<div class="e112_1089">간선</div>
					<div class="e112_1090">광역</div>

					<div class="e112_1091">
						146, 341, 360, 740
					</div>
					<div class="e112_1092">
						M6439, 1100, 1700, 2000, 3200
					</div>

					<img src="${root}/static/img/introduce/___9.png" alt="logo" class="e112_1076">

					<table class="facility-tbl">
						<tr>
							<td>교육시설</td>
							<td>강의실 / 프로젝트룸</td>
						</tr>
						<tr>
							<td>기타시설</td>
							<td>휴게실 / 행정시설지원(FAX, 프린트, Scan)</td>
						</tr>
						<tr>
							<td>4F</td>
							<td>강의실(O, P) / 프로젝트룸</td>
						</tr>
						<tr>
							<td>5F</td>
							<td>강의실(M) / 취업지원센터 / 상담실 / 교육개발본부</td>
						</tr>
						<tr>
							<td>7F</td>
							<td>강의실(K, L) / 상담실</td>
						</tr>
					</table>


					<script type="text/javascript"
						src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=38c74d284b128f482801fcc0af6312cd"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
							mapOption = {
								center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								level: 3 // 지도의 확대 레벨
							};

						// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
						var map = new kakao.maps.Map(mapContainer, mapOption); 
					</script>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			title.innerHTML = "시설 소개";
		</script>