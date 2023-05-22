<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>
	<head>
		<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="${root}/static/css/letter/trash-letter.css" rel="stylesheet">
		
	</head>
	<body>
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
			<main>
				<div id="side-bar">
					<div>
						<form action="${root}/letter/write" method="post">
							<div id="select-button">
								<img src="${root}/static/img/letter/쪽지 쓰기.png">
								<input type="submit" value="쪽지 쓰기" id="write-letter">
							</div>
						</form>
					</div>
					<div>
						<form action="${root}/letter/sent" method="post">
							<div id="select-button">
								<img src="${root}/static/img/letter/보낸 쪽지.png">
								<input type="submit" value="보낸 쪽지" id="sent-letter">
							</div>
						</form>
					</div>
					<div>
						<form action="${root}/letter/receive" method="post">
							<div id="select-button">
								<img src="${root}/static/img/letter/받은 쪽지.png">
								<input type="submit" value="받은 쪽지" id="receive-letter">
							</div>
						</form>
					</div>
					<div>
						<form action="${root}/letter/trash" method="post">
							<div id="select-button">
								<img src="${root}/static/img/letter/휴지통.png">
								<input type="submit" value="휴지통" id="trash-can" disabled>
							</div>
						</form>
					</div>
				</div>
				<div id="letter-list">
					<table>
						<form action="${root}/letter/trash" method="get">
							<thead>
								<tr>
									<td colspan="5" style="text-align: right;">
										<select name="searchSR" id="changeOpt">
											<option value="receiveLetter">받은메세지</option>
											<option value="sendLetter">보낸메세지</option>
										</select>
									</td>
								</tr>
								<tr>
									<td colspan="5">
										<select name="searchType">
											<option value="writer">작성자</option>
											<option value="title">내용</option>
										</select>
										<input type="text" name="searchValue" class="searchValueElem"
										value="${searchVo.searchValue}" placeholder="검색할내용">
										<input type="submit" value="검색하기">
									</td>
								</tr>
								<tr id="trHead">
									<td id="shortTd" style="width: 10%;"></td>
									<td>받은사람</td>
									<td>작성자</td>
									<td>내용내용내용</td>
									<td>날짜</td>
								</tr>
							</thead>
						</form>
						<tbody>
							<tr>
								<td><input type="checkbox"></td>
								<td>받은 편지</td>
								<td>작성자</td>
								<td>내용내용내용</td>
								<td>날짜</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td id="pageTd" colspan="5">
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
		title.innerHTML = "휴지통";

		const banner = document.querySelector(".banner");
		banner.style.marginBottom = 0;

		const caption = document.querySelector(".caption1");
		caption.style.marginTop = 0;

		const pageBtn = document.querySelectorAll('.pageBtn');

		function pageMove(i) {
			location.href = "${root}/letter/trash?page=" + i;
		}

		for (let btn of pageBtn) {
			if (btn.innerHTML == '${pageVo.currentPage}') {
				btn.style.backgroundColor = '#4998D1';
				btn.style.color = 'white';
			}
		}

		const opt = document.querySelector("#changeOpt");
		opt.addEventListener("change",function(){
			$.ajax({
				url: '/semi/letter/trash',
				type: 'post',
				data:JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				success:function(){
					alert("변경 완료")
				},
				error: function(){
					alert("변경 실패")
				}
			});
		});

	</script>