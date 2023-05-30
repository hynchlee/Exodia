<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<link href="${root}/static/css/lecture/test/manage.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<div class="tit">${problemList[0][0].examSubject}</div>
					<br><br><br><br>

					<c:forEach items="${problemList}" var="problems">
						<div class="problem">
							<div class="score">
								<div class="a02">${problems[0].problemPoint} 점</div>
							</div>
							<div class="b01">
								<c:forEach items="${problems}" var="p">
									<div class="bb01">
										<div class="bbb01">
											<span class="pro${p.examProblemNo}">${p.problem}</span>
											<input type="checkbox" class="checkbox" value="${p.examProblemNo}">
										</div>
										<div class="bbb02">
											<span class="ans${p.examProblemNo}">${p.answer}</span>
										</div>
									</div>
								</c:forEach>
							</div>
							<br>
							<div class="wrap_1">
								<div class="menu_3">
									<div class="btn">
										<button class="modbtn1" onclick="modButton1();">수정</button>
										<button class="modbtn2" hidden onclick="modButton2();">저장</button>
										<button onclick="delButton();">삭제</button>
										<button class="plusbtn1" onclick="plusButton();">추가</button>
										<button class="plusbtn2" hidden onclick="plusSave('${problems[0].examCategoryNo}', '${problems[0].problemPoint}');">저장</button>
									</div>
								</div>
							</div>
						</div>
						<br><br><br><br>
					</c:forEach>

					<div class="finish">
						<a href="${root}/lecture/test/info" class="finish-btn">수정</a>
					</div>
				</main>
				<%@ include file="/WEB-INF/views/common/footer.jsp" %>

		</body>

		</html>

		<script>
			const title = document.querySelector('.title');
			const modbtn1 = document.querySelector('.modbtn1');
			const modbtn2 = document.querySelector('.modbtn2');
			const plusbtn1 = document.querySelector('.plusbtn1');
			const plusbtn2 = document.querySelector('.plusbtn2');
			const checkboxes = document.querySelectorAll('.checkbox');
			const tbd = document.querySelector('.b01');
			title.innerHTML = "시험 관리";

			const pageBtn = document.querySelectorAll('.pageBtn');

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}

			function modButton1() {
				var boxList = [];
				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				if (boxList.length == 0) {
					alert("수정할 문제를 선택해주세요");
					return;
				}

				for (const chbox of boxList) {
					const pro = document.querySelector('.pro' + chbox);
					const ans = document.querySelector('.ans' + chbox);
					const proHtml = pro.innerHTML;
					const ansHtml = ans.innerHTML;

					pro.innerHTML = '<input style="overflow-y:none; overflow-x:none; width: 100%; height: 200%;" type="text" value="' + proHtml + '">';
					ans.innerHTML = '<input style="overflow-y:none; overflow-x:none; width: 100%; height: 200%;" type="text" value="' + ansHtml + '">';
				}

				modbtn1.hidden = true;
				modbtn2.hidden = false;
			}

			function modButton2() {
				var boxList = [];
				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}

				for (const chbox of boxList) {
					const pro = document.querySelector('.pro' + chbox + ' input');
					const ans = document.querySelector('.ans' + chbox + ' input');
					
					var bList = [];
					bList.push('mod');
					bList.push(chbox);
					bList.push(pro.value);
					bList.push(ans.value);

					$.ajax({
						url: '/semi/lecture/test/manage',
						type: 'post',
						data: JSON.stringify(bList),
						contentType: "application/json",
						success: function () {
							location.reload();
						},
						error: function () {
							alert("에러");
						}
					});
				}

				alert("수정 완료");
				modbtn1.hidden = false;
				modbtn2.hidden = true;
			}

			function delButton() {
				var boxList = [];
				boxList.push('del');
				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}
				
				if (boxList.length == 1) {
					alert("삭제할 문제를 선택해주세요");
					return;
				}

				$.ajax({
					url: '/semi/lecture/test/manage',
					type: 'post',
					data: JSON.stringify(boxList),
					contentType: "application/json",
					success: function () {
						alert("삭제완료");
						location.reload();
					},
					error: function () {
						alert("에러");
					}
				});
			}

			function plusButton() {
				var txt = tbd.innerHTML;
				var plusTxt = '<input class="newIpt1" placeholder="문제" style="margin: 5px; overflow-y:none; overflow-x:none; width: 95%; height: 75px;" type="text"> <input class="newIpt2" placeholder="정답" style="margin: 5px; overflow-y:none; overflow-x:none; width: 95%; height: 75px;" type="text">';
				tbd.innerHTML = plusTxt + txt;

				plusbtn1.hidden = true;
				plusbtn2.hidden = false;
			}

			function plusSave(examCategoryNo, point) {
				var boxList = [];
				const newIpt1 = document.querySelector('.newIpt1');
				const newIpt2 = document.querySelector('.newIpt2');

				boxList.push('plus');
				boxList.push(examCategoryNo);
				boxList.push(point);
				boxList.push(newIpt1.value);
				boxList.push(newIpt2.value);

				$.ajax({
					url: '/semi/lecture/test/manage',
					type: 'post',
					data: JSON.stringify(boxList),
					contentType: "application/json",
					success: function () {
						alert("문제 추가 완료");
						location.reload();
					},
					error: function () {
						alert("에러");
					}
				});

				plusbtn1.hidden = false;
				plusbtn2.hidden = true;
			}
		</script>