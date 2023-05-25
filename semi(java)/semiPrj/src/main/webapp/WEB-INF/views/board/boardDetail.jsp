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
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
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

            <div class="board_bt">
                <!-- 카테고리에 따라 목록 나누기 -->
                <c:if test="${cvNo.boardCategoryType eq '우리반게시판'}">
	                <a href="${root}/class/list?page=1" class="bt1">목록으로</a>
                </c:if>
                <c:if test="${cvNo.boardCategoryType eq '자유게시판'}">
	                <a href="${root}/free/list?page=1" class="bt1">목록으로</a>
                </c:if>
            </div>

            <form action="${root}/board/detail?bno=${cvNo.boardNo}" method="post" enctype="multipart/form-data">

                <!-- 관리자에게만 보이는 체크박스 -->
				<c:if test="${not empty loginAdmin }">
	                <div class="checked">
	                    <input type="checkbox" name="" id=""><span>상단고정</span>
	                </div>
				</c:if>
    
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
                            <td>${cvNo.boardTitle}</td>
                            <th>조회수</th>
                            <td colspan="4/6">${cvNo.hit}</td>
                        </tr>
                        <tr>
                            <th>작성자</th>
                            <td>${cvNo.writerNick}</td>
                            <th>작성일</th>
                            <td>${cvNo.enrollDate}</td>
                            <td class="edit_date">${cvNo.modifyDate}</td>
                        </tr>
                        <!-- 후기게시판과 큐엔에이 게시판에만 보임 -->
                        <tr>
                            <th>내용</th>
                            <td colspan="4" style="height: 500px;">${cvNo.boardContent}</td>
                        </tr>
                        <!-- <tr>
                            <th>첨부파일</th>
                            <td colspan="4"></td>
                        </tr> -->
                    </tbody>
                </table>
                <!-- 작성자에게만 보이기 -->
                <c:if test="${loginMember.memberNo eq cvNo.memberNo }">
	                <div class="view_btn">
	                	<a href="${root}/board/delete?bno=${cvNo.boardNo}" class="bt1" id="del">삭제하기</a>
	                    <a href="${root}/board/edit?bno=${cvNo.boardNo}" class="bt1">수정하기</a>
	                </div>
                </c:if>
            </form>

            <!-- 댓글 -->
            <div id="reply-area">
                <input type="hidden" name="bno" value="${cvNo.boardNo}">
                <div class="write_comment">
                    <span>댓글</span> 
                    <textarea name="replyContent" class="view_comment" style="resize: none; height: 50px;" required></textarea>
                    <input type="button" onclick="writeComment();" value="댓글작성">

                    <!-- 댓글 조회 -->
                    <!-- <c:if test="${cvo.totalReplies > 0}"> -->
                        <div class="comment_list">
                            <!-- <c:forEach items="${revoList}" var="re"> -->
                                <div class="comment_col">
                                    <span></span>
                                    <span></span>
                                    <input type="button" value="수정">
                                    <input type="button" value="삭제">
                                    <input type="button" value="답글" id="onDisplay">
                                    <span class="time"></span>
                                </div>
                            <!-- </c:forEach> -->
                            <!-- <div class="recomment">
                                <i class="bi bi-arrow-return-right"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z"/>
                                  </svg></i>
                                <span>작성자</span>
                                <span>답글내용자리는이곳이다</span>
                                <input type="button" value="수정">
                                <input type="button" value="삭제">
                                <span class="time">2023.05.01 - 00:00:00:00</span>
                            </div> -->
                        </div>
                        <!-- 답글달기 -->
                        <div class="recomment_write" id="noneDiv" style="display: none;">
                            <span>답글</span>
                            <input type="text">
                            <input type="button" value="작성">
                            <input type="button" id="offDisplay" value="취소">
                        </div>
                    <!-- </c:if> -->
                </div>
            </div>
	            
	            
            
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	// const title = document.querySelector('.title');
	// title.innerHTML = "${cvNo.boardCategoryType}";

    // // 답글 작성란 보이기 숨기기

    // $(function(){
    //     $('#onDisplay').click(function(){
    //         if($("#noneDiv").css("display") == "none"){
    //             $('#noneDiv').show();
    //         }
    //     });
    // });

    // $(function(){
    //     $('#offDisplay').click(function(){
    //         if($("#noneDiv").css("display") != "none"){
    //             $('#noneDiv').hide();
    //         }
    //     })
    // })

    // // $('#onDisplay').click(function(){
    // //     $('#noneDiv').show();
    // // })

    // // $('#offDisplay').click(function(){
    // //     $('#noneDiv').hide();
    // // })

    // $(function(){
    //     $("#onDisplay").on("click",function(){
    //         $("#noneDiv").show();
    //     })
    //     $("#offDisplay").on("click",function(){
    //         $("noneDiv").hide();
    //     })
    // })

    //댓글 작성
    function writeComment(){
        const comment = document.querySelector("textarea[name=replyContent]").value;
        $.ajax({
            url : "${root}/board/reply/write",
            type : "POST",
            data : {
                bno : '${cvNo.boardNo}',
                replyContent : comment,
            },
            success : (x)=>{
                console.log(x);
                if(x = "success"){
                    alert("댓글 작성 완료");
                }
            },
            error : (x)=>{
                console.log(x);
            },
        });
    }

    //댓글 조회
    function loadComment(){
        const replyList = document.querySelector('.comment_col');

        $.ajax({
            url : '${root}/board/reply/list',
            type : "GET",
            data : {
                bno : '${cvNo.boardNo}',

            },
            success : function(result){
                console.log(result);
                const x = JSON.parse(result);
                console.log(x);

                for(let i = 0; i < x.length; i++){
                    replyList.innerHTML 
                                += "<span>" + x[0].replyContent 
                                + "</span><span>" 
                                + x[0].writerNick 
                                + "</span>";
                }
            },
            error : function(e){
                console.log(e);
            },
        });

        let str = '';
        str += '';

        replyList.innerHTML = str;
    }

    //댓글 조회 호출
    loadComment();

</script>
