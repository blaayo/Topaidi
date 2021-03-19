package fr.topaidi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.topaidi.service.CommentaireService;
import fr.topaidi.service.IdeeService;


@WebServlet("/idee")
public class IdeeServlet extends HttpServlet{
	

	@EJB
	private IdeeService ideeService;
	@EJB
	private CommentaireService commentaireService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		HttpSession session = req.getSession();
		
		req.setAttribute("isConnect", session.getAttribute("isConnect"));

		// AFFICHAGE CLASSEMENT
		if(req.getParameter("action").equals("classement")) 
		{
			/* attribue passé à la vue */
			req.setAttribute("listIdeeClassement", ideeService.getIdeeClassement());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeClassement.jsp").forward(req, resp);
		}
		// REDIRECTION CONNEXION PAGE
		else if( null == session.getAttribute("isConnect"))
		{
	        resp.sendRedirect("connexion?action=connexion");
		}
		else 
		{
			// AFFICHAGE FORM CREATE IDEA
			if(req.getParameter("action").equals("create"))
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeCreate.jsp").forward(req, resp);
			}
			// AFFICHAGE IDEA
			else if(req.getParameter("action").equals("view"))
			{
				/* attribue passé à la vue */
				Long ideeId = Long.parseLong(req.getParameter("view"));
				req.setAttribute( "idea", ideeService.getIdee(ideeId) );
				req.setAttribute( "comments", commentaireService.getCommentsByIdea(ideeId) );
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeView.jsp").forward(req, resp);
			}
		}
    }
}