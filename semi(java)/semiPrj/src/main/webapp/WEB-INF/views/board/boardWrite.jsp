<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 썸머노트 -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<link href="${root}/static/css/board/write.css" rel="stylesheet">
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script>
    $(document).ready(function(){
    // 썸머노트
    $('#summernote').summernote({
            height: 500,                 // 에디터 높이
            minHeight: 500,             // 최소 높이
            maxHeight: 500,             // 최대 높이
            lang: "ko-KR",					// 한글 설정
            placeholder: '내용을 입력해주세요.',	//placeholder 설정
            callbacks : {
            onImageUpload : f01
            } ,
            toolbar: [
                    // [groupName, [list of button]]
                    ['fontname', ['fontname']],
                    ['fontsize', ['fontsize']],
                    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
                    ['color', ['forecolor','color']],
                    ['table', ['table']],
                    ['para', ['ul', 'ol', 'paragraph']],
                    ['height', ['height']],
                    ['insert',['picture','link','video']],
                    ['view', ['fullscreen', 'help']]
                ],
                fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
                fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
            
        });
    });
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<main>
			<div class="myClass">
                <ul>
                    <li class="loginName">${loginMember.memberNick} 님 환영합니다</li>
                    <li class="class">(스마트웹&콘텐츠개발)반응형 UI/UX 웹콘텐츠 개발자 양성과정A</li>
                    <li class="classRoom">[강남 362] 2022. 12. 30 ~ 2023. 08. 16 ｜ 15:30 ~ 22:00 (심원용 강사 ｜ 김리아 취업담임)</li>
                </ul>
            </div>

            <hr>

            <form action="${root}/board/write" method="post">

                <!-- 관리자에게만 보이는 체크박스 -->
                <div class="checked">
                    <input type="checkbox" name="" id=""><span>상단고정</span>
                </div>

                <div class="write_wrap">
                    <input type="text" name="boardTitle" placeholder="제목을 입력해주세요." required>
                    <select name="boardCategoryNo" id="select_category" >
                        <option value="1">자유게시판</option>
                        <option value="3">우리반게시판</option>
                    </select>

                    <textarea name="boardContent" id="summernote"></textarea>
                    <input type="file" name="select_file">
                </div>
    
                <div class="board_bt">
                    <input type="submit" value="작성완료" class="bt1">
                </div>
            </form>

		</main>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script>
	const title = document.querySelector('.title');
	title.innerHTML = "게시글 작성";
</script>
