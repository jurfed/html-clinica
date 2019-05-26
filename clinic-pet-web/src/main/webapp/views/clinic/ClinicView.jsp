<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <style><%@include file="/css/myStyle.css"%></style>
    <script type="text/javascript" src="../../js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript">

        function createUser() {
            var t=1;
            alert("Заполните поля!!!!!!!!!!!!!"+t);
        }

    </script>

</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/clinic/CreateClient.jsp">Добавить клиента</a>
<table border="1">
    <tr>
        <td>Клиент</td>
        <td>Питомец</td>
        <td>Класс питомца</td>
    </tr>
    <c:forEach items="${clients}" var="client" varStatus="status">
        <tr valign="top">
            <td>${client.id} </td>
            <td>${client.pet.name}
            <td>${client.petClass}
            <td>
                <a href="${pageContext.servletContext.contextPath}/clinic/edit?clientid=${client.id}">Редактировать</a>
            </td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/clinic/delete?clientName=${client.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<div style="text-align: right;">
    <input type="button" value="MESSAGE" onclick="return createUser();">
</div>

</body>
</html>