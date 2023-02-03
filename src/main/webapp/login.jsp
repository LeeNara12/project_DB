<%@page import="Lv2.login.loginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

</head>
<body>

<form action='map' method='post' >
	사원명 : <input type='text' name='ename' ><br>
	<br>
	사원번호 : <input type='text' name='empno'><br> 
	<br>
	<input type='submit' value='로그인'>
	<%
	 boolean result = (boolean) request.getAttribute("result");
	 String str1 = (String) request.getAttribute("str1");
	%>
	
	<c:choose>
		<c:set var='result' value='<%=result %>'/>
		
		<c:when test='${result==null}'>
			<input type='hidden' name='map' value='login'>
		</c:when>
		
		<c:when test='${result==true}'>
			<input type='hidden' name='bool' value='true' onclick='alert("${str1}")'>
		</c:when>
		
		<c:when  test='${result==false}'>
			<input type='hidden' name='bool' value=' false' onclick='alert("${str1}")'>
		</c:when>
	
	</c:choose>

</form>
</body>
</html>