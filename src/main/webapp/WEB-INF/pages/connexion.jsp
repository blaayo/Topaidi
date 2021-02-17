<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Connexion</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
	
		<div class="row" style="margin-top: 150px">
			<div class="col s12 m8 l4 offset-m2 offset-l4">
				<div class="card">
		
					<div class="card-action teal lighten-1 white-text">
						<h3>Se connecter</h3>
					</div>
		
					<form action="connexion" method="post" class="card-content">
		
						<div class="form-field">${error}</div><br>
						
						<div class="form-field">
							<label for="email">Adresse mail</label>
							<input type="email" name="email" required>
						</div><br>
		
						<div class="form-field">
							<label for="password">Mot de passe</label>
							<input type="password" name="password" required>
						</div><br>
		
						<div class="form-field">
							<a href="connexion?action=inscription">s'inscrire</a>
						</div><br>
		
						<div class="form-field">
							<input type="hidden" name="actionPost" value="connexion">
							<button class="btn-large waves-effect waves-dark" style="width:100%;">connexion</button>
						</div><br>
					</form>
		
				</div>
			</div>
		</div>
	
	</body>
</html>