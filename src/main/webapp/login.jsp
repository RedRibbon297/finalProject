<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h2>Login</h2>
<form method="post" action="<c:url value="<%=ApplicationConstant.LOGIN_CONTROLLER %>"/> ">
    <ul style="list-style: none">
        <li><input name="<%=JspConstant.LOGIN_LABEL%>>" placeholder="Login"></li>
        <br>
        <li><input type="password" name="<%=JspConstant.PASSWORD_LABEL%>>" placeholder="Password"></li>
    </ul>

    <input type="submit" value="Login">
</form>
</body>
</html>
