<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>
	<head>
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
								<input type="submit" value="받은 쪽지" id="receive-letter" disabled>
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
				<div id="letter-list">
					<table>
						<thead>
							<tr>
								<td>
									<select>
										<option value="">작성자</option>
										<option value="">타이틀</option>
									</select>
								</td>
								<td colspan="2">
									<input type="text" style="width: 100%;">
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="width: 50px;"><input type="checkbox"></td>
								<td style="width: 150px;">작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td>작성자</td>
								<td>타이틀</td>
								<td>날짜</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td id="deleteTd" colspan="4">
									<button id="deleteButton">삭제하기</button>
								</td>
							</tr>
							<tr>
								<td id="pageTd" colspan="4">
									<button><</button>
									<button>1</button>
									<button>2</button>
									<button>3</button>
									<button>4</button>
									<button>5</button>
									<button>></button>
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
	</script>