<%@ page import="by.mysite.constants.ApplicationConstant" %>
<%@ page import="by.mysite.constants.JspConstant" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="form-style.css">
</head>
<body>
<jsp:include page="<%=JspConstant.MENU_JSP%>"/>
<h2>Hello ${user.name}!</h2>
<h1>Some content</h1>
<c:if test="${not empty pizzas}">
    <h2>Today we propose next Pizzas</h2>
    <c:forEach var="pizza" items="${pizzas}">
        <div class="food-item-box">
            <img class="small-image" src="img/${pizza.name}.jpg" alt="Pizza">
            <p>Name: ${pizza.name}</p>
            <p>Price: ${pizza.price} byn</p>
            <form method="post" action="<c:url value="<%=ApplicationConstant.CART_CONTROLLER%>"/>">
                <input type="hidden" name="<%=JspConstant.CART_ACTION_PARAM%>" value="addToCart">
                <input type="hidden" name="<%=JspConstant.FOOD_ID_PARAM%>" value="${pizza.id}">
                <input type="hidden" name="<%=JspConstant.FOOD_TYPE_PARAM%>" value="1">
                <input type="hidden" name="<%=JspConstant.FOOD_NAME_PARAM%>" value="${pizza.name}">
                <input type="hidden" name="<%=JspConstant.FOOD_PRICE_PARAM%>" value="${pizza.price}">

                <input type="number" name="<%=JspConstant.FOOD_QUANTITY_PARAM%>">

                <input type="submit" value="Add to Cart">
            </form>
        </div>
    </c:forEach>
</c:if>

<c:if test="${not empty drinks}">
    <h2>Today we propose next Drinks</h2>
    <c:forEach var="drink" items="${drinks}">
        <div class="food-item-box">
            <img class="small-image" src="img/${drink.name}.jpg" alt="Drink">
            <p>Name: ${drink.name}</p>
            <p>Price: ${drink.price} byn</p>
            <form method="post" action="<c:url value="<%=ApplicationConstant.CART_CONTROLLER%>"/>">
                <input type="hidden" name="<%=JspConstant.CART_ACTION_PARAM%>" value="addToCart">
                <input type="hidden" name="<%=JspConstant.FOOD_ID_PARAM%>" value="${drink.id}">
                <input type="hidden" name="<%=JspConstant.FOOD_TYPE_PARAM%>" value="2">
                <input type="hidden" name="<%=JspConstant.FOOD_NAME_PARAM%>" value="${drink.name}">
                <input type="hidden" name="<%=JspConstant.FOOD_PRICE_PARAM%>" value="${drink.price}">

                <input type="number" name="<%=JspConstant.FOOD_QUANTITY_PARAM%>">

                <input type="submit" value="Add to Cart">
            </form>
        </div>
    </c:forEach>
</c:if>

</body>
</html>
