<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="form-style.css">
</head>
<body>
<jsp:include page="<%=JspConstant.MENU_JSP%>"/>
<h2>Hello ${user.name}!</h2>

<c:choose>
    <c:when test="${not empty orderItems}">
        <h2>Your order items: </h2>
        <c:forEach var="item" items="${orderItems}">
            <div class="cart-item-container">
                <img class="cart-img" src="img/${item.item.name}.jpg" alt="item">
                <h3 class="cart-text">You ordered ${item.quantity} ${item.item.name} by ${item.item.price} byn.
                    Amount is ${item.quantity*item.item.price} byn.</h3>
                <form method="post" action="<c:url value="<%=ApplicationConstant.CART_CONTROLLER%>"/>">
                    <input type="hidden" name="<%=JspConstant.CART_ACTION_PARAM%>" value="removeFromCart">
                    <input type="hidden" name="<%=JspConstant.FOOD_ID_PARAM%>" value="${item.item.id}">
                    <input type="hidden" name="<%=JspConstant.FOOD_TYPE_PARAM%>" value="${item.item.type}">
                    <input type="hidden" name="<%=JspConstant.FOOD_NAME_PARAM%>" value="${item.item.name}">
                    <input type="hidden" name="<%=JspConstant.FOOD_PRICE_PARAM%>" value="${item.item.price}">
                    <input type="hidden" name="<%=JspConstant.FOOD_QUANTITY_PARAM%>" value="${item.quantity}">
                    <input type="submit" value="Remove from Cart">
                </form>
            </div>
        </c:forEach>
        <div class="order-container">
            <form method="post" action="<c:url value="<%=ApplicationConstant.ORDER_CONTROLLER%>"/>">
                <input type="text" name="<%=JspConstant.ADDRESS_PARAM%>" placeholder="Delivery address" required>
                <input type="submit" value="Submit order">
            </form>
            <c:if test="${not empty message}">
                <h2 class="error">${message}</h2>
            </c:if>
        </div>

    </c:when>
    <c:otherwise>
        <h2>You haven't items in the order</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
