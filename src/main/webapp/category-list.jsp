<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ一覧</title>
</head>
<body>
	<h2>カテゴリ一覧</h2>
	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management", "root", "Ryon1620");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM categories");
	%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>カテゴリ名</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("category_name")%></td>
		</tr>
		<%
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (Exception e) {
		out.println("エラー: " + e.getMessage());
		}
		%>
	</table>
</body>
</html>
