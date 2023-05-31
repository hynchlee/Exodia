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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                <a href="${root}/notice/list?page=1" class="bt1">목록으로</a>
            </div>

            <form action="${root}/notice/detail" method="post" enctype="multipart/form-data">

                <!-- 관리자에게만 보이는 체크박스 -->
                <c:if test="${not empty loginAdmin }">
	                <div class="checked">
	                    <input type="checkbox" name="pin" id="" value="${nvNo.noticeNo}"><span>상단고정</span>
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
                            <td>${nvNo.noticeTitle}</td>
                            <th>조회수</th>
                            <td colspan="4/6">${nvNo.hit}</td>
                        </tr>
                        <tr>
                            <th>작성자</th>
                            <td>${nvNo.adminNick}</td>
                            <th>작성일</th>
                            <td>${nvNo.enrollDate}</td>
                            <c:if test="${empty nvNo.modifyDate}">
                            	<td></td>
                            </c:if>
                            <c:if test="${not empty nvNo.modifyDate }">
	                            <td class="edit_date">${nvNo.modifyDate}</td>
                            </c:if>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="4" style="height: 500px;">${nvNo.noticeContent}</td>
                        </tr>
                        <!-- <tr>
                            <th>첨부파일</th>
                            <td colspan="4"></td>
                        </tr> -->
                    </tbody>
                </table>
                <!-- 작성자에게만 보이기 -->
                <c:if test="${not empty loginAdmin}">
	                <div class="view_btn">
	                    <a href="${root}/notice/delete?nno=${nvNo.noticeNo}" class="bt1" id="del">삭제하기</a>
	                    <a href="${root}/notice/edit?nno=${nvNo.noticeNo}" class="bt1">수정하기</a>
	                </div>
                </c:if>
            </form>

           
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "공지사항";

    // 답글 작성란 보이기 숨기기

    $(function(){
        $('#onDisplay').click(function(){
            if($("#noneDiv").css("display") == "none"){
                $('#noneDiv').show();
            }
        });
    });

    $(function(){
        $('#offDisplay').click(function(){
            if($("#noneDiv").css("display") != "none"){
                $('#noneDiv').hide();
            }
        })
    })

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

    $(document).ready(function() {
    $("input[name='pin']").change(function() {
        var noticeNo = '${nvo.noticeNo}'; // 게시글 번호 가져오기
        var isChecked = $(this).is(":checked"); // 체크 여부 확인
        
        // Ajax 요청
        $.ajax({
        url: "${root}/notice/detail",
        type: "POST",
        data: { 
            nno: noticeNo, 
            isChecked: isChecked 
        },
        success: function(data) {
            console.log(data);
        },
        error: function(error) {
            console.log(error);
        }
        });
    });
    });


</script>