<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Topaidi</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<div class="nav-header center" style="padding:50px;">
	
			   <h1>Bienvenu sur TOPAIDI</h1>
			   <div class="tagline"><a class="waves-effect waves-light btn-large" href="idee?action=create" >Ajouter une idée</a></div>
			
			</div>
			
			<div class="row">
				<!-- Temporaire -->
				<% for(int i = 0; i < 7; i+=1) { %>
					<div class="col s10 m4">
					  <div class="card">
					    <div class="card-image">
					      <img src="https://data.photofunky.net/output/image/3/6/1/7/361786/photofunky.gif">
					      <span class="card-title"><b>IDEE</b></span>
					    </div>
					    <div class="card-content">
					      <p>Une description ... I am a very simple card. I am good at containing small bits of information.
					      I am convenient because I require little markup to use effectively.</p>
					    </div>
					    <div class="card-action">
					      <a href="idee?action=view&view=id">Voir plus</a>
					    </div>
					  </div>
					</div>
				<% } %>
			</div>
			  
		</div>
		
		<%@include file="commons/footer.jsp" %>
			
	</body>
</html>