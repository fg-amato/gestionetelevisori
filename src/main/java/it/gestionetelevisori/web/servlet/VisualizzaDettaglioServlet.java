package it.gestionetelevisori.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetelevisori.model.Televisore;
import it.gestionetelevisori.service.MyServiceFactory;
import it.gestionetelevisori.service.televisore.TelevisoreService;

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDelTelevisoreDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");

		TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreServiceInstance();

		Televisore result = null;
		try {
			result = televisoreServiceInstance
					.caricaSingolo(Long.parseLong(parametroIdDelTelevisoreDiCuiVoglioIlDettaglio));
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("televisoreDaInviareAPaginaDettalio", result);

		request.getRequestDispatcher("dettaglio.jsp").forward(request, response);
	}

}
