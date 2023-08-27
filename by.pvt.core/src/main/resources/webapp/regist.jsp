
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<body>
<c:out value ="${user.name}"/>

<br>
<br>
<form name="Form"
      method="post"
      action="http://localhost:8080/user">
    <tаble>

        <tr>
            <td><B>Name</B></td>
            <td><input type=textbox name="Name" size="25" value=" "></td>
        </tr>
        <tr>
            <td><B>Surname</B></td>
            <td><input type=textbox name="Surname" size="25" value=" "></td>
        </tr>
         <tr>
            <td><B>Login</B></td>
            <td><input type=textbox name="Login" size="25" value=" "></td>
         </tr>
         <tr>
             <td><B>Password</B></td>
             <td><input type=textbox name="Password" size="25" value=" "></td>
         </tr>


    </tаble>

    <input type=submit value="Submit">
</form>

   <form name="Form"
          method="post"
          action="http://localhost:8080/aut.jsp">

    <input type=submit value="aut">
    <br>
    <br>
    <br>
    </form>


</body>
