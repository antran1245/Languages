<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<title>${language.getName()}</title>
</head>
<body>
	<div class="container">
		<div>
			<form action="/languages/${language.getId()}">
				<input type="hidden" name="_method" value="delete"/>
				<input type="submit" value="Delete" />
			</form>
			<a href="/languages">Dashboard</a>
		</div>
		<form:form action="/languages/${language.getId()}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
				<form:errors path="name"/>
			</div>
			<div class="form-group">
				<form:label path="creator">Creator</form:label>
				<form:input path="creator"/>
				<form:errors path="creator"/>
			</div>
			<div class="form-group">
				<form:label path="currentVersion">Version</form:label>
				<form:input path="currentVersion" type="number" step="0.1"/>
				<form:errors path="currentVersion"/>
			</div>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>