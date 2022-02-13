package abstraction;

public class AppUse {

	public static void main(String[] args) {
		
		Apps app1 = new Games();
		Apps app2 = new Movie();
		
		app1.name = "Fire Ranger";
		app1.ratings = 4.5;
		System.out.println(app1.isMonitized());
		app2.name = "MovieZilla";
		app2.ratings = 4.7;
		
		app1.print();
		app2.print();

	}

}
