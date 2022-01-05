package pattern;

public class PatternRec {

	public static void printPattern(int n) {
		if(n==0) {
			return;
		}
		
		printPattern(n-1);
		for(int i=1; i<=n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void printFullPyramid(int n, int spaces) {
		
		if(n==0) {
			return;
		}
		
		printFullPyramid(n-1, spaces+1);
		
		for(int i=1; i<=spaces; i++) {
			System.out.print(" ");
		}
		for(int i=1; i<=n; i++) {
			System.out.print(" *");
		}
		System.out.println();
	}
	
	public static void printDiamond(int n, int rowCount) {
		if(n==0) {
			return;
		}
		int spaces = n-1;
		for(int i=1; i<=spaces; i++) {
			System.out.print(" ");
		}
		for(int i=1; i<=rowCount-spaces;i++) {
			System.out.print(" *");
		}
		System.out.println();
		printDiamond(n-1, rowCount);
		spaces++;
		for(int i=1; i<=spaces; i++) {
			System.out.print(" ");
		}
		for(int i=1; i<=rowCount-spaces;i++) {
			System.out.print(" *");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printPattern(5);
		//printFullPyramid(5, 0);
		printDiamond(6, 6);

	}

}
