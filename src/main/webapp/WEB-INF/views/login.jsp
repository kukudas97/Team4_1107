<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
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
  <!-- Contact Section -->
  <div class="w3-padding-64 w3-content w3-text-grey" id="contact">
    <h2 class="w3-text-light-grey">Contact Me</h2>
    <hr style="width:200px" class="w3-opacity">
    <p>회원 정보를 입력해 로그인하세요!</p>

<form action="${pageContext.request.contextPath}/loginok.do" method="post" name="loginform">
      <p><input class="w3-input w3-padding-16" type="text" placeholder="id" required name="id"></p>
      <p><input class="w3-input w3-padding-16" type="password" placeholder="pwd" required name="pwd"></p>
        <button class="w3-button w3-light-grey w3-padding-large" type="submit">
          <i class="fa fa-paper-plane"></i> Login
        </button>
      </p>
    </form>
    <%-- 
<form action="${pageContext.request.contextPath}/loginok.do" method="post" name="loginform">

ID : <input type="text" name="id" id="id" placeholder="아이디"><br>
PWD : <input type="password" name="pwd" id="pwd" placeholder="비밀번호"><br>
<input type="submit" value="제출">
</form> --%>
  <!-- End Contact Section -->
  </div>
  
    <!-- Footer -->
 <jsp:include page="/BootStrapInclude/Footer.jsp"></jsp:include>
<!-- END PAGE CONTENT -->
</div>

</body>
</html>