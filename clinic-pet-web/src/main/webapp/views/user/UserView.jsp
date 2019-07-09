<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
    <style><%@include file="/css/myStyle.css"%></style>
</head>

<body>
<a href="${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp">Добавить пользователя</a>
<table border="1"> <%--Тег <tr> служит контейнером для создания строки таблицы. Каждая ячейка в пределах такой строки может задаваться с помощью тега <th> или <td>.--%>
    <tr>
        <td>Логин Email</td>
        <td>Действия</td>
        <td>Идентификатор</td>
        <td>Сообщения</td>
    </tr>
    <c:forEach items="${users}" var="myUser" varStatus="status"> <%--users - атрибут в реквесте  см. UserViewServlet.java--%>
        <tr valign="top">
            <td>${myUser.login} ${myUser.email} ${myUser.role.name}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/user/edit?id=${myUser.id}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/user/delete?id=${myUser.id}">Удалить</a>
            </td>

            <td>
                <c:out value="${myUser.id}"/>
            </td>

            <td>
                <a href="${pageContext.servletContext.contextPath}/user/addMessage?id=${myUser.id}">Добавить Сообщение</a>
                <c:forEach items="${myUser.messages}" var="message" varStatus="status">
                    <br> ${message.text}
                </c:forEach>
            </td>

        </tr>
    </c:forEach>
</table>


</body>
</html>