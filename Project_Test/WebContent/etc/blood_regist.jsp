<%@page import="org.apache.catalina.startup.SetContextPropertiesRule"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="static db.JdbcUtil_bl.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
 // 	String bloodName = (String)request.getParameter("bloodName");
// 	Connection con = null;
// 	PreparedStatement pstmt = null;
	
// 	Context init = new InitialContext();
// 	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/blood");
// 	con = ds.getConnection();	
	
	
// 	if(bloodName != null && bloodName == "a" && bloodName == "b" && bloodName == "o" && bloodName == "ab"){
// 	try{
		
// 	switch(bloodName){
// 	case "a" :
// 		pstmt = con.prepareStatement("insert into blood_a_plus values(?)");
// 		pstmt.setString(1, bloodName);
// 		int result = pstmt.executeUpdate();
// 		System.out.println(bloodName);
// 		break;
// 	case "b" : 
// 		pstmt = con.prepareStatement("insert into blood_b_plus values(?)");
// 		pstmt.setString(1, bloodName);
// 		result = pstmt.executeUpdate();
		
// 		break;	
// 	case "o" : 
// 		pstmt = con.prepareStatement("insert into blood_o_plus values(?)");
// 		pstmt.setString(1, bloodName);
// 		result = pstmt.executeUpdate();
		
// 		break;
// 	case "ab" : 
// 		pstmt = con.prepareStatement("insert into blood_o_plus values(?)");
// 		pstmt.setString(1, bloodName);
// 		result = pstmt.executeUpdate();
		
// 		break;
// 	}
// 	}catch(Exception e){
// 		e.printStackTrace();
// 	}finally{
// 		close(pstmt);
// 	}
// 	}else{
// 		out.println("<script>");
// 		out.println("alert('정확한 값을 입력하세요')");
// 		out.println("history.back();");
// 		out.println("</script>");
// 	} 
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>