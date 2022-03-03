package it.gestionetelevisori.dao.televisore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.gestionetelevisori.dao.DB_Mock;
import it.gestionetelevisori.model.Televisore;

public class TelevisoreDAOImpl implements TelevisoreDAO {

	private Connection connection;

	@Override
	public List<Televisore> list() throws Exception {
		return DB_Mock.LISTA_TELEVISORI;
	}

	@Override
	public Televisore get(Long id) throws Exception {

		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getId().equals(id)) {
				return televisoreItem;
			}
		}
		return null;
	}

	@Override
	public int update(Televisore input) throws Exception {
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getId().equals(input.getId())) {
				televisoreItem.setMarca(input.getMarca());
				televisoreItem.setModello(input.getModello());
				televisoreItem.setPollici(input.getPollici());
				televisoreItem.setPrezzo(input.getPrezzo());
				televisoreItem.setCodice(input.getCodice());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		input.setId(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_TELEVISORI.add(input) ? 1 : 0;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		for (int i = 0; i < DB_Mock.LISTA_TELEVISORI.size(); i++) {
			if (DB_Mock.LISTA_TELEVISORI.get(i).getId().equals(input.getId())) {
				DB_Mock.LISTA_TELEVISORI.remove(i);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		List<Televisore> result = new ArrayList<>();
		List<Televisore> televisoriInLista = this.list();
		for (Televisore televisoreItem : televisoriInLista) {
			if (televisoreItem.getMarca().startsWith(input.getMarca())
					&& televisoreItem.getModello().startsWith(input.getModello())
					&& televisoreItem.getCodice().startsWith(input.getCodice())
					&& televisoreItem.getPrezzo() > input.getPrezzo()
					&& televisoreItem.getPollici() > input.getPollici()) {
				result.add(televisoreItem);
			}
		}
		return result;
	}

}
