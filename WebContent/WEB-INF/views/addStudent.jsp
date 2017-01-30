<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Student Info</title>
	</head>
	<body>
		<h2>Add Student Data</h2>
		<h2><a href="index.html">Back To Main Menu</a></h2>
		<form:form method="POST" action="/OgrKayit/save.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">Student ID:</form:label></td>
			        <td><form:input path="id" value="${student.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Student Name:</form:label></td>
			        <td><form:input path="name" value="${student.name}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="surname">Student Surname:</form:label></td>
			        <td><form:input path="surname" value="${student.surname}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="department">Student Department:</form:label></td>
			        <td><form:input path="department" value="${student.department}"/></td>
			    </tr>
			    
		        <tr>
			        <td><form:label path="telephone">Student Telephone:</form:label></td>
			        <td><form:input path="telephone" value="${student.telephone}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="address">Student Address:</form:label></td>
                    <td><form:input path="address" value="${student.address}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty students}">
		<h2>List Students</h2>
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Surname</th>
			<th>Student Department</th>
		    <th>Student Telephone</th>
			<th>Student Address</th>
			<th>Edit/Delete</th>
		</tr>

		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.name}"/></td>
				<td><c:out value="${student.surname}"/></td>
				<td><c:out value="${student.department}"/></td>
				<td><c:out value="${student.telephone}"/></td>
				<td><c:out value="${student.address}"/></td>
				<td align="center"><a href="edit.html?id=${student.id}">Edit</a> | <a href="delete.html?id=${student.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	</body>
</html>
