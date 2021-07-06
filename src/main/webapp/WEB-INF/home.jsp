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
	<center><h1 style="border: 1px; border-style: solid; border-color: black; padding: .2em; width: fit-content;">Welcome to Netflicks!</h1></center>
	
	<br>
	<br>
	
	<h3 style="border: 1px; border-style: solid; border-color: black; padding: .2em; width: fit-content;">Enter Film ID</h3>
	<form action="GetFilmData.do" method="GET">
		ID#:
		<input type="text" name="filmId" size="4"/> 
		<input type="submit" value="Get Film Data" />
	</form>
	
	<br>
	
	<h3 style="border: 1px; border-style: solid; border-color: black; padding: .2em; width: fit-content;">Enter Search Criteria</h3>
	<form action="GetByKeyword.do" method="GET">
		Keyword:
		<input type="text" name="keyword"/> 
		<input type="submit" value="Search"/>
	</form>
	
	<br>
	
	<h3 style="border: 1px; border-style: solid; border-color: black; padding: .2em; width: fit-content;">Enter New Film Data:</h3>	
	<form action="AddFilm.do" method="POST">
		Title <input type="text" name="title" value="title" /> <br>
				Description <input type="text" name="description" value="description" /><br>
				Release Year <input type="text" name="releaseYear" value="1990" /><br>
				Rental Rate <input type="text" name="rentalRate" value="1.00" /> <br>
				Length <input type="text" name="length" value="90" /> <br>
				Replacement Cost <input type="text" name="replacementCost" value="1.00" /><br>
<!--  			Special Features <input type="text" name="specialFeatures" value="" /> <br>     -->
				Rental Duration <input type="text" name="rentalDuration" value="3" />
				
				<br>
				
				<p><strong>-- Choose the Special Features --</strong></p>
<!--  				<form action="WEB-INF/filmUpdated.jsp">   -->
					<input type="checkbox" id="special_feature_deleted_scenes" name="specialFeatures" value="deleted scenes" <c:if test="${film.specialFeatures.contains('Deleted Scenes') }">checked</c:if> >
						<label for="special_feature_deleted_scenes">Deleted Scenes</label><br>					
						<input type="checkbox" id="special_feature_behind_the_scenes" name="specialFeatures" value="behind the scenes" <c:if test="${film.specialFeatures.contains('Behind the Scenes') }">checked</c:if> >
						<label for="special_feature_behind_the_scenes">Behind the Scenes</label><br>				
						<input type="checkbox" id="special_feature_trailers" name="specialFeatures" value="trailers" <c:if test="${film.specialFeatures.contains('Trailers') }">checked</c:if> >
						<label for="special_feature_trailers">Trailers</label><br>					
						<input type="checkbox" id="special_feature_commentaries" name="specialFeatures" value="commentaries" <c:if test="${film.specialFeatures.contains('Commentaries') }">checked</c:if> >
						<label for="special_feature_commentaries">Commentaries</label><br>	
					
					<br>
				
				<label for="rating"><strong>-- Choose a Category --</strong></label><br>
					<select name="category" id="category">
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
					</select> 
				
					<br>
					<br>

				<label for="rating"><strong>-- Choose a Rating --</strong></label><br>
					<select name="rating" id="rating">
						<option value="G">G</option>
						<option value="PG">PG</option>
						<option value="PG13">PG13</option>
						<option value="R">R</option>
						<option value="NC17">NC17</option>
					</select> 
					
					<br>
					<br>

				<label for="language"><strong>-- Choose a Language --</strong></label><br>
					<select name="languageName" id="language">
						<option value="English">English (1)</option>
						<option value="Italian">Italian (2)</option>
						<option value="Japanese">Japanese (3)</option>
						<option value="Mandarin">Mandarin (4)</option>
						<option value="French">French (5)</option>
						<option value="German">German (6)</option>
					</select> 
					
					<br>
					<br>
					
				<input type="submit" value="Submit"> 		
			</form>
	
</body>

</html>

