
public class Cliente {
	
	private int id;
	private String nome;
	private String cognome;
	private int cap;
	private String telefono;
	private String premium;
	
	public Cliente(int id, String nome, String cognome, int cap, String telefono, String premium) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cap = cap;
		this.telefono = telefono;
		this.premium = premium;
	}

	public Cliente(String nome, String cognome, int cap, String telefono, String premium) {
		this.nome = nome;
		this.cognome = cognome;
		this.cap = cap;
		this.telefono = telefono;
		this.premium = premium;
	}
	
	protected int getId() {
		return id;
	}

	protected String getNome() {
		return nome;
	}

	protected String getCognome() {
		return cognome;
	}

	protected int getCap() {
		return cap;
	}

	protected String getTelefono() {
		return telefono;
	}

	protected String getPremium() {
		return premium;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	
	
}
