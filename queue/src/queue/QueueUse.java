package queue;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException {
		QueueUsingLL queue = new QueueUsingLL();
		int arr[] = {2,4,6,8,3};

		for (int ele : arr) {
			queue.enqueue(ele);
		}
		while (!queue.isEmpty()) {
			try {
				System.out.println(queue.front() + " " + "size: " + queue.size());
				queue.dequeue();
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}

		}
	}

}
