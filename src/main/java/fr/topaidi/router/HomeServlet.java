package fr.topaidi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.topaidi.service.IdeeService;


@WebServlet("/")
public class HomeServlet extends HttpServlet{
	
	@EJB
	private IdeeService ideeService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		req.setAttribute("isConnect", session.getAttribute("isConnect"));
		
		req.setAttribute("listIdee", ideeService.getListIdee());
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
	}
}