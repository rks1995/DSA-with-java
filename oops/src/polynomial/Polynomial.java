package polynomial;

import dynamicArrays.DynamicArray;

public class Polynomial {
	
	DynamicArray coeffecient = new DynamicArray();
	
	public void setCoefficient(int deg, int coeff) {
		coeffecient.setCoeff(deg, coeff);
	}
	
	public void print() {
		for(int i=0; i<coeffecient.size()+1; i++) {
			if(coeffecient.getCoeff(i) != 0) {
				System.out.print(coeffecient.getCoeff(i) + "x^" + i + " + ");
			}
		}
	}
}
