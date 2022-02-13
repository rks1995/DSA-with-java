package abstraction;

public abstract class Apps {
	String name;
	double ratings;
	void print() {
		System.out.println("Apps " + name + " Ratings " + ratings);
	}
	
	abstract boolean isMonitized();
}
