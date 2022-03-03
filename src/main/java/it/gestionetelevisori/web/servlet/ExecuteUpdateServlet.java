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

@WebServlet("/ExecuteUpdateServlet")
public class ExecuteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// binding dati
		String marca = request.getParameter("marcaInput");
		String modello = request.getParameter("modelloInput");
		String pollici = request.getParameter("numeroPolliciInput");
		String prezzo = request.getParameter("prezzoInput");
		String codice = request.getParameter("codiceInput");

		// conversione
		Integer polliciInt = NumberUtility.fromStringToInt(pollici);
		Integer prezzoInt = NumberUtility.fromStringToInt(prezzo);

		if (marca.isBlank() || modello.isBlank() || polliciInt <= 0 || prezzoInt <= 0 || codice.isBlank()) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare tutti i campi correttamente.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.getRequestDispatcher("modifica.jsp").forward(request, response);
			return;
		}

		TelevisoreService televisoreServiceInstance = MyServiceFactory.getTelevisoreServiceInstance();
		try {
			Long idTelevisoreDaAggiornare = Long.parseLong(request.getParameter("idTelevisore"));
			Televisore televisoreAggiornato = new Televisore(idTelevisoreDaAggiornare, marca, modello, prezzoInt,
					polliciInt, codice);
			televisoreServiceInstance.aggiorna(televisoreAggiornato);
			request.setAttribute("listByExample", televisoreServiceInstance.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
