package fundamentals;

import java.util.Scanner;

public class ConditionalOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		if((a > 0 && b < 0) || (a < 0 && b > 0)) {
			System.out.println("one of them is positive and one of them is negative");
		}
		else {
			System.out.println("error");
		}
		
		sc.close();

	}

}
