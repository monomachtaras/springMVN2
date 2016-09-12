<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">  <%@include file="css/layout.css" %></style>
<title>Insert title here</title>
</head>
<body>
<div >
<div id="first">sf</div><div id="first">sf</div><div id="first">sf</div>

</div>
<div id="sec">
<ul id="menu">
    <li><a href="/">Home</a></li>
    <li><a href="#">Categories</a>
        <ul>
            <li><a href="#">A</a></li>
            <li><a href="#">B</a></li>
            <li><a href="#">C</a></li>
            <li><a href="/allCoordinates">All Coordinates</a></li>
        </ul>
    </li>
    <li><a href="#">Work</a>
        <ul>
            <li><a href="#">good</a></li>
            <li><a href="#">nice</a></li>
            <li><a href="#">excelent</a></li>
            <li><a href="#">best</a></li>
        </ul>
    
    </li>
    <li><a href="#">About</a></li>
    <li><a href="#">Contact</a></li>
</ul>

</div>



<security:authorize access="isAuthenticated()">
<form action="logout" method="post">
 <input type="submit">
 <input type="hidden"
			name="${_csrf.parameterName}"
			value="${_csrf.token}"/> 

 </form>
</security:authorize>
</body>
</html>