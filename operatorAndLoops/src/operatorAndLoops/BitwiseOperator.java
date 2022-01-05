package operatorAndLoops;

import java.util.Scanner;

public class BitwiseOperator {

	public static void main(String[] args) {
//		int a = 2 + 10 - 3 + 1;
//		System.out.println(a);
		
		Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int a = s.nextInt();
        boolean isGood = true;
        
        for(int i=2; i<=n; i++) {
            int b = s.nextInt();
            
            if(i <= n/2+1 && a <= b) {
                isGood = false;
                break;
            }
            else if(i > n/2+1 && a > b) {
                isGood = false;
                break;
            }
            
            a = b;
        }
    	System.out.print(isGood);

	}

}
