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
			Title <input type="text" name="title" value="${film.title}" />
			Description <input type="text" name="description" value="${film.description}" />	
			Release Year <input type="text" name="releaseYear" value="${film.releaseYear}" />
		  <!--   Rating <input type="text" name="rating" value="${film.rating}" />--> 
			Rental Rate <input type="text" name="rentalRate" value="${film.rentalRate}" />
			Length <input type="text" name="length" value="${film.length}" />
			Replacement Cost <input type="text" name="replacementCost" value="${film.replacementCost}" />
			Special Features <input type="text" name="specialFeatures" value="${film.specialFeatures}" />
			Language ID <input type="text" name="languageId" value="${film.languageId}" />
			Rental Duration <input type="text" name="rentalDuration" value="${film.rentalDuration}" />	
		 <!--	Language Name <input type="text" name="languageName" value="${film.languageName}" />	-->
			Category <input type="text" name="category" value="${film.category}" />	
						
			<section>
 			 <h3>Cast:</h3>
 			 <c:forEach var="actor" items="${film.actorList}">
			<ul>
			<li>${actor.firstName} ${actor.lastName}</li>
			</ul>
			</c:forEach>
    		</section>

<p> The film is currently rated ${film.rating} </p>

  <label for="rating">Choose a Rating:</label>
  <select name="rating" id="rating">
    <option value="${film.rating}">${film.rating}</option>
    <option value="G">G</option>
    <option value="PG">PG</option>
    <option value="PG13">PG13</option>
    <option value="R">R</option>
    <option value="NC17">NC17</option>
  </select>
  <br><br>
  <input type="submit" value="Submit">

<p >Click the "Submit" to update your movie. </p>


<p> The film is currently rated ${film.languageName} </p>

  <label for="language">Choose a Language:</label>
  <select name="languageName" id="language">
    <option value="${film.languageName}">${film.languageName}</option>
    <option value="English">English</option>
    <option value="Italian">Italian</option>
    <option value="Japanese">Japanese</option>
    <option value="Mandarin">Mandarin</option>
    <option value="French">French</option>
    <option value="German">German</option>
  </select>
  <br><br>

    </form> 
  	</c:when>
  	
 		<%-- 	 </ul>
			</section> 
			<p></p>	      	
			<c:forEach var="actor" items="${film.actorList}">
			<ul>
			<li>${actor.firstName} ${actor.lastName}</li>
			</ul>
			</c:forEach>
			</form> --%>
	<c:otherwise>
	<p>To change film information, please edit the fields below, and then press the "update" button. To delete, use the "delete" button. </p>
	<c:forEach var="film" items="${films}">
		<form action="UpdateFilm.do" method="POST">
			<input value="${film.iD}" type="hidden" name="id">
			Title <input type="text" name="title" value="${film.title}" />
			Description <input type="text" name="description" value="${film.description}" />	
			Release Year <input type="text" name="releaseYear" value="${film.releaseYear}" />
			Rating <input type="text" name="rating" value="${film.rating}" />
			Rental Rate <input type="text" name="rentalRate" value="${film.rentalRate}" />
			Length <input type="text" name="length" value="${film.length}" />
			Replacement Cost <input type="text" name="replacementCost" value="${film.replacementCost}" />
			Special Features <input type="text" name="specialFeatures" value="${film.specialFeatures}" />
			Language ID <input type="text" name="languageId" value="${film.languageId}" />
			Rental Duration <input type="text" name="rentalDuration" value="${film.rentalDuration}" />	
			Language Name <input type="text" name="languageName" value="${film.languageName}" />	
			Category <input type="text" name="category" value="${film.category}" />	
					
			<h3>Cast: </h3>
			<c:forEach var="actor" items="${film.actorList}">
			<ul>
			<li>${actor.firstName} ${actor.lastName}</li>
			</ul>
			</c:forEach>
			<button>Update</button>
		</form>
		<form action="DeleteFilm.do" method="POST">
			<input value="${film.iD}" type="hidden" name="id">
			<button>Delete</button>
		</form>
		<hr size="" width="" color="">
	</c:forEach>
</c:otherwise>
</c:choose>
</body>
</html>