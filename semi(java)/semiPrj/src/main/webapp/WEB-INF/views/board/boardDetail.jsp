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
                    <c:if test="${loginMember.identity eq 'S' }">
		                <a href="${root}/class/slist?page=1" class="bt1">목록으로</a>
                    </c:if>
                    <c:if test="${loginMember.identity eq 'T' }">
		                <a href="${root}/class/tlist?page=1" class="bt1">목록으로</a>
                    </c:if>
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
                        <col width="10%">
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
                </div>   
                    <!-- 댓글 조회 -->
                        <div class="comment_list">
                                <div class="comment_col">
                                    <!-- <span></span>
                                    <span></span>
                                    <input type="button" value="수정">
                                    <input type="button" value="삭제">
                                    <input type="button" value="답글" id="onDisplay">
                                    <span class="time"></span> -->
                                    <!-- <div class="recomment">
                                    </div> -->
                                </div>
                                <!-- <i class="bi bi-arrow-return-right"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z"/>
                                  </svg></i>
                                <span>작성자</span>
                                <span>답글내용자리는이곳이다</span>
                                <input type="button" value="수정">
                                <input type="button" value="삭제">
                                <span class="time">2023.05.01 - 00:00:00:00</span> -->
                                <!-- 답글달기 -->
                                <div class="recomment_write" id="noneDiv" style="display: none;">
                                    <span>답글</span>
                                    <input type="text">
                                    <input type="button" value="작성">
                                    <input type="button" id="offDisplay" value="취소">
                                </div>
                                </div>
                        </div>
            </div>
	            
            
            
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>

    
	const title = document.querySelector('.title');
	title.innerHTML = "${cvNo.boardCategoryType}";

    // 답글 작성란 보이기 숨기기

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

    // $('#onDisplay').click(function(){
    //     $('#noneDiv').show();
    // })

    // $('#offDisplay').click(function(){
    //     $('#noneDiv').hide();
    // })

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
                if(x === "success"){
                    alert("댓글 작성 성공");
                    document.querySelector("textarea[name=replyContent]").value='';
                    //댓글 조회 호출
                    loadComment();
                    loadAnswer();
                }
            },
            error : (x)=>{
                console.log(x);
            },
        });
    }


    // 댓글 조회
    function loadComment() {
    const replyList = document.querySelector('.comment_col');
    const loginMemberNo = '${loginMember.memberNo}';

    if (replyList) {
        $.ajax({
        url: '${root}/board/reply/list',
        type: "GET",
        data: {
            bno: '${cvNo.boardNo}',
        },
        success: function(result) {
            console.log(result);
            const x = JSON.parse(result);
            console.log(x);

            replyList.innerHTML = "";
            let str = "";
            for (let i = 0; i < x.length; i++) {
            str += '<div class="reply_col">';
            str += '<span>' + x[i].writerNick + '</span>';
            str += '<input type="text" name="rC" style="border:none;" value="' + x[i].replyContent + '" readonly>';
            str += '<div></div>';
            if (loginMemberNo == x[i].writerNo) {
                // str += '<input type="button" value="수정" onclick="edit(' + x[i].replyNo + ', \'' + x[i].replyContent + '\');">';
                str += '<input type="button" value="삭제" onclick="deleteComment(' + x[i].replyNo + ');">';
            } else if (loginMemberNo != x[i].writerNo) {
                // str += '<div></div>';
                str += '<div></div>';
            }
            str += '<input type="button" value="답글" id="onDisplay" onclick="loadAnswer(' + x[i].replyNo + ', this.parentElement);">';
            str += '<span class="time">' + x[i].enrollDate + '</span>';
            if(x[i].answerCount > 0){
                str += '<span>[' + x[i].answerCount + ']</span>';
            }else{
                str += '<div></div>'
            }
            str += '<div class="recomment" id="recomment-' + x[i].replyNo + '"></div>'; // 각 댓글에 대한 답글을 구분할 ID를 추가

            str += '</div>';
            }
            replyList.innerHTML += str;
        },
        error: function(e) {
            console.log(e);
        },
        });
    }
    }


  // 답글 조회
  function loadAnswer(replyNo, parentElement) {
  const recomment = parentElement.querySelector('.recomment');
  const recommentWrite = parentElement.querySelector('.recomment_write');
  const loginMemberNo = '${loginMember.memberNo}';

  if (recomment.style.display === 'grid') {
    recomment.style.display = 'none';
    recommentWrite.style.display = 'none';
  } else {
    $.ajax({
      url: '${root}/board/answer/list',
      type: "GET",
      data: {
        rno: replyNo,
      },
      success: function(result) {
        console.log(result);
        const x = JSON.parse(result);
        console.log(x);

        let str = "";
        for (let i = 0; i < x.length; i++) {
          str += '<i class="bi bi-arrow-return-right"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">';
          str += '<path fill-rule="evenodd" d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z"/>';
          str += '</svg>';
          str += '</i>';
          str += '<span>' + x[i].answerWriterNick + '</span>';
          str += '<span>' + x[i].answerContent + '</span>';
          str += '<div></div>';
          if(loginMemberNo == x[i].memberNo){
            str += '<input type="button" value="삭제" onclick="deleteAnswer(' + x[i].answerNo + ');">';
          }else{
            str += '<div></div>';
          }
          str += '<span class="time">' + x[i].enrollDate + '</span>';
        }

        str += '<div class="recomment_write">';
        str += '<span>답글</span>';
        str += '<input type="text" name="answerContent">';
        str += '<input type="button" value="작성" onclick="writeAnswer(' + replyNo + ', this.parentElement);">';
        str += '</div>';

        recomment.style.display = 'grid';
        recomment.innerHTML = str;
        recommentWrite.style.display = 'block';
      },
      error: function(e) {
        console.log(e);
      },
    });
  }
}

// 댓글 삭제
function deleteComment(replyNo) {
  $.ajax({
    url: '${root}/board/reply/delete',
    type: 'POST',
    data: {
      rno: replyNo,
    },
    success: function(result) {
      alert('댓글 삭제 성공');
      loadComment();
    },
    error: function(e) {
      alert('댓글 삭제 실패');
    },
  });
}

//답글 삭제
function deleteAnswer(answerNo) {
  $.ajax({
    url: '${root}/board/answer/delete',
    type: 'POST',
    data: {
      ano: answerNo,
    },
    success: function(result){
      alert("답글 삭제 성공");
      loadComment();
    },
    error: function(e){
      alert('답글 삭제 실패');
    },
  });
}

// 답글 작성
function writeAnswer(replyNo, parentElement) {
  const answerContent = parentElement.querySelector('input[name=answerContent]').value;

  $.ajax({
    url: '${root}/board/answer/write',
    type: 'POST',
    data: {
      rno: replyNo,
      answerContent: answerContent,
    },
    success: function(result) {
      if (result === 'success') {
        alert('답글 작성 성공');
        const parentReply = parentElement.closest('.reply');
        loadComment();
      } else {
        alert('답글 작성 실패');
      }
    },
    error: function(e) {
      console.log(e);
    },
  });
}


// // 댓글 수정
// function edit(replyNo, currentContent) {
//   const replyCol = document.querySelector('.reply_col[data-reply-no="' + replyNo + '"]');
//   if (replyCol) {
//     const replyInput = replyCol.querySelector('input[name=rC]');

//     replyInput.readOnly = false;
//     replyInput.style.border = '1px solid black';
//     replyInput.focus();

//     replyInput.addEventListener('keyup', function(event) {
//       if (event.key === 'Enter') {
//         const updatedContent = replyInput.value.trim();

//         if (updatedContent !== currentContent) {
//           updateComment(replyNo, updatedContent); // 수정된 내용을 서버로 전송하여 업데이트
//         } else {
//           replyInput.value = currentContent;
//           replyInput.readOnly = true;
//           replyInput.style.border = 'none';
//         }
//       }
//     });
//   }
// }

// // 댓글 업데이트
// function updateComment(replyNo, updatedContent) {
//   $.ajax({
//     url: '${root}/board/reply/update',
//     type: 'POST',
//     data: {
//       rno: replyNo,
//       replyContent: updatedContent
//     },
//     success: function(result) {
//       alert('댓글 수정 성공');
//       loadComment(); // 수정 후 댓글을 다시 조회하여 화면에 업데이트
//     },
//     error: function(e) {
//       alert('댓글 수정 실패');
//     },
//   });
// }
    


    // 댓글 조회 호출
    loadComment();




    

    

    

    

</script>

