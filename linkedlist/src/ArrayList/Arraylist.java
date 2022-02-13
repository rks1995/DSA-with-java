package ArrayList;

import java.util.ArrayList;

public class Arraylist {

	public static ArrayList<Integer> removeConsecutiveDuplicates(int[] arr) {
		ArrayList<Integer> output = new ArrayList<>();
		int curr = arr[0];
		output.add(curr);
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] != curr) {
				output.add(arr[i]);
				curr = arr[i];
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,10,10,20,20,30,30,40,40,10};
		
		ArrayList<Integer> unique = removeConsecutiveDuplicates(arr);
		for(int i: unique) {
			System.out.print(i + " ");
		}

	}

}
