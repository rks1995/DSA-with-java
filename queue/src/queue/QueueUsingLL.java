package queue;

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}

public class QueueUsingLL {
	private Node head;
	private Node tail;
	private int size;
	
	public QueueUsingLL() {
		head = null;
		tail = null;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	int size() {
		return size;
	}
	
	int front() throws QueueEmptyException {
		if(head == null) {
			throw new QueueEmptyException();
		}
		return head.data;
	}
	
	void enqueue(int ele) {
		Node node = new Node(ele);
		if(head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = tail.next;
		}
		size++;
	}
	
	int dequeue() throws QueueEmptyException {
		if(head == null) {
			throw new QueueEmptyException();
		}
		
		int temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	
	
}
