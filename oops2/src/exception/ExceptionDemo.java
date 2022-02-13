package exception;

public class ExceptionDemo {

	public static int fact(int n) throws NegativeNumberException {
		if(n < 0) {
			throw new NegativeNumberException();
		}
		
		int result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
	}
	public static int divide(int a, int b) throws DivideByZero {
		if(b == 0) {
			throw new DivideByZero();
		}
		return a / b;
	}
	public static void main(String[] args){
		try {
			
			divide(10, 3);
			System.out.println(fact(-1));
			
		} catch(DivideByZero e) {
			
			System.out.println(e.getMessage());
			
			
		} catch (NegativeNumberException e) {
			
			System.out.println(e.getMessage());
			
		}
		System.out.println("Main");

	}

}
