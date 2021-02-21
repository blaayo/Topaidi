<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>TOPIDEA</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<div class="nav-header center" style="padding:50px;">
	
			   <h1>Bienvenu sur TOPIDEA</h1>
			   <div class="tagline"><a class="waves-effect waves-light btn-large" href="idee?action=create" >Ajouter une idée</a></div>
			
			</div>
			
			<div class="row">
				<c:forEach var="idee" items="${listIdee}" >
				
					<div class="col s10 m4">
					  <div class="card">
					    <div class="card-image">
					      <img src="${idee.getImage()}">
					      <span class="card-title"><b>${idee.getNom()}</b></span>
					    </div>
					    <div class="card-content">
					      <p>${idee.getSubDescription()}</p>
					    </div>
					    <div class="card-action">
					      <a href="idee?action=view&view=${idee.getId()}">Voir plus<b class="right">${idee.getTop() + idee.getFlop()}<i class="material-icons right">thumbs_up_down</i></b></a>
					    </div>
					  </div>
					</div>
					
				</c:forEach>
			</div>
			  
		</div>
		
		<%@include file="commons/footer.jsp" %>
			
	</body>
</html>