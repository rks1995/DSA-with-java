package Inheritance;

public class VehicleUse {

	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		v.print();

		Car c = new Car();
//        c.color = "red";
		c.setColor("red");
		c.maxSpeed = 200;
		c.price = 500000;
		c.numOfDoors = 4;
		c.printCar();

	}

}
