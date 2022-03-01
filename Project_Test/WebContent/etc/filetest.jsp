<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,vo.CardBean" %>
<%
	String fn = request.getParameter("fileName");
	String fn1 = request.getParameter("fileName1");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${name }
<%=fn %>
<%=fn1 %>
</body>
</html>