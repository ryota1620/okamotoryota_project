<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Product" %>
<%
  Product p = (Product)request.getAttribute("product");
%>
<html><head><title>削除確認</title></head><body>
<h2>商品削除の確認</h2>
<p>以下の商品を本当に削除しますか？</p>
<table border="1" cellpadding="4">
<tr><th>ID</th><td><%=p.getId()%></td></tr>
<tr><th>商品名</th><td><%=p.getName()%></td></tr>
</table>
<form action="<%=request.getContextPath()%>/product/delete" method="post">
  <input type="hidden" name="id" value="<%=p.getId()%>">
  <button>削除する</button>
  <a href="<%=request.getContextPath()%>/products">やめる</a>
</form>
</body></html>
