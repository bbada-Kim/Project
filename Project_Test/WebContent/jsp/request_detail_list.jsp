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
<%@ page import="vo.RequestBean" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updateCardConfirm(){
		if(confirm('해당 헌혈증을 지급 처리하시겠습니까?') == true){
			updateCard.submit();
			
		}
		else{
			return;
		}
		
	}
</script>
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
<form action="requestListMod.b" name="updateCard"method="post">
<table>
<c:choose>
<c:when test="${rdStockList ne null and listCount > 0 }">
요청번호 : ${re_idx}<br>요청개수 : ${requestBean.re_count}
<input type="hidden" name="re_count" id="re_count" value="${requestBean.re_count}"/>
<input type="hidden" name="re_idx" id="re_idx" value="${re_idx}"/>
<input type="hidden" name="rdStockList" id="rdStockList" value="${rdStockList}"/>
<tr id="tr_top">
	<td>번호</td>
	<td>증서번호</td>
	<td>헌혈증사진</td>
	<td>전혈/혈장</td>
	<td>RH</td>
	<td>혈액형</td>
	<td>재고상태</td>
</tr>
<a href="javascript:updateCardConfirm()">[헌혈증 지급]</a>	
<!-- <input type="submit" value="헌혈증 지급" formaction="requestListMod.b"/>	 -->

<c:forEach var="list" items="${rdStockList}">

<tr>
	<td><input type="checkbox" name="idx" id="idx" value="${list.c_num}"/>${list.c_idx}</td>
	<td>${list.c_num}</td>
	<td>${list.c_img }</td>
	<td>${list.bc_btype}</td>
	<td>${list.bc_blood}</td>
	<td>${list.bc_RH}</td>
	<td>${list.bc_status}</td>		
</tr>

	</c:forEach>
</table>
</form>
</section>
<section id="pageList">
	<c:choose>
		<c:when test="${nowPage <= 1}">
			[이전]&nbsp;
		</c:when>
		<c:otherwise>
			<a href="requestListDetail.b?re_idx=${re_idx}&page=${nowPage-1}">[이전]</a>&nbsp;
		</c:otherwise>
	</c:choose>
	<c:forEach var="a" begin="${startPage}" end="${endPage}" step="1">
		<c:choose>
			<c:when test="${a == nowPage}">
				[${a}]
			</c:when>
			<c:otherwise>
				<a href="requestListDetail.b?re_idx=${re_idx}&page=${a}">[${a}]</a>&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${nowPage >= maxPage}">
			[다음]
		</c:when>
		<c:otherwise>
			<a href="requestListDetail.b?re_idx=${re_idx}&page=${nowPage+1}">[다음]</a>			
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