<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String openInit = "false";
if(request.getParameter("openInit")!=null){
	openInit="true";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="init()">
<form action="idCheckProcess.jsp" method="post">
<input type="text"  name="idCheck" id="id"/>
<input type="submit" value="중복확인"/>
</form>
<% 
if(request.getParameter("chk_id")!=null&&
		!request.getParameter("chk_id").equals("")){
		String chk_id=request.getParameter("chk_id");
		String useble=request.getParameter("useble");
		out.println("<hr>");
		if(useble.equals("yes")){
			out.print("<h3>"+chk_id+"는 사용가능한 아이디입니다.</h3>");
			out.print("<a href=\"javascript:ok('"+chk_id+"')\">사용하기</a>");
		}else{
			out.print("<h3>"+chk_id+"는 사용 불가능한 아이디입니다. 다시검색하세요.</h3>");
		}
}
%>
<script>
function init(){
if(<%=openInit%>){
document.getElementById("chk_id").value=
	opener.document.getElementById("chk_id").value;
}
}
function ok(v){
	opener.document.getElementById("chk_id").value=v;
	window.close();
}
</script>
</body>
</html>