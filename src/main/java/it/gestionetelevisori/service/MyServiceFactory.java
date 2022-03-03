package it.gestionetelevisori.service;

import it.gestionetelevisori.dao.MyDaoFactory;
import it.gestionetelevisori.service.televisore.TelevisoreService;
import it.gestionetelevisori.service.televisore.TelevisoreServiceImpl;

public class MyServiceFactory {
	// rendiamo questo factory SINGLETON
	private static TelevisoreService TELEVISORE_SERVICE_INSTANCE;

	public static TelevisoreService getTelevisoreServiceInstance() {
		if (TELEVISORE_SERVICE_INSTANCE == null)
			TELEVISORE_SERVICE_INSTANCE = new TelevisoreServiceImpl();

		TELEVISORE_SERVICE_INSTANCE.setTelevisoreDAO(MyDaoFactory.getTelevisoreDAOInstance());

		return TELEVISORE_SERVICE_INSTANCE;
	}
}
