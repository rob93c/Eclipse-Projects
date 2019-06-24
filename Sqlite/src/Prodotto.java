
public class Prodotto {
	
	private int id;
	private String nome;
	private String categoria;
	private double prezzoU;
	private int scorta;
	private String descrizione;
	private Fornitore fornitore;
	
	public Prodotto(int id, String nome, String categoria, double prezzoU, 
			int scorta, String descrizione, Fornitore fornitore) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoU = prezzoU;
		this.scorta = scorta;
		this.descrizione = descrizione;
		this.fornitore = fornitore;
	}

	protected String getNome() {
		return nome;
	}

	protected Fornitore getFornitore() {
		return fornitore;
	}
	
	
	
}
