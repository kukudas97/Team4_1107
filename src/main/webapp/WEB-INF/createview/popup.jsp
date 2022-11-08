<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	console.log('팝업페이지');
	alert('${requestScope.message}' );
    location.href = "main.do";
</script>