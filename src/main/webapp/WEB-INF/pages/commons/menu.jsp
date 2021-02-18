<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<nav>
    <div class="nav-wrapper" style="background-color: #26a69a !important;">
      <a href="home" class="brand-logo" style="margin-left: 10px;"><b>TOPAIDI</b></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="home">Acceuil</a></li>
        <li><a href="idee?action=classement">Classement</a></li>
        <li><a href="idee?action=create">Ajouter</a></li>
        <c:choose>
	      	<c:when test="${isConnect == true}">
	        	<li><a href="connexion?action=disconnect"><i class="material-icons">logout</i></a></li>
	    	</c:when>    
	    	<c:otherwise>
	        	<li><a href="connexion?action=disconnect"><i class="material-icons">login</i></a></li>
		    </c:otherwise>
		</c:choose>
      </ul>
    </div>
</nav>