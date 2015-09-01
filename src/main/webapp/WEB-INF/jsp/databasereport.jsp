<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<h3>Database Report</h3>
	<form:form action="databaseaction.html"
		commandName='databaseReportForm'>
		<c:if test="${databaseReportForm.lOfLogins.size() > 0}">
			<table class='tablecolor'>
				<caption class='captioncolor'>Login Table</caption>
				<tr class='hdrcolor'>
					<th>User Id</th>
					<th>Password</th>
					<th>Authority Level</th>
					<th>Create Date</th>
					<th>Last Updated</th>
				</tr>
				<c:forEach items="${databaseReportForm.lOfLogins}" var="login"
					varStatus="ls">
					<tr>
						<td><form:input class='StdInput' disabled='true'
								path="lOfLogins[${ls.index}]login.userId" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfLogins[${ls.index}]login.password" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfLogins[${ls.index}]login.authorityLevel" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfLogins[${ls.index}]login.crDate" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfLogins[${ls.index}]login.updDate" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${databaseReportForm.lOfRegisteredUser.size() > 0}">
			<div class='scroll'>
			<table class='tablecolor'>
				<caption class='captioncolor'>Registered User Table</caption>
				<tr class='hdrcolor'>
					<th>User Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>telephone</th>
					<th>Create Date</th>
					<th>Last Updated</th>
				</tr>
				<c:forEach items="${databaseReportForm.lOfRegisteredUser}"
					var="registeredUser" varStatus="rs">
					<tr>
						<td><form:input class='StdInput' disabled='true'
								path="lOfRegisteredUser[${rs.index}]registeredUser.login.userId" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfRegisteredUser[${rs.index}]registeredUser.firstname" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfRegisteredUser[${rs.index}]registeredUser.lastname" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfRegisteredUser[${rs.index}]registeredUser.email" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfRegisteredUser[${rs.index}]registeredUser.telephone" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfRegisteredUser[${rs.index}]registeredUser.crDate" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfRegisteredUser[${rs.index}]registeredUser.updDate" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</c:if>
		<c:if test="${databaseReportForm.lOfProducts.size() > 0}">
			<div class='scroll'>
				<table class='tablecolor'>
					<caption class='captioncolor'>Product Table</caption>
					<tr class='hdrcolor'>
						<th>Author</th>
						<th>Image URL</th>
						<th>Large Image URL</th>
						<th>Manufacturer</th>
						<th>Product Index</th>
						<th>Product Group</th>
						<th>Product Id</th>
						<th>Product Id Type</th>
						<th>Source</th>
						<th>Source id</th>
						<th>Title</th>
						<th>Create Date</th>
						<th>Last Updated</th>						
					</tr>
					<c:forEach items="${databaseReportForm.lOfProducts}" var="product"
						varStatus="ps">
						<tr>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.author" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.imageURL" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.imageLargeURL" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.manufacturer" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.productIndex" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.productgroup" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.productid" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.productidtype" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.source" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.sourceid" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.title" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.crDate" /></td>
							<td><form:input class='StdInput' disabled='true'
									path="lOfProducts[${ps.index}]product.updDate" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${databaseReportForm.lOfUserToCatalog.size() > 0}">
			<table class='tablecolor'>
				<caption class='captioncolor'>User to Catalogue Table</caption>
				<tr class='hdrcolor'>
					<th>User Id</th>
					<th>Product Id</th>
					<th>Product Index</th>
					<th>Create Date</th>
					<th>Last Updated</th>	
				</tr>
				<c:forEach items="${databaseReportForm.lOfUserToCatalog}"
					var="userToCatalog" varStatus="us">
					<tr>
						<td><form:input class='StdInput' disabled='true'
								path="lOfUserToCatalog[${us.index}]userToCatalog.userId" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfUserToCatalog[${us.index}]userToCatalog.productId" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfUserToCatalog[${us.index}]userToCatalog.productIndex" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfUserToCatalog[${us.index}]userToCatalog.crDate" /></td>
						<td><form:input class='StdInput' disabled='true'
								path="lOfUserToCatalog[${us.index}]userToCatalog.updDate" /></td>																
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>

