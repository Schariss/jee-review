<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: alilo
  Date: 10/8/2022
  Time: 03:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Login Page</title>
</head>
<body>
    <h1>Login JSP</h1>
    <h2><%= new Date() %></h2>

    <%
        String usernameP = request.getParameter("username");
        String passwordP = request.getParameter("username");
        if(request.getMethod().equals("POST") && usernameP.equals("Adnane") && passwordP.equals("Adnane")){
    %>
    <h1>Welcome <%= usernameP%></h1>
    <% } else {  %>
    <form method="post">
        <input type="text" name="username" placeholder="Username" value="<%= usernameP==null?"":usernameP%>">
        <input type="password" name="password" placeholder="Password" value="<%= passwordP==null?"":passwordP%>">
        <input type="submit" value="Sign in">
    </form>
    <% } %>
</body>
</html>
