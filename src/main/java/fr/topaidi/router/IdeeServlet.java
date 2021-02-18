package fr.topaidi.router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/idee")
public class IdeeServlet extends HttpServlet{

	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		HttpSession session = req.getSession();
		
		req.setAttribute("isConnect", session.getAttribute("isConnect"));
			
		if(req.getParameter("action").equals("classement")) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeClassement.jsp").forward(req, resp);
		}
		else if( null == session.getAttribute("isConnect"))
		{
			/* Redirection page home */
	        resp.sendRedirect("connexion?action=connexion");
		}
		else 
		{
			// Affichage formulaire creation id�es
			if(req.getParameter("action").equals("create"))
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeCreate.jsp").forward(req, resp);
			}
			// Affichage id�es
			else if(req.getParameter("action").equals("view"))
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeView.jsp").forward(req, resp);
			}
		}
    }
}