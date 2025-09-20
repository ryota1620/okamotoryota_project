<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>ログイン</title></head>
<body>
    <h2>ログイン画面</h2>
    <form action="LoginServlet" method="post">
        ユーザー名：<input type="text" name="username"><br>
        パスワード：<input type="password" name="password"><br>
        <input type="submit" value="ログイン">
    </form>
    <p style="color:red;"><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %></p>
</body>
</html>
