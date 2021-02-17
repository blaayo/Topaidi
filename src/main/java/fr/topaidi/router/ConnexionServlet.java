package fr.topaidi.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

	 	// Affichage formulaire inscription
		if(req.getParameter("action").equals("inscription")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(req, resp);
		}
		// Affichage formulaire connexion
		else if(!(req.getParameter("action").equals("connexion")))
		{
		   this.getServletContext().getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req, resp);
		}
	}
}
