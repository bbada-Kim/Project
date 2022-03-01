<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="blood_regist1.jsp">
<LABEL FOR="blood">혈액형 </LABEL><br>
<input type="radio" name="bt" value="전혈" id="j"/>전혈
<input type="radio" name="bt" value="혈장" id="h"/>혈장<br><br>
<input type="radio" name="bloodName" value="A" id="bloodName"/>+A형<br>
<input type="radio" name="bloodName" value="B" id="bloodName"/>+B형<br>
<input type="radio" name="bloodName" value="O" id="bloodName"/>+O형<br>
<input type="radio" name="bloodName" value="AB" id="bloodName"/>+AB형<br>
<input type="submit" value="등록"> 
</form>
</body>
</html>