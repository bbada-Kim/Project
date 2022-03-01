<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	int do_idx = Integer.parseInt(request.getParameter("do_idx"));
	String do_date = request.getParameter("do_date");
	String do_status = request.getParameter("do_status");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modify(){
		if(confirm('해당 신청 건 삭제하시겠습니까?') == true){
			alert('삭제 완료!');
			gibudel.submit();
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
<br><br><br>
<table>
<tr id="tr_top">
<form action="adminGibuListDel.b" method="post" name="gibudel">

	<td>신청 삭제</td>
	<input type="hidden" name="do_idx" id="do_idx" value="<%=do_idx %>"/>
</tr>
	<td id="td">
	<a href="javascript:modify()" >[삭제하기]</a>
	</td>
</table>
</form>
</body>
</html>