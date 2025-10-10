<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>商品登録</title>
</head>
<body>
	<h2>商品登録</h2>
	<form action="<%=request.getContextPath()%>/product/register"
		method="post">
		商品名: <input name="name"><br> 価格: <input name="price"
			value="0"><br> 在庫: <input name="stock" value="0"><br>
		カテゴリID: <input name="categoryId" value="1"><br>
		<button type="submit">登録</button>
	</form>
	<%
	String err = (String) request.getAttribute("error");
	if (err != null) {
	%>
	<p style="color: red;"><%=err%></p>
	<%
	}
	%>
	<p>
		<a href="<%=request.getContextPath()%>/products">一覧へ戻る</a>
	</p>
</body>
</html>
