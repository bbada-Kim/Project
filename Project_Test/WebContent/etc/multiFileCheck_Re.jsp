<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String[] filename1 = request.getParameterValues("filename");
	String[] origfilename1 = request.getParameterValues("origfilename");
%>
<html>
<head>
<title>파일 업로드 확인 및 다운로드</title>
</head>
<body>
올린 사람 : <%=name %><br>
제목 : <%=subject %><br>
<%for(int i=0; i<filename1.length; i++){ %>
파일명1 : <a href="file_down.jsp?file_name=<%=filename1[i] %>"><%=origfilename1[i] %></a><br>
<%} %>

</body>
</html>