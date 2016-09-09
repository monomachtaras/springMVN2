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



<div class="header1" >
   <div class="header2" >
      <div class="header4">  ПН-ПТ 10-20 <br> СБ-НД  10-19 </div>
      <div class="header5">про нас</div>
      <div class="header6">дизайнерам</div>
      <div class="header7">тканини</div>
      <div class="header8">оплата</div>
      <div class="header9">контакти</div>
      <div class="header10">ru</div>
   </div>
   <div class="header3" >
      <div class="header11">sell goods</div>
      <div class="header12">beds</div>
      <div class="header13">chairs</div>
      <div class="header14">4</div>
      <div class="header15">5</div>
      <div class="header16">6</div>
   </div>

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