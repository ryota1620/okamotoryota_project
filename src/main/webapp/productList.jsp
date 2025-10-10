<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*,model.Product" %>
<html><head><title>商品一覧</title></head><body>
<h2>商品一覧</h2>
<a href="<%=request.getContextPath()%>/product/register">新規登録</a>
<form action="<%=request.getContextPath()%>/logout" method="post" style="display:inline">
  <button>ログアウト</button>
</form>
<% String flash=(String)session.getAttribute("flash"); if(flash!=null){ %>
  <p style="color:green;"><%=flash%></p>
  <% session.removeAttribute("flash"); %>
<% } %>
<% String err=request.getParameter("error"); if(err!=null){ %>
  <p style="color:red;"><%=err%></p>
<% } %>
<table border="1" cellpadding="4">
<tr><th>ID</th><th>商品名</th><th>価格</th><th>在庫</th><th>カテゴリID</th><th>操作</th></tr>
<% for(Object o : (List)request.getAttribute("list")){ Product p=(Product)o; %>
<tr>
  <td><%=p.getId()%></td>
  <td><%=p.getName()%></td>
  <td><%=p.getPrice()%></td>
  <td><%=p.getStock()%></td>
  <td><%=p.getCategoryId()%></td>
  <td>
    <form action="<%=request.getContextPath()%>/product/delete" method="get" style="display:inline">
      <input type="hidden" name="id" value="<%=p.getId()%>">
      <button>削除</button>
    </form>
  </td>
</tr>
<% } %>
</table>
</body></html>
