package fundamentals;

import java.util.Scanner;

public class NestedIfElse {

	public static void main(String[] args) {

		int a, b;

		Scanner sc =  new Scanner(System.in);

		a = sc.nextInt();
		b = sc.nextInt();

		if(a > b) {
			System.out.println("a is greater");
		}
		else if(a < b) {
			System.out.println("b is greater");
		}
		else {
			System.out.println("Both are equal");
		}
		
		sc.close();
	}
}

