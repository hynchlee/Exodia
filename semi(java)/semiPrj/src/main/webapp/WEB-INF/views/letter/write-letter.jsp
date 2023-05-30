<%@page import="com.semi.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/static/css/letter/write-letter.css">

</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<main>
		<div id="side-bar">
			<div>
				<form action="${root}/letter/write" method="get">
					<div id="select-button">
						<img src="${root}/static/img/letter/쪽지 쓰기.png"> <input
							type="submit" value="쪽지 쓰기" id="write-letter" disabled>
					</div>
				</form>
			</div>
			<div>
				<form action="${root}/letter/sent" method="get">
					<div id="select-button">
						<img src="${root}/static/img/letter/보낸 쪽지.png"> <input
							type="submit" value="보낸 쪽지" id="sent-letter">
					</div>
				</form>
			</div>
			<div>
				<form action="${root}/letter/receive" method="get">
					<div id="select-button">
						<img src="${root}/static/img/letter/받은 쪽지.png"> <input
							type="submit" value="받은 쪽지" id="receive-letter">
					</div>
				</form>
			</div>
			<div>
				<form action="${root}/letter/trash" method="get">
					<div id="select-button">
						<img src="${root}/static/img/letter/휴지통.png"> <input
							type="submit" value="휴지통" id="trash-can">
					</div>
				</form>
			</div>
		</div>
		<div id="writeDiv">
		<c:forEach items="${memberList}" var="member">
			${member.memberNick}
		</c:forEach>
			
			<form action="/semi/letter/write" id="writeTable" method="post"
				onsubmit="return showErrorOnSubmit();">
				<table>
					<thead>
						<tr>
							<th id="title">받는 사람</th>
							<th><input type="text" name="receiver" id="receiver">
								<input type="text" id="alertInput"
								style="padding-left: 10px; display: none; border: none; width: 30%; color: red;"></th>
						</tr>
						<tr>
							<th id="title">제목</th>
							<th id="inputText"><input type="text" name="title"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th colspan="2"><textarea name="content"></textarea></th>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="보내기"></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>

</html>

<script>
	const title = document.querySelector(".title");
	title.innerHTML = "쪽지 쓰기";

	const banner = document.querySelector(".banner");
	banner.style.marginBottom = 0;

	const caption = document.querySelector(".caption1");
	caption.style.marginTop = 0;

	const memberList = [<c:forEach items="${memberList}" var="member">
    '<c:out value="${member.memberNick}"/>',
  	</c:forEach>];
	
	function showErrorOnSubmit() {
		  const receiver = document.querySelector('#receiver');
		  const alertInput = document.querySelector('#alertInput');
		  const memberNicks = memberList; // memberNick을 배열로 집어넣기

		  if (receiver.value == '${loginMember.memberNick}') {
		    alertInput.value = '!오류: 받는 사람이 본인입니다.';
		    alertInput.style.display = 'inline';
		    return false;
		  } else if (!memberNicks.includes(receiver.value)) { // memberNickExists 대신 memberNicks.includes() 사용
		    alertInput.value = '!오류 : 받는 사람의 ID가 존재하지 않습니다.';
		    alertInput.style.display = 'inline';
		    return false;
		  }
		  alert('작성 완료');
		  return true;
		}
		
	
</script>