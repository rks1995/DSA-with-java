package twoDArray;

public class MoreWith2dArray {

	public static void main(String[] args) {
		//dynamic column 2darray
		int[][] arr = new int[4][];
		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		for(int i=0; i<arr.length; i++) {
			if(i != 0)
				arr[i] = new int[5];
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
