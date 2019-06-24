package it.academy_modis;

public class Appartamento extends Casa {

	private int codiceEnergetico;
//	private int somma;
	
	protected Appartamento(int superficie, int numeroStanze, int codiceEnergetico) {
		super(superficie, numeroStanze);
		this.codiceEnergetico = codiceEnergetico;
	}

	@Override
	protected int costo() {
		return (this.getSuperficie() * 1500) + (this.getNumeroStanze() * this.codiceEnergetico);
	}
	
}
