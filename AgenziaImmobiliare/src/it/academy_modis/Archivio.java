package it.academy_modis;

import java.util.ArrayList;

public class Archivio {
	
	private ArrayList<Casa> V;
	private ArrayList<Casa> higher;
	private double somma;
	private int counter;
	
	public double getMediaOver(int n) {
		for(int i = 0; i < this.V.size(); i++) {
			if(this.V.get(i).getSuperficie() > n) {
				counter++;
				somma += this.V.get(i).costo();
			}
		}
		return somma / counter;
	}

	protected ArrayList<Casa> getV() {
		return V;
	}

	public Archivio(ArrayList<Casa> v) {
		super();
		V = v;
	}
	
	
}
