<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<script type="text/javascript">
	function deleteList(){
		if(confirm('※주의※'+"<br>"+'삭제 시 복구 불가!! 정말로 삭제하시겠습니까?') == true){
			deleteForm.submit();
		}
		else{
			return;
		}
	}
</script>
<style>
	#passForm{
		width:450px;
		margin:auto;
		border:1px solid orange;
	}
	
	#center{
		text-align:center;
	}
	table{
		text-align:center;
	}
</style>
</head>
<body>
<h2>기부신청, 재고 항목 삭제 (jstl버전)</h2>
	<section id="passForm">
		<form name="deleteForm" action="adminListDel.b?do_idx=${do_idx}" method="post">
			<input type="hidden" name="page" value="${page}"/>
			<table>
				<tr>
					<td>
						<label>※삭제 시 복구 불가하므로, 신중히 진행하시기 바랍니다. </label>
					</td>
				</tr>
				<tr>
					<td>
						<a href="javascript:deleteList()">[삭제]</a>
						&nbsp;&nbsp;
						<a href="javascript:history.go(-1)">[뒤로]</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<section id="center">
		<br><a href="gibuAdminList.b">목록으로 돌아가기</a>
		<br><br><a href="index.jsp">처음으로 돌아가기</a>
	</section>
</body>
</html>