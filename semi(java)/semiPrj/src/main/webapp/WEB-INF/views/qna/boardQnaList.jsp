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
            
            <div class="board_search">
	            <form action="${root}/qna/list">
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
            	<div></div>
              <form action="${root}/qna/list" method="get" name="searchBoard">
                	<input type="hidden" name="page" value="1">
                    <select class="searchCategory" name="searchType">
                        <option value="qnaTitle">제목</option>
                        <option value="qnaContent">내용</option>
                    </select>
                    <input type="text" class="searchInput" placeholder="검색어 입력" value="${searchVo.searchValue}" name="searchValue">
                    <input type="submit" value="검색" class="searchBtn">
              </form>
            </div>
            
            <table class="board">
                <thead>
                    <tr>
                        <th style="width: 8%;">No</th>
                        <th style="width: 10%;">작성자</th>
                        <th>제목</th>
                        <th style="width: 15%;">작성일</th>
                        <th style="width: 8%;">답변상태</th>
                        <th style="display: none;"><input type="checkbox"></th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${qvoList}" var="qvo">
	                    <tr>
	                        <td>${qvo.qnaNo}</td>
	                        <td>${qvo.writerNick}</td>
	                        <td class="board_title">${qvo.qnaTitle}</td>
	                        <td>${qvo.enrollDate}</td>
	                        <td class="state">
	                        	<c:if test="${not empty qvo.qnaAnswer}">
		                            <button class="bt_y">완료</button>
	                        	</c:if>
	                        	<c:if test="${empty qvo.qnaAnswer}">
		                            <button class="bt_n">대기</button>
	                        	</c:if>
	                        </td>
                          <td style="display: none;"><input type="checkbox" value="${qvo.qnaNo}"></td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
            
            <div class="board_bt">
              <!-- 관리자 기능 - 게시글 삭제 -->
              <c:if test="${not empty loginAdmin }">
                <a class="bt1" id="btred" onclick="adminBoardDelete();">일괄 삭제</a>
                <div></div>
              </c:if>
              <c:if test="${not empty loginMember && loginMember.identity eq 'S'}">
                <div></div>
                <a href="${root}/qna/write" class="bt1">질문하기</a>
              </c:if>
            </div>
            
			<div class="board_page">
				<c:if test="${pv.currentPage > 1}">
					<a href="${root}/qna/list?page=${pv.currentPage-1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button><<</button></a>
				</c:if>
				<c:forEach begin="${pv.startPage}" end="${pv.endPage}" var="i">
					<c:if test="${pv.currentPage ne i}">
						<a href="${root}/qna/list?page=${i}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>${i}</button></a>
					</c:if>
					<c:if test="${pv.currentPage eq i}">
						<a><button class="active">${i}</button></a>
					</c:if>
				</c:forEach>
				<c:if test="${pv.currentPage < pv.maxPage}">
					<a href="${root}/qna/list?page=${pv.currentPage+1}&searchType=${searchVo.searchType}&searchValue=${searchVo.searchValue}"><button>>></button></a>
				</c:if>
            </div>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "문의게시판";
</script>
<script>

    // 서버에서 searchType 값을 JavaScript 변수로 설정
    const searchType = "${searchVo.searchType}";

    // 검색 타입
    const nc = document.querySelector(`select > option[value="${searchVo.searchType}"]`);
    if (nc) {
    nc.selected = true;
    }

    $(".board tbody tr").click(function(){
        //글번호 가져오기
        const qno = $(this).find('td:first-child').text();
        // const boardTitle = $(this).find('.board_title').text();
      
        // 페이지 이동을 위한 URL 구성
        const url = '${root}/qna/detail?qno=' + qno;
        
        // 페이지 이동
        window.location.href = url;

    });



</script>
<script>
    $(document).ready(function() {
      handleRadioButtonSelection();
  
      $("input[name='contact']").change(function() {
        handleRadioButtonSelection();
      });
  
      function handleRadioButtonSelection() {
        var selectedValue = $("input[name='contact']:checked").val();
  
        $("table.board tbody tr").hide();
  
        if (selectedValue === "a_all") {
          $("table.board tbody tr").show();
        } else if (selectedValue === "a_n") {
          $("table.board tbody tr").each(function() {
            if ($(this).find(".state .bt_n").length) {
              $(this).show();
            }
          });
        } else if (selectedValue === "a_y") {
          $("table.board tbody tr").each(function() {
            if ($(this).find(".state .bt_y").length) {
              $(this).show();
            }
          });
        }
      }
    });


     //체크박스 이동 막기
     $(".board tbody tr input[type='checkbox']").click(function(event) {
        event.stopPropagation();
    });

    document.querySelector(".board th:last-child").addEventListener('change', setAllcheckbox);

    //체크박스 전체 선택
    function setAllcheckbox(){
        //가장 위 체크박스의 체크 상태 가져오기
        const v = document.querySelector(".board thead th input[type='checkbox']").checked;
        //모든 체크박스 가져오기
        const cbArr = document.querySelectorAll(".board tbody tr input[type='checkbox']");
        //checked 값 변경
        for(let cb of cbArr){
            cb.checked = v;

        }
    }


    //체크박스 열 나타내기
    function adminBoardDelete() {

        var checkboxHeaders = document.querySelectorAll(".board th:last-child");
        var checkboxColumns = document.querySelectorAll(".board td:last-child");

        const bnoArr = [];
        const cbArr = document.querySelectorAll(".board tbody tr input[type='checkbox']");
        for(let cb of cbArr){
            if(cb.checked == true){
                bnoArr.push(cb.value);
            }
        }

        //번호 넘기기
        $.ajax({
            url: '${root}/qna/delete',
            type: 'post',
            data: {
                bnoArr : JSON.stringify(bnoArr)
            },
            success: function(data){
                console.log(data);
                if (data === "success") {
                    alert("게시글 삭제 성공");
                    refreshPage();
                } else {
                    console.log("Deletion failed");
                }
            },
            error: function(error){
                console.log(error);
            },
        });

        checkboxHeaders.forEach(function(header) {
            header.style.display = "table-cell";
        });

        checkboxColumns.forEach(function(column) {
            column.style.display = "table-cell";
        });

    }

    function refreshPage() {
    location.reload();
    }
  </script>