<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
<h1>body</h1>
<br>
<br>
<form action="addCity2" method="post" enctype="multipart/form-data">
add city<input type="text" name="cityName">
add file<input type="file" name="file">
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/>
<input type="submit" value="go">
</form>
<br>
<br>
<!-- <a href="login">login</a><br> -->
<a href="toLoginPage">login</a><br>


<a href="http://localhost:8080/a/aaa">click for alter table</a><br>



<form action="addCustomer" method="post">
login<input type="text" name="login"><br>
password<input type="password" name="password"><br>
email<input type="text" name="eMail"><br>
<input type="submit">
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/>
</form>

<form action="addCity" method="post">
add city<input type="text" name="cityName">
<input type="submit">
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/>
</form>




<form action="connect" method="post">

<select name="bindCustomer"> 
<c:forEach items="${customers}" var="singleCustomer">
<option value="${singleCustomer.id}">${singleCustomer.eMail}</option>
</c:forEach>
 </select>
<select name="bindCity"> 
 <c:forEach items="${cities}" var="singleCity">
<option value="${singleCity.id}">${singleCity.cityName}</option>   
</c:forEach></select>
<input type="submit">
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/>
</form>


<sf:form action="sf" method="post" modelAttribute="emptyObj">
login<sf:input path="login"/><br>
  <sf:errors path="login"/>
password<sf:input path="password" type="password"/><br>
email<sf:input path="eMail"/><br>
city<sf:select path="city">

<c:forEach items="${cities}" var="city">
<sf:option value="${city.id}">${city.cityName}</sf:option></c:forEach>
</sf:select><br>
<input type="submit">
 </sf:form>

<br>
<a href="all"> all</a>

<form action="all" method="post">
all
<input type="submit">
<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}"/>

</form>




</body>
</html>