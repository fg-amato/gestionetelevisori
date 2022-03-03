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
		LISTA_TELEVISORI.add(new Televisore(1l, "Sony", "Modello2", 400, 42, "SONYM2"));
		LISTA_TELEVISORI.add(new Televisore(2l, "Samsung", "Modello3", 430, 450, "SAMSUNGM3"));
		LISTA_TELEVISORI.add(new Televisore(3l, "LG", "Modello4", 250, 27, "LGM4"));
		LISTA_TELEVISORI.add(new Televisore(4l, "Panasonic", "Modello5",360, 32, "PAM5"));
		LISTA_TELEVISORI.add(new Televisore(5l, "Xiaomi", "Modello6", 699, 60, "XIAOMIM6"));
		LISTA_TELEVISORI.add(new Televisore(6l, "Papapa", "Modello7", 750, 65, "PAPAM7"));
		LISTA_TELEVISORI.add(new Televisore(7l, "Telefunken", "Modello8", 150, 19, "TELEFUNKENM8"));
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
