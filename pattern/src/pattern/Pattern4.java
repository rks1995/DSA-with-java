package pattern;

import java.util.Scanner;

public class Pattern4 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		int row = 1;
		while(row <= n) {
			int col = n;
			while(col >= 1) {
				System.out.print(col);
				col--;
			}
			System.out.println();
			row++;
		}

	}

}
