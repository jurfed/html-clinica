<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/clinic/edit" method="POST">
	<input type="hidden" name="oldClient" value="${client}">
	<table>
		<tr>
			<td align="right" >Old client name : </td>
			<td>
				<input type="text" name="oldName" value="${client.id}">
			</td>

			<td align="right" >Old pet name : </td>
			<td>
				<input type="text" name="oldPetName" value="${client.pet.name}">
			</td>

		</tr>
		<tr>
			<td align="right" >New client name :</td>
			<td>
				<input type="text" name="newName" value=" ">
			</td>

			<td align="right" >New pet name : </td>
			<td>
				<input type="text" name="newPetName" value=" ">
			</td>

		</tr>
		<tr>
			<td><input type="submit" align="center" value="Submit"/></td>
		</tr>
	</table>
</form>
</body>
</html>