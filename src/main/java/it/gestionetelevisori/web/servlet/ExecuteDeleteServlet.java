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

@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreServiceInstance();
		try {
			Televisore televisoreDaRimuovere = televisoreServiceInstance
					.caricaSingolo(Long.parseLong(request.getParameter("idTelevisore")));
			televisoreServiceInstance.rimuovi(televisoreDaRimuovere);
			request.setAttribute("listByExample", televisoreServiceInstance.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
