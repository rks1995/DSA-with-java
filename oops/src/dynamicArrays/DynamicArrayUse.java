package dynamicArrays;

public class DynamicArrayUse {

	public static void main(String[] args) {
		
		DynamicArray d = new DynamicArray();
		
		for(int i=1; i<=7; i++) {
			d.add(i+100);
		}
		d.print();
		System.out.println(d.size());
		System.out.println(d.get(3));
//		d.set(3,100);
//		System.out.println(d.get(3));
//		
//		while(!d.isEmpty()) {
//			System.out.println(d.removeLast());
//			System.out.println("Size - " + d.size());
//		}

	}

}
