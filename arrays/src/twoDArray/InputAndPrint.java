package twoDArray;

import java.util.Scanner;

public class InputAndPrint {

	public static void printArray(int[][] arr, int row, int col) {
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void takeInput(int[][] arr, int row, int col) {
		
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		s.close();
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of 2dArray: row & col: ");
		int row = s.nextInt();
		int col = s.nextInt();
		int[][] arr = new int[row][col];
		
		takeInput(arr, row, col);
		printArray(arr, row, col);
		s.close();

	}

}
