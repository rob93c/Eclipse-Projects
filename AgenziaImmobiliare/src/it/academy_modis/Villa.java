package it.academy_modis;

public class Villa extends Casa {

	private boolean conPiscina;
	private int somma;
	
	protected Villa(int superficie, int numeroStanze, boolean conPiscina) {
		super(superficie, numeroStanze);
		this.conPiscina = conPiscina;
	}

	@Override
	protected int costo() {
		somma = (this.getSuperficie() * 2000);
		if(this.conPiscina && this.getNumeroStanze() > 9) {
			somma += 30000;
		} else if(this.conPiscina) {
			somma += 20000;
		} else if(this.getNumeroStanze() > 9) {
			somma += 10000;
		}
		return somma;
	}
}
