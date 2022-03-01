<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
session.getAttribute("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#registForm{
	width:500px;
	height:610px;
	border:1px solid red;
	margin:auto;
	}
h2{
	text-align:center;
	}
table{
	margin:auto;
	width:450px;
	}	
.td_left{
	width:150px;
	background:orange;
	}
.td_right{
	width:300px;
	background:skyblue;
	}

#commandCell{
	text-align:center;
	}
</style>
</head>
<body>
	<section id="writeForm">
		<h2>요청신청서</h2>	
		<form action="bloodWritePro.re" method="post" name="bloodform"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><input type="hidden" name="id" id="id" value="${id }"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="locate">수혈장소(주소)</label></td>
					<td class="td_right"><input type="text" name="locate" 
					id="locate" required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="content">요청 내용</label></td>
					<td class="td_right"><input type="text" name="content"
					id="content" required="required"/></td>
				</tr>
				<tr>
					<td><input type="hidden" name="status" id="status" value="승인대기"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="date">요청 날짜</label></td>
					<td class="td_right"><input type="date" name="date" id="date"
					required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="file">진단서 사진</label></td>
					<td class="td_right"><input type="file" name="file" id="file"
					required="required"/></td>
				</tr>
				</table>
			<section id="commandCell">
				요청갯수:
				<select name="count">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				수혈 종류:
				<select name="btype">
					<option value="j">전혈</option>
					<option value="h">혈장</option>
				</select>
				혈액형:
				<select name="blood">
					<option value="a">A</option>
					<option value="b">B</option>
					<option value="ab">AB</option>
					<option value="o">O</option>
				</select>
				<select name="rh">
					<option value="plus">PLUS</option>
					<option value="minus">MINUS</option>
				</select>
			</section>
				<section id="commandCell">
					<input type="submit" value="등록">&nbsp;&nbsp;
					<input type="reset" value="다시쓰기"/>
					</section>
			</form>
	</section>
</body>
</html>