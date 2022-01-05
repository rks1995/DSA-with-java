package oops;

public class StudentUse {
	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student("Ratna", 50);
		
		//correct way to access the static variable;
//		System.out.println(Student.numStudent);
		System.out.println(Student.getNumStudent());
		
		//incorrect way to access the static variable
//		System.out.println(s1.numStudent);
//		System.out.println(s1.getNumStudent());
		
		s1.getDetails();
		s2.getDetails();
		
//		s1.setName("Ratna");
//		s1.setRoll(10);
//		s1.getDetails();
//		
//		s2.setName("Savio");
//		s2.setRoll(20);
//		s2.getDetails();
		
	}

}
