package recursion2;

public class QuickSort {

	public static int partition(int a[], int si,int ei) {
		int pivot = a[ei];
		int i = si-1, j=si;
		while(j<=ei-1) {
			if(a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
			else {
				j++;
			}
		}
		a[j] = a[i+1];
		a[i+1] = pivot;
		return i+1;
	}
	
	public static void quickSort(int a[], int si, int ei) {
		if(si >= ei)
			return;
		int i = partition(a, si, ei);
		quickSort(a, si, i-1);
		quickSort(a, i+1, ei);
	}
	public static void main(String[] args) {
		int a[] = {3,2,1,5,4,8,9,6};
		quickSort(a, 0, a.length-1);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+ " ");
		}
	}

}
