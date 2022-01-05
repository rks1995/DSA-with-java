package implementation;

import java.util.ArrayList;

public class UnsortedArray {
	
	ArrayList<Integer> arr = new ArrayList<>();
	
	//O(1)
	public void insert(int val) {
		arr.add(val);
	}
	
	//O(n)
	public int getMin() {
		if(arr.size() == 0) {
			return -1;
		}
		int min = Integer.MAX_VALUE;
		for(int i: arr) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}
	
	//O(n)
	public int removeMin() {
		int min = getMin();
		for(int i=0; i<arr.size()-1; i++) {
			if(arr.get(i) == min) {
				arr.set(i, arr.get(i+1));
				arr.set(i+1, min);
			}
		}
		return arr.remove(arr.size()-1);
	
	}

}
