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
	        ${film.title}
	        		<%-- <input href = "DeleteFilm.do" type="submit" id= "${film}" value="Delete Film" /> --%>
	        		
	       	<%-- <a href="DeleteFilm.do" id="${film.iD}" class="btn btn-primary" role="button">Delete</a> --%>
	        
	<form action="DeleteFilm.do" method="POST">
		<input value="${film.iD}" type="hidden" name="id">
		<button> Delete </button>
	</form>
	
	
</body>
</html>