<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Receipt</title>
    <link rel="stylesheet" href="form-style.css">
</head>
<body>
<jsp:include page="<%=JspConstant.MENU_JSP%>"/>
<c:if test="${not empty orderReceipt}">
    <div class = "receipt-container">
        ${orderReceipt}
    </div>
</c:if>
</body>
</html>
