package implementation;

class Node {
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}
}

public class UsingLL {
	Node head;
	
	//0(1) because insertion is done at beginning
	public void insert(int val) {
		if(head == null) {
			head = new Node(val);
			return;
		}
		Node node = new Node(val);
		node.next = head;
		head = node;
	}
	
	//O(n)
	public int getMin() {
		int min = Integer.MAX_VALUE;
		if(head == null) {
			return -1;
		}
		Node temp = head;
		while(temp != null) {
			if(temp.value < min) {
				min = temp.value;
			}
			temp = temp.next;
		}
		return min;
	}
	
	//for finding minimum - O(n) removing the minimum - O(1)
	public int removeMin() {
		if(head == null) {
			return -1;
		}
		int min = getMin(); //O(n)
		Node curr = head;
		Node prev = null;
		
		while(curr.value != min) {
			prev = curr;
			curr = curr.next;
		}
		
		if(prev != null) {
			prev.next = curr.next;
			
		}else {
			head = head.next;
		}
		
		return min;
	}
}
