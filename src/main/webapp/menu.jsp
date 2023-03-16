<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<ul class="nav-ul">
    <c:choose>
        <c:when test="${empty user}">
            <li class="nav-li float-left">
                <a class="active" href="<c:url value="<%=JspConstant.INDEX_JSP%>"/>">Home</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%=JspConstant.LOGIN_JSP%>"/>">Log In</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%=JspConstant.REGISTRATION_JSP%>"/>">Register</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="nav-li float-left">
                <a class="active" href="<c:url value="<%=JspConstant.HOME_JSP%>"/>">Home</a>
            </li>
            <li class="nav-li float-left">
                <a href="<c:url value = "<%=ApplicationConstant.PIZZAS_MENU%>"/>">Pizza</a>
            </li>
            <li class="nav-li float-left">
                <a href="<c:url value = "<%=ApplicationConstant.DRINKS_MENU%>"/>">Drink</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%=ApplicationConstant.LOGOUT_CONTROLLER%>"/>">Log Out</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%=JspConstant.CART_JSP%>"/>">Cart</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%=ApplicationConstant.ORDERS_HISTORY_CONTROLLER%>"/>">Orders</a>
            </li>
        </c:otherwise>
    </c:choose>
</ul>
