package it.academy_modis;

public abstract class Casa {
	private int superficie;
	private int numeroStanze;
	
	
	protected Casa(int superficie, int numeroStanze) {
		this.superficie = superficie;
		this.numeroStanze = numeroStanze;
	}
	
	protected abstract int costo();

	protected int getSuperficie() {
		return superficie;
	}

	protected int getNumeroStanze() {
		return numeroStanze;
	}
	
	
}
