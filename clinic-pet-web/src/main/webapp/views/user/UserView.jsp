<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title></title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp">Добавить пользователя</a>
<table border="1">
	<tr>
		<td>Логин Email</td>
		<td>Действия</td>
		<td>Идентификатор</td>
	</tr>
	<c:forEach items="${users}" var="myUser" varStatus="status">
		<tr valign="top">
			<td>${myUser.login} ${myUser.email}</td>
			<td>
				<a href="${pageContext.servletContext.contextPath}/user/edit?id=${myUser.id}">Редактировать</a>
				<a href="${pageContext.servletContext.contextPath}/user/delete?id=${myUser.id}">Удалить</a>

			</td>
			<td>
				<c:out value="${myUser.id}"/>
			</td>
		</tr>
	</c:forEach>
</table>



</body>
</html>