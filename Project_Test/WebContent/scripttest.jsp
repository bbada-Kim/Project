<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="vo.ChartBean" %>
    <%@ page import="vo.StockBean" %>
<%	

int rglCount = (Integer)session.getAttribute("rglCount");
%>
<script>
	
	
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
<%=rglCount %>
</body>
</html>