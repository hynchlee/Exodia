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

				<main>
					<div class="head">
						<div class="facility-menu">
							<a href="${root}/introduce/facility?building=1" class="e112">강남지원 1관
							</a>
							<a href="${root}/introduce/facility?building=2" class="e112">강남지원 2관
							</a>
							<a href="${root}/introduce/facility?building=3" class="e112">강남지원 3관
							</a>
							<a href="${root}/introduce/facility?building=4" class="e112">종로지원
							</a>
							<a href="${root}/introduce/facility?building=5" class="e112">당산지원
							</a>
						</div>
						<br><br><br><br>

						<div id="map" style="width: 70%; height: 500px;"></div>
						<br>

						<div class="e112_1077">주소 :</div>
						<br><br><br><br><br>


						<img src="${root}/static/img/introduce/___9.png" alt="logo" class="e112_1076">
						<br><br><br>
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
					</div>





				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</body>

		</html>

		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=38c74d284b128f482801fcc0af6312cd&libraries=services"></script>
		<script>
			const title = document.querySelector('.title');
			const addss = document.querySelector('.e112_1077');
			const e112_List = document.querySelectorAll('.e112');
			title.innerHTML = "시설 소개";

			var address;

			for (let i = 0; i < e112_List.length; i++) {
				if ('${param.building}' == i + 1) {
					e112_List[i].style.backgroundColor = 'rgba(104.70051661133766, 176.69292032718658, 228.4374949336052, 1)';
					e112_List[i].style.color = 'white';
				}
			}

			if ('${param.building}' == 1) {
				address = " 서울특별시 강남구 테헤란로 14길 6 남도빌딩 2F, 3F, 4F, 5F, 6F";
			} else if ('${param.building}' == 2) {
				address = " 서울특별시 강남구 테헤란로 10길 9 그랑프리빌딩 4F, 5F, 7F";
			} else if ('${param.building}' == 3) {
				address = "	서울특별시 강남구 테헤란로 130 호산빌딩 5F, 6F";
			} else if ('${param.building}' == 4) {
				address = " 서울특별시 중구 남대문로 120 그레이츠 청계(구 대일빌딩) 2F, 3F";
			} else if ('${param.building}' == 5) {
				address = " 서울특별시 영등포구 선유동2로 57 이레빌딩 (구관) 19F, 20F";
			}

			addss.innerHTML += address;

			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					level: 3
					// 지도의 확대 레벨
				};

			// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
			var map = new kakao.maps.Map(mapContainer, mapOption);

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다
			geocoder
				.addressSearch(
					address,
					function (result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
								result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map: map,
								position: coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
								{
									content: '<div style="width:150px;text-align:center;padding:6px 0;">' + e112_List["${param.building}" - 1].innerHTML + '</div>'
								});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
		</script>