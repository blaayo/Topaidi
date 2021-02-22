package fr.topaidi.router;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.topaidi.entite.Users;
import fr.topaidi.service.UserService;



@WebServlet("/connexion")
public class UserServlet extends HttpServlet{
	
	@EJB
	private UserService userService;
	
	/* Message d'erreur affiché */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	 	// Affichage formulaire inscription
		if(req.getParameter("action").equals("inscription")) 
		{
			 this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(req, resp);
		}
		// Affichage formulaire connexion
		else if(req.getParameter("action").equals("connexion"))
		{
		    this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);
		}
		// Affichage formulaire connexion et supression de la session
		else if(req.getParameter("action").equals("disconnect"))
		{
			HttpSession session = req.getSession();
			session.removeAttribute("isConnect");
		    this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		// Inscription
		if(req.getParameter("actionPost").equals("inscription")) 
		{
			/* Création d'un Users temporaire */
			Users user = new Users();
			user.setEmail( req.getParameter("email") );
			user.setNom( req.getParameter("nom"), req.getParameter("prenom") );
			user.setPassword( req.getParameter("password") );
			
			if ( userService.verifEmailUser(user.getEmail()) )
			{
				/* Ajout de l'utilisateur dans la BDD */
				userService.addUser(user);
				/* Affichage de la page de connexion */
				String error = "<p class='green-text text-lighten-1'>Bravo! Inscription reussie, conectez-vous.</p>";
				req.setAttribute("error", error);
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);
			}
			else
			{
				String error = "<p class='red-text text-lighten-1'>Email déjà existante</p>";
				req.setAttribute("error", error);
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(req, resp);
			}
	    }
		// Connexion
		if(req.getParameter("actionPost").equals("connexion")) 
		{
			/* Inscription de l'utilisateur */
			String email 	= req.getParameter("email");
			String password = req.getParameter("password");
			if ( !userService.verifUser(email,password) )
			{
				/* creation de la session */
				HttpSession session = req.getSession();
		        session.setAttribute("isConnect", true);
				/* Redirection page home */
		        resp.sendRedirect("home");
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
