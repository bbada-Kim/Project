<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="vo.PageInfo" %>
<%@ page import="vo.StockBean" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="vo.GibuBean" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#registForm{
		width:500px;
		height:600px;
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


<c:if test="${pageInfo ne null}">
	<c:set var="listCount" value="${pageInfo.listCount}"/>
	<c:set var="nowPage" value="${pageInfo.page}"/>
	<c:set var="maxPage" value="${pageInfo.maxPage}"/>
	<c:set var="startPage" value="${pageInfo.startPage}"/>
	<c:set var="endPage" value="${pageInfo.endPage}"/>


<section id="listForm">
<h2>요청할당목록</h2>	
<table>
<c:choose>
<c:when test="${requestGiveList ne null and listCount > 0 }">
<tr id="tr_top">
	<td>증서번호</td>
	<td>증서사진</td>
	<td>전혈/혈장</td>
	<td>RH</td>
	<td>혈액형</td>
</tr>
<c:forEach var="list" items="${requestGiveList}">
<tr>
	<td>${list.c_num}</td>
	<td>${list.c_img}</td>
	<td>${list.bc_btype}</td>
	<td>${list.bc_RH}</td>
	<td>${list.bc_blood}</td>
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
			<a href="requestList.b?page=${nowPage-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	<c:forEach var="a" begin="${startPage}" end="${endPage}" step="1">
		<c:choose>
			<c:when test="${a == nowPage}">
				[${a}]
			</c:when>
			<c:otherwise>
				<a href="requestList.b?page=${a}">[${a}]</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${nowPage >= maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="requestList.b?page=${nowPage+1}">[다음]</a>			
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