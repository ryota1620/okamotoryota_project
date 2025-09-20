<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,model.Product" %>
<html>
<head><title>商品一覧</title></head>
<body>
    <h2>商品一覧</h2>
    <a href="productRegister">商品登録</a>
    <table border="1">
        <tr><th>ID</th><th>商品名</th><th>価格</th><th>在庫</th><th>カテゴリID</th></tr>
        <%
            List<Product> list = (List<Product>)request.getAttribute("products");
            if (list != null) {
                for (Product p : list) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
            <td><%= p.getStock() %></td>
            <td><%= p.getCategoryId() %></td>
        </tr>
        <%      }
            }
        %>
    </table>
</body>
</html>
