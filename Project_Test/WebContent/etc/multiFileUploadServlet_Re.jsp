<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,vo.CardBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% ArrayList<FileValue_Re> fileList = (ArrayList) request.getAttribute("fileList"); %> --%>
<!-- <form name="filecheck" action="multiFileCheck_Re.jsp" method="POST"> -->
<%-- 	<input type = "hidden" name="name" value="<%=request.getAttribute("name") %>"> --%>
<%-- 	<input type = "hidden" name="subject" value="<%=request.getAttribute("subject") %>"> --%>
<%-- 	<% for(FileValue_Re fv : fileList){ --%>
		
<%-- 	%> --%>
<%-- 	<input type="hidden" name="filename" value="<%=fv.getFilename() %>"> --%>
<%-- 	<input type="hidden" name="origfilename" value="<%=fv.getOrigfilename() %>"> --%>
<%-- <%} %> --%>
<!-- </form> -->
<!-- <a href="#" onclick="filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>  -->
${name}
${subject}
<%
	ArrayList<CardBean> list = (ArrayList) request.getAttribute("fileList"); 
	for(CardBean fv : list){
%>
		<%=fv.getFilename() %>
		<%=fv.getOrigfilename()%>
		<%} %>

</body>
</html>