package functionOverloading;

import Inheritance.Vehicle;

public class Truck extends Vehicle{
	
	int maxLoadingCapacity;
	public void print() {
        System.out.println("Truck " + "color " + getColor() + " maxSpeed " + maxSpeed + " maxLoadingCapacity " + maxLoadingCapacity);
    }
}
