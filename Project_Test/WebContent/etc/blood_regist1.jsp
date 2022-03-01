<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String bt = (String) request.getParameter("bt");
	String bloodName = (String) request.getParameter("bloodName");
	System.out.println(bt+bloodName);
	if(bt != null && bt.equals("전혈")){
		System.out.println(bt+bloodName);
		switch(bloodName){
		case "A" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;	
		case "B" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;
		case "O" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;
		case "AB" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;
		}
	}else if(bt != null && bt.equals("혈장")){
		switch(bloodName){
		case "A" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;	
		case "B" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;
		case "O" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;
		case "AB" :
			out.println(bt +" "+ bloodName+"형 테이블에 저장");
			break;
		}
	}
%>
</body>
</html>