<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>College Fest Management</h1>
		<br>
		<h3>Save Student</h3>
		<form action="/CollegeFest/student/save" method="POST">
			<input type="hidden" name="id" value="${student.id }" />
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Name</label> <input
					type="text" name="Name" value="${student.name }"
					class="form-control" id="name" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Department</label>
				<input type="text" name="Department" value="${student.department }"
					class="form-control" id="department">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Country</label>
				<input type="text" name="Country" value="${student.country }"
					class="form-control" id="country">
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
</body>
</html>