<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ登録</title>
</head>
<body>
	<h2>カテゴリ登録フォーム</h2>
	<form action="register" method="post">
		カテゴリID: <input type="number" name="id" required /><br /> カテゴリ名: <input
			type="text" name="name" required /><br /> <input type="submit"
			value="登録" />
	</form>
</body>
</html>