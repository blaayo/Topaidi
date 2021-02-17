package fr.topaidi.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/idee")
public class IdeeServlet extends HttpServlet{

	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
	 	// Affichage classement idées
		if(req.getParameter("action").equals("classement")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeClassement.jsp").forward(req, resp);
		}
		// Affichage formulaire creation idées
		else if(req.getParameter("action").equals("create"))
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeCreate.jsp").forward(req, resp);
		}
		// Affichage idées
		else if(req.getParameter("action").equals("view"))
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeView.jsp").forward(req, resp);
		}
    }
}