package stack;

public class StackUsingArray {

	private int[] data;
	private int topIndex;
	
	public StackUsingArray() {
		data = new int[2];
		topIndex = -1;
	}

	void push(int item) {
		if(topIndex == data.length-1) {
			//throw exception
			int[] newArr = new int[2*topIndex+1];
			for(int i=0; i<data.length; i++) {
				newArr[i] = data[i];
			}
			data = newArr;
		}
		data[++topIndex] = item;
	}

	int pop() throws StackEmptyException {
		if(topIndex == -1) {
			throw new StackEmptyException();
		}
		int temp = data[topIndex];
		topIndex--;
		return temp;
	}

	int top() throws StackEmptyException {
		if(topIndex == -1) {
			throw new StackEmptyException();
		}
		return data[topIndex];
	}

	int size() {
		return topIndex+1;
	}

	boolean isEmpty() {
		return topIndex == -1;
	}
}
