package pattern;

import java.util.Scanner;

public class TrianglePattern2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int num = 1, row = 1;
		
		while(row <= n) {
			int col = 1;
			while(col <= row) {
				System.out.print(num);
				num++;
				col++;
			}
			System.out.println();
			row++;
		}

	}

}
