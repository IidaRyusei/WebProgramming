<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link  rel="stylesheet" href=login.css>
<title>フォームのサンプル</title>
</head>
<body>
<c: if ${errMsg != null}>
<font color="red">${errMsg}</font>
</c:>

<h1 class="center">ログイン画面</h1>

<form action="Login" method="post">
<div class="center2">ログインID：<input type="text" name="name"><br>
<br>
パスワード：<input type="password" name="pass"><br>

<br>
<input type="submit" class="size" value="ログイン"></div>
</form>
</body>
</html>