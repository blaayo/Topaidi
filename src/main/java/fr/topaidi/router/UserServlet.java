package fr.topaidi.router;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.topaidi.entite.Users;
import fr.topaidi.service.UserService;



@WebServlet("/connexion")
public class UserServlet extends HttpServlet{
	
	@EJB
	private UserService userService;
	
	/* Message d'erreur affiché*/
	String error = "";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

	 	// Affichage formulaire inscription
		if(req.getParameter("action").equals("inscription")) 
		{
			 req.setAttribute("error", error);
			 this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(req, resp);
		}
		// Affichage formulaire connexion
		else if(req.getParameter("action").equals("connexion"))
		{
			req.setAttribute("error", error);
		    this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		// Inscription
		if(req.getParameter("actionPost").equals("inscription")) 
		{
			/* Inscription de l'utilisateur */
			Users user = new Users();
			user.setEmail( req.getParameter("email") );
			user.setNom( req.getParameter("nom"), req.getParameter("prenom") );
			user.setPassword( req.getParameter("password") );
			user.setCreatedAt(new Date());
			   
			/* Ajout de l'utilisateur dans la BDD */
			userService.addUser(user);
			
			/* Affichage de la page de connexion */
			String error = "<p class='green-text text-lighten-1'>Bravo! Inscription reussie!</p>";
			req.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);
	    }
		// Connexion
		if(req.getParameter("actionPost").equals("connexion")) 
		{
			/* Inscription de l'utilisateur */
			String email 	= req.getParameter("email");
			String password = req.getParameter("password");
			if ( userService.verifUser(email,password) == true )
			{
				/* creation de la session */
				// ...
				/* Affichage de la list des idée */
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
			}
			else
			{
				/* Affichage de la page de connexion */
				String error = "<p class='red-text text-lighten-1'>Email ou mot de passe incorect</p>";
				req.setAttribute("error", error);
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);				
			}
	    }
	}
}
