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
		width:800px;
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
<h2>재고 리스트</h2>	
<table>
<c:choose>
<c:when test="${gibuList ne null and listCount > 0 }">
<tr>
	<td><a href="adminDetail.b">기부신청목록</a></td>
		
	<td></td><td></td><td></td><td></td><td></td>
	
	<td align="right"><a href="requestList.b">요청신청목록</a></td>	
</tr>		
<tr id="tr_top">
	<td>번호</td>
	<td>증서번호</td>
	<td>기부증</td>
	<td>전혈/혈장</td>
	<td>혈액형</td>
	<td>RH</td>
	<td>재고상태</td>
</tr>
<c:forEach var="list" items="${gibuList}">
<tr>
	<td>${list.c_idx}</td>
	<td>
		<a href = "adminDetail.b?do_idx=${list.c_idx}&page=${nowPage}">
		${list.c_num}</a>
	</td>
	<td>
		<input type="button" name="image" value="${list.c_img}" id="image"
	onclick="window.open('imageAction.b?image=${list.c_img}','','width=600, height=500')"/><br>
<%-- 	<a href="file_down?downFile=${list.bc_image}">${list.bc_image}</a> --%>
	
	</td>
	
	<td>${list.bc_btype}</td>
	<td>${list.bc_blood}</td>
	<td>${list.bc_RH}</td>
	<td>${list.bc_status}</td>		
</tr>
	</c:forEach>
</table>
</section>
<section id="pageList">
	<c:choose>
		<c:when test="${nowPage <= 1}">
			[이전]&nbsp;
		</c:when>
		<c:otherwise>
			<a href="gibuAdminList.b?page=${nowPage-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	<c:forEach var="a" begin="${startPage}" end="${endPage}" step="1">
		<c:choose>
			<c:when test="${a == nowPage}">
				[${a}]
			</c:when>
			<c:otherwise>
				<a href="gibuAdminList.b?page=${a}">[${a}]</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${nowPage >= maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="gibuAdminList.b?page=${nowPage+1}">[다음]</a>			
		</c:otherwise>
	</c:choose>
	<br><br>
	<a href="index.jsp">처음으로 돌아가기</a>
</section>
	</c:when>
	<c:otherwise>
		<section id="emptyArea">등록된 글이 없습니다.</section>
	</c:otherwise>	
</c:choose>
</c:if>
</body>
</html>