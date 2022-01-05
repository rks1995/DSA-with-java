package recursion2;

public class MoreRecursion {

	public static String replacePi(String str) {
		if(str.length() <= 1)
			return str;
		
		if(str.charAt(0) == 'p' && str.charAt(1) == 'i') {
			return "3.14" + replacePi(str.substring(2));
		}
		else {
			return str.charAt(0) + replacePi(str.substring(1));
		}
		
	}
	
	public static String removeX(String str) {
		if(str.length() == 0)
			return str;
		
		String smallOutput = removeX(str.substring(1));
		
		if(str.charAt(0) == 'x') {
			return smallOutput;
		}
		else {
			return str.charAt(0) + smallOutput;
		}
	}
	
	public static String replaceChar(String str, char org, char replace) {
		if(str.length() == 0)
			return str;
		
		String smallOutput = replaceChar(str.substring(1), org, replace);
		
		if(str.charAt(0) == org) {
			return replace + smallOutput;
		}
		else {
			return str.charAt(0) + smallOutput;
		}
	}
	 
	public static void main(String[] args) {
		//String str = "xxaxbx";
		//System.out.println(replaceChar(str, 'x', 'y'));
		//System.out.println(removeX(str));
		System.out.println(replacePi("abppid"));
	}

}
