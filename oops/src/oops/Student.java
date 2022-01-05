package oops;

public class Student {
	
	String name;
	final private int rollNumber;
	private static int numStudent;
	
	//constructor
	public Student(String name, int rollNumber) {
		this.name = name;
		numStudent++;
		this.rollNumber = numStudent;
	}
	
	public Student() {
		this.name = "abc";
		numStudent++;
		this.rollNumber = numStudent;
	}
	
	public static int getNumStudent() {
//		System.out.println(name);
		return numStudent;
	}
	
	//functionality
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setRoll(int rollNumber) {
//		if(rollNumber <= 0)
//			return;
//		this.rollNumber = rollNumber;
//	}
//	
	public void getDetails() {
		System.out.println(this.name+ " " +this.rollNumber);
	}
}
