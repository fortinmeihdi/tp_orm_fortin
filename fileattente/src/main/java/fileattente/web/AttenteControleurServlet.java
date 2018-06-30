package fileattente.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileattente.modele.AttenteService;

@WebServlet(loadOnStartup = 0, urlPatterns = "/attente")
public class AttenteControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private AttenteService attenteService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardVueFileAttente(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("suivant".equals(action)) {
			attenteService.passerAuSuivant();
		}
		forwardVueFileAttente(req, resp);
	}

	private void forwardVueFileAttente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("file", attenteService.getFile());
		req.setAttribute("filePleine", attenteService.isFilePleine());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/fileattente.jsp");
		rd.forward(req, resp);
	}
}
