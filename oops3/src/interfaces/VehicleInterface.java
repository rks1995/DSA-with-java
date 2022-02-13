package interfaces;

public interface VehicleInterface {
	
	// All the method in the interface are public and abstract by default;
	//that means we cannot create objects using Interface since it is abstract but we can create its reference;
	// interface implements everything by scratch i.e, every function in the interface should be implemented;
	// just think interface as a contract;
	//two or more can have same methods but not variables
	boolean isMotorized();
	
	String companyName();
	
	int numGears();
}
