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
			<form action="UpdateFilm.do" method="POST">
				<input value="${film.iD}" type="hidden" name="id"> 
				Title <input type="text" name="title" value="${film.title}" /> <br>
				Description <input type="text" name="description" value="${film.description}" /><br>
				Release Year <input type="text" name="releaseYear" value="${film.releaseYear}" /><br>
				Rental Rate <input type="text" name="rentalRate" value="${film.rentalRate}" /> <br>
				Length <input type="text" name="length" value="${film.length}" /> <br>
				Replacement Cost <input type="text" name="replacementCost" value="${film.replacementCost}" /><br>
<!--  			Special Features <input type="text" name="specialFeatures" value="${film.specialFeatures}" /> <br>     -->
				Rental Duration <input type="text" name="rentalDuration" value="${film.rentalDuration}" /><br>
				
				<br>
				
				<p>The current special features include: ${film.specialFeatures}</p>
				<p><strong>-- Choose New Special Features --</strong></p>
					<form action="WEB-INF/filmUpdated.jsp"> 
						<input type="checkbox" id="special_feature_deleted_scenes" name="deleted_scenes" value="${film.specialFeatures}">
						<label for="special_feature_deleted_scenes">Deleted Scenes</label><br>					
						<input type="checkbox" id="special_feature_behind_the_scenes" name="behind_the_scenes" value="${film.specialFeatures}">
						<label for="special_feature_behind_the_scenes">Behind the Scenes</label><br>				
						<input type="checkbox" id="special_feature_trailers" name="trailers" value="${film.specialFeatures}">
						<label for="special_feature_trailers">Trailers</label><br>					
						<input type="checkbox" id="special_feature_commentaries" name="commentaries" value="${film.specialFeatures}">
						<label for="special_feature_commentaries">Commentaries</label><br>	
					</form> 
					
					<br>
				
				<p>The category is: ${film.category}</p>
				<label for="rating" ><strong>-- Choose a New Category --</strong></label><br> 
					<select name="category" id="category">
						<option value="${film.category}">${film.category}</option>
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

				<p>The film is currently rated ${film.rating}</p>
				<label for="rating"><strong>-- Choose a New Rating --</strong></label><br> 
					<select name="rating" id="rating">
						<option value="${film.rating}">${film.rating}</option>
						<option value="G">G</option>
						<option value="PG">PG</option>
						<option value="PG13">PG13</option>
						<option value="R">R</option>
						<option value="NC17">NC17</option>
					</select> 

					<br>

				<p>The film's language ID is: ${film.languageId}</p>
				<label for="language"><strong>-- Choose a New Language --</strong></label><br> 
					<select name="languageName" id="language">
						<option value="${film.languageName}">${film.languageName}</option>
						<option value="English">English (1)</option>
						<option value="Italian">Italian (2)</option>
						<option value="Japanese">Japanese (3)</option>
						<option value="Mandarin">Mandarin (4)</option>
						<option value="French">French (5)</option>
						<option value="German">German (6)</option>
					</select> 
				
					<br>
					<br> 

				<section>
					<h4>Cast:</h4>
					<c:forEach var="actor" items="${film.actorList}">
						<ul>
							<li>${actor.firstName} ${actor.lastName}</li>
						</ul>
					</c:forEach>
				</section>
				<br>
				<p>Click "Submit" to update your movie or use "DELETE FILM" to permanently remove the film.</p>
				<input type="submit" value="Submit"> 
			</form>
			<form action="DeleteFilm.do" method="POST">
				<input value="${film.iD}" type="hidden" name="id">
				<button>
					<font color="red"><strong>DELETE FILM</strong></font>
				</button>
				<br>
			
			</form>
				<br>
			<form action="home.do"><input type="submit" value="Return to the Previous Page"></form>
				<br>
		</c:when>

                    

		<c:otherwise>
			<p>To change film information, please edit the fields below, and
				then press the "update" button. To delete, use the "delete" button.
			</p>
			<c:forEach var="film" items="${films}">
				<form action="UpdateFilm.do" method="POST">
				<input value="${film.iD}" type="hidden" name="id"> 
				Title <input type="text" name="title" value="${film.title}" /> <br>
				Description <input type="text" name="description" value="${film.description}" /><br>
				Release Year <input type="text" name="releaseYear" value="${film.releaseYear}" /><br>
				Rental Rate <input type="text" name="rentalRate" value="${film.rentalRate}" /> <br>
				Length <input type="text" name="length" value="${film.length}" /> <br>
				Replacement Cost <input type="text" name="replacementCost" value="${film.replacementCost}" /><br>
<!-- 			Special Features <input type="text" name="specialFeatures" value="${film.specialFeatures}" /> <br>        -->
				Rental Duration <input type="text" name="rentalDuration" value="${film.rentalDuration}" /><br>
				
					<br>

			<p>The current special features include: ${film.specialFeatures}</p>
			<p><strong>-- Choose New Special Features --</strong></p>
				<form action="WEB-INF/filmUpdated.jsp"> 
					<input type="checkbox" id="special_feature_deleted_scenes" name="deleted_scenes" value="${film.specialFeatures}">
					<label for="special_feature_deleted_scenes">Deleted Scenes</label><br>					
					<input type="checkbox" id="special_feature_behind_the_scenes" name="behind_the_scenes" value="${film.specialFeatures}">
					<label for="special_feature_behind_the_scenes">Behind the Scenes</label><br>				
					<input type="checkbox" id="special_feature_trailers" name="trailers" value="${film.specialFeatures}">
					<label for="special_feature_trailers">Trailers</label><br>					
					<input type="checkbox" id="special_feature_commentaries" name="commentaries" value="${film.specialFeatures}">
					<label for="special_feature_commentaries">Commentaries</label><br>	
					</form> 
				
				<p>The category is: ${film.category}</p>

				<label for="rating" ><strong>-- Choose a New Category --</strong></label><br> 
					<select name="category" id="category">
						<option value="${film.category}">${film.category}</option>
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

				<p>The film is currently rated ${film.rating}</p>
				<label for="rating" ><strong>-- Choose a New Rating --</strong></label><br> 
					<select name="rating" id="rating">
						<option value="${film.rating}">${film.rating}</option>
						<option value="G">G</option>
						<option value="PG">PG</option>
						<option value="PG13">PG13</option>
						<option value="R">R</option>
						<option value="NC17">NC17</option>
					</select> 
					
					<br>
					<br>

				<p>The film's language ID is: ${film.languageId}</p>
				<label for="rating" ><strong>-- Choose a New Language --</strong></label><br> 
					<select name="languageName" id="language">
						<option value="${film.languageName}">${film.languageName}</option>
						<option value="English">English (1)</option>
						<option value="Italian">Italian (2)</option>
						<option value="Japanese">Japanese (3)</option>
						<option value="Mandarin">Mandarin (4)</option>
						<option value="French">French (5)</option>
						<option value="German">German (6)</option>
					</select> 
					
					<br>
					<br> 

				<section>
					<h4>Cast:</h4>
					<c:forEach var="actor" items="${film.actorList}">
						<ul>
							<li>${actor.firstName} ${actor.lastName}</li>
						</ul>
					</c:forEach>
				</section>
			
				<br><p>Click "Submit" to update your movie or use "DELETE FILM" to permanently remove the film.</p>
				<input type="submit" value="Submit"> 
			</form>
			<form action="DeleteFilm.do" method="POST">
				<input value="${film.iD}" type="hidden" name="id">
				<button>
					<font color="red"><strong>DELETE FILM</strong></font>
				</button>
			</form>
			
			<form action="home.do"><input type="submit" value="Return to the Previous Page"></form>
				
		
				<hr size="" width="" color="">
			</c:forEach>
		</c:otherwise>
	</c:choose>		
</body>
</html>