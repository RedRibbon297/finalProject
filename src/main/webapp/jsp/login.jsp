<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="/css/form-style.css">
</head>
<body>
<jsp:include page="<%=JspConstant.MENU_JSP%>"/>
<img class="default-image" src="/img/pizza1.jpg" alt="pizza1">
<div class = "form-box">
    <h2>Login</h2>
    <form method="post" action="<c:url value="<%=ApplicationConstant.LOGIN_CONTROLLER %>"/> ">
        <input name="<%=JspConstant.LOGIN_LABEL%>" placeholder="Login">
        <input type="password" name="<%=JspConstant.PASSWORD_LABEL%>" placeholder="Password">
        <input type="submit" value="Login">
    </form>
    <c:if test="${not empty message}">
        <h2 class="error">${message}</h2>
    </c:if>
</div>
</body>
</html>
