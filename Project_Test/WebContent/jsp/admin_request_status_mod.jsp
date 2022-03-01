<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int re_idx = Integer.parseInt(request.getParameter("re_idx"));
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modify(){
		if(confirm('해당 건의 요청 신청 현황을 변경 하시겠습니까?') == true){
			alert('변경 완료!');
			requestmod.submit();
		}
		else{
			return;
		}
	}
</script>
<style type="text/css">
	
	h2{
		text-align:center;
	}
	
	table{
		margin:auto;
		width:300px;
	}
	
	#tr_top{
		background:orange;
		text-align:center;
	}
	#td{
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
<table>
<tr id="tr_top">
<form action="adminRequestStatusMod.b" method="post" name="requestmod">

	<td>신청현황변경</td>
	<input type="hidden" name="re_idx" id="re_idx" value="<%=re_idx %>"/>
</tr>
<tr>
	<td id="td">
	<input type="text" name="re_status" id="re_status"/>
	<a href="javascript:modify()" >[변경하기]</a>
	</td>
</tr>
</table>
</form>
</body>
</html>