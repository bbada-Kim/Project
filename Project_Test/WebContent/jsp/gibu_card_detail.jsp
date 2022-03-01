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
<%
	int do_idx = Integer.parseInt(request.getParameter("do_idx"));
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function inStockConfirm(){
		if(confirm('해당 증서를 입고 처리하시겠습니까?') == true){
			alert('입고 완료!');
			inStockMod.submit();
		}
		else{
			return;
		}
	}
</script>
<style type="text/css">
	#registForm{
		width:500px;
		height:400px;
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
		background:skyblue;
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

<form action="adminGibuDetailMod.b" method="post" name="inStockMod">
<input type="hidden" name="do_idx" id="do_idx" value="<%=do_idx %>"/>
<section id="registForm">
<h2>기부신청 상세</h2>	
<table>
<c:choose>
<c:when test="${giList ne null and listCount > 0 }">
	
<tr id="tr_top">
	<td>번호</td>
	<td>증서번호</td>
	<td>헌혈증</td>
</tr>
<c:forEach var="list" items="${giList}">
<tr>
	<td>${list.c_idx}
		<input type="hidden" name="c_idx" id="c_idx" value="${list.c_idx}">
	</td>
	<td>${list.c_num}</td>
	<td>
		<input type="button" name="image" value="${list.c_img}" id="image"
	onclick="window.open('imageAction.b?image=${list.c_img}','','width=600, height=500')"/><br>
<%-- 	<a href="file_down?downFile=${list.bc_image}">${list.bc_image}</a> --%>
	</td>	
</tr>
	</c:forEach>
</table>
</section>
</form>
<section id="pageList">
	<c:choose>
		<c:when test="${nowPage <= 1}">
			[이전]&nbsp;
		</c:when>
		<c:otherwise>
			<a href="adminGibuDetail.b?do_idx=<%=do_idx %>&page=${nowPage-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	<c:forEach var="a" begin="${startPage}" end="${endPage}" step="1">
		<c:choose>
			<c:when test="${a == nowPage}">
				[${a}]
			</c:when>
			<c:otherwise>
				<a href="adminGibuDetail.b?do_idx=<%=do_idx %>&page=${a}">[${a}]</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${nowPage >= maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="adminGibuDetail.b?do_idx=<%=do_idx %>&page=${nowPage+1}">[다음]</a>			
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