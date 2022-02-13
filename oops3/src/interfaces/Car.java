package interfaces;

public class Car extends Vehicle implements VehicleInterface, CarInterface {

	@Override
	public boolean isMotorized() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String companyName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numGears() {
		// TODO Auto-generated method stub
		return 5;
	}

}
