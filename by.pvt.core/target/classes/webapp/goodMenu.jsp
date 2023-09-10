<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="by.pvt.core.*"%>
<%@ page import ="java.util.*"%>

<html>
<body>

<form name="Form"
method="post"
action="http://localhost:8080/adminS">
<input type=submit value="List Product">
</br>
</form>


<br>
<table>
<c:forEach var="good" items="${Goods}">
<tr>
<td>id:${good.id}</td>
</tr>
<tr>
<td>Name:${good.name}</td>
</tr>
<tr>
<td>type:${good.type}</td>
</tr>
<tr>
<td>price:${good.price}</td>
</tr>
<tr>
<td>code:${good.code}</td>
</tr>
<tr>
<td> <form name="Form"
     method="get"
     action="http://localhost:8080/adminS">
     <input type=submit value="buy">
     <input type="hidden" id=${good.id} name="id" value=${good.id}>
     </br>
     </form> </td>
</tr>

<tr>
<td>  </td>
</tr>
</c:forEach>
</table>

<form name="Form"
method="get"
action="http://localhost:8080/completionBasket.jsp">
<input type=submit value="Basket">
</br>
</form>

</html>
</body>