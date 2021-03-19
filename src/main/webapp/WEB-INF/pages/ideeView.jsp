<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View</title>
		<%@include file="commons/header.jsp" %>
	</head>
	<body>
		<div class="container">
			<%@include file="commons/menu.jsp" %>
			
			<div class="row">
				<div class="col s10 m12">
				    <img class="materialboxed" width="100%" src="${idea.getImage()}">
				</div>
				
				<div class="col s10 m12 center">
					<h1><b>${idea.getNom()}</b></h1>
				</div>
				
				<div class="col s10 m12">
    				<div class="col s10 m5"></div>
    				<div class="col s10 m1">
			  			<a class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons">thumb_up</i></a>
					</div>
    				<div class="col s10 m1">
			  			<a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">thumb_down</i></a>
					</div>
    				<div class="col s10 m5"></div>
				</div>
				
				<div class="col s10 m12">
    				<p class="center">${idea.getDescription()}</p>
				</div>
				
				<div class="col s10 m12">
        			<div class="card-panel grey lighten-5 z-depth-1" style="margin:50px 0;">
						<!-- Temporaire -->
						<c:forEach var="comment" items="${comments}" >
		        			<div class="row">
					            <div class="col s1 center">
					              <i class="medium material-icons">account_circle</i>
					            </div>
					            <div class="col s11">
									<b>${comment.getUser().getNom()}</b>
					            </div>
							    <blockquote>
							      ${comment.getContent()}
							    </blockquote>
					        </div>
						</c:forEach>
						<hr/>
		        			<div class="row ">
							  <form class="col s12">
							    <div class="row">
							    	<b>Ajouter un commentaire</b>
							    </div>
							    <div class="row">
							    	<div class="input-field col s10">
										<i class="material-icons prefix">insert_comment</i>
										<label for="commentaire">Commentaire</label>
										<textarea id="commentaire" class="materialize-textarea" name="commentaire"></textarea>
							    	</div>
								    <div class="input-field col s2">
							      		<input type="hidden" name="commentaire">
								    	<button class="waves-effect waves-light btn-large" type="submit">AJOUTER</button>
									</div>
							    </div>
							  </form>
					        </div>
	        		</div>
				</div>                     
			</div>
			  
		</div>
		
		<%@include file="commons/footer.jsp" %>
		<script type="text/javascript">
			document.addEventListener('DOMContentLoaded', function() {
			    var elems = document.querySelectorAll('.materialboxed');
			    var instances = M.Materialbox.init(elems, options);
			  });
		</script>
			
	</body>
</html>

