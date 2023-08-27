
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="by.pvt.core.*"%>
<%@ page import ="java.util.*"%>

<html>
<body>




<form name="Form"
      method="post"
      action="http://localhost:8080/goodreg">
    <tаble>

        <tr>
            <td><B>Name</B></td>
            <td><input type=textbox name="Name" size="25" value=" "></td>
        </tr>
        <br>
        <tr>
            <td><B>Type</B></td>
            <td><input type=textbox name="type" size="25" value=" "></td>
        </tr>
        <br>
         <tr>
            <td><B>Price</B></td>
            <td><input type=textbox name="price" size="25" value=" "></td>
         </tr>

    </tаble>
<br>
    <input type=submit value="Registration">
</form>

<p>Просмотор товара</p>

<form name="Form"
      method="get"
      action="http://localhost:8080/goodreg">
    <input type=submit value="show good list">

</form>
 <p>Меню товаров </p>
<br>
<form name="Form"
action="http://localhost:8080/goodMenu.jsp">
<input type=submit value="Good menu">
</br>
</form>
<form name="Form"
      method="post"
      action="http://localhost:8080/goodreg">
    <tаble>
        <tr>
            <td><B>id</B></td>
            <td><input type=textbox name="id" size="25" value=" "></td>
        </tr>
        <input type=submit value="remove good">
    </table>
</form>
<br>
<p>Выберите id товара который хотите изменить</p>
</form>
<form name="Form"
      method="get"
      action="http://localhost:8080/goodreg">
    <tаble>
        <tr>
            <td><B>id</B></td>
            <td><input type=textbox name="change_id" size="25" value=" "></td>
        </tr>
        <tr>
                    <td><B>name</B></td>
                    <td><input type=textbox name="change_name" size="25" value=" "></td>
        </tr>
        <tr>
                     <td><B>type</B></td>
                     <td><input type=textbox name="change_type" size="25" value=" "></td>
        </tr>
        <tr>
                             <td><B>price</B></td>
                             <td><input type=textbox name="change_price" size="10" value=" "></td>
        </tr>
        <input type=submit value=" change good">
    </table>
</form>
<p>Все зарегистрированные пользователи</p>
<div>
<c:out value ="${allUsers}"/>
</div>
<form name="Form"
method="post"
action="http://localhost:8080/goodreg">
<input type=submit value="List Product">
</br>
</form>
</body>
</html>