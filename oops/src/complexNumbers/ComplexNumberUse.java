package complexNumbers;

public class ComplexNumberUse {

	public static void main(String[] args) {
		
//		ComplexNumber c1 = new ComplexNumber(2,3);
//		c1.print();
//		c1.setReal(10);
//		c1.setImg(8);
//		c1.print();
		
		ComplexNumber c2 = new ComplexNumber(2,3);
//		c1.add(c2);
//		c1.print();
//		c2.print();
		
		ComplexNumber c3 = new ComplexNumber(3,4);
//		c2.multiply(c3);
//		c2.print();
//		c3.print();
		
		ComplexNumber c4 = ComplexNumber.add(c2,c3);
		c2.print();
		c3.print();
		c4.print();
		
	}

}
