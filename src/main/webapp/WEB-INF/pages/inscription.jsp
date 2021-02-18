<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inscription</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
	
		<div class="row" style="margin-top: 150px">
			<div class="col s12 m8 l4 offset-m2 offset-l4">
				<div class="card">
		
					<div class="card-action teal lighten-1 white-text">
						<h3>S'inscrire</h3>
					</div>
		
					<form action="connexion" method="post" class="card-content">
		
						<div class="form-field">${error}</div><br>
						
						<div class="form-field">
							<label for="nom">Nom</label>
							<input type="text" name="nom" required>
						</div><br>
						
						<div class="form-field">
							<label for="prenom">Prenom</label>
							<input type="text" name="prenom" required>
						</div><br>
					
						<div class="form-field">
							<label for="email">E-mail</label>
							<input type="email" name="email" required>
						</div><br>
		
						<div class="form-field">
							<label for="password">Mot de passe</label>
							<input type="password" name="password" required>
						</div><br>
						
						<div class="form-field">
							<a href="connexion?action=connexion">se connecter</a>
						</div><br>
		
						<div class="form-field">
							<input type="hidden" name="actionPost" value="inscription" id="password">
							<button class="btn-large waves-effect waves-dark" type="submit" style="width:100%;">s'inscrire</button>
						</div><br>
					</form>
		
				</div>
			</div>
		</div>
	
	</body>
</html>