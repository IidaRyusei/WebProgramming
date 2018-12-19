<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel="stylesheet" href=login.css>
<title>Insert title here</title>

<style type="text/css">

fieldset.example {
margin: 0 0 20px;
padding: 0 20px 15px;
}

fieldset p {
margin-bottom: 1em;
}
fieldset input {
width: 200px;
}

/*文字の間隔*/
p.example1 { word-spacing: 5em; }
p.example2 { word-spacing: 1em; }
p.example3 { word-spacing: -0.2em; }
</style>
</head>
<body>

<div class="header">
<font color="white"><div class="center">${userInfo.name}</div></font>
<div class="right"><font color="red">
<a href="Logout">ログアウト</a></font></div>
</div>

<br><br>
<h1 class="center2">ユーザ新規登録</h1>
<br><br><br>
<form action="NewUser" method="post">

<div class="center2">ログインID<input type="text" name="loginId" value="${loginId}"></div>
<br><br>
<div class="center2">パスワード<input type="password" name="pass"></div>
<br><br>
<div class="center2">パスワード(確認)<input type="password" name="passs"></div>
<br><br>
<div class="center2">ユーザ名<input type="text" name="name" value="${name}"></div>
<br><br>
<div class="center2">生年月日<input type="text" name="birth" value="${birth}"></div>
<br><br>
<div class="center2"><input type="submit" value="登録" style="WIDTH: 200px; HEIGHT: 200px"></div>
</form>
<br>
<br>
<c: if${errMsg !=null }>
<font color="red">${errMsg}</font>
</c:>
<br>
<font color=blue>戻る</font>
</body>
</html>