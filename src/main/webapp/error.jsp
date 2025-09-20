<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>エラー</title></head>
<body>
    <h3 style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "不明なエラーが発生しました。" %></h3>
    <a href="login.jsp">ログイン画面へ</a>
</body>
</html>
