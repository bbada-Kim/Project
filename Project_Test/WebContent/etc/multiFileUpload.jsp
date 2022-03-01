<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>

<!-- 파일 업로드 시 실제 경로 
C:\jsp\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Chapter10\upload -->
<%
// 	String uploadPath=request.getRealPath("/upload");
	String uploadPath=application.getRealPath("/upload");	
	System.out.println(uploadPath);
	int size = 10*1024*1024;
	String name="";
	String subject="";
	
	try{
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		name = multi.getParameter("name");
		subject = multi.getParameter("subject");
		
		Enumeration files = multi.getFileNames();	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="filecheck" action="multiFileCheck.jsp" method="post" enctype="multipart/form-data">
	<input type="hidden" name="name" value="<%=name %>">
	<input type="hidden" name="subject" value="<%=subject %>">
	<% while(files.hasMoreElements()){ 
		String file = (String) files.nextElement();
	%>
	<input type="hidden" name="filename1" value="<%=multi.getFilesystemName(file) %>">

	<input type="hidden" name="origfilename1" value="<%=multi.getOriginalFileName(file) %>">
<%} %>
</form>
<a href="#" onclick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>
<%
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>