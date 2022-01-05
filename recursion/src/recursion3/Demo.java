package recursion3;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		ArrayList<Integer>a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(5);
		ArrayList<Integer>b = new ArrayList<>(a);
		for(int i: b) {
			System.out.println(i);
		}

	}

}
