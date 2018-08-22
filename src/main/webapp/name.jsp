<%--
  Created by IntelliJ IDEA.
  User: donpho
  Date: 8/21/18
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Name</title>
</head>
<body>
    <div>
        <h1>Please enter a name!</h1>
        <div>
            <form action="/name" method="post">
                <div>
                    <input id="name" name="name" type="text">
                </div>
                <div>
                    <input type="submit" value="Submit">
                </div>
            </form>
        </div>
    </div>


</body>
</html>
