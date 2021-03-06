<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Classement</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<div class="nav-header center" style="padding:50px;">
	
			   <h1>Classement des idées</h1>
			   <div class="tagline"><a class="waves-effect waves-light btn-large" href="idee?action=create" >Ajouter une idée</a></div>
			
			</div>
			
			<div class="row">
				<c:forEach var="idee" items="${listIdeeClassement}" >
				
					<div class="col s12 l6 xl4" style="cursor: pointer" onclick="document.location.href='idee?action=view&view=${idee.getId()}'">
					  <div class="card">
					    <div class="card-image card-bg-a" style="background-image: url('${idee.getImage()}')">
					      <img style="opacity:0" src="https://www.suitedesoins.fr/wp-content/uploads/2016/03/fond-blanc-site-300x214.png">
					      <span class="card-title"><b>${idee.getNom()}</b></span>
					    </div>
					    <div class="card-content">
					      <p>${idee.getDescription()} <a href="#">voir plus</a></p>
					    </div>
					    <div class="card-action">
					      <a href="#">${idee.getCreatedAt()}
					      	<b class="right">
					      		${idee.getTop()}<i class="material-icons right">thumb_up</i>
					      	</b>
					      	<b class="right" style="margin-right:15px">
					      		${idee.getFlop()}<i class="material-icons right">thumb_down</i>
					      	</b>
					      </a>
					    </div>
					  </div>
					</div>
					
				</c:forEach>
			</div>
			  
		</div>
		
		<%@include file="commons/footer.jsp" %>
			
	</body>
</html>