package abstraction;

public class Games extends Apps {
	boolean isMultiplayer;
	void print() {
		System.out.println("Games " + name + " Rating " + ratings + " is Multiplayer ? " + isMultiplayer);
	}
	@Override
	boolean isMonitized() {
		// TODO Auto-generated method stub
		return true;
	}
 }
