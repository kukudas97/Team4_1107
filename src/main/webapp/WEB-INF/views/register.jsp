<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<title>회원가입</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
 //jquery 로 간단하게 유효성 check 하기
 $(function() {
  	$('#joinForm').submit(function() {
	   //alert("가입");
	if ($('#id').val() == "") { // 아이디 검사
    	alert('ID를 입력해 주세요.');
    	$('#id').focus();
    return false;
   } else if ($('#pwd').val() == "") { // 비밀번호 검사
    alert('PWD를 입력해 주세요.');
    $('#pwd').focus();
    return false;
   }else if ($('#mname').val() == "") { // 이름 검사
    alert('mname를 입력해 주세요.');
    $('#mname').focus();
    return false;
   }else if ($('#age').val() == "") { // 나이 검사
    alert('age를 입력해 주세요.');
    $('#age').focus();
    return false;
   }else if ($('#email').val() == "") { // 우편번호
    alert('email를 입력해 주세요.');
    $('#email').focus();
    return false;
   }
   
  });
 });
</script>
</head>
<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
 <jsp:include page="/BootStrapInclude/NavBar.jsp"></jsp:include>
	
			<!-- 	<form action="registerok.do" method="post" name="joinForm" id="joinForm">
					<h3 style="text-align: center;">회원가입</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<th>ID:</th>
								<td><input type="text" name="id" id="id"></td>
							</tr>
							<tr>
								<th>PWD:</th>
								<td><input type="password" name="pwd" id="pwd"></td>
							</tr>
							<tr>
								<th>Name:</th>
								<td><input type="text" name="name" id="name"></td>
							</tr>
							<tr>
								<th>age:</th>
								<td><input type="text" name="age" id="age" maxlength="3"></td>
							</tr>
							<tr>
								<th>Gender:</th>
								<td><input type="radio" name="gender" id="gender" value="여"
									checked>여자 <input type="radio" name="gender"
									id="gender" value="남">남자</td>
							</tr>
							<tr>
								<th>Email:</th>
								<td><input type="text" name="email" id="email"></td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="회원가입">
									<input type="reset" value="취소"></td>
							</tr>
						</table>
						</div>
						</form>-->
<!-- Page Content -->
<div class="w3-padding-large" id="main"> 
  <!-- Contact Section -->
  <div class="w3-padding-64 w3-content w3-text-grey" id="contact">
    <h2 class="w3-text-light-grey">Register</h2>
    <hr style="width:200px" class="w3-opacity">
    <p>회원 정보를 입력해 회원가입하세요!</p>

	<form action="registerok.do" method="post" name="joinForm" id="joinForm">
      <p><input class="w3-input w3-padding-16" type="text" placeholder="id" required name="id"></p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="pwd" required name="pwd"></p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="name" required name="name"></p>
      <p><input class="w3-input w3-padding-16" type="number" placeholder="age" required name="age"></p>
      <p class="w3-white"><input type="radio" name="gender" id="gender" value="여"	checked>여자 <input type="radio" name="gender" id="gender" value="남">남자</p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="email" required name="email"></p>
        <button class="w3-button w3-light-grey w3-padding-large" type="submit">
          <i class="fa fa-paper-plane"></i> 회원가입
        </button>
      </p>
    </form>
  <!-- End Contact Section -->
  </div>
    <!-- Footer -->
 <jsp:include page="/BootStrapInclude/Footer.jsp"></jsp:include>
<!-- END PAGE CONTENT -->
</body>
</html>

