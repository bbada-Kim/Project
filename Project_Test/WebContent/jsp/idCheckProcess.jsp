<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
	request.setCharacterEncoding("utf-8");
String chk_id = request.getParameter("idCheck");

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "select*from bloodMember where m_id=?";
try {
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/blood");
	conn = ds.getConnection();

	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, chk_id);
	rs = pstmt.executeQuery();
	if (rs.next()) { //아이디 사용불가
		response.sendRedirect("idCheck.jsp?chk_id=" + chk_id + "&useble=no");
	} else { //아이디 사용가능
		response.sendRedirect("idCheck.jsp?chk_id=" + chk_id + "&useble=yes");
	}
} catch (Exception e) {
	out.println("<h3>데이터베이스 연결에 문제가 발생했습니다.</h3>");
	e.printStackTrace();
} finally {
	try {
		if(rs!=null)
	rs.close();
		if (pstmt != null)
	pstmt.close();
		if (conn != null)
	conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>