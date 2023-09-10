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

<c:out value ="${orderclient}"/>

<br>
<br>

<form name="Form"
      method="post"
      action="http://localhost:8080/DeleteOrder">
    <tаble>
        <tr>
            <td><B>id</B></td>
            <td><input type=textbox name="orderbyid" size="25" value=" "></td>
              <input type="hidden" id=${userId} name="userId" value=${userId}>
        </tr>
        <input type=submit value="удалить заказ">
    </table>
</form>
<br>
<br>
<tr>Статусы сформированных заказов</tr>
<c:out value ="${statusOrder}"/>
<br>
<br>
<form name="Form"
      method="get"
      action="http://localhost:8080/basketServlet">
        <input type=submit value="оплатить заказ">
        <input type="hidden" id=${userId} name="userId" value=${userId}>

</form>



</form>
<form name="Form"
      method="post"
      action="http://localhost:8080/adminS">

        <input type=submit value="меню товара">

</form>

<c:out value ="${orderclient1}"/>

<form name="Form"
      method="get"
      action="http://localhost:8080/basketServletFinish">
        <input type=submit value="статус заказов">
<input type="hidden" id=${userId} name="userId" value=${userId}>

</form>
<c:out value ="${orderclientAll}"/>
<form name="Form"
      method="post"
      action="http://localhost:8080/basketServletFinish">
        <input type=submit value="полный список заказов">
<input type="hidden" id=${userId} name="userId" value=${userId}>
</form>


</body>
</html>