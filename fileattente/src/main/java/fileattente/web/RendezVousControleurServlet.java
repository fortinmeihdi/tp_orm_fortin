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
import fileattente.modele.Civilite;
import fileattente.modele.FileAttentePleineException;
import fileattente.modele.RendezVousInvalideException;

@WebServlet("/rendezvous")
public class RendezVousControleurServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@EJB
	private AttenteService attenteService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardVueRendezVous(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Civilite civilite = Civilite.valueOf(req.getParameter("civilite"));
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		boolean urgent = Boolean.valueOf(req.getParameter("urgent"));
		try {
			attenteService.mettreEnAttente(civilite, prenom, nom, urgent);
			resp.sendRedirect("attente");
		} catch (RendezVousInvalideException e) {
			req.setAttribute("errors", e.getMessages());
			forwardVueRendezVous(req, resp);
		} catch (FileAttentePleineException e) {
			resp.sendRedirect("attente");
		}
	}

	private void forwardVueRendezVous(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/rendezvous.jsp");
		rd.forward(req, resp);
	}
	
}
