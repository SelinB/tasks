<%@include file="/jspf/directive/page.jspf"%>
<%@include file="/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" value="MyEsop#AdminPage" />
<%@include file="/jspf/head.jspf"%>
<body>
	<h2>Hello, ${user.getFirstName()} ${user.getLastName()}, you are
		${role}</h2>
	<div align="center">
		<c:if test="${not empty message}">
			${message}
		</c:if>
		<form action="controller?command=processAddProduct" method="post">
			<table>
				<caption>Add products to database:</caption>
				<tr>
					<td><label for="name">Product name:</label> <input name="name">
					</td>
				</tr>
				<tr>
					<td><label for="price">Product price:</label> <input
						name="price"></td>
				</tr>
				<tr>
					<td><label for="stock">Product stock:</label> <input
						name="stock"></td>
				</tr>
				<tr>
					<td><label for="date"></label> Manufacturing date: <input
						name="date"></td>
				</tr>
				<tr>
					<td><label for="size">Product size:</label> <input name="size">
					</td>
				</tr>
				<tr>
					<td><label for="color">Product color:</label> <input
						name="color"></td>
				</tr>
				<tr>
					<td><label for="image">Image source:</label><input
						name="image"></td>
				</tr>
				<tr>
					<td><label for="description">Description of a product:</label>
						<input name="description"></td>
				</tr>
				<tr>
					<td><label for="category">Product category: </label><input
						name="category"></td>
				</tr>
			</table>
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>