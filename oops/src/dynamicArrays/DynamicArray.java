package dynamicArrays;

public class DynamicArray {
	
	private int arr[];
	private int nextElementIndex;
	public DynamicArray() {
		arr = new int[5];
		nextElementIndex = 0;
	}
	
	public void add(int ele) {
		if(nextElementIndex == arr.length) {
			int newArr[] = new int[2*arr.length];
			for(int i=0;i<arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		
		arr[nextElementIndex] = ele;
		nextElementIndex++;
	}
	
	public int size() {
		return nextElementIndex;
	}
	
	public int get(int idx) {
		if(idx >= nextElementIndex)
			return -1;
		return arr[idx];
	}
	
	public void set(int idx, int e) {
		if(idx >= nextElementIndex) {
			//Throw error
			return;
		}
		arr[idx] = e;
	}
	
	public int removeLast() {
		if(nextElementIndex == 0)
			return -1;
		return arr[--nextElementIndex];
	}
	
	public boolean isEmpty() {
		return (nextElementIndex == 0);
	}
	
	public void print() {
		for(int i=0; i<nextElementIndex; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//functions for polynomial
	public void setCoeff(int deg, int coeff) {
		if(deg >= arr.length) {
			int newCoeffArr[] = new int[deg+1];
			for(int i=0; i<arr.length; i++) {
				newCoeffArr[i] = arr[i];
			}
			arr = newCoeffArr;
		}
		
		arr[deg] = coeff;
		if(deg > nextElementIndex) {
			nextElementIndex = deg;
		}
	}
	
	public int getCoeff(int idx) {
		if(idx > nextElementIndex)
			return -1;
		return arr[idx];
	}
}

