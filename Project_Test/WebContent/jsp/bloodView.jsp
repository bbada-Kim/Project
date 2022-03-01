<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="J_vo.BloodReBean" %>
<!DOCTYPE html>
<%
	session.getAttribute("id");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	width:1000px;
	border: 1px solid black;
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
	margin:auto;
}

h2{
	text-align:center;
}

#listtable{
	margin:auto;
	width:900px;
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
<h2>요청신청 현황</h2>
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
<c:when test="${bloodReList ne null and listCount > 0 }">
<tr id="tr_top">
	<td>아이디</td>
	<td>수혈 장소</td>
	<td>요청사유</td>
	<td>신청날짜</td>
	<td>요청갯수</td>
	<td>전혈/혈장</td>
	<td>RH</td>
	<td>혈액형</td>
	<td>요청진행상황</td>
	<td>작성날짜</td>
	<td>진단서 사진</td>
</tr>
<c:forEach var="list" items="${bloodReList}">
<tr>
	<td>${list.ID }</td>
	<td>${list.re_locate }</td>
	<td>${list.re_content }</td>
	<td>${list.re_date }</td>
	<td>${list.re_count }</td>
	<td>${list.re_btype }</td>
	<td>${list.re_rh }</td>
	<td>${list.re_blood }</td>
	<td>${list.re_status }</td>
	<td>${list.re_wri_date }</td>
	<td><input type="button" name="image" value="${list.re_image }" id="image"
   onclick="window.open('imageAction.re?image=${list.re_image }','','width=800, height=600')"/><br></td>
</tr>
	</c:forEach>
</table>
</section>
<br>
<section id="pageList">
	<c:choose>
		<c:when test="${nowPage <= 1}">
			[이전]
		</c:when>
		<c:otherwise>
			<a href="RequestList.re?page=${nowPage-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	<c:forEach var="a" begin="${startPage}" end="${endPage}" step="1">
		<c:choose>
			<c:when test="${a == nowPage}">
				[${a}]
			</c:when>
			<c:otherwise>
				<a href="RequestList.re?page=${a}">[${a}]</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${nowPage >= maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="RequestList.re?page=${nowPage+1}">[다음]</a>			
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