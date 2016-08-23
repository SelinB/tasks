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
					<th>Login:</th>
				</tr>
				<tr>
					<td><input name="login" /></td>
				</tr>
				<tr>
					<th>Email:</th>
				</tr>
				<tr>
					<td><input name="email" /></td>
				</tr>
				<tr>
					<th>Password:</th>
				</tr>
				<tr>
					<td><input name="password" /></td>
				</tr>
				<tr>
					<th>First name:</th>
				</tr>
				<tr>
					<td><input name="firstName" /></td>
				</tr>
				<tr>
					<th>Last name:</th>
				</tr>
				<tr>
					<td><input name="lastName" /></td>
				</tr>
				<tr>
					<th>Phone:</th>
				</tr>
				<tr>
					<td><input name="phone" /></td>
				</tr>
				<tr>
					<th>Address:</th>
				</tr>
				<tr>
					<td><input name="address" /></td>
				</tr>
				<tr>
					<th>Gender:</th>
				</tr>
				<tr>
					<td><input name="gender" /></td>
				</tr>
			</table>
			<br> <input type="submit" value="Register">
		</form>
	</div>
</body>
</html>