<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="form-style.css">
</head>
<body>
    <jsp:include page="<%=JspConstant.MENU_JSP%>"/>
    <h2>Hello ${user.name}!</h2>
    <c:choose>
           <c:when test="${not empty ordersList}">
               <h2>Your orders:</h2>
               <c:forEach var="order" items="${ordersList}">
                   <div class="order-list-container">
                       <h3>${order.date} you ordered delivery to ${order.address}. Order id is ${order.id}.</h3>
                       <form method="post" action="<c:url value="<%=ApplicationConstant.PRINT_ORDER_CONTROLLER%>"/>">
                           <input type="hidden" name="<%=JspConstant.ORDER_ID_ATTR%>" value="${order.id}">
                           <input type="submit" value="Print receipt">
                       </form>
                       <form method="post" action="<c:url value="<%=ApplicationConstant.REMOVE_ORDER_CONTROLLER%>"/>">
                           <input type="hidden" name="<%=JspConstant.ORDER_ID_ATTR%>" value="${order.id}">
                           <input type="submit" value="Remove order">
                       </form>
                   </div>
               </c:forEach>
           </c:when>
        <c:otherwise>
            <h3>You haven't orders at present</h3>
        </c:otherwise>
    </c:choose>

</body>
</html>
