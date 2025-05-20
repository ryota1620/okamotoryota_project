<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>カテゴリリスト</title>
</head>
<body>
<h2>カテゴリリスト</h2>

<c:if test="${not empty errorMessage}">
    <p style="color:red">${errorMessage}</p>
</c:if>

<table border="1">
    <tr>
        <th>カテゴリID</th>
        <th>カテゴリ名</th>
    </tr>
    <c:forEach var="category" items="${categoryList}">
        <tr>
            <td>${category.categoryId}</td>
            <td>${category.categoryName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
