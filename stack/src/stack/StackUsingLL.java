package stack;

public class StackUsingLL {
	private Node head;
	private int count;
	
	StackUsingLL() {
		head = null;
	}

	int size() {
		return count;
	}

	boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}

	int top() throws StackEmptyException {
		if(head == null) {
			throw new StackEmptyException();
		}
		return head.data;
	}

	void push(int data) {
		count++;
		Node node = new Node(data);
		if(head == null) {
			head = node;
		}else {
			node.next = head;
			head = node;
		}
	}

	int pop() throws StackEmptyException {
		if(head == null) {
			throw new StackEmptyException();
		}
		count--;
		int temp = head.data;
		head = head.next;
		return temp;
	}
}
