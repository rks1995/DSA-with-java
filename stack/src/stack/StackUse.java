package stack;

import java.util.Stack;

public class StackUse {

	static void reverseStack(Stack<Integer>s1, Stack<Integer> helper) {
		if(s1.isEmpty()) return;
		
		int temp = s1.pop();
		reverseStack(s1, helper);
		
		while(!s1.isEmpty()) {
			helper.push(s1.pop());
		}
		s1.push(temp);
		
		while(!helper.isEmpty()) {
			s1.push(helper.pop());
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,10,9};
		Stack<Integer> st = new Stack<>();
		Stack<Integer> helper = new Stack<>();
		
		for(int i:arr) {
			st.push(i);
		}
		
		reverseStack(st, helper);
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
		
	}

}



