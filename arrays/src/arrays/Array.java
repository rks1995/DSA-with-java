package arrays;

public class Array {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		for(int i=0; i<5; i++) {
			arr[i] = 10;
		}
		
		arr = new int[6];
		for(int i=0; i<5; i++) {
			System.out.println(arr[i]);
		}

	}

}
