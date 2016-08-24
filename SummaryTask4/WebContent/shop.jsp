<%@include file="/jspf/directive/page.jspf"%>
<%@include file="/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" value="MyEsop#Shop" />
<%@include file="/jspf/head.jspf"%>
<body>
	<%-- HEADER --%>
	<%@ include file="/jspf/header.jspf"%>
	<%-- HEADER --%>
	<c:if test="${empty productsList}">
		<jsp:forward page="controller?command=displayProducts" />
	</c:if>
	<div align="center">
		<div align="left">
			<table>
				<caption>Categories:</caption>
				<tr>
					<td><a href="controller?command=displayProducts">All</a></td>
				</tr>
				<c:forEach items="${categoriesList}" var="category">
					<tr>
						<td><a
							href="controller?command=displayProducts&categoryId=${category.getId()}&categoryName=${category.getName()}">${category.getName()}</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div align="left">
			<form action="controller" method="get">
				<input type="hidden" name="command" value="displayProducts">
				<input type="hidden" name="categoryName" value="${currentCategory}">
				<select name="sortMethod">
					<optgroup label="Sort by name">
						<option value="name">A-z</option>
						<option value="reverseName">Z-a</option>
					</optgroup>
					<optgroup label="Sort by price">
						<option value="price">DESHEVIY</option>
						<option value="reversePrice">DOROGOY</option>
					</optgroup>
					<optgroup label="Sort by manufacturin date">
						<option value="date">Newest</option>
						<option value="dateReverse">Oldest</option>
					</optgroup>
				</select> <input type="submit" value="Sort">
			</form>
		</div>
		<div align="left">
			<h2>Products in stock:</h2>
			<c:if test="${not empty currentCategory}">
				<h2>Current category: ${currentCategory}</h2>
			</c:if>
			<table border="1px" style="border-collapse: collapse;">
				<tr>
					<th>Product:</th>
					<th>Price:</th>
					<th>Stock:</th>
					<th>Manufacturing date:</th>
					<th>Size:</th>
					<th>Color:</th>
					<th>Description:</th>
				</tr>
				<c:forEach items="${productsList}" var="product">
					<tr>
						<td>${product.getName()}</td>
						<td>${product.getPrice()}</td>
						<td>${product.getStock()}</td>
						<td>${product.getManufactoryDate()}</td>
						<td>${product.getSize()}</td>
						<td>${product.getColor()}</td>
						<td>${product.getDescription()}</td>
						<td></td>
						<td><c:if test="${not empty product.getStock()}">
								<a
									href="controller?command=processAddToCart&productId=${product.getId()}&currentCategory=${currentCategory}&userId=${user.getId()}">Add
									to cart</a>
							</c:if> <c:if test="${empty product.getStock()}">There are no any products left in stock :(</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>