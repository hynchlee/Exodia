<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>main</title>

      <c:set var="root" value="${pageContext.request.contextPath}"></c:set>

      <!-- CSS only -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
      <!-- JavaScript Bundle with Popper -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
      <link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro%3A400%2C600" />
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins%3A400%2C600" />
      <link href="${root}/static/css/main/smain.css" rel="stylesheet">


      <style>
        a {
          text-decoration: none;
          color: black;
        }
        
        #logoImg {
		width: 180px;
		}
      </style>
    </head>

    <body>

      <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <main style="height: 1875px;">
          <div class="v54_2">
            <div class="interview">
              <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                  <div class="carousel-item active">
							<img src="/semi/static/img/main/v10_01.png" id="blank"
								class="d-block w-100" alt="...">
							<div class="v75_54">
								<img
									src="/semi/static/img/main/interview01.png"
									class="d-block w-100" alt="...">
							</div>
							<div class="v75_55">
								<img
									src="/semi/static/img/main/interview02.jpg"
									class="d-block w-100" alt="...">
							</div>

						</div>
						<div class="carousel-item">
							<img src="/semi/static/img/main/v10_01.png" id="blank"
								class="d-block w-100" alt="...">
							<div class="v75_54">
								<img
									src="/semi/static/img/main/interview03.png"
									class="d-block w-100" alt="...">
							</div>
							<div class="v75_55">
								<img
									src="/semi/static/img/main/interview04.png"
									class="d-block w-100" alt="...">
							</div>
						</div>
						<div class="carousel-item">
							<img src="/semi/static/img/main/v10_01.png" id="blank"
								class="d-block w-100" alt="...">
							<div class="v75_54">
								<img
									src="/semi/static/img/main/interview05.png"
									class="d-block w-100" alt="...">
							</div>
							<div class="v75_55">
								<img
									src="/semi/static/img/main/interview06.png"
									class="d-block w-100" alt="...">
							</div>
						</div>
                </div>
                <button class="carousel-control-prev" id="interviewBtn01" type="button"
                  data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" id="interviewBtn02" type="button"
                  data-bs-target="#carouselExampleControls" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
              </div>
            </div>

            <div class="v75_49">
              <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
                <div class="carousel-indicators">
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img src="/semi/static/img/main/v10_01.png" class="d-block w-100" alt="...">
                  <div class="v76_71">
								<img
									src="/semi/static/img/main/project01.jpg"
									class="d-block w-100 img01" alt="...">
							</div>
							<span class="v76_72">KH project</span> <span class="v76_73">kh
								정보교육원 홈페이지를 이용하면서 많은 불편함과 아쉬운 점을 경험하였다. 특히, 수강신청의 난해함 및 수강생들간의
								교류가 장려가 되지 않았던 점 등이 그러했다. 따라서 kh 정보교육원 홈페이지를 재구성하고자 하였다. 본
								프로젝트에서는 재구성 방향성을 대학 홈페이지로 잡았다. kh 정보교육원은 IT 교육기관으로 일종의 대학 기능을
								수행하기에 기존의 홈페이지와 대학 홈페이지의 구성을 결합하는 것이 새로운 브랜드 이미지 형성으로 긍정적인 영향을 줄
								수 있다고 보았다. </span><span class="v76_86">(자바개발자)자바 기반 임베디드</span>
						</div>
						<div class="carousel-item">
							<img src="/semi/static/img/main/v10_01.png" class="d-block w-100"
								alt="...">
							<div class="v76_71">
								<img
									src="/semi/static/img/main/project04.jpg"
									class="d-block w-100 img02" alt="...">
							</div>
							<span class="v76_72">KH project</span> <span class="v76_73">사용하지 않는 집이나, 노후 되었으나 수익성이 충분히 있는 집이나 
							공간을 리모델링 하여 수익성을 높일 수 있도록 하고,
							리모델링시 쉐어하우스 라는 사업 모델을 함께하여 새로운 수익 모델을 창출
							예전 '하숙집' 이라는 이름의 값싼 하급 여관집 느낌을 버리고 '쉐어하우스'로 탈바꿈
							그 외에도 세입자를 필요로 하는 집주인들을 위한 '입주자 모집 게시판'을 운영하고 추후에 수수료를 받는 형식으로 변경하였다.
								 </span><span class="v76_86">(자바개발자)자바 기반 임베디드</span>
						</div>
						<div class="carousel-item">
							<img src="/semi/static/img/main/v10_01.png" class="d-block w-100"
								alt="...">
							<div class="v76_71">
								<img
									src="/semi/static/img/main/project03.jpg"
									class="d-block w-100 img03" alt="...">
							</div>
							<span class="v76_72">KH project</span> <span class="v76_73">
								한류열풍으로 인해 전 세계적으로 한국에 관심이 커진 현재, 한국어 능력 시험인 TOPIK 시험이
								 큰 인기를 끌고 있습니다. 교육부 국립국제교육원의 직원들에게 악의적인 URL이 담긴 메일이 
								 수신되어 직원들의 개인정보가 유출되는 보안사고가 발생하였습니다. 이에 따라 국립국제교육원에서
								  개인정보 및 자료유출, 금전적 피해 등을 입을 수 있는 만큼, 이러한 피해를 방지하기 위하여 
								  팀 끝나고 보조에게 모의해킹 및 보안솔루션 제안을 요청하였습니다. 
								  </span><span class="v76_86">(정보시스템구축)보안엔지니어링 기반 정보보안 전문가 양성</span>
						</div>
					</div>
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
          <div class="v67_3">
            <video class="video01" src="/semi/static/img/main/testvid01.mp4" autoplay loop muted width="100%" height="550px;"></video>
          </div>
          

          <div class="v69_16">
          	<div class="innerprofile">
          		<div class="logout"><a href="${root}/member/logout">로그아웃</a></div>
				<div class="photo01">
					<c:if test="${empty loginMember.profile}">
					<img id="profile-img" src="${root}/static/img/header/defaultProfile.png" alt="프사" id="profile_img_1" class="profile_img">
					</c:if>
					<c:if test="${not empty loginMember.profile}">
					<img id="profile-img" src="${root}/static/img/profile/${loginMember.profile}" alt="프사" id="profile_img_1" class="profile_img">
					</c:if>
				</div>
				<div class="identity"><a href="${root}/mypage">${loginMember.memberNick}님 (수강생)</a></div>
				<div class="class01"><a href="${root}/lecture/apply"></a></div>
				<div class="change"><a href="${root}/member/edit">내 정보 수정</a></div>
				<div class="letter"><a href="${root}/letter/receive">쪽지 ${letterCount}</a></div>
				<div class="mywrite"><a href="${root}/my/list?page=1">내가 쓴 글${countMyWrite}</a></div>
				<div class="point"><a href="${root}/vacation/list?page=1">마일리지 ${mileage}</a></div>
				<div class="test"><a href="${root}/lecture/test/list" class="a01">시험 응시</a></div>
				<div class="vacation"><a href="${root}/member/vacation/form" class="a01">휴가 신청</a></div>
				<div class="exit"><a href="${root}/mypage" class="a01">마이페이지</a></div>
			</div>
          </div>
          <div class="v75_31">
          	<div id="carouselExample02" class="carousel slide carousel-fade" data-bs-ride="carousel">
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			       <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Solid_white.svg/2048px-Solid_white.svg.png" class="d-block w-100" alt="...">
			    	<div class="carousel-caption" id="innerinfo01">
              		    <span class="v75_33"><a href="/">정보 보안 개강 일정</a></span>
						<div class="v75_39"></div>
						<span class="v75_44">(정보시스템구축) 보안엔지니어링 기반 정보보안 전문가 양성과정B1</span>
						<div class="v75_35">06 / 17</div>
            		</div>
			    </div>
			    <div class="carousel-item">
			      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Solid_white.svg/2048px-Solid_white.svg.png" class="d-block w-100" alt="...">
			    	<div class="carousel-caption" id="innerinfo01">
              		    <span class="v75_33"><a href="/">정보 보안 개강 일정</a></span>
						<div class="v75_39"></div>
						<span class="v75_44">(정보시스템구축) 보안엔지니어링 기반 정보보안 전문가 양성과정B1</span>
						<div class="v75_35">08 / 26</div>
            		</div>
			    </div>
			    <div class="carousel-item">
			      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Solid_white.svg/2048px-Solid_white.svg.png" class="d-block w-100" alt="...">
			    	<div class="carousel-caption" id="innerinfo01">
              		    <span class="v75_33"><a href="/">정보 보안 개강 일정</a></span>
						<div class="v75_39"></div>
						<span class="v75_44">(정보시스템구축) 보안엔지니어링 기반 정보보안 전문가 양성과정B1</span>
						<div class="v75_35">10 / 07</div>
            		</div>
			    </div>
			  </div>
			  <button class="carousel-control-prev" id="secu01" type="button" data-bs-target="#carouselExample02" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" id="secu02" type="button" data-bs-target="#carouselExample02" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
          </div>
          <div class="v75_32">
          	<div id="carouselExample01" class="carousel slide carousel-fade" data-bs-ride="carousel">
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Solid_white.svg/2048px-Solid_white.svg.png" class="d-block w-100" alt="...">
			    	<div class="carousel-caption" id="innerinfo02">
              		    <span class="v75_34"><a href="/">자바 개발자 개강 일정</a></span>
						<div class="v75_41"></div>
						<span class="v75_43">(디지털컨버전스) 공공데이터 융합 자바개발자 양성과정A3</span>
						<div class="v75_36">05 / 07</div>
            		</div>
			    </div>
			    <div class="carousel-item">
			      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Solid_white.svg/2048px-Solid_white.svg.png" class="d-block w-100" alt="...">
			    	<div class="carousel-caption" id="innerinfo02">
              		    <span class="v75_34"><a href="/">자바 개발자 개강 일정</a></span>
						<div class="v75_41"></div>
						<span class="v75_43">(디지털컨버전스) 공공데이터 융합 자바개발자 양성과정A3</span>
						<div class="v75_36">05 / 26</div>
            		</div>
			    </div>
			    <div class="carousel-item">
			      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Solid_white.svg/2048px-Solid_white.svg.png" class="d-block w-100" alt="...">
			    	<div class="carousel-caption" id="innerinfo02">
              		    <span class="v75_34"><a href="/">자바 개발자 개강 일정</a></span>
						<div class="v75_41"></div>
						<span class="v75_43">(디지털컨버전스) 공공데이터 융합 자바개발자 양성과정A3</span>
						<div class="v75_36">06 / 17</div>
            		</div>
			    </div>
			  </div>
			  <button class="carousel-control-prev" id="javabtn01" type="button" data-bs-target="#carouselExample01" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" id="javabtn02" type="button" data-bs-target="#carouselExample01" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
          </div>
          <div class="v75_50"></div>
          <span class="v75_51">KH interview</span>
          <div class="v75_56"></div>
          <div class="v75_62"></div>
          <div class="v75_57"></div>
          <div class="v75_63"></div>
          <div class="v75_58"></div>
          <div class="v75_64"></div>
          <span class="v75_59">#디지털컨버전스</span><span class="v75_65">#자바개발자</span><span class="v75_60"># 실무에서 일하는 것처럼
            배우자</span><span class="v75_66">#오전/ 오후 자습시간 활용</span><span class="v75_61">#이승철
            강사님</span><span class="v75_67">#심원용 강사님</span>
          </div>


        </main>

        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </body>

    </html>

    <script>
    const logoImg = document.querySelector('#logo_img');    
    const header = document.querySelector('header');
    const a1 = document.querySelectorAll('.menu3 a');
    const a2 = document.querySelectorAll('.submenu-tbl a');

    function scrolling() {
        if (header.matches(':hover')) {
          logoImg.src = "/semi/static/img/header/4.png";
          header.style.backgroundColor = 'white';
          for (let a of a1) {
            a.style.color = 'black';
          }
        } else {
          if (window.scrollY > 0) {
        	logoImg.src = "/semi/static/img/header/4.png";
            header.style.backgroundColor = 'white';
            for (let a of a1) {
              a.style.color = 'black';
            }
          } else {
       	    logoImg.src = "/semi/static/img/header/5.png";
            header.style.background = 'transparent'
            for (let a of a1) {
              a.style.color = 'white';
          }
        }
      }
    };

    setInterval(scrolling, 20);
    </script>