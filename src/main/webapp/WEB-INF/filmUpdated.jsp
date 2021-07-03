
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
				<li>${film.title} Good job, Flavor Flav. The film was
					successfully updated.</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>Danger Will Robinson, the film was not updated! Sorry, not sorry!</p>
		</c:otherwise>
	</c:choose>
	
</body>
</html>


