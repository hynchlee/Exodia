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

            <form action="" method="post">
                <div class="board_bt">
                    <a href="" class="bt1">목록으로</a>
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
                            <th>첨부파일</th>
                            <td></td>
                            <th>수정일</th>
                            <td>2023.05.01</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="3" style="height: 500px;">이곳은 내용자리</td>
                        </tr>
                    </tbody>
                </table>

                <p class="answer_title">답변 내용</p>

                <table class="qna_answer">
                    <colgroup>
                        <col width="15%">
                        <col width="35%">
                        <col width="15%">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>답변자</th>
                            <td>이곳은 답변자</td>
                            <th>작성일</th>
                            <td>2023.05.01</td>
                        </tr>
                        <tr>
                            <th>첨부파일</th>
                            <td></td>
                            <th>수정일</th>
                            <td>2023.05.06</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="3" style="height: 500px;">이곳은 내용자리</td>
                        </tr>
                    </tbody>
                </table>
    
                <div class="view_btn">
                    <input type="button" value="삭제하기">
                    <input type="submit" value="수정하기">
                </div>
    
                
                
            </form>
            
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "문의게시판";
</script>