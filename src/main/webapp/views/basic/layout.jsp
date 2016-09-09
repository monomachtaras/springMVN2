<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">  <%@include file="css/layout.css" %></style>

 
<title>Insert title here</title>
</head>
<body>
<div class="header"><tiles:insertAttribute name="header"></tiles:insertAttribute></div>
<div class="body"><tiles:insertAttribute name="body"></tiles:insertAttribute></div>
<div id="footer"><tiles:insertAttribute name="footer"></tiles:insertAttribute></div>
</body>
</html>