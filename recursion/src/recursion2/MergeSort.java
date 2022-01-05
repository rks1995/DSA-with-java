package recursion2;

public class MergeSort {

	public static void merge(int a[], int si, int mid, int ei) {
		int temp[] = new int[ei-si+1];
		int k=0, p = si, q = mid+1;
		while(p <= mid && q <= ei) {
			if(a[p] <= a[q]) {
				temp[k++] = a[p];
				p++;
			}
			else {
				temp[k++] = a[q];
				q++;
			}
		}
		while(p <= mid) {
			temp[k++] = a[p++];
		}
		while(q <= ei) {
			temp[k++] = a[q++];
		}
		
		for(int s=0, j=si; s<temp.length; s++) {
			a[j++] = temp[s];
		}
	}
	
	public static void helper(int a[], int si, int ei) {
		if(si >= ei)
			return;
		int mid = (si+ei)/2;
		
		helper(a, si, mid);
		helper(a, mid+1, ei);
		merge(a, si, mid, ei);
		
	}
	
	public static void mergeSort(int arr[]) {
		helper(arr, 0, arr.length-1);
	}
	
	public static void print(int a[]) {
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {
		int a[] = {3,5,1,8,4,2,0};
		mergeSort(a);
		print(a);
	}

}
