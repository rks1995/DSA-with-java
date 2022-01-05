package implementation;

import java.util.ArrayList;

public class SortedArray {
	
	private ArrayList<Integer> arr = new ArrayList<>();
	
	//O(n)
	public void insert(int val) {
		if(arr.size() == 0) {
			arr.add(val);
		}
		int idx=0;
		//find index for the value
		while(idx<arr.size() && arr.get(idx) < val) {
			idx++;
		}
		//set that value in its correct place and shift all element to the right side;
		if(idx == arr.size()) {
			arr.add(val);
		}else {
			for(int i=idx; i<arr.size(); i++) {
				int temp = arr.get(i);
				arr.set(i, val);
				val = temp;
			}
		}
	}
	
	//O(1)
	public int getMin() {
		return arr.get(0);
	}
	
	//O(n)
	public int removeMin() {
		int min = arr.get(0);
		for(int i=0; i<arr.size()-1; i++) {
			arr.set(i, arr.get(i+1));
			arr.set(i+1, min);
		}
		return arr.remove(arr.size()-1);
	}
	
}
