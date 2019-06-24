package it.academy_modis;

import java.util.Scanner;

/**
 * Class to create and manage
 * a tic tac toe grid
 * 
 * @author Roberto Cella
 *
 */
public class Grid {
	private char[][] grid;
	private char[] simboli = {'x', 'o'};
	private int move = 0;
	
	public Grid() {
		char[][] grid = new char[3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grid[i][j] = ' ';
			}
		}
		this.grid = grid;
	}
	
	/**
	 * check if the coordinates 
	 * given to the scanner
	 * are valid ones and,
	 * once a valid couple 
	 * is provided, adds the
	 * corresponding symbol
	 */
	public void getChoice() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Scegli la riga: ");
		int x = scanner.nextInt();
		System.out.print("Scegli la colonna: ");
		int y = scanner.nextInt();
		if(x < 3 & y < 3 && this.grid[x][y] == ' ') {
			this.grid[x][y] = simboli[move % 2];
			move++;
		} else {
			System.out.println("Inserisci una mossa valida");
			getChoice();
		}
	}
	
	/**
	 * 
	 * @return the grid
	 */
	public char[][] getGrid() {
		return this.grid;
	}
	
	/**
	 * 
	 * @return the move value
	 */
	public int getMossa() {
		return this.move;
	}
	
	/**
	 * 
	 * @return if the current player won
	 */
	public boolean checkWinner() {
		if(move >= 5) {
			if((grid[0][0] == grid[1][1] & 
				grid[1][1] == grid[2][2] & 
				grid[1][1] != ' ') 		||
				grid[2][0] == grid[1][1] & 
				grid[1][1] == grid[0][2] & 
				grid[1][1] != ' ') 
				return true;
			for(int i = 0; i < 3; i++) {
				if(grid[i][0] == grid[i][1] & 
				   grid[i][1] == grid[i][2] & 
				   grid[i][1] != ' ')
					return true;
				if(grid[0][i] == grid[1][i] & 
				   grid[1][i] == grid[2][i] & 
				   grid[1][i] != ' ')
					return true;
			}
		}
		return false;
	}
}
