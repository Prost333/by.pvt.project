<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import ="by.pvt.core.*"%>
<%@ page import ="java.util.*"%>

<html>
<body>
<div>
<c:out value ="${list}"/>
</div>

<br>
<form name="Form"
method="get"
action="http://localhost:8080/goodreg">
<input type=submit value="List Product">
</br>
</form>
</html>
</body>