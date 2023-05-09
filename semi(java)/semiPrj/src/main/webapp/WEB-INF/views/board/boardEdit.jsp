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
                    <li class="class">(스마트웹&콘텐츠개발)반응형 UI/UX 웹콘텐츠 개발자 양성과정A</li>
                    <li class="classRoom">[강남 362] 2022. 12. 30 ~ 2023. 08. 16 ｜ 15:30 ~ 22:00 (심원용 강사 ｜ 김리아 취업담임)</li>
                </ul>
            </div>

            <div class="board_bt">
                <input type="submit" value="삭제하기" class="bt1">
            </div>

            <table class="board_view">
                <colgroup>
                    <col width="15%">
                    <col width="35%">
                    <col width="15%">
                    <col width="*">
                </colgroup>
                <tbody>
                    <tr>
                        <th>제목</th>
                        <td>이곳은제목자리</td>
                        <th>조회수</th>
                        <td>77</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>이곳은작성자</td>
                        <th>작성일</th>
                        <td>2023.05.01</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td colspan="3" style="height: 500px;">이곳은 내용자리</td>
                    </tr>
                </tbody>
            </table>
            <div class="view_btn">
                <a href="">목록으로</a>
                <input type="submit" value="수정하기">
            </div>

            <div class="write_comment">
                <span>댓글쓰기</span> 
                <textarea name="comment" class="view_comment" style="resize: none; height: 50px;"></textarea> 
                <input type="submit" value="댓글작성">
            </div>
            <div class="comment_list">
                <div class="comment_col">
                    <span>작성자</span>
                    <span>댓글내용자리는이곳이다</span>
                    <span>2023.05.01</span>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                </div>
                <div class="comment_col">
                    <span>작성자</span>
                    <span>댓글내용자리는이곳이다</span>
                    <span>2023.05.01</span>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                </div>
                <div class="comment_col">
                    <span>작성자</span>
                    <span>댓글내용자리는이곳이다</span>
                    <span>2023.05.01</span>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                </div>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "자유게시판";
</script>