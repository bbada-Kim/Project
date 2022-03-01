<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/htm14/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>파일 업로드 폼</title>
<style type="text/css">
#uploadFormArea{
	margin:auto;
	width:400px;
	border:1px solid black;
}
.td_title{
	font-size=xx-Large;
	text-align:center;	
}
</style>
<script>
	var cnt=1;
	var oTbl;
	//Row추가
	function insRow(){
		cnt++;
		oTbl = document.getElementById("addTable");
		var oRow = oTbl.insertRow();	//새로운 행 추가하는 자바스크립트 명령어
		oRow.onmouseover = function(){
			oTbl.clickedRowIndex = this.rowIndex
		}; //clicedRowIndex - 클릭한 Row의 위치를 확인
		var oCell1 = oRow.insertCell();
		var oCell2 = oRow.insertCell();
		//삽입될 Form Tag
		var frmTag1 = "<label for='fileName"+cnt+"'>파일명:</label>";
		var frmTag2 = "<input type='file' name='fileName"+cnt+"' id='fileName"+cnt+"'>";
		frmTag2 += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
		oCell1.innerHTML = frmTag1;
		oCell2.innerHTML = frmTag2;
	}
	//Row 삭제
	function removeRow(){
		oTbl.deleteRow(oTbl.clickedRowIndex);
	}
	function frmCheck(){
		var frm = document.f;
		for(var i=0; i <= frm.elements.length -1; i++){
			if(frm.elements[i].name.indexOf("filename")>-1){
				if(!frm.elements[i].value){
					alert("업로드할 파일을 선택하세요");
					frm.elements[i].focus();
					return false;
				}
			}
		}
	}
</script>
</head>
<body>
	<section id="uploadFormArea">
	<form name="f" action="multiFileAct
	ion.b" method="post"
		enctype="multipart/form-data" onsubmit="return frmCheck()">
		<table width="100%">
			<tr>
				<td colspan="2" class="td_title">파일 업로드 폼</td>
			</tr>
			<tr>
				<td><label for="name">올린 사람 : </label></td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td><label for="subject">제목 : </label></td>
				<td><input type="text" name="subject" id="subject"></td>
			</tr>
			<tr>
				<td colspan="2">
				<table id="addTable" border="1">
					<tr>
						<td><label for="fileName1">파일명 : </label></td>
						<td><input type="file" name="fileName1" id="fileName1"></td>
					</tr>
					</table></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="업로드"></td>
				</tr>
		</table>
		</form>
		<input name="addButton" type="button" style="cursor:pointer"
			onClick="insRow()" value="입력창 추가">
		</section>
</body>
</html>