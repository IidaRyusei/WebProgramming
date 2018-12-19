<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=login.css>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="botton_link.css">
<style type="text/css">

</style>
</head>
<body link="#1111cc">

<!-- header -->
	<header>
	<h2 class="center2">${userInfo.name}さん</h2>
	<div class="right">
	<a href="Login">ログアウト</a>
	</div>
	</header>
	<!-- /header -->
	<h1 class="center2">ユーザ情報詳細参照</h1>
<br>
<br>
<p><h4>ログインID:${syousai.login_id}</p>
<p>を本当に削除してもよろしいでしょうか。</h4></p>
<br>
<br><br><br>

<form>
<div style="position:absolute;left:470px;">
  <button onClick="form.action='UserList' ;return true" style="width:100px;height:50px" >キャンセル</button>
  </div>
  <div style="position:absolute;left:900px;">
  <button name="id" value ="${syousai.id}" onClick="form.action='Delete2' ;return true" style="width:100px;height:50px">OK</button>
  </div>
</form>
</body>
</html>