<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html><head><title>エラー</title></head><body>
<h2>エラーが発生しました</h2>
<p style="color:red;"><%= request.getAttribute("error") %></p>
<p><a href="<%=request.getContextPath()%>/products">商品一覧へ</a></p>
</body></html>
