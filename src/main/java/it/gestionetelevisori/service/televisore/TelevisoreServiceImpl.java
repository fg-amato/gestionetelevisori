package it.gestionetelevisori.service.televisore;

import java.util.List;

import it.gestionetelevisori.dao.televisore.TelevisoreDAO;
import it.gestionetelevisori.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {
	private TelevisoreDAO televisoreDAO;

	@Override
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;
	}

	@Override
	public List<Televisore> trovaPer(Televisore input) throws Exception {
		return televisoreDAO.findByExample(input);
	}

	@Override
	public Televisore caricaSingolo(Long id) throws Exception {
		return televisoreDAO.get(id);
	}

	@Override
	public void inserisciNuovo(Televisore televisoreInput) throws Exception {
		televisoreDAO.insert(televisoreInput);
	}

	@Override
	public List<Televisore> listAll() throws Exception {
		return televisoreDAO.list();
	}

	@Override
	public void rimuovi(Televisore televisoreDaRimuovere) throws Exception {
		televisoreDAO.delete(televisoreDaRimuovere);
	}

	@Override
	public void aggiorna(Televisore televisoreDaAggiornare) throws Exception {
		televisoreDAO.update(televisoreDaAggiornare);
	}

}
