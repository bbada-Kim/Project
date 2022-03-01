<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>

<style>
	#memberListArea{
		width : 400px;
		border : 1px solid gray;
		margin : auto;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "memberListArea">
<table>
	<tr>
		<td colspan=2><h1>회원 목록</h1></td>
	</tr>
	<c:forEach var = "member" items = "${memberList}">
	<tr>
		<td>
			${member.m_ID}
			<a href="${pageContext.request.contextPath}/memberViewAction.me?id=${member.m_ID}">
				회원정보
			</a>
		</td>
<!-- 		<td> -->
<%-- 			<a href="${pageContext.request.contextPath}/RequestList.re?id=${member.m_ID}"> --%>
<!-- 				요청신청서현황 -->
<!-- 			</a> -->
<!-- 		</td> -->
		<td>
<%-- 		<form action="memberDeleteAction.me?id=${member.m_ID}" method="post" --%>
<!-- 		name="memdel"> -->
<!-- 			<a href="javascript:del()">[삭제]</a> -->
<!-- 			</form> -->
		<a href="${pageContext.request.contextPath}/memberDeleteAction.me?id=${member.m_ID}" 
		onclick="return confirm('해당 회원을 정말로 삭제하시겠습니까?');">삭제</a> 

		</td>
	</tr>
	</c:forEach>
</table>
</section>
</body>
</html>