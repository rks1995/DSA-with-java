package interfaces;

public class VehicleUse {

	public static void main(String[] args) {
		
//		Vehicle v = new Vehicle();
		VehicleInterface vI; //reference
		
		vI = new Car();
		System.out.println(vI.companyName());
		

	}

}
