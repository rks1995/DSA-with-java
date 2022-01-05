package recursion2;

public class BinarySearch {	
	
	public static int binarySearch(int arr[], int x, int si, int ei) {
		//base condition
		if(si > ei)
			return -1;
		
		int mid = (ei+si)/2;
		if(arr[mid] == x)
			return mid;
		else if(arr[mid] > x) {
			return binarySearch(arr, x, si, mid-1);
		}
		else {
			return binarySearch(arr, x, mid+1, ei);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2,39,48,55,68,70,81,89,98};
		System.out.println(binarySearch(arr, 98, 0, arr.length-1));
		
	}

}
