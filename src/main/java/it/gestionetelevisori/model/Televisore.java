package it.gestionetelevisori.model;

public class Televisore {
	private Long id;
	private String marca;
	private String modello;
	private Integer prezzo;
	private Integer pollici;
	private String codice;

	public Televisore() {
		super();
	}

	public Televisore(String marca, String modello, Integer prezzo, Integer pollici, String codice) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.pollici = pollici;
		this.codice = codice;
	}

	public Televisore(Long id, String marca, String modello, Integer prezzo, Integer pollici, String codice) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.prezzo = prezzo;
		this.pollici = pollici;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getPollici() {
		return pollici;
	}

	public void setPollici(Integer pollici) {
		this.pollici = pollici;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
