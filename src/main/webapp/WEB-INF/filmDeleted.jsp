
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>RESULTS GALORE</title>
</head>

<body>
<div class="containter-fluid">
	<c:choose>
		<c:when test="${empty film}">
			<ul>
				<li>Good job, Flavor Flav. The film was
					successfully deleted.</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>Danger Will Robinson, the film was not deleted!</p>
		</c:otherwise>
	</c:choose>
	
		<br>
			<form action="home.do"><input type="submit" value="Return to the Home Page"></form>
		<br>
	</div>
</body>
</html>


