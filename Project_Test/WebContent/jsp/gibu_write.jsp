<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
session.getAttribute("id");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#registForm{
	width:500px;
	height:610px;
	border:1px solid red;
	margin:auto;
}

h2{
	text-align:center;
}

table{
	margin:auto;
	width:700px;
}

.td_left{
	width:100px;
	background:orange;
}

.td_right{
	width:150px;
	background:skyblue;
}

#commandCell{
	text-align:center;
}

#uploadFormArea{
	margin:auto;
	width:750px;
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
		if(cnt<10){
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
		else{
			alert('한 번에 10개까지만 신청 가능합니다. 10개 이상은 추가로 신청해 주세요.');
		}
	}
	function removeRow(){
		oTbl1.deleteRow(oTbl1.clickedRowIndex);
	}
</script>
</head>
<body>
<!-- 	기부신청 -->
	<section id="uploadFormArea">
		<h2>기부신청</h2>
		<form action="gibuWrite.b" method="post" enctype="multipart/form-data">
			<table>
				<tr>
<!-- 					<td class="td_left"><label for="id">아이디</label></td> -->
					<td><input name="id" type="hidden" id="id" value="${id }" required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="coment">내용</label></td>
					<td class="td_right"><input name="coment" type="text" id="coment" required="required"/></td>
				</tr>
				<tr>
					<td class="td_right"><input name="gibu_status" type="hidden" id="gibu_status" value="신청중" required="required"/></td>
				</tr>	

				<tr><td><h4>기부증입력</h4></td></tr>
			</table>
			<table>
				<tr>
					<td class="td_left"><label for="btype">헐액타입(전혈/혈장)</label></td>
					<td class="td_right">
					<select id = "btype" name="btype">
					<option>전혈</option>
					<option>혈장</option>
					</select>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="blood">혈액형</label></td>
					<td class="td_right">
					<select id = "blood" name="blood">
					<option>A</option>
					<option>B</option>
					<option>O</option>
					<option>AB</option>
					</select>
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="rh">RH</label></td>
					<td class="td_right">
					<select id = "rh" name="rh">
					<option>PLUS</option>
					<option>MINUS</option>
					</select>
					</td>
				</tr>															
				<tr>
					<td class="td_right"><input name="bc_status" type="hidden" id="bc_status" value="신청중" required="required"/></td>
				</tr>
				<tr>
					<td class="td_right"><input name="bc_id" type="hidden" id="bc_id" value="bin" required="required"/></td>
				</tr>	
				<tr><td><h4>증서 저장</h4></td></tr>															
			</table>
			<table width="100%">
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

				</tr>
				<tr>
					<td>
					<input name="addButton" type="button" style="cursor:pointer"
						onClick="insRow()" value="파일 입력창 추가">	
					</td>
		</table>
	
		
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기"/>
			</section>
			<section id="commandCell">
				<br><a href="index.jsp">처음으로 돌아가기</a>
			</section>
		</form>
	</section>
</body>
</html>