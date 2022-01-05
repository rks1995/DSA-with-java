package pattern;

import java.util.Scanner;

public class PatternOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		
		int row = 1;
		
		while(row <= n) {
			int col = 1;
			while(col <=n) {
				System.out.print("*");
				col++;
			}
			System.out.println();
			row++;
		}

	}

}
