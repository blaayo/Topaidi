<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ajouter</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<div class="nav-header center" style="padding:50px;">
	
			   <h1>Ajouter votre idée</h1>
			   <div class="tagline">Blablbla pour votre idée !</div>
			
			</div>
			
			
	        <div class="card-panel grey lighten-5 z-depth-1" style="margin:50px 0">
				<div class="row">
				  <form class="col s12" method="post">
				  
					   <div class="row">
					    	<div class="input-field col s12">
								<i class="material-icons prefix">mode_edit</i>
								<label for="titre">Titre</label>
								<textarea id="titre" class="materialize-textarea" name="titre"></textarea>
					    	</div>
					   </div>
				       <div class="row">
					    	<div class="input-field col s12">
								<i class="material-icons prefix">insert_photo</i>
								<label for="image">Url de l'image</label>
								<textarea id="image" class="materialize-textarea" name="image"></textarea>
					    	</div>
					    </div>
					    <div class="row">
					    	<div class="input-field col s12">
								<i class="material-icons prefix">sticky_note_2</i>
								<label for="description">Description</label>
								<textarea id="description" class="materialize-textarea" name="description"></textarea>
					    	</div>
					    </div>					    	  
					    <div class="row">
					    	<div class="input-field col s12">
								<select class="form-select" aria-label="Default select example" name="categorie">
									<c:forEach var="categorie" items="${categories}" >
									<option value="1">${categorie.getName()}</option>
									</c:forEach>
								</select>
					    	</div>
	  					</div>
					    <div class="center-align">
					      	<input type="hidden" name="create">
					    	<button class="waves-effect waves-light btn-large" type="submit">Créer</button>
						</div>
				  </form>
				</div>
			</div>
			
		</div>
		
		<%@include file="commons/footer.jsp" %>
			
	</body>
</html>