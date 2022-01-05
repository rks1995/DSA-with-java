package implementation;

public class PriorityQueueUse {

	public static void main(String[] args) {
		UsingHeap1<String> pq = new UsingHeap1<>();
		
		pq.insert("pqr", 5);
		pq.insert("ghi", 3);
		pq.insert("def", 2);
		pq.insert("jkl", 4);
		pq.insert("abc", 1);
		pq.insert("rrr", 10);
//		pq.heapSort();
		try {
			System.out.println(pq.removeMin());
		}catch(PriorityQueueException e) {
			System.out.println("pq Exception");
		}

//		try {
//			System.out.println(pq.getMin());
//		}catch(PriorityQueueException e) {
//			
//		}
		pq.printHeap();
		
		String a = "abcdefg";
		String p = a.substring(0,3);
		String q = a.substring(4, 7);
		System.out.println(p + " "+q);
		
	}
}
