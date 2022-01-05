package pattern;

import java.util.Scanner;

public class CharacterPattern {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int row = 1;
		
		while(row <= n) {
			char ch = 'A';
			int col = 1;
			while(col <= n) {
				System.out.print(ch);
				ch = (char)(ch + 1);
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
