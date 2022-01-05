package arrays;

import java.util.Scanner;

public class MaxElement {

	public static int findMax(int[] arr) {
		int n = arr.length;
		int max = arr[0];
		for(int i=1; i<n; i++) {
			if(max < arr[i])
				max = arr[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int size =s.nextInt();
		int arr[] = new int[size];
		
		for(int i=0; i<size; i++) {
			arr[i] =  s.nextInt();
		}
		
		int max_element = findMax(arr);
		
		System.out.println(max_element);
		s.close();
	}

}
