<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<link href="${root}/static/css/letter/receive-letter.css" rel="stylesheet">
		</head>

		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<div id="side-bar">
						<div>
							<form action="${root}/letter/write" method="get">
								<div id="select-button">
									<img src="${root}/static/img/letter/쪽지 쓰기.png">
									<input type="submit" value="쪽지 쓰기" id="write-letter">
								</div>
							</form>
						</div>
						<div>
							<form action="${root}/letter/sent" method="get">
								<div id="select-button">
									<img src="${root}/static/img/letter/보낸 쪽지.png">
									<input type="submit" value="보낸 쪽지" id="sent-letter">
								</div>
							</form>
						</div>
						<div>
							<form action="${root}/letter/receive" method="get">
								<div id="select-button">
									<img src="${root}/static/img/letter/받은 쪽지.png">
									<input type="submit" value="받은 쪽지" id="receive-letter" disabled>
								</div>
							</form>
						</div>
						<div>
							<form action="${root}/letter/trash" method="get">
								<div id="select-button">
									<img src="${root}/static/img/letter/휴지통.png">
									<input type="submit" value="휴지통" id="trash-can">
								</div>
							</form>
						</div>
					</div>
					<div id="letter-list">
						<table>
							<form action="${root}/letter/receive" method="post">
								<thead>
									<tr>
										<td colspan="5">
											<select name="searchType">
												<option value="writer">작성자</option>
												<option value="title">제목</option>
											</select>
											<input type="text" class="searchValueElem" name="searchValue"
												value="${searchVo.searchValue}" placeholder="검색할내용">
											<input type="submit" id="searchButton" value="검색하기">
										</td>
									</tr>
									<tr id="trHead">
										<td id="shortTd" style="width: 10%;"></td>
										<td>작성자</td>
										<td>제목</td>
										<td>날짜</td>
									</tr>
								</thead>
							</form>
							<tbody>
								<c:forEach items="${voList}" var="vo">
									<tr>
										<td style="width: 50px;">
											<input type="checkbox" class="checkbox" value="${vo.letterNo}">
										</td>
										<td style="width: 150px;">${vo.sendMemberName}</td>
										<td>${vo.letterTitle}</td>
										<td>${vo.enrollDate}</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td id="deleteTd" colspan="4">
										<button id="deleteButton" onclick="delButton();">삭제하기</button>
									</td>
								</tr>
								<tr>
									<td id="pageTd" colspan="4">
										<button onclick="pageMove('${pageVo.startPage}');"><<</button>
										<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="i">
											<button class="pageBtn" onclick="pageMove('${i}');">${i}</button>
										</c:forEach>
										<button onclick="pageMove('${pageVo.endPage}');">>></button>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</main>

				<%@ include file="/WEB-INF/views/common/footer.jsp" %>

		</body>

		</html>

		<script>
			const title = document.querySelector(".title");
			title.innerHTML = "받은 쪽지";

			const banner = document.querySelector(".banner");
			banner.style.marginBottom = 0;

			const caption = document.querySelector(".caption1");
			caption.style.marginTop = 0;

			const pageBtn = document.querySelectorAll('.pageBtn');

			function pageMove(i) {
				location.href = "${root}/letter/receive?page=" + i;
			}

			for (let btn of pageBtn) {
				if (btn.innerHTML == '${pageVo.currentPage}') {
					btn.style.backgroundColor = '#4998D1';
					btn.style.color = 'white';
				}
			}

			function delButton() {
				const checkboxes = document.querySelectorAll('.checkbox');
				var boxList = [];

				for (const checkbox of checkboxes) {
					if (checkbox.checked) {
						boxList.push(checkbox.value);
					}
				}
				$.ajax({
					url: '/semi/letter/delete/receive',
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

			const searchType = '${searchVo.searchType}';
			const searchValue = '${searchVo.searchValue}';

			const searchValueSelectTag = document.querySelector("select[name='searchValue']");
			const searchValueInputTag = document.querySelector("input[name='searchValue']");

			if (searchType.length > 1) {
				initSearchType();
			}

			// 검색 타입 초기셋팅
			function initSearchType() {
				const x = document.querySelector('select > option[value="' + searchType + '"]');
				x.selected = true;
			}


			//서치타입 변경 시 함수 실행
			const searchTypeTag = document.querySelector('select[name="searchType"]');
			searchTypeTag.addEventListener("change", setSearchValueTag);

			function setSearchValueTag() {
				const searchType = searchTypeTag.value;
					setSearchValueTagInput();
			}

			//검색값 영역을 인풋이 보이게 (타입이 카테고리가 아닐 때)
			function setSearchValueTagInput() {
				searchValueInputTag.classList.add("active");
				searchValueInputTag.disabled = false;
				searchValueSelectTag.classList.remove("active");
				searchValueSelectTag.disabled = true;
			}

			setSearchValueTag();

		</script>