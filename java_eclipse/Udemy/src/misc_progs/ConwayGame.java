package misc_progs;

import java.util.Scanner;

public class ConwayGame {

	private static ConwayCell[][] conwayGrid;
	private static boolean[][] conwayQueue;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of rows: ");
		int numRow = scanner.nextInt();

		System.out.print("Enter number of cols: ");
		int numCol = scanner.nextInt();

		conwayGrid = new ConwayCell[numRow][numCol];
		conwayQueue = new boolean[numRow][numCol];

		initialize();

		for (int row = 0; row < numRow; row++) {
			System.out.print("Enter " + numCol + " elements of row " + (row + 1) + ": ");
			for (int col = 0; col < numCol; col++) {
				if (scanner.nextInt() == 1) {
					conwayGrid[row][col].revive();
					conwayQueue[row][col] = true;
				}
			}
		}

		print();
		
		while(true) {
			if (scanner.nextInt() == 1) {
				step();
				print();
			}
			
		}
	}

	public static void initialize() {
		for (int i = 0; i < conwayGrid.length; i++) {
			for (int j = 0; j < conwayGrid[0].length; j++) {
				conwayGrid[i][j] = new ConwayCell(i, j);
				conwayQueue[i][j] = false;
			}
		}
	}

	public static void step() {
		for (int i = 0; i < conwayGrid.length; i++) {
			for (int j = 0; j < conwayGrid[0].length; j++) {
				conwayGrid[i][j].act();
			}
		}
		for (int i = 0; i < conwayGrid.length; i++) {
			for (int j = 0; j < conwayGrid[0].length; j++) {
				if (conwayQueue[i][j]) {
					conwayGrid[i][j].revive();
				} 
				else {
					conwayGrid[i][j].kill();
				}
			}
		}
	}

	public static void print() {
		for (int i = 0; i < conwayGrid.length; i++) {
			for (int j = 0; j < conwayGrid[0].length; j++) {
				if (conwayGrid[i][j].isAlive()) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println("");
		}
	}

	public static void queueKill(int i, int j) {
		conwayQueue[i][j] = false;
	}

	public static void queueRevive(int i, int j) {
		conwayQueue[i][j] = true;
	}

	public static boolean isCellAlive(int i, int j) {
		return conwayGrid[i][j].isAlive();
	}

	public static int length() {
		return conwayGrid[0].length;
	}

	public static int height() {
		return conwayGrid.length;
	}

}
