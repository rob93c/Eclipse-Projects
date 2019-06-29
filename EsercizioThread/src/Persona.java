
public class Persona implements Runnable {
	
	private static Persona persona;
	private String stato;
	
	public static Persona getIstance() {
		if(persona == null) {
			persona = new Persona();
			persona.stato = Stato.IN_ATTESA.getMessaggio();
		}
		return persona;
	}
	
	public synchronized void osserva() throws InterruptedException {
		this.stato = Stato.OSSERVAZIONE.getMessaggio();
		System.out.println(Thread.currentThread().getName() + ": " + stato);
		
		Thread.sleep(3000);
		
		this.stato = Stato.FINITO.getMessaggio();
		System.out.println(Thread.currentThread().getName() + ": " + stato);
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " è in coda.");
			System.out.println("----------------------");
			Persona.getIstance().osserva();
			System.out.println("----------------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName() + ": " + this.stato;
	}
	
}
