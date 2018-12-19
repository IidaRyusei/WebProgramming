<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel="stylesheet" href=login.css>
<title>フォームのサンプル</title>
</head>
<body>
<h1 class="center">ログイン画面</h1>

<form action="/Example/Login" method="get">
<div class="center2">ログインID：<input type="text" name="name"><br>
<br>
パスワード：<input type="password" name="pass"><br>

<br>
<input type="submit" class="size" value="ログイン"></div>
</form>
</body>
</html>