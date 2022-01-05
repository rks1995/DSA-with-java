package recursion;

public class FirstIndex {

	public static int lastIndex(int arr[], int x, int li) {
		if(li == -1)
			return -1;
		if(arr[li] == x)
			return li;
		int idx = lastIndex(arr, x, li-1);
		return idx;
	}
	
	public static int firstIndex(int arr[], int x) {
		if(arr.length == 0)
			return -1;
		if(arr[0] == x)
			return 0;
		
		int smallArr[] = new int[arr.length-1];
		for(int i=1; i<arr.length; i++) {
			smallArr[i-1] = arr[i];
		}
		
		int fi = firstIndex(smallArr, x);
		if(fi == -1)
			return -1;
		else
			return fi + 1;
	}
	
	public static int firstIndexBetter(int arr[], int x, int si) {
		if(si == arr.length)
			return -1;
		if(arr[si] == x)
			return si;
		int fi = firstIndexBetter(arr, x, si+1);
		return fi;
	}
	
	public static void main(String[] args) {
		//int arr[] = {1,3,4,5,6,7,4,0,6};
//		System.out.println(firstIndex(arr, 10));
//		System.out.print(firstIndexBetter(arr, 11, 0));
		//System.out.println(lastIndex(arr, 40, arr.length-1));
	}

}
