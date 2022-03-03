package it.gestionetelevisori.dao.televisore;

import java.sql.Connection;

import it.gestionetelevisori.dao.IBaseDAO;
import it.gestionetelevisori.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {

	public void setConnection(Connection connection);

}
