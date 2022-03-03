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
import it.gestionetelevisori.utility.NumberUtility;

@WebServlet("/ExecuteInsertServlet")
public class ExecuteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// binding dati
		String marca = request.getParameter("marcaInput");
		String modello = request.getParameter("modelloInput");
		String pollici = request.getParameter("prezzoInput");
		String prezzo = request.getParameter("codiceInput");
		String codice = request.getParameter("polliciInput");

		// conversione
		Integer polliciInt = NumberUtility.fromStringToInt(pollici);
		Integer prezzoInt = NumberUtility.fromStringToInt(prezzo);

		if (marca.isBlank() || modello.isBlank() || polliciInt <= 0 || prezzoInt <= 0 || codice.isBlank()) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare tutti i campi correttamente.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		Televisore nuovoTelevisore = new Televisore(marca, modello, prezzoInt, polliciInt, codice);
		TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreServiceInstance();

		try {
			televisoreServiceInstance.inserisciNuovo(nuovoTelevisore);
			request.setAttribute("listByExample", televisoreServiceInstance.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
