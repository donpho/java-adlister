<%--
  Created by IntelliJ IDEA.
  User: donpho
  Date: 8/20/18
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if(request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equalsIgnoreCase("admin") && password.equals("password")){
            response.sendRedirect("profile.jsp");
        }
    }
%>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login.jsp" method="post">
    Username:<br>
    <input type="text" name="username">
    <br>
    Password:<br>
    <input type="password" name="password">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
