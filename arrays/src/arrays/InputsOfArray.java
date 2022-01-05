package arrays;

import java.util.Scanner;

public class InputsOfArray {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of an array");
		int n = s.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			System.out.print("Enter element at " + i + "th index: ");
			arr[i] = s.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			System.out.println("array at " + i + "th index: " + arr[i]);
		}
		s.close();

	}

}
