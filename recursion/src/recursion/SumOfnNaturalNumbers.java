package recursion;

public class SumOfnNaturalNumbers {

	public static int sumOfNaturalNumbers(int n) {
		if(n==1)
			return 1;
		int smallOutput = sumOfNaturalNumbers(n-1);
		int output = n + smallOutput;
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(sumOfNaturalNumbers(10));

	}

}
