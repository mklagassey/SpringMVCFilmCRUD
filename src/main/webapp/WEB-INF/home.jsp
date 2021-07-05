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
		Title <input type="text" name="title" value="title" /> <br>
				Description <input type="text" name="description" value="description" /><br>
				Release Year <input type="text" name="releaseYear" value="1990" /><br>
				Rental Rate <input type="text" name="rentalRate" value="5.99" /> <br>
				Length <input type="text" name="length" value="90" /> <br>
				Replacement Cost <input type="text" name="replacementCost" value="19.99" /><br>
				Special Features <input type="text" name="specialFeatures" value="Trailers" /> <br>
				Rental Duration <input type="text" name="rentalDuration" value="5" /><br>
				
				<label for="rating">Choose a Category:</label> <select name="category" id="category">
					<option value="Action">Action</option>
					<option value="Animation">Animation</option>
					<option value="Children">Children</option>
					<option value="Classics">Classics</option>
					<option value="Comedy">Comedy</option>
					<option value="Documentary">Documentary</option>
					<option value="Drama">Drama</option>
					<option value="Family">Family</option>
					<option value="Foreign">Foreign</option>
					<option value="Games">Games</option>
					<option value="Horror">Horror</option>
					<option value="Music">Music</option>
					<option value="New">New</option>
					<option value="Sci-Fi">Sci-Fi</option>
					<option value="Sports">Sports</option>
					<option value="Travel">Travel</option>
					
				</select> <br>
				<br>

				<label for="rating">Choose a Rating:</label> <select name="rating" id="rating">
					<option value="G">G</option>
					<option value="PG">PG</option>
					<option value="PG13">PG13</option>
					<option value="R">R</option>
					<option value="NC17">NC17</option>
				</select> <br>
				<br>


				<label for="language">Choose a Language:</label> <select name="languageName" id="language">
					<option value="English">English (1)</option>
					<option value="Italian">Italian (2)</option>
					<option value="Japanese">Japanese (3)</option>
					<option value="Mandarin">Mandarin (4)</option>
					<option value="French">French (5)</option>
					<option value="German">German (6)</option>
				</select> <br>
				<input type="submit" value="Submit"> 

	</form>
	
</body>

</html>

