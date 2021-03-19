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

import fr.topaidi.entite.Category;
import fr.topaidi.entite.Idea;
import fr.topaidi.service.CategorieService;
import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Users;
import fr.topaidi.service.CommentaireService;

import fr.topaidi.service.IdeeService;




@WebServlet("/idee")
public class IdeeServlet extends HttpServlet{
	

	@EJB
	private IdeeService ideeService;
	@EJB
	private CommentaireService commentaireService;
	
	@EJB private CategorieService categorieService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		HttpSession session = req.getSession();
		
		req.setAttribute("isConnect", session.getAttribute("isConnect"));

		// AFFICHAGE CLASSEMENT
		if(req.getParameter("action").equals("classement")) 
		{
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
				req.setAttribute("categories", categorieService.getCategories());
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeCreate.jsp").forward(req, resp);
			}
			// AFFICHAGE IDEA
			else if(req.getParameter("action").equals("view"))
			{
				Long ideeId = Long.parseLong(req.getParameter("view"));
				
				req.setAttribute( "idea", ideeService.getIdee(ideeId) );
				req.setAttribute( "comments", commentaireService.getCommentsByIdea(ideeId) );
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeView.jsp").forward(req, resp);
			}
		}
    }
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		
		// AJOUT DE COMMENTAIRE
		if(req.getParameter("action").equals("addCommentaire")) 
		{
			Commentaires commentaire = new Commentaires();
			Long ideeId = Long.parseLong(req.getParameter("idea"));
			
			commentaire.setContent(req.getParameter("commentaire"));
			commentaire.setUser((Users) session.getAttribute("user"));
			commentaire.setIdea(ideeService.getIdee(ideeId));
			
			commentaireService.addCommentaire(commentaire);
			
			req.setAttribute( "idea", ideeService.getIdee(ideeId) );
			req.setAttribute( "comments", commentaireService.getCommentsByIdea(ideeId) );
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/ideeView.jsp").forward(req, resp);
		}
		
		Idea idee = new Idea();
		Category cat = new Category();
		cat.setName(req.getParameter("categorie"));
		idee.setNom(req.getParameter("titre"));
		//idee.setCategory(cat);
		idee.setCreatedAt(new Date());
		idee.setDescription(req.getParameter("description"));
		idee.setImage(req.getParameter("image"));
	}
	

}