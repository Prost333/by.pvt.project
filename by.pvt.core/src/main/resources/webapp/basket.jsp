<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="by.pvt.core.*"%>
<%@ page import ="java.util.*"%>


<html>
<body>
<div>
<tr>ваш ID:</tr>
<c:out value ="${userId}"/>
<br>
<br>
Добавлен в корзину:
<c:out value ="${good}"/>
<c:out value ="${order}"/>
</div>
<tr>
<form name="Form"
      method="get"
      action="http://localhost:8080/adminS">

        <tr>
            <td><B>колличество</B></td>
            <td><input type=textbox name="count" size="15" value=" "></td>
            <input type="hidden" id=${good.id} name="id" value=${good.id}>
            <input type="hidden" id=${userId} name="userId" value=${userId}>
        </tr>
        <input type=submit value="accord">

</form>
<form name="Form"
      method="post"
      action="http://localhost:8080/adminS">

        <input type=submit value="меню товара">

</form>

<br>

<form name="Form"
      method="post"
      action="http://localhost:8080/basketServlet">
        <input type=submit value="оформить заказ">
        <input type="hidden" id=${userId} name="userId" value=${userId}>
         <input type="hidden" id=${AllPrice} name="AllPrice" value=${AllPrice}>
         <input type="hidden" id=${order.cost} name="order1" value=${order.cost}>
</form>

</body>
</html>
