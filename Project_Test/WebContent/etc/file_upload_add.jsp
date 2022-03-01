<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#uploadFormArea{
	margin:auto;
	width:850px;
	border:1px solid black;
}
.td_title{
	font-size=xx-Large;
	text-align:center;	
}
</style>
<script>
	var cnt=0;
	var cnt1=0;
	var oTbl;
	//Row추가
	function insRow(){
		cnt++;
		cnt1++;
		oTbl1 = document.getElementById("addTable");
		var oRow = oTbl1.insertRow();	//새로운 행 추가하는 자바스크립트 명령어
		oRow.onmouseover = function(){
			oTbl1.clickedRowIndex = this.rowIndex
		}; //clicedRowIndex - 클릭한 Row의 위치를 확인
		var oCell1 = oRow.insertCell();
		var oCell2 = oRow.insertCell();
		var oCell3 = oRow.insertCell();
		var oCell4 = oRow.insertCell();
		//삽입될 Form Tag
		var frmTag1 = "<label for='fileName"+cnt+"'>파일명:</label>";
		var frmTag2 = "<input type='file' name='fileName"+cnt+"' id='fileName"+cnt+"' required>";
// 		frmTag2 += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
		var frmTag3 = "<label for='cnum"+cnt1+"'>증서번호:</label>";
		var frmTag4 = "<input type='text' name='cnum"+cnt1+"' id='cnum"+cnt1+"' required>";
		frmTag4 += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
		oCell1.innerHTML = frmTag1;
		oCell2.innerHTML = frmTag2;
		oCell3.innerHTML = frmTag3;
		oCell4.innerHTML = frmTag4;
	}
// 	function insRowtxt(){
// 		cnt1++;
// 		oTbl2 = document.getElementById("addTable1");
// 		var oRow = oTbl2.insertRow();	//새로운 행 추가하는 자바스크립트 명령어
// 		oRow.onmouseover = function(){
// 			oTbl2.clickedRowIndex = this.rowIndex
// 		}; //clicedRowIndex - 클릭한 Row의 위치를 확인
// 		var oCell3 = oRow.insertCell();
// 		var oCell4 = oRow.insertCell();
// 		//삽입될 Form Tag
// 		var frmTag3 = "<label for='cnum"+cnt1+"'>증서번호:</label>";
// 		var frmTag4 = "<input type='text' name='cnum"+cnt1+"' id='cnum"+cnt1+"'>";
// 		frmTag4 += "<input type=button value='삭제' onClick='removeRow1()' style='cursor:hand'>";
// 		oCell3.innerHTML = frmTag3;
// 		oCell4.innerHTML = frmTag4;
// 	}	
	//Row 삭제
	function removeRow(){
		oTbl1.deleteRow(oTbl1.clickedRowIndex);
	}
// 	function removeRow1(){
// 		oTbl2.deleteRow(oTbl2.clickedRowIndex);
// 	}
	function frmCheck(){
		var frm = document.f;
		for(var i=0; i <= frm.elements.length ; i++){
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
	<form name="f" action="gibuWrite.b" method="post"
		enctype="multipart/form-data" onsubmit="return frmCheck()">
		<table width="100%">
<!-- 			<tr> -->
<!-- 				<td colspan="2" class="td_title">파일 업로드 폼</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><label for="name">올린 사람 : </label></td> -->
<!-- 				<td><input type="text" name="name" id="name"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><label for="subject">제목 : </label></td> -->
<!-- 				<td><input type="text" name="subject" id="subject"></td> -->
<!-- 			</tr> -->
			<tr>
				<td colspan="2">
				<table id="addTable" border="1">
					<tr>
						
						<td><label for="fileName0">파일명 : </label></td>
						<td><input type="file" name="fileName0" id="fileName0" required></td>
						<td><label for="cnum0">증서번호 : </label></td>
						<td><input type="text" name="cnum0" id="cnum0" required></td>
					</tr>
					<tr>
					</table></td>
					
				<td colspan="2">
<!-- 				<table id="addTable" border="1"> -->
<!-- 					<tr> -->
						
<!-- 						<td><label for="cnum0">증서번호 : </label></td> -->
<!-- 						<td><input type="text" name="cnum0" id="cnum0" ></td> -->

<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 					</table></td> -->
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="업로드" required></td>
				</tr>
		</table>
		</form>
		<input name="addButton" type="button" style="cursor:pointer"
			onClick="insRow()" value="파일 입력창 추가">
<!-- 		<input name="addButton1" type="button" style="cursor:pointer" -->
<!-- 			onClick="insRowtxt()" value="입력창 추가"> -->
		</section>
</body>
</html>