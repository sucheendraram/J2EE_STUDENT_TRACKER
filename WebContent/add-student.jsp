<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a student here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-styles.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Study online University</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add a new Student</h3>
		<form action="StudentControllerServlet">
			<input type="hidden" name="action" value="ADD" />
			<table id="add-student-table" border="1">
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td><label>Age</label></td>
						<td><input type="number"  maxlength="100" name="age" /></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><input type="email" name="email" /></td>
					</tr>
					<tr>
						<td><label>Department</label></td>
						<td><input type="text" name="department" /></td>
					</tr>
					<tr>
						<td><label>Grade</label></td>
						<td><input type="text" name="grade" /></td>
					</tr>
					<tr>
						<td><label>Registration number</label></td>
						<td><input type="text" name="regNo" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Add Student" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<a href="StudentControllerServlet" >Go Back</a>
</body>
</html>