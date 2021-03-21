<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ajouter</title>
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
				  <form class="col s12" method="post" action="idee">
				  
					   <div class="row">
					    	<div class="input-field col s12">
								<i class="material-icons prefix">mode_edit</i>
								<input id="icon_titre" type="tel" class="validate" name="titre">
								<label for="icon_titre">Titre</label>
					    	</div>
					   </div>
				       <div class="row">
					    	<div class="input-field col s12">
						        <i class="material-icons prefix">insert_photo</i>
						        <input id="icon_image" type="text" class="validate" name="image">
						        <label for="icon_image">Url de l'image</label>
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
								<div class="input-field col s12">
								    <select name="categorie">
								      <option value="" disabled selected>Choisir une categorie</option>
								      	<c:forEach var="categorie" items="${categories}" >
										<option value="${categorie.getId()}">${categorie.getName()}</option>
										</c:forEach>
								    </select>
								    <label>Catégorie</label>
							     </div>
					    	</div>
	  					</div>	    	  
					    <div class="row">
						    <div class="center-align col s12">
						      	<input type="hidden" name="action" value="addIdea">
						    	<button class="waves-effect waves-light btn-large" type="submit">Créer</button>
							</div>
						</div>
				  </form>
				</div>
			</div>
			
		</div>
		
		<%@include file="commons/footer.jsp" %>
			
	</body>
</html>