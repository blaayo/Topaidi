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
		
					<div class="card-content">
						<div class="form-field">
							<label for="username">Identifiant</label>
							<input type="text" id="username">
						</div><br>
		
						<div class="form-field">
							<label for="password">Mot de passe</label>
							<input type="password" id="password">
						</div><br>
		
						<div class="form-field">
							<a href="connexion?action=inscription">s'inscrire</a>
						</div><br>
		
						<div class="form-field">
							<button class="btn-large waves-effect waves-dark" style="width:100%;">connexion</button>
						</div><br>
					</div>
		
				</div>
			</div>
		</div>
	
	</body>
</html>