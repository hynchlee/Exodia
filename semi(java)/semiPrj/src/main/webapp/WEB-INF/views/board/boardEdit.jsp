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
                <!-- 카테고리에 따라 목록 나누기 -->
                <a href="${root}/class/list" class="bt1">목록으로</a>
            </div>

            <form action="${root}/board/write" method="post" enctype="multipart/form-data">

                <!-- 관리자에게만 보이는 체크박스 -->
                <div class="checked">
                    <input type="checkbox" name="" id=""><span>상단고정</span>
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
                    <input type="button" class="bt1" value="삭제하기">
                    <input type="submit" class="bt1" value="수정하기">
                </div>
            </form>

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
                <div class="recomment">
                    <i class="bi bi-arrow-return-right"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z"/>
                      </svg></i>
                    <span>작성자</span>
                    <span>답글내용자리는이곳이다</span>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                    <span class="time">2023.05.01 - 00:00:00:00</span>
                </div>
                <div class="recomment">
                    <i class="bi bi-arrow-return-right"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z"/>
                      </svg></i>
                    <span>작성자</span>
                    <span>답글내용자리는이곳이다</span>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                    <span class="time">2023.05.01 - 00:00:00:00</span>
                </div>
                <div class="recomment_write">
                    <span>답글</span>
                    <input type="text">
                    <input type="button" value="작성">
                    <input type="button" value="취소">
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