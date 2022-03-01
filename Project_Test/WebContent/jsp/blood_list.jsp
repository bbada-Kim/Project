<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BloodBean" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	margin:auto;
	width:700px;
	text-align:center;
	font:bold;
}

.td_title1{
	width:100px;
	background:orange;
}
.td_title2{
	width:100px;
	background: skyblue;
}

.td_value{
	width:150px;
	background:Aquamarine;
}
</style>
</head>
<body>
<section id="listForm">
<h2>상세정보</h2>
<table>
<!-- 	<tr> -->
<!-- 		<td>전혈/PLUS/A : </td> -->
<%-- 		<td>${bloodBean.bc1 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>전혈/PLUS/B : </td> -->
<%-- 		<td>${bloodBean.bc2 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>전혈/PLUS/AB : </td> -->
<%-- 		<td>${bloodBean.bc3 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>전혈/PLUS/O : </td> -->
<%-- 		<td>${bloodBean.bc4 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>전혈/MINUS/A : </td> -->
<%-- 		<td>${bloodBean.bc5 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>전혈/MINUS/B : </td> -->
<%-- 		<td>${bloodBean.bc6 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>전혈/MINUS/AB : </td> -->
<%-- 		<td>${bloodBean.bc7 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>전혈/MINUS/O : </td> -->
<%-- 		<td>${bloodBean.bc8 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/PLUS/A : </td> -->
<%-- 		<td>${bloodBean.bc9 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/PLUS/B : </td> -->
<%-- 		<td>${bloodBean.bc10 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/PLUS/AB : </td> -->
<%-- 		<td>${bloodBean.bc11 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/PLUS/O : </td> -->
<%-- 		<td>${bloodBean.bc12 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/MINUS/A : </td> -->
<%-- 		<td>${bloodBean.bc13 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/MINUS/B : </td> -->
<%-- 		<td>${bloodBean.bc14 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/MINUS/AB : </td> -->
<%-- 		<td>${bloodBean.bc15 }</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<!-- 		<td>혈장/MINUS/O : </td> -->
<%-- 		<td>${bloodBean.bc16 }</td> --%>
<!-- 	</tr> -->
		
		
	<tr>
		<td class="td_title1" colspan="8">전혈</td>
	</tr>
	<tr>
		<td class="td_title2" colspan="4">PLUS</td>
		<td class="td_title2" colspan="4">MINUS</td>
	</tr>
	<tr>
		<td class="td_title2">A형</td>
		<td class="td_title2">B형</td>
		<td class="td_title2">AB형</td>
		<td class="td_title2">O형</td>
		<td class="td_title2">A형</td>
		<td class="td_title2">B형</td>
		<td class="td_title2">AB형</td>
		<td class="td_title2">O형</td>
	</tr>
	<tr>
		<td class="td_value">${bloodBean.bc1 }</td>
		<td class="td_value">${bloodBean.bc2 }</td>
		<td class="td_value">${bloodBean.bc3 }</td>
		<td class="td_value">${bloodBean.bc4 }</td>
		<td class="td_value">${bloodBean.bc5 }</td>
		<td class="td_value">${bloodBean.bc6 }</td>
		<td class="td_value">${bloodBean.bc7 }</td>
		<td class="td_value">${bloodBean.bc8 }</td>
	</tr>
	<tr><td><br><br><br><br></td></tr>
	<tr>
		<td class="td_title1" colspan="8">혈장</td>
	</tr>
	<tr>
		<td class="td_title2" colspan="4">PLUS</td>
		<td class="td_title2" colspan="4">MINUS</td>
	</tr>
	<tr>
		<td class="td_title2">A형</td>
		<td class="td_title2">B형</td>
		<td class="td_title2">AB형</td>
		<td class="td_title2">O형</td>
		<td class="td_title2">A형</td>
		<td class="td_title2">B형</td>
		<td class="td_title2">AB형</td>
		<td class="td_title2">O형</td>
	</tr>
	<tr>
		<td class="td_value">${bloodBean.bc9 }</td>
		<td class="td_value">${bloodBean.bc10 }</td>
		<td class="td_value">${bloodBean.bc11 }</td>
		<td class="td_value">${bloodBean.bc12 }</td>
		<td class="td_value">${bloodBean.bc13 }</td>
		<td class="td_value">${bloodBean.bc14 }</td>
		<td class="td_value">${bloodBean.bc15 }</td>
		<td class="td_value">${bloodBean.bc16 }</td>
	</tr>
	
		
</table>
<a href="index.jsp">돌아가기</a>
</section>
</body>
</html>