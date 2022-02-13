package abstraction;

public class Movie extends Apps {
	boolean isVrPresent;
	void print() {
		System.out.println("Movie " + name + " Rating " + ratings + " is VR Present ? " + isVrPresent);
	}
	@Override
	boolean isMonitized() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
