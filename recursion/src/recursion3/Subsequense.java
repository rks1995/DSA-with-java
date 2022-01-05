package recursion3;

public class Subsequense {

	public static String keypad[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static String[] subsequence(String str) {
		if(str.length() == 0) {
			String s[] = {""};
			return s;
		}
		String[] smallOutput = subsequence(str.substring(1));
		String[] output = new String[2*smallOutput.length];
		int i=0;
		while(i < smallOutput.length) {
			output[i] = smallOutput[i];
			i++;
		}
		while(i<output.length) {
			output[i] = str.charAt(0) + smallOutput[i-smallOutput.length];
			i++;
		}
		return output;
		
	}
	
	public static void printSubsequence(String str, String s) {
		if(str.length() == 0) {
			System.out.println(s);
			return;
		}
		printSubsequence(str.substring(1), s);
		printSubsequence(str.substring(1), s + str.charAt(0));
	}
	
	public static String[] returnKeypad(int n) {
		if(n==0 || n==1) {
			String output[] = {""};
			return output;
		}
		int lastDigit = n%10;
		String lastDigitOption = keypad[lastDigit];
		String[] smallOutput = returnKeypad(n/10);
		String[] output = new String[smallOutput.length * lastDigitOption.length()];
		int k=0;
		for(int i=0; i<lastDigitOption.length(); i++) {
			for(int j=0; j<smallOutput.length; j++) {
				output[k++] = smallOutput[j] + lastDigitOption.charAt(i); 
			}
		}
		return output;
	}
	public static void printKeypad(int n, String s) {
		if(n==0) {
			System.out.println(s);
			return;
		}
		int lastDigit = n%10;
		String lastDigitOption = keypad[lastDigit];
		for(int i=0; i<lastDigitOption.length(); i++) {
			printKeypad(n/10, lastDigitOption.charAt(i) + s);
		}
		
	}
	
	public static int returnMinInArray(int[] arr) {
		if(arr.length == 1) {
			return arr[0];
		}
		int[] newArr = new int[arr.length-1];
		for(int i=1; i<arr.length; i++) {
			newArr[i-1] = arr[i];
		}
		int min = returnMinInArray(newArr);
		if(arr[0] < min)
			return arr[0];
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abc";
//		String output[] = subsequence(str);
//		printSubsequence("abc","");
//		int n = 12;
//		String output[] = returnKeypad(n);
//		for(String s: output) {
//			System.out.println(s);
//		}
//		
//		printKeypad(23, "");
		int arr[] = {2,1,3,4,1};
		System.out.println(returnMinInArray(arr));
		String[] str = {""};
		System.out.println(str.length);
	}

}
