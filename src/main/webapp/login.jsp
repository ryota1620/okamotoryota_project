<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>ログイン</title>
</head>
<body>
	<h2>ログイン</h2>
	<form action="<%=request.getContextPath()%>/login" method="post">
		ユーザー名: <input name="username"><br> パスワード: <input
			type="password" name="password"><br>
		<button type="submit">ログイン</button>
	</form>
	<%
	String err = (String) request.getAttribute("error");
	if (err != null) {
	%>
	<p style="color: red;"><%=err%></p>
	<%
	}
	%>
</body>
</html>
