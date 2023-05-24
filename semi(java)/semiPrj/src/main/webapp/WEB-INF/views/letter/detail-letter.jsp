<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<link rel="stylesheet" href="${root}/static/css/letter/detail-letter.css">
		</head>
		<body>
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
				<main>
					<div id="side-bar">
						<div>
							<form action="${root}/letter/write" method="post">
								<div id="select-button">
									<img src="${root}/static/img/letter/쪽지 쓰기.png">
									<input type="submit" value="쪽지 쓰기" id="write-letter" disabled>
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
									<input type="submit" value="휴지통" id="trash-can">
								</div>
							</form>
						</div>
					</div>
					<div id="writeDiv">
						<div id="writeTable">
							<table>
								<thead>
									<tr>
										<th id="title" style="width: 100px;">받는 사람</th>
										<th><input type="text" name="receiver"></th>
                                        <th id="title">보낸 시간</th>
                                        <th><input type="text" value="시간" style="width: 75%;"></th>
									</tr>
									<tr>
										<th id="title">제목</th>
										<th id="inputText" colspan="3"><input type="text" name="title"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th colspan="4">
											<textarea></textarea>
										</th>
									</tr>
								</tbody>
								<tfoot>
									<tr>
                                        <th id="deleteTh">
                                        </th>
										<th colspan="3">
                                            <button id="delete">삭제하기</button>
											<button id="send">보내기</button>
										</th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</main>

				<%@ include file="/WEB-INF/views/common/footer.jsp" %>

		</body>

		</html>

		<script>
			const title = document.querySelector(".title");
			title.innerHTML = "쪽지 상세조회";

			const banner = document.querySelector(".banner");
			banner.style.marginBottom = 0;

			const caption = document.querySelector(".caption1");
			caption.style.marginTop = 0;
			
		</script>