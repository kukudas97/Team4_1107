
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${!empty sessionScope.id}&& ${sessionScope.id != 'admin' } ">
<script>location.href="login.do";</script>
</c:if>
<title>detail</title>
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
	<c:set var="member" value="${requestScope.member}"></c:set>
<div class="w3-padding-large" id="main">
  <c:set var="list" value="${requestScope.list}"></c:set>
    <h1 class="w3-jumbo">회원리스트</h1>
					<table class="table table-dark">
					<thead>
					</thead>
							<tbody>
							<tr>
				  			 		<td style="width:100px">아이디</td>
				  			 		<td style="width:100px">${member.id }</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">비번</td>
				  			 		<td style="width:100px">${member.pwd }</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">이름</td>
				  			 		<td style="width:100px">${member.name}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">나이</td>
				  			 		<td style="width:100px">${member.age }</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">성별</td>
				  			 		<td style="width:100px">${member.gender }</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">이메일</td>
				  			 		<td style="width:100px">${member.email}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td colspan="2">
				  			 			<a href="alllist.do">목록가기</a>
				  			 		</td>
				  			 	</tr>
						</tbody>
					</table>
    <!-- Footer -->
 <jsp:include page="/BootStrapInclude/Footer.jsp"></jsp:include>
	</div>
<!-- END PAGE CONTENT -->

</body>
</html>