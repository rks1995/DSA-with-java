package strings;

public class StringBufferDemo {

	public static void main(String[] args) {
		//StringBuffer is a mutable string, but it is not optimize as String;
		StringBuffer str = new StringBuffer("abc");
		str.setCharAt(0, 'd');
		str.append("def");
		System.out.println(str + " " + str.length());

	}

}
