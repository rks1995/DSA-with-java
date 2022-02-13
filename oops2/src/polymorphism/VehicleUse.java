package polymorphism;

public class VehicleUse {

	public static void main(String[] args){
		//here vehicle will only have property specific to vehicle, because vehicle can point to any subclass 
		// so thats why vehicle object cannot access the subclass property;
		Vehicle v = new Bicycle();
		v.maxSpeed = 10;
//		v.numDoors = 4; throw error because numDoors is a property for car, this is compile time polymorphism
		v.print(); // this is runtime polymorphism, here print function of car will be executed, first it will
		            // look in its subclass if not found then it will look for that function in its own class;
		
	}

}
