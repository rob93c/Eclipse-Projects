import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	enum StatoPersona  {
		IN_ATTESA,
		OSSERVAZIONE,
		FINITO;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();
		Persona p4 = new Persona();
		Persona p5 = new Persona();
		Persona p6 = new Persona();
		Persona p7 = new Persona();
		Persona p8 = new Persona();
		Persona p9 = new Persona();
		Persona p10 = new Persona();
//-----------------------------------------
		Thread th1 = new Thread(p1);
		Thread th2 = new Thread(p2);
		th1.start();
		th2.start();
		th1.join();
		th2.join();

		
	}
	
}
