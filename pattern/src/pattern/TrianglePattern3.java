package pattern;

import java.util.Scanner;

public class TrianglePattern3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int row =  1;
		
		while(row <= n) {
			int num = row;
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
