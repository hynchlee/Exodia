<%@page import="com.semi.member.vo.MemberVo" %>
	<%@page import="java.util.List" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<title>Insert title here</title>
					<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
					<link href="${root}/static/css/introduce/teacher.css" rel="stylesheet">
				</head>

				<body>
					<%@ include file="/WEB-INF/views/common/header.jsp" %>
						<main>
							<% List<MemberVo> teacherList = (List<MemberVo>) request.getAttribute("teacherList");
									List<String> commentList = (List<String>) request.getAttribute("commentList");
											%>

											<% for (int i=0; i < teacherList.size(); i=i + 2) { %>
												<div class="wrap_1">
													<div class="bigMenu">
														<div class="menu_1">
															<div class="pfl">
																<% if(teacherList.get(i).getProfile()==null) { %>
																	<img src="${root}/static/img/header/defaultProfile.png"
																		alt="logo" id="profile_img_1"
																		class="profile_img">
																	<% } else {%>
																		<% String profile="/semi/static/img/profile/" +
																			teacherList.get(i).getProfile(); %>
																			<img src=<%=profile%> alt="logo"
																			id="profile_img_1" class="profile_img">
																			<% } %>
																				<div id="e98_1481" class="profile_name">
																					<%=teacherList.get(i).getMemberNick()
																						%>
																				</div>
															</div>

															<div id="e98_1" class="intro_div">
																<%= commentList.get(i)%>
															</div>
														</div>
														<% if(i + 1 < teacherList.size()) {%>
															<div class="menu_1">
																<div class="pfl">
																	<% if(teacherList.get(i+1).getProfile()==null) { %>
																		<img src="${root}/static/img/header/defaultProfile.png"
																			alt="logo" id="profile_img_1"
																			class="profile_img">
																		<% } else {%>
																			<% String
																				profile="/semi/static/img/profile/" +
																				teacherList.get(i+1).getProfile(); %>
																				<img src=<%=profile%> alt="logo"
																				id="profile_img_1" class="profile_img">
																				<% } %>
																					<div id="e98_1481"
																						class="profile_name">
																						<%=teacherList.get(i+1).getMemberNick()
																							%>
																					</div>
																</div>

																<div id="e98_1" class="intro_div">
																	<%= commentList.get(i + 1)%>
																</div>
															</div>
															<% } %>
													</div>
												</div>
												<br><br><br>
												<% } %>
													<br> <br> <br>
													<div class="wrap_1">
														<div class="bigMenu2">
															<div id="pageDiv">
																<c:if test="${pageVo.currentPage > 1 }">
																	<button onclick="pageMove('${pageVo.startPage}');">
																		<<</button>
																</c:if>
																<c:forEach begin="${pageVo.startPage}"
																	end="${pageVo.endPage}" var="i">
																	<button class="pageBtn"
																		onclick="pageMove('${i}');">${i}</button>
																</c:forEach>
																<c:if test="${pageVo.currentPage < pageVo.maxPage }">
																	<button
																		onclick="pageMove('${pageVo.endPage}');">>></button>

																</c:if>
															</div>
														</div>
													</div>
						</main>
						<%@ include file="/WEB-INF/views/common/footer.jsp" %>
				</body>

				</html>

				<script>
					const title = document.querySelector('.title');
					title.innerHTML = "강사진 소개";

					const pageBtn = document.querySelectorAll('.pageBtn');

					function pageMove(i) {
						location.href = "${root}/introduce/teacher?page=" + i;
					}

					for (let btn of pageBtn) {
						if (btn.innerHTML == '${pageVo.currentPage}') {
							btn.style.backgroundColor = '#4998D1';
							btn.style.color = 'white';
						}
					}
				</script>