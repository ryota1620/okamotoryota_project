<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,model.Category"%>
<html>
<head>
<title>商品登録</title>
</head>
<body>
	<h2>商品登録</h2>
	<form action="productRegister" method="post">
		商品名: <input type="text" name="name"><br> 価格: <input
			type="text" name="price"><br> 在庫数: <input type="text"
			name="stock"><br> カテゴリ: <select name="category">
			<%
			List<Category> categories = (List<Category>) request.getAttribute("categories");
			if (categories != null) {
				for (Category c : categories) {
			%>
			<option value="<%=c.getId()%>"><%=c.getName()%></option>
			<%
			}
			}
			%>
		</select><br> <input type="submit" value="登録">
	</form>

	<%
	if (request.getAttribute("error") != null) {
	%>
	<p style="color: red;"><%=request.getAttribute("error")%></p>
	<%
	}
	%>
</body>
</html>
