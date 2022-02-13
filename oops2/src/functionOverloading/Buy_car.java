package functionOverloading;

//import Inheritance.Vehicle;

/*
class Vehicle{
    String colour;
    private int number;
    void print()
    {
        System.out.println("vehicle");
    }
}

class Car extends Vehicle{
    void print()
    {
        System.out.println("car");
    }
}
class Honda extends Car{
//    void print()
//    {
//        System.out.println("Honda");
//    }
}
*/

/*
 * Note: Modifies
 * Private: accessible only within the same class
 * Default: accessible within same package
 * Protected: accessible within same package and different package of derived class(inherited class)
 * Public: accessible everywhere
 */

public class Buy_car {

	public static void main(String[] args) {
//		Honda h = new Honda();
//		h.print();

//		Vehicle v = new Vehicle();
//		v.maxSpeed = 10;
		Truck t = new Truck();
//		v.color = "red";
		t.setColor("Black");
		t.setMaxSpeed(40);
		t.maxLoadingCapacity = 100;
		t.print();

	}

}
