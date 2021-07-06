
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>RESULTS GALORE</title>
</head>

<body>

	<c:choose>
		<c:when test="${not empty film}">
			<ul>
				<li>Good job, Flavor Flav. ${film.title} was
					successfully updated.</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>Danger Will Robinson, the film was not updated! Sorry, not sorry!</p>
		</c:otherwise>
	</c:choose>
	
				<a input type="button" onClick="home.do"> Return to Home Page</a>
	
 		<br>
					<form action="home.do"><input type="submit" value="Return to the Home Page"></form>

		<br>     
		
		
</body>
</html>

