<%@page import="java.util.List"%>
<%@page import="Lv1.list.ListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 표시</title>
</head>
<body>
<h1>회원목록 표시</h1>

<table border='1'>
	<tr>
		<td>사원번호</td>
		<td>사원명</td>
		<td>부서</td>
		<td>직속상사번호</td>
		<td>입사일</td>
		<td>연봉</td>
		<td>상여</td>
		<td>근무지코드</td>
	</tr>
	<%
	ListDAO dao = new ListDAO();
	List list= dao.list();
	%>
	<c:set var='list' value='<%=list %>'/>
		<c:forEach var="i" begin="0" end="${list.size()-1 }" step='1'>
		<tr>
			<td>${list[i].empno}</td>
			<td>${list[i].ename}</td>
			<td>${list[i].job}</td>
			<td>${list[i].mgr}</td>
			<td>${list[i].hiredate}</td>
			<td>${list[i].sal}</td>
			<td>${list[i].comm}</td>
			<td>${list[i].deptno}</td>
		</tr>
		</c:forEach>
	
</table>

</body>
</html>