package polymorphism;

public class Car extends Vehicle {
	
	int numDoors;
	public Car() {
		System.out.println("Car's constructor");
	}
	
	void print() {
		System.out.println("car print function");
	}
}
