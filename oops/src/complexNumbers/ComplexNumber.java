package complexNumbers;

public class ComplexNumber {
	
	private int real;
	private int img;
	
	//constructor
	public ComplexNumber(int real, int img) {
		this.real = real;
		this.img = img;
	}
	//setter and getter
	public void setReal(int real) {
		this.real = real;
	}
	
	public void setImg(int img) {
		this.img = img;
	}
	
	public int getReal() {
		return real;
	}
	
	public int getImg() {
		return img;
	}
	
	//methods
	public void add(ComplexNumber c2) {
		this.real = this.real + c2.real;
		this.img = this.img + c2.img;
	}
	
	public void multiply(ComplexNumber c3) {
		int temp = this.real;
		this.real = (this.real*c3.real) - (this.img*c3.img);
		this.img = (temp*c3.img) + (this.img*c3.real);
	}
	public static ComplexNumber add(ComplexNumber c2, ComplexNumber c3) {
		int real = c2.real + c3.real;
		int img = c2.img + c3.img;
		ComplexNumber c4 = new ComplexNumber(real, img);
		return c4;
	}
	
	public void print() {
		System.out.println(real + "+" +img+"i");
	}
}
