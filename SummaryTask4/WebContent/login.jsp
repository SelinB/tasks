<%@include file="/jspf/directive/page.jspf"%>
<%@include file="/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" value="MyEsop#Login" />
<%@include file="/jspf/head.jspf"%>
<body>
	<div align="center">
		<h2>This is a login page</h2>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="processLogin">
			<table>
				<tr>
					<th>Login:</th>
				</tr>
				<tr>
					<td><input name="login" /></td>
				</tr>
				<tr>
					<th>Password:</th>
				</tr>
				<tr>
					<td><input name="password" /></td>
				</tr>
			</table>
			<br> <input type="submit" value="Login">
		</form>
		<br>
		<c:if test="${not empty message}">
			<p style="color: red;">${message}</p>
		</c:if>
	</div>
</body>
</html>