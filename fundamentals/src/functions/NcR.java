package functions;

import java.util.Scanner;

public class NcR {
	
	public static int factorial(int n) {
		int fact = 1;
		
		for(int i=2; i<=n; i++) {
			fact *= i;
		}
		
		return fact;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int r = s.nextInt();
		
		int factN = factorial(n);
		int factR = factorial(r);
		int factNR = factorial(n-r);
		
		int result = factN / (factR * factNR);
		System.out.println(result);
		s.close();

	}

}
