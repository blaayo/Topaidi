<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				  <form class="col s12">
				    <div class="row">
				    	<div class="input-field col s12">
							<i class="material-icons prefix">mode_edit</i>
							<label for="titre">Titre</label>
							<textarea id="titre" class="materialize-textarea" name="titre"></textarea>
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
						    <select>
						      <option value="" disabled selected>Choose your option</option>
						      <option value="1">Option 1</option>
						      <option value="2">Option 2</option>
						      <option value="3">Option 3</option>
						    </select>
						    <label>Materialize Select</label>
						  </div>
				    </div>
				    <div class="file-field input-field">
					    <div class="btn">
					        <span>Image</span>
					        <input type="file">
					    </div>
					    <div class="file-path-wrapper">
					      	<input class="file-path validate" type="text" placeholder="Ajouter une image">
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

<script>
	document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('select');
	    var instances = M.FormSelect.init(elems, options);
	  });
</script>