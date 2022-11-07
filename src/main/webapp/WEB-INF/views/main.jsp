<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>main</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
  <!-- Header/Home -->
  <header class="w3-container w3-padding-32 w3-center w3-black" id="home">
    <h1 class="w3-jumbo">우리태우잘하조</h1>
    <c:choose>
		<c:when test="${!empty sessionScope.id }">
			<p>${id}회원님 방가방가^^</p>
			<c:if test="${sessionScope.id =='admin'}">
				<a href="alllist.do">회원보기</a>
			</c:if>
			<a href="logout.do">로그아웃</a>
		</c:when>
		<c:otherwise>
			<p>사이트 방문을 환영합니다 ^^ <br><a href="register.do">회원가입하러가기</a></p>
		</c:otherwise>
	</c:choose>
  </header>
  
    <!-- Footer -->
 <jsp:include page="/BootStrapInclude/Footer.jsp"></jsp:include>
<!-- END PAGE CONTENT -->
</div>

</body>
</html>

