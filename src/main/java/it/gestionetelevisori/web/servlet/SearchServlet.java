package it.gestionetelevisori.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetelevisori.model.Televisore;
import it.gestionetelevisori.service.MyServiceFactory;
import it.gestionetelevisori.utility.NumberUtility;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// binding dati
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloDaPagina = request.getParameter("modelloInput");
		String codiceDaPagina = request.getParameter("codiceInput");
		String prezzoDaPagina = request.getParameter("prezzoInput");
		String polliciDaPagina = request.getParameter("polliciInput");

		try {
			// conversione
			Integer prezzoConvertito = NumberUtility.fromStringToInt(prezzoDaPagina);
			Integer polliciConvertito = NumberUtility.fromStringToInt(polliciDaPagina);

			Televisore inputDaPagina = new Televisore(marcaDaPagina, modelloDaPagina, prezzoConvertito,
					polliciConvertito, codiceDaPagina);

			request.setAttribute("listByExample",
					MyServiceFactory.getTelevisoreServiceInstance().trovaPer(inputDaPagina));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
