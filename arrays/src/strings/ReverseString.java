package strings;

public class ReverseString {

	public static boolean checkPalindrome(String str, String str1) {
		return str.equals(str1);
	}
	public static String reverseString(String str) {
		String str1 = "";
		for(int i=str.length()-1; i>=0; i--) {
			str1 += str.charAt(i);
		}
		//System.out.println(System.identityHashCode(str1));
		return str1;
	}
	public static void main(String[] args) {
		String str = "racecar";
		String str1 = reverseString(str);
		String str2 = "racecar";
//		str2 = "abc";
//		System.out.println(str2.charAt(0));
//		System.out.println(System.identityHashCode(str)+ " " +System.identityHashCode(str2));
//		System.out.println(System.identityHashCode(str1));
		System.out.println(checkPalindrome(str, str1));
		
	}

}
