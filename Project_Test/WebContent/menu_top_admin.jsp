<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body, div, ul, li{
		margin:0;
		padding:0;
	}
	body{
		font-size:13px;
		font-family:"맑은 고딕", arial;
		font-weight:bold;
	}
	ul{
		list-style:none;
	}
	a{
		color:#000;
		text-decoration:none;
	}
	.gnb{
		height:36px;
		margin:auto;
		margin-top:0;
	}
/* 메인매뉴 영역 */
	.gnb>ul{
		text-align:center;
		height:36px;
		background:#0099ff;
		padding:0;
	}
	.gnb>ul>li{
		display:inline-block;
		width:102px;
		height:36px;
		margin-top:0;
		position:relative;
	}
	.gnb>ul>li>a{
		display:block;
		width:100%;
		height:100%;
		font:bold 13px/30px "맑은 고딕", arial;
		text-align:center;
		color:#fff;
		background:#0099ff;
	}
	.gnb ul li a:hover{
		color:#000;
		background:#0099ff;
	}
/* 서브메뉴 영역 */
	.gnb ul ul{
		display:none;
	}
/* 롤 오버	 */
	.gnb ul li:hover ul{
		display:block;
	}
	.gnb li li{
		width:100px;
		height:36px;
		background-color:#47a9f4;
		text-align:center;
		float:left;
	}
	.gnb li li a{
		display:block;
		width:100%;
		height:100%;
		font:bold 12px/25px "맑은 고딕", arial;
		margin-top:5px;
	}
	.gnb li li a:hover{
		color:white;
		background:none;
	}
</style>
</head>
<body>
<div class="gnb">
	<ul>
		<li><a href="#">헌혈증 재고현황</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/bloodList.b">상세 유형별 재고</a></li>
				<li><a href="${pageContext.request.contextPath}/chartList.b">혈액 통계</a></li>
			</ul>
		</li>
		<li><a href="#">관리자</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/gibuAdminList.b">재고 현황 리스트</a></li>
				<li><a href="${pageContext.request.contextPath}/memberListAction.me">회원 목록</a></li>
				<li><a href="#">서브메뉴3</a></li>
				<li><a href="#">서브메뉴4</a></li>
			</ul>
		</li>
		<li>
		<%if(session.getAttribute("id")==null){ %>
				<a href="jsp/loginForm.jsp">로그인</a>
			<%}else{ %>
				<a href="${pageContext.request.contextPath}/logoutForm.b">로그아웃</a>
			<%} %>
<!-- 			<ul>
				<li><a href="#">서브메뉴1</a></li>
				<li><a href="#">서브메뉴2</a></li>
				<li><a href="#">서브메뉴3</a></li>
			</ul> -->
		</li>
		<li><a href="${pageContext.request.contextPath}/boardList.bo">커뮤니티</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/boardWriteForm.bo">글쓰기</a></li>
				<li><a href="#">서브메뉴2</a></li>
				<li><a href="#">서브메뉴3</a></li>
				<li><a href="#">서브메뉴4</a></li>
			</ul>
		</li>
	</ul>
</div>
</body>
</html>