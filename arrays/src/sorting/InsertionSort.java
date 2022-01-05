package sorting;
		
public class InsertionSort {
		
	public static void printArr(int[] arr) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}	
	}		
	
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=1; i<n; i++) {
			
			//insert ith element in its correct position
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		
		int arr[] = {3,4,1,12,7,9,6};
		
		insertionSort(arr);
		printArr(arr);
		
	}	
		
}
