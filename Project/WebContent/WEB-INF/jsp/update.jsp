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
input.height {
height: 50px;
}
</style>
</head>
<body>

	<header> <font color="white"><div class="center">${userInfo.name}</div></font>
	<div class="right">
		<font color="red"> <a href="/Example/Login"
			method="get">ログアウト</a></font>
	</div>
	</header>
	<div id="container"></div>
	<h1 class="center2">ユーザ情報更新</h1>

	<form action="/Example/Update" method="post">

<input type="hidden" name="id" value="${syousai.id}">

		<h3 style="display: inline-block; width: 20%;">
			<span style="margin-left: 50px">ログインID:</span>
		</h3>
		<h2 style="display: inline-block; width: 59%;">
			<div class="center2">
			<input type="text" name="loginId" value="${syousai.login_id}">
			</div>
		</h2>

		<br>





<h3 style="display: inline-block; width: 20%;">
			<span style="margin-left: 50px">パスワード:</span>
		</h3>
		<h2 style="display: inline-block; width: 59%;">
			<div class="center2">
				<input type="password" name="pass">
			</div>
		</h2>

		<br>




<h3 style="display: inline-block; width: 20%;">
			<span style="margin-left: 50px">パスワード(確認):</span>
		</h3>
		<h2 style="display: inline-block; width: 59%;">
			<div class="center2">
				<input type="text" name="passs">
			</div>
		</h2>

		<br>









		<h3 style="display: inline-block; width: 20%;">
			<span style="margin-left: 50px">ユーザ名:</span>
		</h3>
		<h2 style="display: inline-block; width: 59%;">
			<div class="center2">
				<input type="text" name="name" value="${syousai.name}" >
			</div>
		</h2>

		<br>




		<h3 style="display: inline-block; width: 20%;">
			<span style="margin-left: 50px">生年月日:</span>
		</h3>
		<h2 style="display: inline-block; width: 59%;">
			<div class="center2">
				<input type="date" name="birth" value="${syousai.birth_date}">
			</div>
		</h2>

		<br> <br> <br> <br>


		<div class="center2">
			<input class="update" type="submit" name="更新" value="更新">
		</div>
		</p>
	</form>
	<br>
	<c:if "${errMsg != null}">
	<font color="red">${errMsg}</font>
	</c:if>
	<br>
	<br>
	<font color="blue">戻る</font>
</body>
</html>