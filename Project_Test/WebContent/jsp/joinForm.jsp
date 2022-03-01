<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#joinformArea{
		width:400px;
		margin:auto;
		border:1px solid gray;
		}
	table{
		width:380px;
		margin:auto;
		text-align:center;
		}
</style>
</head>
<body>
<section id ="joinformArea">
<form name="joinform" action="${pageContext.request.contextPath}/memberJoinAction.me" method="post">
<table>
	<tr>
		<td colspan="2">
			<h1>회원 가입 페이지</h1>
		</td>
	</tr>
	<tr>
		<td><label for="M_ID">아이디 : </label></td>
		<td><input type="text" name="M_ID" id="M_ID" required="required"/>
		<input type="button" name="idCheck" value="아이디 중복확인"
						id="idCheck"
				onClick="window.open('jsp/idCheck.jsp?openInit=true','',
						 'width=400,height=200')"/>
						 </td>
	</tr>
	<tr>
		<td><label for = "M_PASSWD">비밀번호 : </label></td>
		<td><input type="password" name="M_PASSWD" id = "M_PASSWD" required="required"/></td>
	</tr>
	<tr>
		<td><label for = "M_NAME">이름 : </label></td>
		<td><input type="text" name="M_NAME" id = "M_NAME" required="required"/></td>
	</tr>
	<tr>
		<td><label for = "M_AGE">나이 : </label></td>
		<td><input type="text" name="M_AGE" maxlength="2" id = "M_AGE" required="required"/></td>
	</tr>
	<tr>
		<td><label for = "M_GENDER">성별 : </label></td>
		<td>
			<input type="radio" name="M_GENDER" value="남" checked="checked" id = "M_GENDER"/>남자
			<input type="radio" name="M_GENDER" value="여"/>여자
		</td>
	</tr>
	<tr>
		<td><label for = "M_PHONE">전화번호 : </label></td>
		<td><input type="text" name="M_PHONE" id = "M_PHONE" required="required"/></td>
	</tr>
	<tr>
		<td><label for="M_BLOOD">혈액형 : </label></td>
		<td>
			<input type="radio" name="M_BLOOD" value="A" id="M_BLOOD" checked="checked"/>A
			<input type="radio" name="M_BLOOD" value="B"/>B
			<input type="radio" name="M_BLOOD" value="AB"/>AB
			<input type="radio" name="M_BLOOD" value="O"/>O
		</td>
	</tr>
	<tr>
		<td><label for="M_ADDR">주소 : </label></td>
		<td>
			<input type="text" name="M_ADDR" id="M_ADDR" required="required"/>
		</td>
	</tr>
	<tr>
		<td><label for = "M_EMAIL">이메일 주소 : </label></td>
		<td><input type="text" name="M_EMAIL" id = "M_EMAIL" required="required"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</form>
</section>
</body>
</html>