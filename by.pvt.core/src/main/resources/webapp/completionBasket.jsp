<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="by.pvt.core.*"%>
<%@ page import ="java.util.*"%>

<html>
<body>
<div>
<tr>ваш ID:</tr>
<c:out value ="${userId}"/>
<c:out value ="${user.name}"/>
</div>

<c:out value ="${basket}"/>


<br>
<br>
<c:out value ="${allorder}"/>

<br>
<br>
<tr>Статусы сформированных заказов</tr>
<c:out value ="${statusOrder}"/>
<br>
<br>
<tr>Общая сумма заказа</tr>
<c:out value ="${price}"/>
<form name="Form"
      method="get"
      action="http://localhost:8080/basketServlet">
        <input type=submit value="оплатить заказ">

</form>



</form>
<form name="Form"
      method="post"
      action="http://localhost:8080/adminS">

        <input type=submit value="меню товара">

</form>

<c:out value ="${allBasket}"/>


</body>
</html>