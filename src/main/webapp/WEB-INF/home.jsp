<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
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
	
	<h3>Enter your search criteria:</h3>
	<form action="GetByKeyword.do" method="GET">
		Keyword:
		<input type="text" name="keyword"/> 
		<input type="submit" value="Search" />
	</form>
	
		<h3>Enter new film data:</h3>
	
	<form action="AddFilm.do" method="POST">
		Title:
		<input type="text" name="title" value="title"/> 
		Language ID:
		<input type="text" name="languageId"/> 
		<input type="submit" value="Add New Film" />
	</form>
	
<!-- <h3>Push the button to go to fancy page:</h3>
	<form action="GoToDisplayFilm.do" method="GET">
		<input type="submit" value="GO!!!" />
	</form> -->
	
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