<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*, studyonline.javafiles.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students List</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Study online University</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input onclick="window.location.href='add-student.jsp'"
				class="add-student-button" type="button" value="Add Student" />
			<table border="1">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Department</th>
						<th>Registration Number</th>
						<th>Email</th>
						<th>Grade</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<!-- display all the students here -->

					<c:forEach var="student" items="${STUDENTS_LIST}">
						<c:url var="updateLink" value="StudentControllerServlet">
							<c:param name="action" value="LOAD" />
							<c:param name="studentId" value="${student.id }" />
						</c:url>
						<c:url var="deleteLink" value="StudentControllerServlet">
							<c:param name="action" value="DELETE" />
							<c:param name="studentId" value="${student.id }" />
						</c:url>
						<tr>
							<td>${student.firstName }</td>
							<td>${student.lastName }</td>
							<td>${student.age }</td>
							<td>${student.department }</td>
							<td>${student.reg_no }</td>
							<td>${student.email }</td>
							<td>${student.grade }</td>
							<td><a href="${updateLink }">Update</a>
								| <a href="${deleteLink }">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>