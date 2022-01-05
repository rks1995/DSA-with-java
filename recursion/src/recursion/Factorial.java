package recursion;

public class Factorial {

	public static int factorial(int n) {
		if(n==1)
			return 1;
		int smallOutput = factorial(n-1);
		
		return n*smallOutput;
	}
	
	public static void main(String[] args) {
		int ans = factorial(5);
		System.out.println(ans);
	}

}
