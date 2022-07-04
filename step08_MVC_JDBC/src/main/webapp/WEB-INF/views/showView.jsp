<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>showView</title>
</head>
<body>
	<div>deptno : <%=request.getAttribute("deptno")%></div>
	<div>dname : <%=request.getAttribute("dname")%></div>
	<div>loc : <%=request.getAttribute("loc")%></div>
	<form action="home.jsp">
		<input type="submit" value="home으로 이동">
	</form>

</body>
</html>
