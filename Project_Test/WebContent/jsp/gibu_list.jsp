<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="vo.GibuBean" %>
<!DOCTYPE html>
<%
// session.getAttribute("id");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modify(){
		gibumodify.submit();
		alert('수정 완료!!');
	}
</script>
<style type="text/css">
#registForm{
	width:500px;
	height:auto;
	border:1px solid red;
	margin:auto;
}

h2{
	text-align:center;
}

table{
	margin:auto;
	width:500px;
}

.td_left{
	width:150px;
	background:orange;
}

.td_right{
	width:250px;
	background:skyblue;
	text-align:center;
}

#commandCell{
	text-align:center;
}
	#registForm{
	width:500px;
	height:600px;
	border:1px solid red;
	margin:auto;
}

h2{
	text-align:center;
}

#listtable{
	margin:auto;
	width:600px;
}

#tr_top{
	background:orange;
	text-align:center;
}

#pageList{
	margin:auto;
	width:500px;
	text-align:center;
}

#emptyArea{
	margin:auto;
	width:500px;
	text-align:center;
}
</style>
</head>
<body>
<h2>기부신청 현황</h2>
<form action="gibuListMod.b" method="post" name="gibumodify">

<%-- 	<input type="hidden" name="page" value="${page}"/> --%>

	<c:if test="${pageInfo ne null}">
	<c:set var="listCount" value="${pageInfo.listCount}"/>
	<c:set var="nowPage" value="${pageInfo.page}"/>
	<c:set var="maxPage" value="${pageInfo.maxPage}"/>
	<c:set var="startPage" value="${pageInfo.startPage}"/>
	<c:set var="endPage" value="${pageInfo.endPage}"/>

<section id="listForm">

<table id="listtable">
<c:choose>
<c:when test="${gibuList ne null and listCount > 0 }">
<tr id="tr_top">
	<td>아이디</td>
	<td>코멘트</td>
	<td>신청날짜</td>
	<td>진행상황</td>
	<td>진행상황변경</td>
	<td>신청삭제</td>
</tr>
<c:forEach var="list" items="${gibuList}">
<tr>
	<td><input type="button" name="gibuDetail" value="${list.id}" id="gibuDetail"
		onclick="window.open('gibuDetail.b?do_idx=${list.do_idx}','','width=550, height=450')"/></td>
	<td>${list.do_coment }</td>
	<td>${list.do_date }</td>
	<td>${list.do_status }</td>
	<td><input type="button" name="gibuDetail" value="변경하기" id="gibuDetail"
		onclick="window.open('gibuStatusDetail.b?do_idx=${list.do_idx}','','width=480, height=200')"/>
	</td>
	<td>	
		<input type="button" name="gibuDel" value="삭제하기" id="gibuDel"
		onclick="window.open('adminGibuListDelForm.b?do_idx=${list.do_idx}','','width=480, height=200')"/>
	</td>
</tr>
	</c:forEach>
</table>
</section>
</form>
<br>
<section id="pageList">
	<c:choose>
		<c:when test="${nowPage <= 1}">
			[이전]
		</c:when>
		<c:otherwise>
			<a href="gibuList.b?page=${nowPage-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	<c:forEach var="a" begin="${startPage}" end="${endPage}" step="1">
		<c:choose>
			<c:when test="${a == nowPage}">
				[${a}]
			</c:when>
			<c:otherwise>
				<a href="gibuList.b?page=${a}">[${a}]</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${nowPage >= maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="gibuList.b?page=${nowPage+1}">[다음]</a>			
		</c:otherwise>
	</c:choose>
	<br><br>

</section>
	</c:when>
	<c:otherwise>
		<section id="emptyArea">등록된 글이 없습니다.</section>
	</c:otherwise>	
</c:choose>
</c:if>
</body>
</html>