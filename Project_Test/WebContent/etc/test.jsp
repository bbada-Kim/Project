<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
<!-- 	기부신청 -->
	<section id="writeForm">
		<h2>기부신청</h2>
		<form action="scripttest.jsp" method="post" enctype="multipart/form-data" name="boardform">
			<table>
				<tr>
					<td class="td_left"><label for="id">아이디</label></td>
					<td class="td_right"><input name="id" type="text" id="id" required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="coment">내용</label></td>
					<td class="td_right"><input name="coment" type="text" id="coment" required="required"/></td>
				</tr>
				<tr>
					<td class="td_right"><input name="gibu_status" type="hidden" id="gibu_status" value="신청중" required="required"/></td>
				</tr>	
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="cnum">증서번호</label></td> -->
<!-- 					<td class="td_right"><input name="cnum" type="text" id="cnum" required="required"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="image">헌혈증첨부</label></td> -->
<!-- 					<td class="td_right"><input name="image" type="file" id="image" required="required"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="btype">헐액타입(전혈/혈장)</label></td> -->
<!-- 					<td class="td_right"> -->
<!-- 					<select id = "btype" name="btype"> -->
<!-- 					<option>전혈</option> -->
<!-- 					<option>혈장</option> -->
<!-- 					</select> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="blood">혈액형</label></td> -->
<!-- 					<td class="td_right"> -->
<!-- 					<select id = "blood" name="blood"> -->
<!-- 					<option>A</option> -->
<!-- 					<option>B</option> -->
<!-- 					<option>O</option> -->
<!-- 					<option>AB</option> -->
<!-- 					</select> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td class="td_left"><label for="rh">RH</label></td> -->
<!-- 					<td class="td_right"> -->
<!-- 					<select id = "rh" name="rh"> -->
<!-- 					<option>PLUS</option> -->
<!-- 					<option>MINUS</option> -->
<!-- 					</select> -->
<!-- 					</td> -->
<!-- 				</tr>															 -->
<!-- 				<tr> -->
<!-- 					<td class="td_right"><input name="bc_status" type="hidden" id="bc_status" value="신청중" required="required"/></td> -->
<!-- 				</tr>																 -->
			</table>	
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기"/>
			</section>
			<section id="commandCell">
				<br><a href="index.jsp">처음으로 돌아가기</a>
			</section>
		</form>
	</section>
</body>
</html>