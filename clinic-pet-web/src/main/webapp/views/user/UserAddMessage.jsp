<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/addMessage" method="POST">
	<input type="hidden" name="id" value="${user.id}">
	<table>
		<tr>
			<td align="right" >Message: </td>
			<td>
				<input type="text" name="message">
			</td>
		</tr>

		<tr>
			<td><input type="submit" align="center" value="Submit"/></td>
		</tr>
	</table>
</form>
</body>
</html>