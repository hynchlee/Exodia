<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
			<meta name="viewport"
				content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
			<!-- jquery CDN -->
			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
			<!-- fullcalendar CDN -->
			<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
			<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
			<!-- fullcalendar 언어 CDN -->
			<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
			<style>
				/* body 스타일 */
				html,
				body {
					font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
					font-size: 14px;
				}
				.fc-sticky{
					color: white;
				}
				
				/* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
				.fc-header-toolbar {
					padding-top: 1em;
					padding-left: 1em;
					padding-right: 1em;
				}

				/* 일요일 날짜 빨간색 */
				.fc-day-sun a {
				color: red;
				text-decoration: none;
				}

				/* 토요일 날짜 파란색 */
				.fc-day-sat a {
				color: blue;
				text-decoration: none;
				}

			</style>
			
		</head>

		<body>
			<!-- calendar 태그 -->
			<div id='calendar-container'>
				<div id='calendar'></div>
			</div>
			<script>
				
				function getRandomColor() {
					var letters = '0123456789ABCDEF';
					var color = '#';
					for (var i = 0; i < 6; i++) {
						color += letters[Math.floor(Math.random() * 16)];
						if(color == '#ffffff'){
							return color;
						}
					}
					return color;
				}

				var randomColor = getRandomColor(); // 랜덤 색상 생성

				(function () {
					$(function () {
						// calendar element 취득
						var calendarEl = $('#calendar')[0];
						// full-calendar 생성하기
						var calendar = new FullCalendar.Calendar(calendarEl, {
							height: '700px', // calendar 높이 설정
							expandRows: true, // 화면에 맞게 높이 재설정
							slotMinTime: '08:00', // Day 캘린더에서 시작 시간
							slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
							// 해더에 표시할 툴바
							headerToolbar: {
								left: 'prev,next today',
								center: 'title',
								right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
							},
							initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
							// initialDate: '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
							navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
							editable: true, // 수정 가능?
							selectable: true, // 달력 일자 드래그 설정가능
							nowIndicator: true, // 현재 시간 마크
							dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
							locale: 'ko', // 한국어 설정
							
							eventAdd: function (obj) { // 이벤트 추가(드래그))
								const params = [];
								params.push("write")
								params.push(obj.event.title);
								params.push(obj.event.start);
								params.push(obj.event.end);

								$.ajax({
									url: '/semi/teamCalendar',
									type: 'post',
									data: {
										params: JSON.stringify(params)
									},
									error: function () {
										alert("error");
									}
								});
							},
							eventChange: function (obj) { // 이벤트 수정(이벤트 드래그)
								const params = [];
								params.push("modify")
								params.push(obj.event.title);
								params.push(obj.event.start);
								params.push(obj.event.end);

								$.ajax({
									url: '/semi/teamCalendar',
									type: 'post',
									data: {
										params: JSON.stringify(params)
									},
									error: function () {
										alert("error");
									}
								});
							},
							eventClick: function (obj) { // 이벤트 삭제 (이벤트 클릭)
								var result = confirm('이 일정을 삭제하시겠습니까?');

								if (result == true) {
									const params = [];
									params.push("delete")
									params.push(obj.event.title);
									params.push(obj.event.start);
									params.push(obj.event.end);

									$.ajax({
										url: '/semi/teamCalendar',
										type: 'post',
										data: {
											params: JSON.stringify(params)
										},
										success: function() {
											location.reload();
										},
										error: function () {
											alert("error");
										}
									});
								}
							},

							
							select: function (arg) { // 드래그 or 클릭으로 이벤트 생성
								var title = prompt('일정을 입력해주세요');
								if (title) {
									calendar.addEvent({
										title: title,
										start: arg.start,
										end: arg.end,
										allDay: arg.allDay,
										backgroundColor: randomColor // 배경색 지정
									});
								}
								calendar.unselect()
							},
							// 이벤트 
							events: [
								<c:forEach items="${voList}" var="vo">
									{
									title: '${vo.meetingContent}',
									start: '${vo.startDate}',
									end: '${vo.endDate}',
									backgroundColor: getRandomColor()
									},
								</c:forEach>
							]
						});



						// 캘린더 랜더링
						calendar.render();
					});
				})();
			</script>
		</body>

		</html>