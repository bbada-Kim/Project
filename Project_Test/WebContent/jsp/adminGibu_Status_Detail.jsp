<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int do_idx = Integer.parseInt(request.getParameter("do_idx"));
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modify(){
		if(confirm('해당 건의 기부 신청 현황을 변경 하시겠습니까?') == true){
			alert('변경 완료!');
			gibumod.submit();
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
<form action="adminListMod.b" method="post" name="gibumod">

	<td>신청현황변경</td>
	<input type="hidden" name="do_idx" id="do_idx" value="<%=do_idx %>"/>
</tr>
<tr>
	<td id="td">
	<select name="do_status" id="do_status">
		<option selected>신청중</option>
		<option>발송요청</option>
		<option>승인완료</option>
	</select>
	<a href="javascript:modify()" >[변경하기]</a>
	</td>
</tr>
</table>
</form>
</body>
</html>