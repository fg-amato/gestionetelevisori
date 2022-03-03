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
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		boolean consideraMarca = !input.getMarca().isBlank();
		boolean consideraModello = !input.getModello().isBlank();
		boolean consideraCodice = !input.getCodice().isBlank();
		boolean consideraPrezzo = (input.getPrezzo() == null ? false : true);
		boolean consideraPollici = (input.getPollici() == null ? false : true);

		List<Televisore> result = new ArrayList<>();

		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (consideraMarca) {
				if (!televisoreItem.getMarca().startsWith(input.getMarca())) {
					continue; // passa alla prossima iterazione
				}
			}

			if (consideraModello) {
				if (!televisoreItem.getModello().startsWith(input.getModello())) {
					continue; // passa alla prossima iterazione
				}
			}

			if (consideraCodice) {
				if (!televisoreItem.getCodice().startsWith(input.getCodice())) {
					continue; // passa alla prossima iterazione
				}
			}

			if (consideraPollici) {
				if (!(televisoreItem.getPrezzo() < input.getPrezzo())) {
					continue; // passa alla prossima iterazione
				}
			}
			if (consideraPrezzo) {
				if (!(televisoreItem.getPollici() < input.getPollici())) {
					continue; // passa alla prossima iterazione
				}
			}
			result.add(televisoreItem);
		}
		return result;
	}

}
