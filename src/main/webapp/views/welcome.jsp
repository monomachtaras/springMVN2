<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${xxx}

<form action="add" method="post">
<table>
<tr><td>Input login</td> <td><input type="text" name="login" required></td></tr>
<tr><td>Input mail</td> <td><input type="text" name="mail" required></td></tr>
 <tr><td>Input pass</td><td><input type="text" name="password" required></td></tr>
 <tr><td><input type="submit" ></td></tr>
</table>
</form>

</body>
</html>