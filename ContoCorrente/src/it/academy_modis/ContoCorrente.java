package it.academy_modis;

public class ContoCorrente {
	
	private double saldo;
	private String nomeECognome;
	private int codiceConto;
	private static int numeroConto = 9000;
	private static double tassoInteresse = 0.02;
	
	public ContoCorrente(String intestatario, double saldoIniziale) {
		this.nomeECognome = intestatario;
		this.saldo = saldoIniziale;
		numeroConto++;
		this.codiceConto = numeroConto;
	}
	
	public ContoCorrente(double saldoIniziale) {
		super();
		this.saldo = saldoIniziale;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void versa(double somma) {
		this.saldo += somma;
	}
	
	public void preleva(double somma) {
		this.saldo -= somma;
	}

	public String getNomeECognome() {
		return nomeECognome;
	}

	public void setNomeECognome(String nomeECognome) {
		this.nomeECognome = nomeECognome;
	}

	public static double getTassoInteresse() {
		return tassoInteresse;
	}

	public static void setTassoInteresse(double tassoInteresse) {
		ContoCorrente.tassoInteresse = tassoInteresse;
	}
	
	public void stampaSaldo() {
		System.out.println("Il saldo del conto corrente " + this.codiceConto +
				" di " + this.getNomeECognome() + " è: " + this.saldo);
	}
	
	public void calcolaInteresse() {
		this.saldo += this.saldo * ContoCorrente.tassoInteresse;
	}
	
	
}
