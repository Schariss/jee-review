<%--
  Created by IntelliJ IDEA.
  User: alilo
  Date: 10/8/2022
  Time: 05:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <%
        Boolean isConnected = (Boolean) session.getAttribute("isConnected");
        if (isConnected == null || isConnected == Boolean.FALSE) {
    %>
    <h2>You are not logged in</h2>
    <a href="login">Click here to sign in</a>
    <% }else { %>
    <h1 style="text-align: center;">Welcome ${username}</h1>
    <h3 style="text-align: center;">Your are successfully logged in</h3>
    <% }%>
</body>
</html>
