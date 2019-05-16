<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/clinic/create" method="POST">
    <table>
        <tr>
            <td align="right" >Имя клиента : </td>
            <td>
                <input type="text" name="clientName">
            </td>
        </tr>
        <tr>
            <td align="right" >Имя питомца : </td>
            <td>
                <input type="text" name="petName">
            </td>
        </tr>
    </table>

        <h3> Выберите класс питомца</h3>

    <p><input name="petType" type="radio" value="dog"> Собака</p>
    <p><input name="petType" type="radio" value="cat"> Кошка</p>

    <tr>
        <td><input type="submit" align="center" value="Submit"/></td>
    </tr>
</form>
</body>
</html>
