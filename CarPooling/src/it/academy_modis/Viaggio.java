package it.academy_modis;

public class Viaggio {
	
	private int id_viaggio;
	private int id_autista;
	private String partenza;
	private String arrivo;
	private String data;
	private String ora;
	private int prezzo;
	private int durata;
	private int soste;
	private int animali;
	private int bagagli;
	private int prenotazione;
	// TODO Durata
	
	public Viaggio(int id_viaggio, int id_autista, String partenza, String arrivo, String data, String ora, 
						int prezzo, int durata, int soste, int animali, int bagagli, int prenotazione) {
		super();
		this.id_viaggio = id_viaggio;
		this.id_autista = id_autista;
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.data = data;
		this.ora = ora;
		this.prezzo = prezzo;
		this.durata = durata;
		this.soste = soste;
		this.animali = animali;
		this.bagagli = bagagli;
		this.prenotazione = prenotazione;
	}

	protected String getPartenza() {
		return partenza;
	}

	protected String getArrivo() {
		return arrivo;
	}

	protected String getData() {
		return data;
	}

	protected String getOra() {
		return ora;
	}

	protected int getPrezzo() {
		return prezzo;
	}

	protected int getSoste() {
		return soste;
	}

	protected int getAnimali() {
		return animali;
	}

	protected int getBagagli() {
		return bagagli;
	}

	protected int getPrenotazione() {
		return prenotazione;
	}

	protected int getDurata() {
		return durata;
	}

	protected int getId_viaggio() {
		return id_viaggio;
	}

	protected int getId_autista() {
		return id_autista;
	}

	
	public String printViaggio() {
		String[] data = getData().split(" ");
		String[] formatted = data[0].split("-");
		String prettyData = formatted[2] + "/" + formatted[1] + "/" + formatted[0];
		return ("ID viaggio: " + this.id_viaggio + " da " + this.partenza + " a " + this.arrivo + " in data " + prettyData 
				+ " alle ore " + this.ora + " al prezzo di " + this.prezzo + "€");
	}
	
	
}
