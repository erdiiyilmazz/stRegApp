<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Students Table</title>
</head>
<body>
<h1>List of Students</h1>
<h3><a href="add.html">Add More Students</a></h3>
<h3><a href="index.html">Back To Main Menu</a></h3>
<h3><a href="download/xls.html">Download Excel File</a></h3>
<c:if test="${!empty students}">
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Surname</th>
			<th>Student Department</th>
			<th>Student Telephone</th>
			<th>Student Address</th>
		</tr>

		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.name}"/></td>
				<td><c:out value="${student.surname}"/></td>
				<td><c:out value="${student.department}"/></td>
				<td><c:out value="${student.telephone}"/></td>
				<td><c:out value="${student.address}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>