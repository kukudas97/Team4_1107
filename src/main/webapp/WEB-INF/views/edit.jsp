<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:if test="${!empty sessionScope.id}&& ${sessionScope.id != 'admin' } ">
<script>location.href="login.do";</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<title>edit</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}
/* Set the width of the sidebar to 120px */
.w3-sidebar {width: 120px;background: #222;}
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
#main {margin-left: 120px}
/* Remove margins from "page content" on small screens */
@media only screen and (max-width: 600px) {#main {margin-left: 0}}
</style>
</head>
<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
 <jsp:include page="/BootStrapInclude/NavBar.jsp"></jsp:include>
<!-- Page Content -->
<div class="w3-padding-large" id="main">
				<form action="updateok.do" method="post">
	<c:set var="member" value="${requestScope.member}"></c:set>
    <h1 class="w3-jumbo">회원정보</h1>
					<table class="table table-dark">
					<thead>
					</thead>
							<tbody>
							<tr>
								<td>아이디</td>
								<td>
								  	<input type="text" name="id" value="${member.id }" readonly>
								</td>
							</tr>
							<tr>
								<td>비번</td>
								<td>${member.pwd }</td>							</tr>
							<tr>
								<td>이름</td>
								<td>
									<input type="text" name="name" value="${member.name }" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>나이</td>
								<td>
									<input type="text" name="age" value="${member.age}" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td>
									[${member.gender }]
									<c:choose>
										<c:when test=" ${member.gender == '여'}" >
											<input type="radio" name="gender" id="gender" value="여" checked>여자
											<input type="radio" name="gender" id="gender" value="남"> 남자
										</c:when>
										<c:otherwise>
											<input type="radio" name="gender" id="gender" value="여" >여자
											<input type="radio" name="gender" id="gender" value="남" checked> 남자
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>
									<input type="text" name="email" value="${member.email }" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="submit" value="수정하기">
								<a href='alllist.do'>리스트이동</a></td>
						</tbody>
					</table>
					</form>
    <!-- Footer -->
 <jsp:include page="/BootStrapInclude/Footer.jsp"></jsp:include>
	</div>
<!-- END PAGE CONTENT -->

</body>
</html>
