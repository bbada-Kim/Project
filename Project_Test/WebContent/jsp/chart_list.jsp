<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.ChartBean" %>




<%
	ChartBean chartBean = (ChartBean)request.getAttribute("chartBean");
	int all_blood = chartBean.getAll_blood();
	int gi_blood = chartBean.getGi_blood();
	int re_blood = chartBean.getRe_blood();
	int gi_a_blood = chartBean.getGi_a_blood();
	int gi_b_blood = chartBean.getGi_b_blood();
	int gi_o_blood = chartBean.getGi_o_blood();
	int gi_ab_blood = chartBean.getGi_ab_blood();
	int re_a_blood = chartBean.getRe_a_blood();
	int re_b_blood = chartBean.getRe_b_blood();
	int re_o_blood = chartBean.getRe_o_blood();
	int re_ab_blood = chartBean.getRe_ab_blood();
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	<br><br><br><br><br><br><br><br>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
	var all_blood = <%=all_blood%>
	var gi_blood = <%=gi_blood%>
	var re_blood = <%=re_blood%>
	var gi_a_blood = <%=gi_a_blood%>
	var gi_b_blood = <%=gi_b_blood%>
	var gi_o_blood = <%=gi_o_blood%>
	var gi_ab_blood = <%=gi_ab_blood%>
	var re_a_blood = <%=re_a_blood%>
	var re_b_blood = <%=re_b_blood%>
	var re_o_blood = <%=re_o_blood%>
	var re_ab_blood = <%=re_ab_blood%>
	
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawVisualization);
		google.charts.setOnLoadCallback(drawVisualization1);

		function drawVisualization() { 
			var data = google.visualization.arrayToDataTable([
					['Blood',  'A형', 'B형', 'O형', 'AB형'],
					['신청 가능 수량',  gi_a_blood,    gi_b_blood,     gi_o_blood,    gi_ab_blood],
					['요청 지급 수량',  re_a_blood,    re_b_blood,     re_o_blood,    re_ab_blood],
					['혈액형별 \n기부 혈액 비율\n(단위 : %)', gi_a_blood/gi_blood*100, gi_b_blood/gi_blood*100, gi_o_blood/gi_blood*100, gi_ab_blood/gi_blood*100],
					['혈액형별 \n요청 혈액 비율\n(단위 : %)', re_a_blood/re_blood*100, re_b_blood/re_blood*100, re_o_blood/re_blood*100, re_ab_blood/re_blood*100]
				]);
			var options = {
					title : '혈액 통계 리스트',
// 					vAxis: {title: 'Cups'},
// 					hAxis: {title: 'Month'}, 
					seriesType: 'bars',
// 					series: {5: {type: 'line'}}
				};
			
			var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
			chart.draw(data, options);
		}
	</script>



	<div id="chart_div" style="width:900px; height: 500px;"></div>

</body>
</html>