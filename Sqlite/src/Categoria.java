
public class Categoria {
	
	private String categoria;
	private int giacenza;
	
	public Categoria(String categoria, int giacenza) {
		this.categoria = categoria;
		this.giacenza = giacenza;
	}

	protected String getCategoria() {
		return categoria;
	}

	protected int getGiacenza() {
		return giacenza;
	}	
}
