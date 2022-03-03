package it.gestionetelevisori.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.gestionetelevisori.model.Televisore;

public class DB_Mock {
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore(1l, "Marca1", "Modello1", 400, 42, "MM1"));
		LISTA_TELEVISORI.add(new Televisore(2l, "Marca2", "Modello2", 430, 450, "MM2"));
		LISTA_TELEVISORI.add(new Televisore(3l, "Marca3", "Modello3", 250, 27, "MM3"));
		LISTA_TELEVISORI.add(new Televisore(4l, "Marca4", "Modello4",360, 32, "MM4"));
		LISTA_TELEVISORI.add(new Televisore(5l, "Marca5", "Modello5", 699, 60, "MM5"));
		LISTA_TELEVISORI.add(new Televisore(6l, "Marca6", "Modello6", 750, 65, "MM6"));
		LISTA_TELEVISORI.add(new Televisore(7l, "Marca7", "Modello7", 150, 19, "MM7"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId = LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getId)).get().getId();
		return ++resultId;
	}

}
