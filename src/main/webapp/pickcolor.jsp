<%--
  Created by IntelliJ IDEA.
  User: donpho
  Date: 8/21/18
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick a Color</title>
</head>
<body>

    <form action="pickcolor" method="post">
        <input type="radio" name="color" value="blue" checked> Blue <br>
        <input type="radio" name="color" value="red"> Red <br>
        <input type="radio" name="color" value="violet"> Green <br>
        <input type="radio" name="color" value="yellow"> Yellow <br>
        <input type="radio" name="color" value="pink"> Pink <br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
