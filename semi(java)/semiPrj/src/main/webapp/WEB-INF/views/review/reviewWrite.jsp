<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/write.css" rel="stylesheet">
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<!-- 썸머노트 -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<main>
			<div class="myClass">
                <ul>
                    <li class="loginName">${loginMember.memberNick} 님 환영합니다</li>
                    <li class="class">${memberLecture[0].lectureName}</li>
                </ul>
            </div>

            <hr>

            <form action="${root}/review/write" method="post">

                <!-- 관리자에게만 보이는 체크박스 -->
				<c:if test="${not empty loginAdmin }">
	                <div class="checked">
	                    <input type="checkbox" name="" id=""><span>상단고정</span>
	                </div>
				</c:if>

                <div class="write_wrap">
                    <input type="text" name="boardTitle" placeholder="제목을 입력해주세요." required>
                    <select name="boardCategoryNo" id="select_category" >
                        <option>수강후기</option>
                    </select>

                    <textarea name="boardContent" id="summernote"></textarea>
                </div>
    
                <div class="board_bt">
                    <input type="submit" value="작성완료" class="bt1">
                </div>
            </form>
		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
        // 썸머노트 설정
        $('#summernote').summernote({
            tabsize: 1,
            height: 456,
            minHeight: 434,             // 최소 높이
            maxHeight: 434,             // 최대 높이
            focus: true,
            placeholder: '내용을 입력해주세요',
            lang: "ko-KR",
            callbacks: {
                onImageUpload: f01
            },
            toolbar: [
                // [groupName, [list of button]]
                ['fontname', ['fontname']],
                ['fontsize', ['fontsize']],
                ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
                ['color', ['forecolor', 'color']],
                ['table', ['table']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['height', ['height']],
                ['insert', ['picture', 'link', 'video']],
            ],
            fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋움체', '바탕체'],
            fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72']
        });
    
        function f01(fileList) {
            console.log(fileList);
    
            const fd = new FormData();
            for (let file of fileList) {
                fd.append("f", file)
            }
    
            $.ajax({
                url: '${root}/review/upload',
                type: 'post',
                data: fd,
                processData: false,
                contentType: false,
                dataType: 'json',
                success: function (changeNameList) {
                    console.log(changeNameList);
                    for (let changeName of changeNameList) {
                        $('#summernote').summernote('insertImage', '/semi/static/img/review/' + changeName);
                    }
                },
                error: function (error) {
                    console.log(error);
                },
            });
        }
    
        const title = document.querySelector('.title');
        title.innerHTML = "게시글 작성";
    </script>
    </body>
    </html>
    