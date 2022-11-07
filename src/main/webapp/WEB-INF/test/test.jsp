<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
        let httpReq=null;
	
	function getInstance(){
		  if(window.XMLHttpRequest){
			  httpReq = new XMLHttpRequest(); //현재 브라우져 XMLHttpRequest 내장
		  }else if(window.ActiveXObject){ //IE6 이하   //지금 필요없어요
			  httpReq = new ActiveXObject("Msxml2.XMLHTTP");
		  }else{
			 throw new Error("AJAX 지원하지 않습니다"); 
		  }
		return httpReq;  
	}
	function handlerStateChange(){
		 if(httpReq.readyState == 4){ //1. 서버에서 응답이 왔다면
			 if(httpReq.status >= 200 && httpReq.status < 300){
				//ㅇㅅㅇㅅㅇㅅㅇㅅㅇㅅㅇㅅㅇㅅㅇ
				document.getElementById("test").innerHTML = httpReq.responseText;
				//ㅇㅅㅇㅅㅇㅅㅇㅅㅇㅅㅇㅅㅇㅅㅇ
			 }else{
				 alert("status Text : " + httpReq.status);
			 }
		 }
	}
	function sendData(){
		httpReq = getInstance();
		httpReq.onreadystatechange = handlerStateChange;
		httpReq.open("POST","test.do"); 
		httpReq.send(); // form submit 버튼 클릭
	}
	</script>
<title>list</title>
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
<!-- Page Content -->
<div class="w3-padding-large" id="main">
  <c:set var="list" value="${requestScope.list}"></c:set>
    <div id="test">
					<table class="table table-dark">
					<thead>
					</thead>
							<tbody>
							<c:forEach var="member" items="${list }">
								<tr>
									<td width="100px">
										<a href='detail.do?id=${member.id }'>${member.id }</a>
									</td>
									<td width="100px">${member.ip }</td>
									<td>
										<a href="delete.do?id=${member.id }">[삭제]</a>
									</td>
									<td>
										<a href="update.do?id=${member.id }">[수정]</a>
									</td>
								</tr> 
						</c:forEach>
						</tbody>
					</table>
					</div>
    <!-- Footer -->
	</div>
<!-- END PAGE CONTENT -->

</body>
</html>