<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/qnalist.css" rel="stylesheet">
<style>
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<main>
			<div class="myClass">
                <ul>
                    <li class="loginName">유저님 환영합니다</li>
                    <li class="class">(스마트웹&콘텐츠개발)반응형 UI/UX 웹콘텐츠 개발자 양성과정A</li>
                    <li class="classRoom">[강남 362] 2022. 12. 30 ~ 2023. 08. 16 ｜ 15:30 ~ 22:00 (심원용 강사 ｜ 김리아 취업담임)</li>
                </ul>
            </div>
            
            <form action="${root}/qna/list">
                <div class="board_search">
                    <div class="qna_control">
                        <label>
                            <input type="radio" name="contact" value="a_all" checked />
                            <span>전체글</span>
                          </label>
                        <label>
                            <input type="radio" name="contact" value="a_n"/>
                            <span>답변대기</span>
                          </label>
                          <label>
                            <input type="radio" name="contact" value="a_y" />
                            <span>답변완료</span>
                          </label>
                    </div>
            </form>
                <form action="" method="post" name="searchBoard">
                    <select class="searchCategory" name="searchCategory">
                        <option value="t">제목</option>
                        <option value="c">내용</option>
                        <option value="tc">제목+내용</option>
                    </select>
                    <input type="text" class="searchInput" placeholder="검색어 입력" name="searchText">
                    <input type="button" value="검색" class="searchBtn">
                </form>
            </div>
            
            <table class="board">
                <thead>
                    <tr>
                        <th style="width: 8%;">No</th>
                        <th style="width: 10%;">작성자</th>
                        <th>제목</th>
                        <th style="width: 15%;">작성일</th>
                        <th style="width: 8%;">상태</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">
                            <button class="bt_y">완료</button>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">
                            <button class="bt_n">대기</button>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">완료</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">완료</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">완료</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">완료</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">완료</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">완료</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>아무개</td>
                        <td class="board_title">글제목자리 <span class="new_btn">New</span></td>
                        <td>2023.05.01</td>
                        <td class="state">완료</td>
                    </tr>
                    
                </tbody>
            </table>
            <!-- 관리자나 강사가 클릭하면 다른 창 -->
            <div class="board_bt">
                <a href="${root}/board/write" class="bt1">질문하기</a>
            </div>
			<div class="board_page">
                <button><<</button>
                <button>1</button>
                <button>2</button>
                <button>3</button>
                <button>4</button>
                <button>5</button>
                <button>>></button>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "문의게시판";
</script>