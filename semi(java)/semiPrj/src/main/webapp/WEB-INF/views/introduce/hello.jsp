<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>HeaderTest</title>
		<link rel="stylesheet" href="./static/css/introduce/hello.css">
	</head>

	<body>
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
			<main>
				<div class="wrap_1">
					<img src="${root}/static/img/introduce/___7.png" alt="logo" id="master_img">
					<div class="e112_188">
						안녕하십니까?
						<br>
						KH UNIV 대표 심원용입니다
					</div>
					<div class="e112_189">
						IT 전문가가 되는 방법, KH 정보대학원에 있습니다.
						<br>
						국민내일배움카드 소지자 및 국민취업제도 참여자는 누구나 신청하실 수 있습니다.
					</div>

					<hr>

					<div class="e112_192">
						KH UNIV 를 찾아주셔서 감사합니다
					</div>
					<div class="e112_193">
						KH 그룹에 따뜻한 격려와 사랑을 아낌없이 보내주시는 주주와 고객여러분의 성원에 진심으로 감사드립니다.
						<br>
						<br>
						반얀나무는 한 그루에서 가지가 뻗어 나가다 휘어져 땅에 닿으면 거기서 다시 뿌리가 나서 자라나 새로운 가지를 만들어 넓은 숲을 만듭니다.
						반얀나무처럼 고객의 행복나무 가지가 뻗어 나가서 뿌리를 내려 또 다른 고객의 행복 나무를 만드는 것, 이것이 KH 그룹의 정신입니다.


					</div>
					<div class="e112_194">
						우리 그룹은 새로운 도약을 위해서 도전을 멈추지 않겠습니다.
						시대 변화에 따른 시장의 변화를 수시로 관찰하여 새로운 수익 모델의 방향을 제시하고 신성장 동력을 발굴하는 데
						게을리 하지 않겠습니다. 촘촘한 사업 포트폴리오를 바탕으로 건실한 경영을 해 나가겠습니다.
						<br>

						KH 그룹이 성장할 수 있었던 것은 주주와 고객 여러분의 큰 신뢰와 응원 덕분입니다. 그 신뢰와 응원에 보답하기 위해 전 임직원들은 행복을 나누는 기업의 모범이 되고자
						최선을 다하겠습니다.

						감사합니다.
					</div>
					<img src="${root}/static/img/introduce/sign.PNG" alt="logo" id="sign_img">
				</div>
			</main>
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</body>

	</html>

	<script>
		const title = document.querySelector('.title');
		title.innerHTML = "인사말";
	</script>