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
		width:1200px;
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
<h2>요청신청목록</h2>	
<table>
<c:choose>
<c:when test="${rbList ne null and listCount > 0 }">
<tr id="tr_top">
	<td>번호</td>
	<td>아이디</td>
	<td>작성날짜</td>
	<td>제출장소</td>
	<td>요청사유</td>
	<td>진단서</td>
	<td>필요날짜</td>
	<td>전혈/혈장</td>
	<td>RH</td>
	<td>혈액형</td>
	<td>요청수량</td>
	<td>요청진행상황</td>
	<td>요청진행변경</td>
	<td>요청할당목록</td>
</tr>
<c:forEach var="list" items="${rbList}">
<tr>
	<td>${list.re_idx}</td>
	<td>
		<input type="button" name="requestDetail" value="${list.id}" id="requestDetail"
		onclick="window.open('requestListDetail.b?re_idx=${list.re_idx}','','width=850, height=450')"/>
	</td>
	<td>${list.re_wri_date}</td>
	
	<td>${list.re_locate}</td>
	<td>${list.re_content}</td>
	<td>${list.re_image}</td>
	<td>${list.re_date}</td>		
	<td>${list.re_btype}</td>
	<td>${list.re_rh}</td>
	<td>${list.re_blood}</td>
	<td>${list.re_count}</td>
	<td><font size="1"><b>${list.re_status}</b></font></td>
	<td>
		<input type="button" name="requestStat" value="변경하기" id="requestStat"
		onclick="window.open('adminRequestStatusModForm.b?re_idx=${list.re_idx}','','width=480, height=200')"/>
	</td>
	<td>
		<input type="button" name="requestGive" value="할당목록" id="requestGive"
		onclick="window.open('requestGiveList.b?re_idx=${list.re_idx}','','width=550, height=300')"/>
	</td>
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