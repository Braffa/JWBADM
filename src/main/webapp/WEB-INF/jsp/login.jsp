<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h2>Login Form</h2>
	<form:form action="attemptlogin.html" commandName="loginForm">
	<div class='center'>
		<table class='logintable'>
			<tr>
				<td>User Name:</td>
			</tr>
			<tr>	
				<td><FONT color=red><form:errors path="userName" /></FONT></td>
			</tr>
			<tr>
				<td><form:input class='StdInput' path="userName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
			</tr>	
			<tr>
				<td><FONT color=red><form:errors path="password" /></FONT></td>
			</tr>
			<tr>
				<td><form:password class='StdInput' path="password" /></td>
			</tr>
			<tr>
				<td><input class= 'StdButton' type="submit" value="Submit" /></td>
			</tr>
		</table>
		</DIV>
	</form:form>
