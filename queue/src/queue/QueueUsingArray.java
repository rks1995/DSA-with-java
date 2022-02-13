package queue;

public class QueueUsingArray {

	private int[] arr;
	private int front;
	private int rear;
	private int size;

	public QueueUsingArray() {
		arr = new int[5];
		front = -1;
		rear = -1;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public int front() throws QueueEmptyException {
		if (size == 0) {
			throw new QueueEmptyException();
		}
		return arr[front];
	}

	public void enqueue(int ele) {
		if (size == arr.length) {
			doubleCapacity();
		}
		if (size == 0) {
			front = 0;
		}
		rear = (rear + 1) % arr.length;
		arr[rear] = ele;
		size++;
	}

	private void doubleCapacity() {
		int temp[] = arr;
		arr = new int[2 * temp.length];
		int ind = 0;
		for (int i = front; i != rear; i = (i%temp.length + 1)) {
			arr[ind++] = temp[i];
		}
		arr[ind] = temp[rear];
		front = 0;
		rear = temp.length-1;
	}

	public int dequeue() throws QueueEmptyException {
		if (size == 0) {
			throw new QueueEmptyException();
		}

		int temp = arr[front];
		front = (front + 1) % arr.length;
		size--;
		if (size == 0) {
			front = -1;
			rear = -1;
		}
		return temp;
	}

}
