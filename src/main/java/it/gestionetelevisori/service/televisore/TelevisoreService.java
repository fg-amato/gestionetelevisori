package it.gestionetelevisori.service.televisore;

import java.util.List;

import it.gestionetelevisori.dao.televisore.TelevisoreDAO;
import it.gestionetelevisori.model.Televisore;

public interface TelevisoreService {
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO);

	public List<Televisore> trovaPer(Televisore input) throws Exception;

	public Televisore caricaSingolo(Long id) throws Exception;

	public void inserisciNuovo(Televisore televisoreInput) throws Exception;

	public List<Televisore> listAll() throws Exception;

	public void rimuovi(Televisore televisoreDaRimuovere) throws Exception;

	public void aggiorna(Televisore televisoreDaAggiornare) throws Exception;
}
