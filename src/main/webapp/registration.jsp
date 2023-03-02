<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Registration Page</title>
    <link rel="stylesheet" href="css/form-style.css">
</head>
<body>
<div class="grandParentContainer">
    <div class="parentContainer">
        <h2>Registration</h2>
        <form class="loginForm" method="post" action="<c:url value="<%=ApplicationConstant.REGISTRATION_CONTROLLER %>"/> ">
            <input name="<%=JspConstant.LOGIN_LABEL%>" placeholder="Login">
            <input name="<%=JspConstant.NAME_LABEL%>" placeholder="Name">
            <input type="password" name="<%=JspConstant.PASSWORD_LABEL%>" placeholder="Password">
            <input type="email" name="<%=JspConstant.EMAIL_LABEL%>" placeholder="E-mail">
            <input type="submit" value="Registration">
        </form>
        <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
        </c:if>
    </div>
</div>
</body>
</html>
