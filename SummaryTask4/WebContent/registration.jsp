<%@include file="/jspf/directive/page.jspf"%>
<%@include file="/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" value="MyEsop#Registration" />
<%@include file="/jspf/head.jspf"%>
<body>
	<div align="center">
		<h2>Registration:</h2>
		Do you already have an account? <a href="login.jsp">Login</a>
		<form action="controller" method="post">
			<h3>Create a new profile:</h3>
			<h4>Fill the following forms and click 'submit' to create an
				account</h4>
			<c:if test="${not empty message}">
				${message}
			</c:if>
			<input type="hidden" name="command" value="processRegistrarion">
			<table>
				<tr>
					<td><label for="login">Login:</label><br> <input
						name="login" /></td>
				</tr>
				<tr>
					<td><label for="email">Email:</label> <br> <input
						name="email" /></td>
				</tr>
				<tr>
					<td><label for="password">Password:</label><br> <input
						name="password" /></td>
				</tr>
				<tr>
					<td><label for="firstName">First name:</label><br> <input
						name="firstName" /></td>
				</tr>
				<tr>
					<td><label for="lastName">Last name:</label><br> <input
						name="lastName" /></td>
				</tr>
				<tr>
					<td><label for="phone">Phone:</label><br> <input
						name="phone" /></td>
				</tr>
				<tr>
					<td><label for="address">Address:</label><br> <input
						name="address" /></td>
				</tr>
				<tr>
					<td><label for="gender">Gender:</label><br> <input
						type="radio" name="gender" value="male" />Male<br>
					<input type="radio" name="gender" value="female" />Female</td>
				</tr>
			</table>
			<br> <input type="submit" value="Register">
		</form>
	</div>
</body>
</html>