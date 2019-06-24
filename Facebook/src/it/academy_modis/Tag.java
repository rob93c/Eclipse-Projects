package it.academy_modis;

import java.util.ArrayList;

public class Tag {
	
	private ArrayList<Foto> fotografie;
	private Amico[] amici;
	private int numAmici;
	private final int MAX_NUM_AMICI = 200;
	private double somma;
	private int counter;
	
	public Tag(ArrayList<Foto> fotografie) {
//		ArrayList<Foto> fotografie = new ArrayList<>();
		this.fotografie = fotografie;
		this.amici = new Amico[MAX_NUM_AMICI];
		this.numAmici = 0;
	}
	
	public void aggFoto(String titolo) { // :-(
		for(Foto f: fotografie) {
			if(f.getTitolo().equals(titolo)) {
				System.out.println("Questa foto è già stata caricata!");
				break;
			} else {
				fotografie.add(new Foto(titolo));
			}
		}
	}
	
	public void aggAmico(String unNomeAmico, String unCognomeAmico, int unEta) {
		for(int i = 0; i < amici.length; i++) {
			if(amici[i] != null) { // numAmici > 0
				if(amici[i].getNome().equalsIgnoreCase(unNomeAmico) &
						amici[i].getCognome().equalsIgnoreCase(unCognomeAmico) &
						amici[i].getEta() == unEta) {
					System.out.println("Questo amico è già stato aggiunto!");
					return;
				}
			}
		}
		for(int j = 0; j < amici.length; j++) {
			if(amici[j] == null) {
				amici[j] = new Amico(unNomeAmico, unCognomeAmico, unEta);
				System.out.println("Amico aggiunto!");
				break;
			}
		}
		numAmici++;
	}
	
	public void stampaAmici() {
		for(int i = 0; i < amici.length; i++) {
			if(amici[i] != null) {
				System.out.println(amici[i].getNome() + " " + amici[i].getCognome());
			}
		}
	}
	
	public void addTag(String unTitolo, String unNomeAmico, String unCognomeAmico, int unEta) {
		Amico amico = new Amico(unNomeAmico, unCognomeAmico, unEta);
//		Foto foto = new Foto(unTitolo, amico);
		for(Foto f: fotografie) {
			if(f.getAmico() != null) {
				if(f.getTitolo().equalsIgnoreCase(unTitolo)) {
					aggAmico(unNomeAmico, unCognomeAmico, unEta);
					f.setAmico(amico);
				}
			}
		}
		System.out.println(unNomeAmico + " " + unCognomeAmico + " è stato taggato nella foto.");
	}

	public void rimuoviAmico(String unNomeAmico, String unCognomeAmico, int unEta) {
		for(int i = 0; i < amici.length; i++) {
			if(amici[i] != null) {
				if(amici[i].getNome().equalsIgnoreCase(unNomeAmico) &
					amici[i].getCognome().equalsIgnoreCase(unCognomeAmico) &
					amici[i].getEta() == unEta) {
					amici[i] = null;
					System.out.println("L'amico " + unNomeAmico + " " + unCognomeAmico + " è stato rimosso dagli amici.");
					numAmici--;
				}
			}
		}
	}
	
	public double calcolaEtaMedia() {
		for(Amico a: amici) {
			if(a != null) {
				somma += a.getEta();
			}
		}
		return somma / numAmici;
	}
	
	public int contaFotoAmico(String unNomeAmico, String unCognomeAmico, int unEta) {
		for(Foto f: fotografie) {
			if(f.getAmico() != null) {
				if(f.getAmico().getNome().equalsIgnoreCase(unNomeAmico) & 
						f.getAmico().getCognome().equalsIgnoreCase(unCognomeAmico) &
						f.getAmico().getEta() == unEta) {
					counter++;
				}
			}
		}
		return counter;
	}
	
//	public Amico calcolaMaxApparizioni() {
//		int totApparizioni = 0;
//		int index = 0;
//		for(int i = 0; i < fotografie.size(); i++) {
//			if(contaFotoAmico(fotografie.get(i).getAmico().getNome(), 
//						fotografie.get(i).getAmico().getCognome(),
//						fotografie.get(i).getAmico().getEta()) > totApparizioni)
//				
//				totApparizioni = contaFotoAmico(fotografie.get(i).getAmico().getNome(), 
//						fotografie.get(i).getAmico().getCognome(),
//						fotografie.get(i).getAmico().getEta());
//				index = i;
//		}
//		return fotografie.get(index).getAmico();
//	}
	
	public Amico calcolaMaxApparizioni() {
		int totApparizioni = 0;
		int index = 0;
		for(int i = 0; i < amici.length; i++) {
			if(amici[i] != null) {
				if(contaFotoAmico(amici[i].getNome(), amici[i].getCognome(),
									amici[i].getEta()) > totApparizioni) {
					
					totApparizioni = contaFotoAmico(amici[i].getNome(), amici[i].getCognome(),
							amici[i].getEta());
					index = i;
					
				}
			}
		}
		return amici[index];
	}
	
	protected ArrayList<Foto> getFotografie() {
		return fotografie;
	}

	protected Amico[] getAmici() {
		return amici;
	}

	protected int getNumAmici() {
		return numAmici;
	}
	
	
}
