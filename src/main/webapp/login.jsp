<%--
  Created by IntelliJ IDEA.
  User: alilo
  Date: 10/8/2022
  Time: 03:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
    <h1>Login Screen</h1>
    <form method="post" action="login">
        <input type="text" name="username" placeholder="Username" value="${username}" autofocus>
        <input type="password" name="password" placeholder="Password" value="${password}">
        <input type="submit" value="Sign in"><br>
        <div class="errorMessage">${errorMessage}</div>
    </form>
</body>
</html>
