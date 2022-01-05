package twoDArray;

public class LargestColSum {

	public static int largestColSum(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		int lcs = Integer.MIN_VALUE;
		
		for(int i = 0; i<c; i++) {
			int sum = 0;
			for(int j=0; j<r; j++) {
				sum += arr[j][i];
			}
			if(sum > lcs)
				lcs = sum;
		}
		
		return lcs;
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {{1,4,5},{2,3,4},{6,9,2}};
		
		System.out.println(largestColSum(arr));

	}

}
