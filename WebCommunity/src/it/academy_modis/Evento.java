package it.academy_modis;

public class Evento {
	
	private int id_categoria;
	private String nome;
	private String luogo;
	private String provincia;
	private String data;
	
	public Evento(int id_categoria, String nome, String luogo, String provincia, String data) {
		super();
		this.id_categoria = id_categoria;
		this.nome = nome;
		this.luogo = luogo;
		this.provincia = provincia;
		this.data = data;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public String getLuogo() {
		return luogo;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		String[] dataArr = data.split(" ");
		String[] formatted = dataArr[0].split("-");
		String prettyData = formatted[2] + "/" + formatted[1] + "/" + formatted[0];
		return "L'evento " + nome + " si terrà a " + luogo + " in data " + prettyData;
	}
	
	
}
