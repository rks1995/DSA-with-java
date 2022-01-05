package strings;

public class ReverseEacHWord {

	public static String reverseEachWord(String str) {
		String ans = "";
		int currentWordStart = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ' ' || i == str.length()-1) {
				//find endIndex
				int currentWordEnd = i-1;
				if(i==str.length()-1)
					currentWordEnd = i;
				String reversedWord = "";
				for(int j=currentWordStart; j<=currentWordEnd; j++) {
					reversedWord = str.charAt(j) + reversedWord;
				}
				//append the reverseWord to the ans
				ans += reversedWord + " ";
				currentWordStart = i+1;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		String str = "abc def ghi jkl";
		System.out.println(reverseEachWord(str));

	}

}
