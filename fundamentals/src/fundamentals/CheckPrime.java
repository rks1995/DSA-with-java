package fundamentals;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {

		int n; 
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();


		for(int div = 2; div <= n/2; div++) {
			if(n % div == 0) {
				System.out.println("composite");
				return;
			}
				
		}

		System.out.println("Prime");
		sc.close();
	}

}
