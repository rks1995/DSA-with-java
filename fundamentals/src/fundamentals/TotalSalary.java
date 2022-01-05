package fundamentals;

import java.util.Scanner;

public class TotalSalary {
		public static void main(String[] args) {
			// Write your code here
	        int sal, allow, totalSalary;
	        String Grade;
	        char ch;
	        
	        Scanner sc = new Scanner(System.in);
	        
	        sal = sc.nextInt();
	        Grade = sc.next();
			ch = Grade.charAt(0);
			
	        if(ch == 'A') {
	            allow = 1700;
	        }
	        else if(ch == 'B') {
	            allow = 1500;
	        }
	        else {
	            allow = 1300;
	        }
	        
	        double hra = .2 * sal;
	        double da = .5 * sal;
	        double pf = .11 * sal;
	        
	        System.out.println(hra + " " + " " + da + " " + pf);
	        totalSalary =(int) Math.round(sal + hra + da + allow - pf);
	        System.out.println(totalSalary);
	        
		}

}
