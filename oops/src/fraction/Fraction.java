package fraction;

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	//constructor
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		simplify();
	}
	
	
	//setter and getter
	public void setNumerator(int numerator) {
		this.numerator = numerator;
		simplify();
	}
	public int getNumerator() {
		return numerator;
	}
	
	public void setDenominator(int denominator) {
		if(denominator == 0)
			return;
		this.denominator = denominator;
		simplify();
	}
	
	public int getDemominator() {
		return denominator;
	}
	
	//functions or methods
	private void simplify() {
		int gcd = 1;
		int smallerNum = Math.min(numerator, denominator);
		for(int i=2; i<=smallerNum; i++) {
			if(numerator % i == 0 && denominator % i == 0) {
				gcd = i;
			}
		}
		
		numerator /= gcd;
		denominator /= gcd;
	}
	
	public void increment() {
		numerator += denominator;
		simplify();
	}
	
	public void print() {
		System.out.println(numerator+ "/" + denominator);
	}
	
	public void add(Fraction f2) {
		//f1 is the object which is calling the add function
		//f2 is the object being passed as argument;
		this.numerator = this.numerator * f2.denominator + f2.numerator * this.denominator;
		this.denominator = this.denominator * f2.denominator;
		simplify();
	}
 	
	public static Fraction add(Fraction f1, Fraction f2) {
		int newNum = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
		int newDeno = f1.denominator * f2.denominator;
		Fraction f3 = new Fraction(newNum, newDeno);
		return f3;
	}
	
}
