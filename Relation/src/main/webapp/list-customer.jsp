<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Directory</title>
</head>

<body>

	<div class="container">

		<h3>Customer Directory</h3>
		<hr>
  
	<form action="/save" method="Post">

			<!-- Add hidden form field to handle update -->
			
			<div class="form-inline">
				<input type="text" name="firstName" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>
			<div class="form-inline">
				<input type="text" name="lastname" value="${Customer.lastname}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>
			<div class="form-inline">
				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>







		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>

					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>

					<th>Action</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customers}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>


						<td>
							<!-- Add "update" button/link --> <a
							href="/update?Id=${tempCustomer.id}" class="btn btn-info btn-sm">
								Update </a> <!-- Add "delete" button/link --> <a
							href="/delete?Id=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>

						</td>


					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>