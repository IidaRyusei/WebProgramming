<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=login.css>
<link rel="stylesheet" href="style.css">
<style type="text/css">

</style>
</head>
<body>


	<!-- header -->
	<header>
	<h2 class="center2">${userInfo.name}さん</h2>
	<div class="right">
	<a href="Logout">ログアウト</a>
	</div>
	</header>
	<!-- /header -->
	<h1 class="center2">ユーザ情報詳細参照</h1>
	<br>
	<br>
	<h3 style="
    display: inline-block;
    width: 20%;
"><span style="margin-left: 50px">ログインID:</span>
	</h3>
	<h2 style="
    display: inline-block;
    width: 59%;
">
	<div class="center2">${syousai.login_id}</div>
	</h2>

<br>


<h3 style="
    display: inline-block;
    width: 20%;
"><span style="margin-left: 50px">ユーザ名:</span>
	</h3>
	<h2 style="
    display: inline-block;
    width: 59%;
">
	<div class="center2">${syousai.name}</div>
	</h2>

<br>


<h3 style="
    display: inline-block;
    width: 20%;
"><span style="margin-left: 50px">生年月日:</span>
	</h3>
	<h2 style="
    display: inline-block;
    width: 59%;
">
	<div class="center2">${syousai.birth_date}</div>
	</h2>

<br>


<h3 style="
    display: inline-block;
    width: 20%;
"><span style="margin-left: 50px">登録日時:</span>
	</h3>
	<h2 style="
    display: inline-block;
    width: 59%;
">
	<div class="center2">${syousai.create_date}</div>
	</h2>


<br>

<h3 style="
    display: inline-block;
    width: 20%;
"><span style="margin-left: 50px">更新日時:</span>
	</h3>
	<h2 style="
    display: inline-block;
    width: 59%;
">
	<div class="center2">${syousai.update_date}</div>
	</h2>


</body>
</html>