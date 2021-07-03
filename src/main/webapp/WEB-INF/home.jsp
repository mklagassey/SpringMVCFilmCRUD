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
	
	<form action="AddFilm.do" method="POST">
		Title:
		<input type="text" name="title" value="title"/> 
		Language ID:
		<input type="text" name="languageId"/> 
		<input type="submit" value="Get Title Data" />
	</form>
	
	<ol>
	
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	<li></li>
	
	</ol>
	
</body>

</html>

<!--  private int id; 
	private String title; 
	private int releaseYear; 
	private String rating; 
	private String description; 
	private String languageId; 
	private int rentalDuration; 
	private int rentalRate; 
	private int length; 
	private double replacementCost;
	private String specialFeatures; //
	private List cast; //
	private Language languageName; // -->