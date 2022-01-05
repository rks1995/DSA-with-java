package oops;

//Java program to demonstrate
//why a non-static variable cannot
//be accessed from a static context

//Creating a class A
public class Demo {
	static int N;

	// Static method
	public static void increment()
	{
		// this throws a compile - time error.	
		N++;
	}

	// Main method
	public static void main(String args[])
	{
		// Creating multiple objects
		// for class A
		Demo obj1 = new Demo();
		Demo obj2 = new Demo();
		Demo obj3 = new Demo();

		// Assigning the different values
		// for the non static variable N
		obj1.N = 3;
		obj2.N = 4;
		obj3.N = 5;
		System.out.println(Demo.N);
		// Calling the method
		Demo.increment();

		System.out.println(obj1.N);
		System.out.println(obj2.N);
		System.out.println(obj3.N);
	}
}

