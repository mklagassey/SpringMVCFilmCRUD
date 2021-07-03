<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>FILM MVC Y'all</title>
</head>

<body>
	<h1>Welcome to our awesome film site!</h1>
	
	<h3>Enter film ID:</h3>
	<form action="GetFilmData.do" method="GET">
		ID#:
		<input type="text" name="filmId" size="4"/> 
		<input type="submit" value="Get Film Data" />
	</form>
	
</body>

</html>