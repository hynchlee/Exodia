<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/list.css" rel="stylesheet">
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style>
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<main>
			<c:if test="${not empty loginMember}">
                <div class="myClass">
                    <ul>
                        <li class="loginName">${loginMember.memberNick} 
                            <c:if test="${loginMember.identity eq 'S'}">
                                [${memberLecture[0].lectureName}]
                            </c:if>
                            님 환영합니다</li>
                        <li class="class">*통신예절에 어긋나는 글 등은 관리자에 의해 사전 통보없이 삭제 될 수 있습니다.</li>
                    </ul>
                </div>
            </c:if>

                <!-- <div class="board_search2">
                    <form action="${root}/class/list" method="get" name="searchBoard">
                        <input type="hidden" name="page" value="1">
                        <select class="searchCategory" name="searchType">
                            <option value="classTitle">제목</option>
                            <option value="classContent">내용</option>
                        </select>
                        <input type="text" class="searchInput" placeholder="검색어 입력" value="${searchVo.searchValue}" name="searchValue">
                        <input type="submit" value="검색" class="searchBtn">
                    </form>
                </div> -->
                <!-- <div class="choiceLecture">
                    <form action="${root}/class/list" method="get" name="classLecture">
                        <input type="hidden" name="page" value="1">
                        <select name="lectureNo" id="lectureNo">
                            <c:forEach items="${tvolist}" var="tvo">
                                <option class="tvoNo" value="${tvo.lectureNo}">${tvo.lectureCategoryName}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="조회">
                    </form>
                </div> -->


            <table class="board" style="margin-top: 90px;">
                <thead>
                    <tr>
                        <th style="width: 8%;">No</th>
                        <th>제목</th>
                        <th style="width: 10%;">작성자</th>
                        <th style="width: 15%;">작성일</th>
                        <th style="width: 8%;">조회수</th>
                    </tr>
                </thead>
                <tbody>
                	<c:if test="${loginMember.identity eq 'T' }">
	                    <c:forEach items="${tcvoList}" var="tcvo">
		                    <tr>
		                        <td>${tcvo.boardNo}</td>
		                        <td class="board_title">${tcvo.boardTitle}
			                        <c:if test="${tcvo.totalReplies > 0}">
				                        <span class="comment_num">[${tcvo.totalReplies}]</span>
			                        </c:if>
		                        </td>
		                        <td>${tcvo.writerNick}</td>
		                        <td>${tcvo.enrollDate}</td>
		                        <td>${tcvo.hit}</td>
		                    </tr>
	                    </c:forEach>
                	</c:if>
                </tbody>
            </table>
            
            <div class="board_bt" style="justify-content: flex-end;">
                <c:if test="${not empty loginMember || not empty loginAdmin}">
	                <a href="${root}/board/write" class="bt1">글 등록</a>
                </c:if>
            </div>
            
			<div class="board_page">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/class/tlist?page=${pv.currentPage-1}"><button><<</button></a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
					<c:if test="${pv.currentPage ne i}">
						<a href="${root}/class/tlist?page=${i}"><button>${i}</button></a>
					</c:if>
					<c:if test="${pv.currentPage eq i}">
						<a><button class="active">${i}</button></a>
					</c:if>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/class/tlist?page=${pv.currentPage+1}"><button>>></button></a>
				</c:if>
            </div>
           
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "우리반게시판";
</script>
<script>
    // const lnArr = document.querySelectorAll('.tvoNo');

    // // 서버에서 searchType 값을 JavaScript 변수로 설정
    // const searchType = "${searchVo.searchType}";
    
    // // 검색 타입
    // const nc = document.querySelector(`select > option[value="${searchVo.searchType}"]`);
    // if (nc) {
    // nc.selected = true;
    // }

    $(".board tbody tr").click(function(){
        //글번호 가져오기
        const bno = $(this).find('td:first-child').text();
        //const boardTitle = $(this).find('.board_title').text();
      
        // 페이지 이동을 위한 URL 구성
        const url = '${root}/board/detail?bno=' + bno;
        
        // 페이지 이동
        window.location.href = url;

    });
    
    

    // for (const ln of lnArr) {
    // const lectureNo = ln.value;

    // ln.addEventListener("change", function() {
    //     $.ajax({
    //     url: '${root}/class/list',
    //     type: "GET",
    //     data: {
    //         lectureNo: lectureNo
    //     },
    //     success: function() {
    //         location.reload();
    //     },
    //     error: function() {
    //         alert("에러");
    //     }
    //     })
    // });
    // }

    //     document.addEventListener("DOMContentLoaded", function() {
    //         // 선택한 값 가져오기
    //         var selectedValue = "${lectureVo.lectureNo}"; // lectureVo.lectureNo에는 세션에 저장된 강의 번호가 담겨있다고 가정합니다.
            
    //         // 선택한 값 설정하기
    //         var selectElement = document.getElementById("lectureNo");
    //         selectElement.value = selectedValue;
            
    //         // 변경 이벤트 처리
    //         selectElement.addEventListener("change", function() {
    //             // 선택한 값 유지하기
    //             selectedValue = this.value;
    //         });
    //     });

    

    

</script>
