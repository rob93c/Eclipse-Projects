
public class Fornitore {
	
	private int id;
	private String nome;
	private String indirizzo;
	private String telefono;
	private double costoTrasporto;
	
	public Fornitore(int id, String nome, String indirizzo, String telefono, double costoTrasporto) {
		super();
		this.id = id;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.costoTrasporto = costoTrasporto;
	}

	protected String getNome() {
		return nome;
	}
}
