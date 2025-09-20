<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.User" %>
<%
    HttpSession currentSession = request.getSession(false);
    User user = (currentSession != null) ? (User) currentSession.getAttribute("user") : null;

    if (user == null) {
        request.setAttribute("error", "ログインしてください。");
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request, response);
        return;
    }
%>
<html>
<head><title>ホーム</title></head>
<body>
    <h2>ようこそ、<%= user.getUsername() %>さん</h2>
    <a href="LogoutServlet">ログアウト</a>
</body>
</html>
