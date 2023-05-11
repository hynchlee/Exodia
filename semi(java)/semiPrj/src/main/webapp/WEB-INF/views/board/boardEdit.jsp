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
                <a href="" class="bt1">목록으로</a>
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
                        <td>이곳은제목자리</td>
                        <th>조회수</th>
                        <td colspan="4/6">77</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>이곳은작성자</td>
                        <th>작성일</th>
                        <td>2023.05.01</td>
                        <td class="edit_date">2023.05.06</td>
                    </tr>
                    <!-- 후기게시판과 큐엔에이 게시판에만 보임 -->
                    <tr>
                        <th>강좌명</th>
                        <td colspan="4">(스마트웹&콘텐츠개발)반응형 UI/UX 웹콘텐츠 개발자 양성과정A</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td colspan="4" style="height: 500px;">이곳은 내용자리</td>
                    </tr>
                    <tr>
                        <th>첨부파일</th>
                        <td colspan="4"></td>
                    </tr>
                </tbody>
            </table>
            <!-- 작성자에게만 보이기 -->
            <div class="view_btn">
                <input type="button" value="삭제하기">
                <input type="submit" value="수정하기">
            </div>

            <!-- 큐엔에이, 후기게시판은 답글 안받음 -->
            <div class="write_comment">
                <span>댓글쓰기</span> 
                <textarea name="comment" class="view_comment" style="resize: none; height: 50px;"></textarea> 
                <input type="submit" value="댓글작성">
            </div>
            <div class="comment_list">
                <div class="comment_col">
                    <span>작성자</span>
                    <span>댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                    </span>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                    <input type="button" value="답글">
                    <span class="time">2023.05.01 - 00:00:00:00</span>
                </div>
                <div class="comment_col">
                    <span>작성자</span>
                    <span>댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                        댓글내용자리는이곳이다
                    </span>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                    <input type="button" value="답글">
                    <span class="time">2023.05.01 - 00:00:00:00</span>
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