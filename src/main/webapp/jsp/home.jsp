<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="../css/form-style.css">
</head>
<body>
<jsp:include page="<%=JspConstant.MENU_JSP%>"/>
<h2>User Info</h2>
<p>id ${user.id}</p>
<p>login ${user.login}</p>
<p>name ${user.name}</p>
<p>email ${user.email}</p>

<p>
    <a href="<c:url value="<%= ApplicationConstant.LOGOUT_CONTROLLER%>"/>">Logout</a>
</p>
</body>
</html>
