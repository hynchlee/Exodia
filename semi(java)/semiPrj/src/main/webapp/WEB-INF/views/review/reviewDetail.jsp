<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/edit.css" rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<main>
			 <div class="myClass">
                <ul>
                    <li class="boardCategoryName">상세조회</li>
                </ul>
            </div>
            
            <form action="${root}/review/detail" method="post">
                <div class="board_bt">
                    <a href="${root}/review/list?page=1" class="bt1">목록으로</a>
                </div>
    
                <table class="board_view">
                    <colgroup>
                        <col width="15%">
                        <col width="50%">
                        <col width="15%">
                        <col width="*%">
                        <col width="10">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>제목</th>
                            <td colspan="4">${rvNo.reviewTitle}</td>
                        </tr>
                        <tr>
                            <th>작성자</th>
                            <td>${rvNo.writerNick}</td>
                            <th>작성일</th>
                            <td>${rvNo.enrollDate}</td>
                            <td class="edit_date">${rvNo.modifyDate}</td>
                        </tr>
                        <!-- 후기게시판과 큐엔에이 게시판에만 보임 -->
                        <tr>
                            <th>강좌명</th>
                            <td colspan="4">${rvNo.lectureName}</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="4" style="height: 500px;">${rvNo.reviewContent}</td>
                        </tr>
                        
                    </tbody>
                </table>

                <c:if test="${loginMember.memberNo == rvNo.memberNo}">
					<div class="view_btn">
	                    <a href="${root}/review/delete?rno=${rvNo.reviewNo}" class="bt1" id="del">삭제하기</a>
	                    <a href="${root}/review/edit?rno=${rvNo.reviewNo}" class="bt1">수정하기</a>
                	</div>
                </c:if>

            </form>
            
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "수강후기";
</script>