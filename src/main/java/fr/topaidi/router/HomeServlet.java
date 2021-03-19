package fr.topaidi.router;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.topaidi.entite.Category;
import fr.topaidi.service.CategorieService;
import fr.topaidi.service.IdeeService;


@WebServlet("/")
public class HomeServlet extends HttpServlet{
	
	@EJB
	private IdeeService ideeService;
	
	@EJB
	private CategorieService categorieService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Category category = new Category();
		category.setName("Litterature");
		categorieService.addCategories(category);
		Category category1 = new Category();
		category1.setName("Informatique");
		categorieService.addCategories(category1);
		Category category2 = new Category();
		category2.setName("Jeux-videos");
		categorieService.addCategories(category2);
		
		HttpSession session = req.getSession();
		req.setAttribute("isConnect", session.getAttribute("isConnect"));
		
		req.setAttribute("listIdee", ideeService.getListIdee());
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
	}
}