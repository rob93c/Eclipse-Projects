package it.academy_modis;


/**
 * Main class to start
 * a tic tac toe game
 * 
 * @author Roberto Cella
 *
 */
public class Main {

	public static void main(String[] args) {
		Grid gioco = new Grid();
		
		while(!gioco.checkWinner()) {
			System.out.println("Giocatore " + ((gioco.getMossa() % 2) + 1) + 
								" scegli dove inserire il tuo simbolo.");
			gioco.getChoice();
			System.out.println(gioco.getGrid()[0][0] + "|" +
							   gioco.getGrid()[0][1] + "|" +
							   gioco.getGrid()[0][2] + "\n" +
							   gioco.getGrid()[1][0] + "|" +
							   gioco.getGrid()[1][1] + "|" +
							   gioco.getGrid()[1][2] + "\n" +
							   gioco.getGrid()[2][0] + "|" +
							   gioco.getGrid()[2][1] + "|" +
							   gioco.getGrid()[2][2] + "\n");
		}
		System.out.println("Complimenti giocatore " + 
							(((gioco.getMossa() - 1) % 2) + 1) 
							+ ", hai vinto!");

	}

}
