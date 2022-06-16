<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.getId()}</title>
</head>
<body>
	<div class="container">
		<a href="/languages">Dashboard</a>
		<div>
			<p>${language.getName()}</p>
			<p>${language.getCreator()}</p>
			<p>${language.getCurrentVersion()}</p>
			<a href="/language/${language.getId()}/edit">Edit</a>
			<form action="/languages/${language.getId()}">
				<input type="hidden" name="_method" value="delete"/>
				<input type="submit" value="Delete" />
			</form>
		</div>
	</div>
</body>
</html>