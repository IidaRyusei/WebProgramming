<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<link  rel="stylesheet" href=login.css>
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>


<header>
<font color="white"><div class="center2">${userInfo.name}</div></font>
<div class="right"><font color="red">
<a href="Logout" method="get">ログアウト</a></font></div>
</header>
<div id="container"></div>
<br>
<br>
<h1 class="center2">ユーザ一覧</h1>

<div class="right"><font color="#0000FF">
<a href="NewUser" method="get">新規登録</a></font></div>

<form action="UserSearch" method="post">

<div class="center2">ログインID<input type="text" name="loginId"></div>
<br>
<div class="center2">ユーザー名<input type="text" name="name"></div>
<br>
<div class="center2">生年月日<input type="date" name="date">〜<input type="date" name="date2"></div>
<br>
<div class="right"><input type="submit" value="検索" style="WIDTH: 200px; HEIGHT: 200px"></div>

<br>
<br>
<c:if test="${err != null}">
${err}
</c:if>
<hr>
<br>

<table class="table table-bordered" align="center" width="80%" border="5" bordercolor="#ff0000">
  <thead>
    <tr>
      <th>ログインID</th>
      <th>ユーザ名</th>
      <th>生年月日</th>
      <th></th>
    </tr>
  </thead>
  <tbody>

<c:if test="${userInfo.name =='管理者'}">

<c:forEach var="user" items="${userList}">
    <tr>
    <td scope="col">${user.login_id}</td>
    <td scope="col">${user.name}</td>
    <td scope="col">${user.birth_date}</td>
    <td>
    <a href="Syousai?id=${user.id}" method="get">詳細</a>
    <a href="Update?id=${user.id}" method="get">更新</a>
    <a href="Delete?id=${user.id}" method="get">削除</a>
    </td>
    </tr>
 </c:forEach>
</c:if>

<c:if test="${userInfo.name !='管理者'}">
<c:forEach var="user" items="${userList}">
    <tr>
    <td scope="col">${user.login_id}</td>
    <td scope="col">${user.name}</td>
    <td scope="col">${user.birth_date}</td>
    <td>

    <a href="Syousai?id=${user.id}" method="get">詳細</a>
    <c:if test="${userInfo.name ==user.name}">
    <a href="Update?id=${user.id}" method="get">更新</a>
    </c:if>
    </td>
    </tr>
    </c:forEach>
</c:if>
  </tbody>
</table>
</form>
</body>
</html>