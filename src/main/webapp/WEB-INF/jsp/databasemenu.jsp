<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Database Menu</h2>
<form:form action="databaseaction.html" >
<div class='center'>
	<table >
		<tr>
			<td><a class='menu2' href="recreateDatabase.html">Recreate Database</a></td>
		</tr>
		<tr>	
			<td><a class='menu2' href="viewlogin.html">View Login table</a></td>
		</tr>
		<tr>
			<td><a class='menu2' href="viewregistereduser.html">View Registered Users table</a></td>
		</tr>			
		<tr>
			<td><a class='menu2' href="viewcatalog.html">View Catalogue table</a></td>
		</tr>
		<tr>
			<td><a class='menu2' href="viewusertocatalog.html">View user to Catalogue table</a></td>
		</tr>	
	</table>
</DIV>
</form:form>

